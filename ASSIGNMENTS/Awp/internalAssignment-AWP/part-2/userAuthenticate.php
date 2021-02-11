<!-- Code for user authentication -->
<?php

    session_start();

    $email=$_POST['email'];
    $password=$_POST['password'];

    // checking for empty input values
    if(empty($email) || empty($password)){
        header("location:login.php");
    }else{
        // including a file to connect to Db
        include 'db_connection.php';
        // query to find out user based on email and password entered
        $sql="select username from users where email='".$email."' and password = '".$password."'";
        $result=mysqli_query($connect,$sql);
        $row=mysqli_fetch_array($result);
        $username=$row['username'];
        // if no user exists then redirect to login page again
        if(empty($username)){
            header("location:login.php");
        }
        // else redirect to userlist page
        else{
            $_SESSION['username'] = $username;
            header("location:userlist.php");
        }
    }


?>