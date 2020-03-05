<?php

/*
 * phpFreaksCrypto.class.php5 -> phpFreaksCrypto Class (PHP5)
 */

 /**
  * @author Dustin Whittle
  * @version 0.01 (English Version)
  *
  * messages and comments has been translated in italian by Fabrizio Camuso
  */
     
if (realpath(__FILE__) == realpath($_SERVER['SCRIPT_FILENAME']))
{
  // impediamo accessi diretti a questo file: bisogna passare per il server
  exit('Non puoi accedere a questo file direttamente...');
}

class phpFreaksCrypto
{
  
  private $td;
    
  // questa funzione è richiamata quando viene istanziato un oggetto della classe
  public function __construct($key = 'LaMiaStringaCasualeCheRimarràSempreLaStessa',
                              $iv = false, $algorithm = 'tripledes', $mode = 'ecb')
  {  
    if(extension_loaded('mcrypt') === FALSE)
    {
      $prefix = (PHP_SHLIB_SUFFIX == 'dll') ? 'php_' : '';
      dl($prefix . 'mcrypt.' . PHP_SHLIB_SUFFIX) or die('Impossibile caricare il modulo Mcrypt.');
    }

    if($mode != 'ecb' && $iv === false)
    {
      /*
        il vettore di inizializzazione iv è lo stesso per la cifratura e la decifratura
        ed è di norma inserito nella stringa cifrata, ma non sempre
      */
      die('Per usare sistemi di cifratura diversi da ecb bisogna specificare un unico vettore di inizializzazione.');
    }

    // imposta la modalità e l'algoritmo di cifratura 
    $this->td = mcrypt_module_open($algorithm, '', $mode, '') ;

    //Unix ha un generatore pseudo casuale migliore di quello di mcript, per cui se è disponibile  usiamolo!
    $random_seed = strstr(PHP_OS, "WIN") ? MCRYPT_RAND : MCRYPT_DEV_RANDOM;

    // se il vettore di inizializzazione è disponibile usiamolo altrimenti si parte da un seme casuale
    // if initialization vector set in constructor use it else, generate from random seed
    $iv = ($iv === false) ? mcrypt_create_iv(mcrypt_enc_get_iv_size($this->td), $random_seed)
                          : substr($iv, 0, mcrypt_enc_get_iv_size($this->td));

    //ottieni la dimensione presunta della chiave basandoti sulla modalità e algoritmo di cifratura
    $expected_key_size = mcrypt_enc_get_key_size($this->td);

    //non abbiamo bisogno di conoscere la chiave reale; dobbiamo solo confermare che corrisponde
    //alla versione generata dall'hash
    $key = substr(md5($key), 0, $expected_key_size);

    //inizializziamo la libreria mcrypt con la modalità, la chiave di cifratura
    //e il vettore di inizializzazione
    mcrypt_generic_init($this->td, $key, $iv);
  }
  
  public function encrypt($plain_string)
  {    
    /*
      cifra la stringa usando mcrypt, codifica eventuali caratteri speciali e
      restituisce la stringa in forma cifrata
    */
    return base64_encode(mcrypt_generic($this->td, $plain_string));
  }
  
  public function decrypt($encrypted_string)
  { 
    /*
      elimina eventuali caratteri speciali, decifra la stringa usando mcrypt, rimuovi i caratteri null
      dalla stringa e restituisci la stringa decifrata
    */
    return trim(mdecrypt_generic($this->td, base64_decode($encrypted_string)));
  }  
  
  //questa funzione è richiamata quando il garbage collector di php distrugge l'oggetto 
  public function __destruct()
  {
    // shutdown mcrypt
    mcrypt_generic_deinit($this->td);

    // chiudi il modulo mcrypt
    mcrypt_module_close($this->td);
  }

}
?>