'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 controllo presenza multiplo in lista
 interi e un valore intero n, restituisce True se almeno
 uno dei valori della lista è multiplo di n, False
 altrimenti
# '''

def esiste_multiplo(li: list, n: int) -> bool:
	'''
	True se in li esiste almeno un multiplo di n
	'''
	print(li)
	if len(li) == 0:		#lista vuota
		return False
	if li[0] % n == 0:		#se il primo elemento è multiplo di n
		return True
	return esiste_multiplo(li[1:],n)	#ricorsione

def main():
	#print(esiste_multiplo([2,25,88],5))
	print(esiste_multiplo([2,25,88],3))
	
if __name__=="__main__":
	main()
