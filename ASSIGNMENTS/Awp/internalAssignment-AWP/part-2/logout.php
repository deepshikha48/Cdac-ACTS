<!-- code to destroy the session -->
<?php
    session_start();
    session_destroy();
    header("location:index.php");
?>