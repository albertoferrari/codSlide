'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 Fattoriale
# '''
from random import randint

def factorial(n: int) -> int:
	'''
	return n!
	'''
	result = 1
	if n > 1:
		result = n * factorial(n-1)
	return result


def main():
	for i in range(10):
		v = randint(1,10)
		print(v,'! =',factorial(v))

if __name__=="__main__":
	main()
