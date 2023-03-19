package com.uvg.gt;

/**
 * Clase Idiomas
 * 
 * Tiene como objetivo representar las 3 traducciones de una palabra en inglés,
 * español y francés de un diccionario
 */
public class Idiomas {

	/**
	 * Traducciones del diccionario
	 */
	private String ingles;
	private String espanol;
	private String frances;

	/**
	 * Método que construye la clase Idiomas de una palabra con sus 3 traducciones
	 * 
	 * @param ingles,  traduccion en inglés
	 * @param espanol, traduccion en español
	 * @param frances, traduccion en francés
	 */
	public Idiomas(String ingles, String espanol, String frances) {
		super();
		this.ingles = ingles;
		this.espanol = espanol;
		this.frances = frances;
	}

	/**
	 * Método que retorna la traduccion de la palabra en ingles
	 * 
	 * @return traduccion en ingles
	 */
	public String getIngles() {
		return ingles;
	}

	/**
	 * Método que cambia el valor de la variable ingles
	 * 
	 * @param ingles, palabra en ingles
	 */
	public void setIngles(String ingles) {
		this.ingles = ingles;
	}

	/**
	 * Método que retorna la traduccion de la palabra en español
	 * 
	 * @return traduccion en español
	 */
	public String getEspanol() {
		return espanol;
	}

	/**
	 * Método que cambia el valor de la variable español
	 * 
	 * @param español, palabra en español
	 */
	public void setEspanol(String espanol) {
		this.espanol = espanol;
	}

	/**
	 * Método que retorna la traduccion de la palabra en frances
	 * 
	 * @return traduccion en frances
	 */
	public String getFrances() {
		return frances;
	}

	/**
	 * Método que cambia el valor de la variable frances
	 * 
	 * @param frances, palabra en frances
	 */
	public void setFrances(String frances) {
		this.frances = frances;
	}

}