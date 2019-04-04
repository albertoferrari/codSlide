'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 Successione di Fibonacci (ricorsivo)
# '''

def fibonacci(n: int) -> int:
	'''
	return ennesimo termine della successione di Fibinacci
	https://it.wikipedia.org/wiki/Successione_di_Fibonacci
	'''
	result = 1
	if n > 1:
		result = fibonacci(n-1) + fibonacci(n-2)
	return result


def main():
	for v in range(20+1):
		print('termine ',v,'della serie di Fibonacci =',fibonacci(v))

if __name__=="__main__":
	main()
