'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 Successione di Fibonacci (iterativo)
# '''

def fibonacci(n: int) -> int:
	'''
	return ennesimo termine della successione di Fibinacci
	https://it.wikipedia.org/wiki/Successione_di_Fibonacci
	'''
	valore = 1
	precedente = 0
	for i in range(n):
		valore, precedente = valore + precedente, valore
	return valore

def main():
	for v in range(20+1):
		print('termine ',v,'della serie di Fibonacci =',fibonacci(v))

if __name__=="__main__":
	main()
