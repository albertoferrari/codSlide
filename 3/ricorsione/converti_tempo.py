'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html

 Scrivere la funzione converti che riceve in input un numero intero che 
 rappresenta i secondi e restituisce una lista con 3 valori interi 
 che rappresentano il numero di ore, di minuti e di secondi equivalenti 
'''
from random import randint

def converti(secondi: int) -> list:
	''' 
	converte secondi in ore, minuti e secondi
	'''
	ore = secondi // 3600
	minuti = (secondi - ore * 3600) // 60
	secondi = secondi % 60
	return [ore,minuti,secondi]

def riconverti(tempo: list) -> int:
	'''
	converte [ore,minuti,secondi]
	in secondi
	'''
	ore, minuti, secondi = tempo
	return ore*3600+minuti*60+secondi
	
	
def main():
	for i in range(10):
		s = randint(1000,12000)
		t = converti(s)
		ts = riconverti(t)
		print(s,t,ts)

if __name__ == '__main__':
	main()

