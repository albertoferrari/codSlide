<?php

$pwd = "itis leonardo";

$pwd_sha512 = hash("sha512", $pwd);
$pwd_md5 = hash("md5", $pwd);

echo "password crittata sha512:<br \> $pwd_sha512<br \>";
echo "password crittata md5:<br \> $pwd_md5<br \>";

$salt = openssl_random_pseudo_bytes(15);
echo "salt: $salt<br \>";
$pwd_salt = $salt . $pwd;
echo "pwd_salt: $pwd_salt<br \>";

$pwd_md5bis = md5($pwd);
echo "pwd_md5bis: $pwd_md5bis<br \>";
?>
