'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 es. riscorsione conteggio vocali minuscole
'''

def contaVocali (s: str) -> int:
	'''
	restituisce numero di vocali minuscole in s
	'''
	if len(s) == 0:			#condizione di terminazione
		return 0
	testa = s[0]			#primo elemento
	coda = s[1:]			#altri elementi
	if testa in "aeiou":
		return 1 + contaVocali(coda)	#1 + vocali in coda
	else:
		return 0 + contaVocali(coda)	#0 + vocali in coda
 
def main():
	print("Ingegneria contiene",contaVocali("Ingegneria"),"vocali minuscole")
	print("stringa vuota contiene",contaVocali(""),"vocali minuscole")
	print("qwrt contiene",contaVocali("qwrt"),"vocali minuscole")
	print("aia contiene",contaVocali("aia"),"vocali minuscole")	
main()
