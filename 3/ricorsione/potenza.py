'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html

 Calcolare la potenza intera di un numero, sfruttando la ricorsione
'''

def potenza(base: int, esp: int) -> int:
	''' return base elevato a esp '''
	print('sto calcolando',base,'elevato',esp)
	if esp == 0:						#condizione di terminazione
		return 1						#se l'esponente è 0 il valore è 1
	return base * potenza(base, esp-1)	#ricorsione
	
	
def main():
	b = int(input("base: "))
	e = int(input("esponente: "))
	print(b,"^",e,"=",potenza(b,e))
    
if __name__ == '__main__':
    main()

