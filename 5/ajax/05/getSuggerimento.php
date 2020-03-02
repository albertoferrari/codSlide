<?php
// Array with names
$a[] = "Anna";
$a[] = "Gino";
$a[] = "Letizia";
$a[] = "Alberto";
$a[] = "Marco";
$a[] = "Ernesto";
$a[] = "Catia";
$a[] = "Gerardo";
$a[] = "Matteo";
$a[] = "Mattia";
$a[] = "Linda";
$a[] = "Nina";
$a[] = "Amanda";
$a[] = "Cinzia";
$a[] = "Chiara";
$a[] = "Doris";
$a[] = "Marco";
$a[] = "Giuseppe";
$a[] = "Carlo";

// leggi parametro q da URL
$q = $_REQUEST["q"];

$hint = "";

// leggi suggerimenti da array se $q è diverso da "" 
if ($q !== "") {
    $q = strtolower($q);
    $len=strlen($q);
    foreach($a as $name) {
        if (stristr($q, substr($name, 0, $len))) {
            if ($hint === "") {
                $hint = $name;
            } else {
                $hint .= ", $name";
            }
        }
    }
}

// Output "no suggerimento" se non trova niente
echo $hint === "" ? "no suggestion" : $hint;
?>