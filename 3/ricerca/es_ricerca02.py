'''
Scrivere la funzione ricerca01 che ricerca la presenza di una stringa 
ricevuta come parametro in una lista di stringhe anche questa ricevuta 
come parametro. 
La lista è ordinata in modo non decrescente per numero di caratteri.
La ricerca dà esito positivo se le due stringhe hanno lo stesso numero 
di caratteri. 
Scrivere un programma che testa il funzionamento della funzione realizzata.
'''

def ricerca02(s:str, li:list) -> bool:
	'''
	True se la stringa s è presente nella lista li
	li è ordinata in modo non decrescente per numero di caratteri
	'''
	for i in range(len(li)):
		if len(s) == len(li[i]):
			return True
		if len(s) < len(li[i]):
			return False
	return False
	
		
miaLista = ['da', 'Itis', 'Vinci', 'Leonardo']
print(miaLista)
r = input('parola con lunghezza da cercare: ')
if ricerca02(r,miaLista):
	print('presente')
else:
	print('non presente')

