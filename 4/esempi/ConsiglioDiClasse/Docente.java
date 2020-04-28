/**
 * @author AF
 * Docente con nome e materia
 */
public class Docente {
	
	/** nome del docente */
	private String nome;
	
	/** materia insegnata dal docente nella classe */
	private String materia;

	/**
	 * @param nome nome del docente
	 * @param materia materia insegnata
	 */
	public Docente(String nome, String materia) {
		this.nome = nome;
		this.materia = materia;
	}

	/**
	 * @return nome del docente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome nome del docente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return materia insegnata
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia materia insegnata
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "prof " + nome + ", insegna " + materia;
	}
	
}
