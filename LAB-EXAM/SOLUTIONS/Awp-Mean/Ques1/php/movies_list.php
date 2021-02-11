<head>
    <title>Movies</title>
    <meta charset="utf-8" />
   <link rel="stylesheet" type="text/css" href="../css/list.css">
</head>

<body>
<div class="main">
            
    <div class="title">
        <h1>Movies list</h1>
    </div>
    
    <div class="list">
    <?php
   include "db_connection.php" ;
    $sql ="SELECT movieid, moviename, director FROM movies ";
    $result = mysqli_query($connect,$sql);
    $movieid="";
    $moviename="";
    $director="";
    echo "<table>"."<th>"."Movie Id".'</th> <th> '."Movie Name".'</th> <th>'. "Director Name".'</th>';
    while($row=mysqli_fetch_assoc($result))
    {
    $movieid=$row['movieid'];
    $moviename=$row['moviename'];
    $director=$row['director'];
    echo '<tr> <td>'.$movieid.'</td> <td> ' . $moviename.'</td> <td> ' .$director.'</td></tr>';
    }
    echo "</table>";

    ?>
 
    </div>
</div>
</body>

