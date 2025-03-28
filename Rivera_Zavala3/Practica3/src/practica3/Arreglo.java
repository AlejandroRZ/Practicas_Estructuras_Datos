package practica3;

public class Arreglo implements ArregloInterface{
private int[] dim;
private int[] rep;
	
/** 
* Metodo constructor de un arreglo unidimensional que representa a 
* un arreglo multidimensional(de Illife).
* @param dimensiones arreglo que contiene el numero de dimensiones asi 
* como sus respectivas longitudes.
**/
	public Arreglo(int [] dimensiones){
		int tam = 1;
		if(dimensiones.length < 1) throw new IllegalArgumentException("Tamaño del arreglo no valido");		
			dim = new int[dimensiones.length];
			for(int a=0; a<dimensiones.length;a++){
				if(dimensiones[a]>0){
				tam *=  dimensiones[a];
				dim[a] = dimensiones[a];
			    }else{
			    	throw new IllegalArgumentException("Tamaño no valido");
			     }
		    }		
		rep = new int[tam];	
	}

	
	/**
	* Devuelve el elemento que se encuentra en la posicion <code>th</code> en el arreglo multidimensional.
	* @param indices arreglo con los indices del elemento a recuperar.
	* @return el elemento almacenado en la posicion <code>i</code>.
	*/
	public int obtenerElemento(int [] indices){
		
		if(indices.length != dim.length) throw new IllegalArgumentException("Cantidad de indices invalida");
		for(int b = 0; b<indices.length; b++){
			if(indices[b] > dim[b] || indices[b]<0 )throw new IndexOutOfBoundsException("Indice invalido");
		}
		int suma = 0;
		for(int y = 0; y < dim.length ;y++){
			int producto = 1;
			for(int x = y+1; x<dim.length;x++){
				producto *= dim[x];
			}
			suma += producto * indices[y];
		}
		return rep[suma];
	
	}

	
	/**
	* Asigna un elemento en la posicion <code>th</code> del arreglo multidimensional.
	* @param indices arreglo con los indices donde se almacenara el elemento.
	* @param elem elemento a almacenar.
	*/
	public void almacenarElemento(int [] indices, int elem){
		if(indices.length != dim.length) throw new IllegalArgumentException("Cantidad de indices invalida");
		
		for(int c = 0; c<indices.length; c++){
			if(indices[c] > dim[c] || indices[c]<0)throw new IndexOutOfBoundsException("Indice invalido");
		}
		int suma = 0;
		for(int z = 0; z < dim.length ;z++){
			int producto = 1;
			for(int w = z+1; w<dim.length;w++){
				producto *= dim[w];
			}
			suma += producto * indices[z];
		}
		rep[suma] = elem;
	}

	/**
	* Devuelve la posicion <code>i</code> del elemento en el arreglo de una dimension.
	* @param indices arreglo con los indices donde esta el elemento en el arreglo multidimensional.
	* @return la posicion del elemento en el arreglo de una dimension.
	* @throws IndexOutOfBoundsException si alguno de los indices del arreglo no esta dentro del rango.
	*/
	public int obtenerIndice(int [] indices){
		if(indices.length != dim.length) throw new IllegalArgumentException("Cantidad de indices invalida");
		for(int d = 0; d<indices.length; d++){
			if(indices[d] > dim[d] || indices[d]<0)throw new IndexOutOfBoundsException("Indice invalido");
		}
		int suma = 0;
		for(int p = 0; p < dim.length ;p++){
			int producto = 1;
			for(int q = p+1; q<dim.length;q++){
				producto *= dim[q];
			}
			suma += producto * indices[p];
		}
		return suma;
	}


}