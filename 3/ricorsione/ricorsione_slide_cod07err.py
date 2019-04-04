'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
# '''

def f(n):
	if n != 0:
		print(n, end = ' ')
		f(n / 10)

def main():
	f(12345)

	
if __name__=="__main__":
	main()
