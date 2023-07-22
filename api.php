<?php

require_once('dbcon.php');

 if (!isset($_POST['name']) && !isset($_POST['location']) && !isset($_POST['comments'])){
   die("Error incomplete HTTP request");



 }

 if (strlen($_POST['name']) < 3 || strlen($_POST['comments'])<6) {

   die("Error plese fill in the form");

 }

//kena filter semua input, bahaya kalau tak filter
$POSTV = filter_input_array(INPUT_POST,
    ['name' => FILTER_SANITIZE_STRING,
     'email' => FILTER_SANITIZE_STRING,
	 'location' => FILTER_SANITIZE_STRING,
     'comments' => FILTER_SANITIZE_STRING,
    ]
);
$name = $POSTV['name'];
$email = $POSTV['email'];
$addr = $_SERVER['REMOTE_ADDR'];
$location = $POSTV['location'];
$comments = $POSTV['comments'];
$agent = $_SERVER['HTTP_USER_AGENT'];


$query= "INSERT INTO comments (id, name, email, ip_address, user_agent, location, comments)
VALUES (NULL,'$name','$email','$addr','$agent', '$location', '$comments')";

$result=mysqli_query($conn, $query);

if (!$result) {

  echo mysqli_error($conn);

} else {

echo "Road report submitted";

}
 ?>
