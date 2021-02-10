<?php

    $movieid=$_POST['movieid'];
    $moviename=$_POST['moviename'];
    $director=$_POST['director'];

    echo $director;

    if(empty($movieid) || empty($moviename) || empty($director)){
        header("Location:./registration.html");
    }

    else{
        include "db_connection.php";

        $sql="INSERT INTO movies(movieid, moviename, director) VALUES ( '".$movieid."', '".$moviename."', '".$director."')";
        if(mysqli_query($connect,$sql))
        {
            header("<Location:movies_list.php");
        }
        else{

            echo "Error".mysqli_error($connect);
        }
    }
?>

