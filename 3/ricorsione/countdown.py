'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 countdown
'''

def countdown(n: int):
	'''
	conto alla rovescia partendo da n
	'''
	if n > 0:
		print(n, end=' ')
		countdown(n-1)

def main():
	countdown(5)
	print()
	
if __name__=="__main__":
	main()
