<?php 

// testo in chiaro
$testo_in_chiaro = "Itis Leonardo da Vinci Parma"; 
echo "testo in chiaro: " . $testo_in_chiaro . "<br>"; 
  
// metodo di cifratura
$metodo_cifratura = "AES-128-CTR"; 
  
// Opzioni
// $iv_length = openssl_cipher_iv_length($metodo_cifratura); 
$opzioni = 0; 
  
// vettore inizializzazione (non nullo) per crittazione 
$vettore_crittazione = '1234567891011121'; 
  
// Chiave di cifratura 
$chiave_cifratura = "5AInformatica"; 
  
// Cifratura 
$testo_cifrato = openssl_encrypt($testo_in_chiaro, $metodo_cifratura, 
            $chiave_cifratura, $opzioni, $vettore_crittazione); 
  
// testo cifrato 
echo "testo cifrato: " . $testo_cifrato . "<br>"; 
  
// vettore inizializzazione (non nullo) per decrittazione 
$vettore_decifrazione = '1234567891011121'; 
  
// Chiave di decifrazione 
$chiave_decifratura = "5AInformatica"; 
  
// Decifrazione
$testo_decifrato=openssl_decrypt ($testo_cifrato, $metodo_cifratura,  
        $chiave_decifratura, $opzioni, $vettore_decifrazione); 
  
// Testo decifrato 
echo "testo decifrato: " . $testo_decifrato. "<br>"; 
  
?> 
