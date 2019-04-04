'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
'''

def f(n):
	if n > 0:
		print(n % 10)
		f(n // 10)

def f2(n):
	if n > 0:
		f2(n // 10)
		print(n % 10)

def main():
	f(12345)
	print()
	f2(12345)
	
if __name__=="__main__":
	main()
