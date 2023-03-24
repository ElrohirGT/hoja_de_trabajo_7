package com.uvg.gt;

// librerias para la lectura y traduccion de oraciones
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// libreria para permitir la entrada de respuestas
import java.util.Scanner;

/**
 * Clase Traductor
 * 
 * Tiene como objetivo ser el controlador del programa, muestra un menu para
 * decidir el origen y destino de traduccion y la traduccion
 */
public class Traductor {

	// arbol con las asociaciones
	private BinaryTree<Item> arbol;

	/**
	 * Método que pide el idioma de origen y destino de la traduccion
	 * 
	 * @throws FileNotFoundException
	 */
	public void respuestaTraduccion() throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		String origen;
		String destino;

		System.out.println("=======================================");
		System.out.println("||            Diccionario            ||");
		System.out.println("=======================================");
		System.out.println("      --- Idiomas Disponibles ---      ");
		System.out.println("| 1. Ingles | 2. Espaniol | 3. Frances |\n");

		System.out.print("Ingresa la opcion numerica para el idioma de origen: ");
		origen = sc.next();
		System.out.print("Ingresa la opcion numerica para el idioma destino: ");
		destino = sc.next();

		/*
		 * realizar las asignaciones
		 */
		// origen = ingles
		if (origen.equals("1")) {
			origen = "ingles";
			arbol = Asociation.leerDatos(origen);
			traductorFrase(arbol, origen, destino);

			// origen = español
		} else if (origen.equals("2")) {
			origen = "espanol";
			arbol = Asociation.leerDatos(origen);
			traductorFrase(arbol, origen, destino);

			// origen = frances
		} else {
			origen = "frances";
			arbol = Asociation.leerDatos(origen);
			traductorFrase(arbol, origen, destino);

		}
		sc.close();
	}

	/**
	 * Método que traduce las oraciones de un txt de ejemplo
	 * 
	 */
	public void traductorFrase(BinaryTree<Item> arbol, String origen, String destino) {

		System.out.println("Las traducciones son:\n");
		// nodo encontrado en cada iteracion del txt
		Item item_encontrado;
		Item item = new Item();

		// evalua errores
		try {
			// abre el archivo txt
			BufferedReader br = new BufferedReader(new FileReader("ejemplos.txt"));
			String linea;

			// recorre el txt
			while ((linea = br.readLine()) != null) {

				// separa los signos de puntuación de cada linea
				String[] palabrasArray = linea.split("[^a-zA-Z0-9]+");

				// guarda la frase por palabra en una lista
				List<String> palabras = new ArrayList<String>();
				for (String palabra : palabrasArray) {
					palabras.add(palabra);
				}

				// lista con la traducción de la frase
				List<String> traduccion = new ArrayList<String>();

				// recorrer la lista con las palabras a traducir
				for (String palabra : palabras) {

					item.setLlave(palabra);

					// obtener el nodo con el nodo segun con el valor con la palabra enviada
					item_encontrado = arbol.get(item);

					// si el nodo está vacío, guardar la palabra en su formato "*palabra*"
					if (item_encontrado == null) {
						traduccion.add("*" + palabra + "*");

						// si el nodo no está vacío, guardar su traducción en la lista
					} else {
						// se obtiene la clase con los valores del valor del nodo
						Idiomas idiomas = item_encontrado.getValor();

						// si el destino es ingles, retornar su traducción
						if (destino.equals("1")) {
							traduccion.add(idiomas.getIngles());

							// si el destino es español, retornar su traducción
						} else if (destino.equals("2")) {
							traduccion.add(idiomas.getEspanol());

							// si el destino es frances, retornar su traducción
						} else {
							traduccion.add(idiomas.getFrances());

						}
					}
				}

				// mostrar la oracion y traduccion
				System.out.println(palabras);
				System.out.println(traduccion);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		System.out.println("\nLa jerarquia del arbol es:\n");
		arbol.inOrder(arbol.getRoot(), 0);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Traductor t = new Traductor();

		t.respuestaTraduccion();
	}

}
