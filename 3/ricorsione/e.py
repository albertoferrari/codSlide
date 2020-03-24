'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html

 Calcolare il valore di e utilizzando la sommatoria 1/n! per tutti
 i valori di n compresi fra 2 e 10
'''
def fattoriale(n: int) -> int:
	''' return n! '''
	if n==0:
		return 1
	return n * fattoriale(n-1) 

def main():
	e = 2
	for n in range(2,11):
		e = e + 1/fattoriale(n)
		print(n,e)

if __name__ == '__main__':
	main()

