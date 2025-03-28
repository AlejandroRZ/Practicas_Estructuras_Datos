package estructuras.lineales;
/**
 * Estructura que guarda un elemento y la direccion de otro contenedor.
 * @author DSO.
 */
class Nodo<E>{
 //Dato a almacenar en el nodo
 private E dato;
 //Direccion del nodo con el siguiente dato
 private Nodo<E> direccion;
/**
 * Constructor que recibe parametros.
 * @param d dato a almacenar en el nodo.
 * @param dir direccion del nodo con el siguiente dato.
 */
 public Nodo(E d, Nodo<E> dir){
  dato = d;
  direccion = dir;
 }

/**
 * Metodo que obtiene el dato almacenado en el nodo.
 * @return dato almacenado en el nodo. 
 */
 
 public E getDato(){
  return dato;
 }

/**
 * Metodo que obtiene la direccion del nodo siguiente.
 * @return direccion del nodo siguiente. 
 */

 public Nodo<E> getDireccion(){
  return direccion;
 }

/**
 * Metodo que modifica la direcion a la que apunta un nodo.
 * @param n direccion del nodo siguiente. 
 */

 public void setDireccion(Nodo<E> n){
 	direccion = n;
 }

}