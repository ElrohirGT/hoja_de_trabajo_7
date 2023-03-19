package com.uvg.gt;

/**
 * Clase Item
 * 
 * Tiene como objetivo representar la clase llave-valor que almacenará el árbol
 */
public class Item {

	/**
	 * Llave que identifica a la clase
	 */
	private String llave;
	/**
	 * Traducciones del diccionario
	 */
	private Idiomas valor;

	/**
	 * Método que construye la clase Item con su identificador y us 3 traducciones
	 * 
	 * @param llave, llave que identifica a la clase
	 * @param valor, traducciones del diccionario
	 */
	public Item(String llave, Idiomas valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}

	/**
	 * Método que retorna el valor de llave
	 * 
	 * @return llave que identifica a la clase
	 */
	public String getLlave() {
		return llave;
	}

	/**
	 * Método que modifica el valor de llave
	 * 
	 * @param llave, variable que modifica el valor de llave
	 */
	public void setLlave(String llave) {
		this.llave = llave;
	}

	/**
	 * Método que retorna el valor de la clase
	 * 
	 * @return valor que contiene la clase
	 */
	public Idiomas getValor() {
		return valor;
	}

	/**
	 * Método que modifica el valor de la clase
	 * 
	 * @param valor, variable que modifica el valor de la clase
	 */
	public void setValor(Idiomas valor) {
		this.valor = valor;
	}

}