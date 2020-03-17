'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 somma dei valori presenti in una lista
# '''
from random import randint

def somma(lis: list) -> int:
	'''
	return somma dei valori presenti in lis
	'''
	if len(lis) == 0:
		return 0
	return lis[0] + somma(lis[1:])
	
def main():
	for i in range(5):
		lungLista = randint(0,5)
		lista = []
		for e in range(lungLista):
			lista.append(randint(10,30))
		print(lista,somma(lista))

if __name__=="__main__":
	main()
