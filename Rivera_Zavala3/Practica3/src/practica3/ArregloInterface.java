package practica3;

/**
* Arreglo de n-dimensiones
*/
public interface ArregloInterface{

	/**
	* Devuelve el elemento que se encuentra en la posicion <code>th</code> en el arreglo multidimensional.
	* @param indices arreglo con los indices del elemento a recuperar.
	* @return el elemento almacenado en la posicion <code>i</code>.
	*/
	public int obtenerElemento(int [] indices);

	/**
	* Asigna un elemento en la posicion <code>th</code> del arreglo multidimensional.
	* @param indices arreglo con los indices donde se almacenara el elemento.
	* @param elem elemento a almacenar.
	*/
	public void almacenarElemento(int [] indices, int elem);

	/**
	* Devuelve la posicion <code>i</code> del elemento en el arreglo de una dimension.
	* @param indices arreglo con los indices donde esta el elemento en el arreglo multidimensional.
	* @return la posicion del elemento en el arreglo de una dimension.
	* @throws IndexOutOfBoundsException si alguno de los indices del arreglo no esta dentro del rango.
	*/
	public int obtenerIndice(int [] indices);
	
}