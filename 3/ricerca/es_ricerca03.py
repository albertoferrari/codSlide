'''
Scrivere la funzione ricerca03 che riceve come parametri un valore 
intero n e una lista di interi lis ordinata in modo non decrescente. 
La funzione restituisce la posizione del primo elemento di lis 
maggiore di n o il valore -1 se tutti gli elementi della lista sono minori. 
Scrivere un programma che testa il funzionamento della funzione realizzata.
'''
from random import randint

def ricerca03(n:int, lis:list) -> bool:
	'''
	restituisce la posizione del primo elemento di lis 
	maggiore di n o il valore -1 se tutti gli elementi della lista sono minori
	'''
	for i in range(len(lis)):
		if lis[i] > n:
			return i
	return -1

miaLista = []
for i in range(10):
	miaLista.append(randint(1,100))
print(miaLista)
v = int(input('valore da cercare: '))
pos = ricerca03(v,miaLista)
if pos == -1:
	print('nessun valore valore è maggiore di',v)
else:
	print('il primo valore maggoriore di',v,'è in posizione',pos)


