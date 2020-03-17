'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 controllo presenza multiplo in lista
 interi e un valore intero n, restituisce True se almeno
 uno dei valori della lista è multiplo di n, False
 altrimenti
# '''

def fattoriale(n: int) -> int:
	'''
	restituisce n!
	'''
	print('sto calcolando il fattoriale di',n)
	if n == 0:
		return 1
	return n * fattoriale(n-1)

def main():
	print(fattoriale(8))

if __name__=="__main__":
	main()
