'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
'''

def f(n):
	if n > 0:
		print(n, end=' ')
		f(n-1)

def f2(n):
	if n > 0:
		f2(n-1)
		print(n, end=' ')

def main():
	f(5)
	print()
	f2(5)
	
if __name__=="__main__":
	main()
