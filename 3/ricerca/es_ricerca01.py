'''
Scrivere la funzione ricerca01 che ricerca la presenza di una stringa 
ricevuta come parametro in una lista di stringhe anche questa ricevuta 
come parametro. 
La ricerca dà esito positivo se le due stringhe hanno lo stesso numero 
di caratteri. 
Scrivere un programma che testa il funzionamento della funzione realizzata.
'''

def ricerca01(s:str, li:list) -> bool:
	'''
	True se la stringa s è presente nella lista li
	'''
	for i in range(len(li)):
		if len(s) == len(li[i]) :
			return True
	return False
	
		
miaLista = ['Itis', 'Leonardo', 'da', 'Vinci']
print(miaLista)
r = input('parola con lunghezza da cercare: ')
if ricerca01(r,miaLista):
	print('presente')
else:
	print('non presente')

