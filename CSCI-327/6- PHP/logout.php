<html lang="en">
    <head>
        <title>Log Out page</title>
    </head>
    <body>
        <?php
                session_start();
                if (isset($_SESSION["userid"]) && $_SESSION["userid"]!="")
                {
                    $fullname = $_SESSION["FullName"];
                    echo $fullname." logged out successfully!";
                    session_destroy();
                }
                else
                {
                    echo "<h1> You have to log in to access this page!</h1>";
                    echo "<a href=\"index.php\">Go to login page</a>";
                }
        ?>
    </body>
</html>