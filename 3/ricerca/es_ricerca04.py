'''
Scrivere la funzione ricerca04 che riceve come parametri un valore float n 
e una lista di float lis ordinata in modo non decrescente. 
La funzione restituisce la posizione dell’elemento di lis la cui 
differenza in valore assoluto con n è minore o uguale a 0.01 
o il valore -1 se nessun elemento viene trovato. 
Scrivere un programma che testa il funzionamento della funzione realizzata.
'''
from random import randint

def ricerca04(n:float, lis:list) -> bool:
	'''
	restituisce la posizione del primo elemento di lis 
	la cui differenza in valore assoluto con n è minore o uguale a 0.01 
	restituisce -1 se non è presente
	'''
	for i in range(len(lis)):
		print(i,abs(lis[i] - n))
		if abs(lis[i] - n) <= 0.01:
			return i
		if lis[i] > n:
			return -1
	return -1

miaLista = []
for i in range(10):
	miaLista.append(randint(1,10000)/100)
print(miaLista)
miaLista.sort()
print(miaLista)
v = float(input('valore da cercare: '))
pos = ricerca04(v,miaLista)
if pos == -1:
	print('nessun valore si avvicina a',v)
else:
	print('il primo valore che si avvicina a',v,'è in posizione',pos)


