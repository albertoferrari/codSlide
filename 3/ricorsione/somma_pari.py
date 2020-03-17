'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 somma dei numeri pari di una lista
# '''
from random import randint

def sommaPari(lis: list) -> int:
	'''
	return somma dei numeri pari presenti in lis
	'''
	if len(lis) == 0:
		return 0
	if lis[0] % 2 == 0:					#pari
		return lis[0] + sommaPari(lis[1:])
	else:
		return sommaPari(lis[1:])
	
def main():
	for i in range(5):
		lungLista = randint(0,5)
		lista = []
		for e in range(lungLista):
			lista.append(randint(10,30))
		print(lista,sommaPari(lista))

if __name__=="__main__":
	main()
