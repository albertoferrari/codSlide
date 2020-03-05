<?php
require_once('mcrypt_class.php');
//HASHING

//l'utente si registra ed indica questa psw 
$psw = "arYY_23Pq1w";

//ma noi memorizzeremo nel DB il suo valore di hash
//e da nessuna parte sul nostro server verrà mantenuta traccia della psw in chiaro

$salt=openssl_random_pseudo_bytes(15);
echo "Sale aggiunto: $salt<br />";

$hashing = hash("sha512", $salt . $psw); //QUESTA è memorizzata nel DB
echo "Hash salt+psw: $hashing<br />";

$stringa_da_cifrare = 'Quel ramo del lago di Como ...';

$crypto = new phpFreaksCrypto();
echo "ok";
$stringa_cifrata = $crypto->encrypt($stringa_da_cifrare);
$stringa_decifrata = $crypto->decrypt($stringa_cifrata);  

echo 'Stringa originale: ' . $stringa_da_cifrare . '<br />';
echo 'Stringa cifrata  : ' . $stringa_cifrata . '<br />';
echo 'Stringa decifrata: ' . $stringa_decifrata . '<br />';

?>
