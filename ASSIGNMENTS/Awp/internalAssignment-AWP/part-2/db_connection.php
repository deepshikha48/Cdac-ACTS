<!-- Code to connect to the database -->
<?php

    $connect = mysqli_connect("localhost","root","","users_list");
    if($connect == false){
    die("Error:Connection failed".mysqli_connect_error($connect));
    }

 ?>
