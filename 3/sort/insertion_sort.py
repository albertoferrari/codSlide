'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 ordinamento insertion sort
'''
import time
from random import randint, shuffle

def insertionSort(v: list):
	'''
	ordina la lista v 
	con algoritmo selection sort
	'''
	# il primo elemento è ordinato quindi partiamo dal secondo
	for s in range(1, len(v)):
		elementoDaInserire = v[s]
		indiceElemento = s
		while indiceElemento > 0 and v[indiceElemento - 1] > elementoDaInserire:
			v[indiceElemento] = v[indiceElemento -1]
			indiceElemento = indiceElemento - 1
		v[indiceElemento] = elementoDaInserire

def listaCasuale(n: int, min_v: int, max_v: int) ->list:
	'''
	restituisce una lista di n valori interi
	con valori casuali compresi fra min_v e max_v
	'''
	lista = []
	for i in range(n):
		lista.append(randint(min_v,max_v))
	return lista

valori = listaCasuale(10,100,200)
print(valori)
t0 = time.time()
insertionSort(valori)
t = time.time() - t0
print(valori)
print(t,"secondi")
