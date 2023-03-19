package com.uvg.gt;

//librerias para la lectura del archivo diccionario
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase Asociation
 * 
 * Tiene como objetivo realizar las asociaciones de un archivo txt con las de un
 * "Arbol"
 */
public class Asociation {

	/**
	 * Método leerDatos, lee un archivo "diccionario.txt" que contiene 3
	 * traducciones de una palabra en un orden "ingles,español,frances"
	 * 
	 * @param decision, decision del usuario sobre el idioma origen
	 * @return arbol, arbol con las asociaciones del diccionario
	 */
	public static Arbol leerDatos(String decision) throws FileNotFoundException {

		// arbol con las asociaciones
		Arbol arbol = new Arbol();

		// evalua errores durante la lectura del arhivo txt
		try {
			// abre el txt
			BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));
			// asumiendo el orden "ingles,español,frances"
			String linea;

			// recorre el txt
			while ((linea = br.readLine()) != null) {
				String[] palabras = linea.split(",");
				// ingles
				String ingles = palabras[0].toLowerCase();
				// español
				String espanol = palabras[1].toLowerCase();
				// frances
				String frances = palabras[2].toLowerCase();

				// instancia de idiomas
				Idiomas idiomas = new Idiomas(ingles, espanol, frances);

				// decision = ingles
				if (decision.equals("ingles")) {
					// Crear un Item
					Item item = new Item(ingles, idiomas);
					arbol.insertar(item);

					// decision = español
				} else if (decision.equals("espanol")) {
					// Crear un Item
					Item item = new Item(espanol, idiomas);
					arbol.insertar(item);

					// decision = frances
				} else {
					// Crear un Item
					Item item = new Item(frances, idiomas);
					arbol.insertar(item);
				}

			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}

		return arbol;
	}
}
