<html lang="en">
    <head>
        <title>Search Artists</title>
    </head>
    <body>
        <?php
        
            session_start();
            if (isset($_SESSION["userid"]) && $_SESSION["userid"]!="")
            {
        ?>
            <h2>Search for an Artist</h2>
         <form action="searchArtist.php" method="get">
            Firstname:&nbsp;<input type="text" name="firstname"><br><br>
            Lastname:&nbsp;<input type="text" name="lastname"><br><br>
            Nationality:&nbsp;<input type="text" name="nationality"><br><br>
            <input type="submit" value="Search">
            <input type="reset" value="Clear">
        </form>
        <?php
            if(isset($_GET["firstname"]))
            {
                $servername="localhost";
                $username="root";
                $password="";
                $dbname="vrg";

                // Create connection
                $conn = new mysqli($servername, $username, $password, $dbname);
                if($conn->connect_error)
                {
                    die("Connection failed: ".$conn->connect_error);
                }
                else
                {   //Read the form data
                    $firstname = $_GET["firstname"];
                    $lastname = $_GET["lastname"];
                    $nationality = $_GET["nationality"];

                    //Generate query
                    $sql = "select artistid, firstname, lastname, nationality, dateofbirth, datedeceased from artist";
                    if ($firstname != "" || $lastname!="" || $nationality != "")
                    {
                        $sql = $sql. " where artistid <> ''";
                    
                        if ($firstname != "")
                            $sql = $sql. " and firstname='".$firstname."'";
                        if ($lastname != "")
                            $sql = $sql. " and lastname='".$lastname."'";
                        if ($nationality != "")
                            $sql = $sql. " and nationality='".$nationality."'";
                    
                    }
                    $sql = $sql. " order by lastname";
                    //echo $sql;
                    //Run query
                    $result = $conn->query($sql);
                    if($result->num_rows>0)
                    {   echo "<table border=\"1\">";
                        echo "<tr>";
                        echo "<th>Artist ID</th>";
                        echo "<th>First Name</th>";
                        echo "<th>Last Name</th>";
                        echo "<th>Nationality</th>";
                        echo "<th>Year of Birth</th>";
                        echo "<th>Year Deceased</th>";
                        echo "</tr>";
                        while($row = $result->fetch_assoc())
                        {
                            echo "<tr>";
                            echo "<td><a href=\"findPaintings.php?id=".$row["artistid"]."\">".$row["artistid"] ."</td>";
                            echo "<td>".$row["firstname"]."</td>";
                            echo "<td>".$row["lastname"]."</td>";
                            echo "<td>".$row["nationality"]."</td>";
                            echo "<td>".$row["dateofbirth"]."</td>";
                            echo "<td>".$row["datedeceased"]."</td>";
                            echo "</tr>";
                        }
                        echo "</table>";
   
                    }
                else
                    {
                        echo "No records found!";
                    }
                $conn->close();
                }
            }

            }
            else
            {
                echo "<h1> You have to log in to access this page!</h1>";
                echo "<a href=\"index.php\">Go to login page</a>";
            }

        ?>
        <br><br><a href="logout.php">Log out</a>
    </body>
</html>