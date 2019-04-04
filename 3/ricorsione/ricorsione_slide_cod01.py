'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 Massimo Comun Divisore
# '''
from random import randint

def mcd(a: int, b:int) -> int:
	'''
	algoritmo di Euclide
	return MCD di a e b
	'''
	r = a % b
	if (r == 0):
		return b	#condizione di terminazione
	else:
		return(mcd(b,r))


def main():
	for i in range(10):
		n1 = randint(1,100)
		n2 = randint(1,100)
		print('MCD',n1,n2,'=',mcd(n1,n2))

if __name__=="__main__":
	main()
