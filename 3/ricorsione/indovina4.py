'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html

 Il gioco indovina4 stabilisce che un concorrente vince se, 
 scegliendo 6 numeri, riesce ad indovinarne almeno 4 fra i 7 estratti. 
 I numeri sono compresi fra 1 e 90. 
 Richiedere in input i 6 numero da giocare verificando che il valore 
 sia compreso fra 1 e 90 poi generare casualmente 7 numeri tutti diversi 
 sempre compresi fra 1 e 90. Verificare poi se il giocatore ha vinto.
'''
from random import randint

def generaNumeri() -> list:
	''' 
	genera una lista di 7 numeri compresi 
	fra 1 e 90 tutti diversi 
	'''
	numeri = []
	while len(numeri) < 7:
		n = randint(1,90)
		if not n in numeri:
			numeri.append(n)
	return numeri
	
def giocaNumeri() -> list:
	'''
	restituisce una lista di 6 valori tutti
	differenti e compresi fra 1 e 10 
	inseriti dall'utente
	'''
	numeri = []
	while len(numeri) < 6:
		n = int(input("inserisci un valore nell'intervallo[1,90]"))
		if n>=1 and n<=90 and n not in numeri:
			numeri.append(n)
		else:
			print(n,"non valido")
	return numeri
	
def comuni(l1: list, l2: list) -> int:
	'''
	restituisce il numeri di elementi comuni 
	alle liste l1 e l2
	'''
	com = 0
	for e in l1:
		if e in l2:
			com += 1
	return com

def main():
	giocati = giocaNumeri()
	print("giocati:",giocati)
	estratti = generaNumeri()
	print("estratti:",estratti)
	indovinati = comuni(giocati,estratti)
	if indovinati >= 4:
		print("vittoria! hai indovinato",indovinati,"numeri");
	else:
		print("hai perso! hai indovinato solo",indovinati,"numeri"); 

if __name__ == '__main__':
	main()

