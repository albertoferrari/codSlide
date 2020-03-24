'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 visualizzazione delle cifre di un numero intero
'''

def stampa_cifre_rev(n: int):
	'''
	visualizza le cifre di n 
	partendo dalla meno significativa
	'''
	if n > 0:
		print(n % 10)				#ultima cifra
		stampa_cifre_rev(n // 10)	#altre cifre

def stampa_cifre(n: int):
	'''
	visualizza le cifre di n 
	partendo dalla più significativa
	'''
	if n > 0:
		stampa_cifre(n // 10)	#altre cifre
		print(n % 10)			#prima cifra

def main():
	stampa_cifre_rev(12345)
	print()
	stampa_cifre(12345)
	
if __name__=="__main__":
	main()

