<?php

$connect=mysqli_connect("localhost","root","","movies_database");
if($connect==false)
{
    die("error:connection failed".mysqli_connect_error($connect));

}
else
    echo "";

?>