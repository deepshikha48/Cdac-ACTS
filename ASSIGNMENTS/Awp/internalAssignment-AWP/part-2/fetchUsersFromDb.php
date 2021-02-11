<!-- code to fetch users list from database -->
<?php
    // including a file to connect to Db
    include 'db_connection.php';
    // query to fetch all the users
    $sql="select * from users";
    $result=mysqli_query($connect,$sql);    
    // displaying fetched data in the form of table   
    echo "<table><tr><th>Name</th><th>Email</th><th>Contact</th></tr>";
    while($row=mysqli_fetch_array($result)){
        $username=$row['username'];
        $email=$row['email'];
        $phone=$row['phone'];
        echo "<tr><td>".$username."</td><td>".$email."</td><td>".$phone."</td></tr>";
    }
    echo "</table>";
?>