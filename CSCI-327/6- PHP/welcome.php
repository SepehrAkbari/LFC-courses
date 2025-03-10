<html lang="en">
    <head>
        <title>Welcome Page</title>
    </head>
    <body>
        <?php
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
                $userid = $_POST["username"];
                $password = $_POST["password"];
                
                //Generate query
                $sql = "select firstname, lastname, username, is_admin";
                $sql = $sql. " from user where username='".$userid."' and password='".$password."'";
                
                //Run query
                $result = $conn->query($sql);
                if($result->num_rows>0)
                {
                    $row = $result->fetch_assoc();
                    $fullname = $row["firstname"]." ".$row["lastname"];
                    echo "<h1>Welcome to the Main Menu ".$fullname."</h1>";
                    if($row["is_admin"]==1)
                    {
                        echo "<h3>You're an admin, so you'll see the special menu.</h3>";
                        echo "<br><a href=\"seeSalesFigures.php\">See Sales Numbers</a>";
                    }
                    else
                    {
                        echo "<h3>You're not an admin, so you'll see regular menu.</h3>";
                        

                    }   
                    echo "<br><a href=\"searchArtist.php\">Search for an artist</a>";
                    echo "<br><a href=\"searchWork.php\">Search for a work of art</a>";
                    echo "<br><a href=\"searchCustomer.php\">Search for a customer</a>";

                }
                else
                {
                    echo "<h3>Sorry! Login failed!</h3>";
                    echo "Go back to the <a href=\"index.php\">login page</a> and try again.";
                }
                $conn->close();
                
                session_start();
                $_SESSION["userid"] = $userid;
                $_SESSION["FullName"] = $fullname;
            }
        ?>
        <br><br><a href="logout.php">Log out</a>
    </body>
</html>