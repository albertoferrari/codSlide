'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 elimina le vocali da una stringa
# '''


def elimina_vocali(s: str) -> str:
	'''
	restituisce la stringa s senza vocali
	'''
	vocali = 'aeiouAEIOU'
	if len(s) == 0:						#consizione di terminazione
		return ''
	if s[0] in vocali:						#se è una vocale
		return elimina_vocali(s[1:])		#ricorsione
	else:
		return s[0] + elimina_vocali(s[1:])	#ricorsione
	
def main():
	st = input('stringa:   ')
	print(elimina_vocali(st))

if __name__=="__main__":
	main()
