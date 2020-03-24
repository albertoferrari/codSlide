'''
 @author Alberto Ferrari - https://albertoferrari.github.io/
 @license This software is free - http://www.gnu.org/licenses/gpl.html
 
 stringa palindroma
'''

def palindroma(testo: str) -> bool:
	''' true se la stringa testo è palindroma '''
	if len(testo) <= 1:
		return True					# terminazione positiva
	primo = testo[0]
	ultimo = testo[-1]
	centro = testo[1:-1]
	if primo != ultimo:				# primo carattare diverso da ultimo
		return False				# terminazione negativa
	else:
		return palindroma(centro)	# verifica il resto della stringa

def palindroma_bis(testo: str) -> bool:
	print("sto verificando se è palindroma la stringa: ",testo)
	if len(testo) <= 1:
		return True
	return testo[0] == testo[-1] and palindroma_bis(testo[1:-1])

if __name__ == '__main__':
	#print('ottetto',palindroma_bis('ottetto'))
	#print('areyrra',palindroma_bis('areyrra'))
	#print('ottetto',palindroma_bis('ottetto'))
	#print('arca',palindroma_bis('arca'))
	print('antktna',palindroma_bis('antktna'))
