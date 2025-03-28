package estructuras.lineales;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Estructura "Ultimo en entrar, ultimo en salir".
 * @author DSO
 */

public class ColaArreglo<E> extends ColeccionAbstracta<E> implements Cola<E>{
 private int cabeza = 0;
 private int fin = 0;
 private int tam = 0;
 private final int longitudInicial = 10;
 private Object[] buffer = new Object[longitudInicial];

 /**
 * Constructor vacio para ColaArreglo.
 */

 ColaArreglo(){
	for(int x = 0; x < buffer.length; x++){
		buffer[x] = null;
	}
}

 /**
 * Metodo que verifica si la cola esta vacia o no
 * @return respuesta si la cola esta vacia o no. 
 */
 @Override 
 
 public boolean isEmpty(){
  if(buffer[fin] == null)return true;
  return false;
 }

 /**
 * Metodo auxiliar para determinar la posición del elemento a eliminar.
 */
 
 private static int mod(int n, int m){
  if(n >= 0)return n%m;
  return 3 - ((int)Math.abs(n)%3);
 }

 /**
    * Muestra el elemento al inicio de la Cola
    * @return Una referencia al elemento siguiente.
    * @throws NoSuchElementException si la Cola esta vacía.
    */
 
 public E mira(){
  if(isEmpty())throw new NoSuchElementException("La cola esta vacía");
  return (E)buffer[cabeza];
 }

 /**
    * Devuelve el elemento al inicio de la Cola y lo elimina.
    * @return Una referencia al elemento siguiente.
    * @throws NoSuchElementException si la Cola esta vacía.
    */

 public E desencolar () throws NoSuchElementException{
 	if(isEmpty())throw new NoSuchElementException("La cola esta vacía");
 	E temp = (E)buffer[cabeza];
 	buffer[cabeza] = null;
 	cabeza = (cabeza + 1)%buffer.length;
 	tam--;
 	return temp;
 }

 /**
    * Agrega un elemento al final de la Cola.
    * @param e Referencia al elemento a agregar.
    */

 public void encolar(E e){
  if(e == null)throw new IllegalArgumentException("No se aceptan elementos nulos");  
  if(isEmpty()){fin = 0;}else{fin = (fin + 1)%buffer.length;}  
  if(fin == cabeza && !isEmpty()){
   Object[] temporal = new Object[buffer.length * 2];
   for(int init = cabeza, i = 0; i<buffer.length; init = (cabeza + 1)%buffer.length , i++){
       temporal[i] = (E)buffer[init];
      }
      cabeza = 0;
      fin = buffer.length - 1;
      buffer = temporal;    
  }     
     buffer[fin] = e;
     tam++;
 }
    
    /**
    * Clase interna que define un iterador para ColaArreglo.
    * @author DSO
    */ 

 public class Iterador implements Iterator<E>{
  private int sig;
  private boolean canRemove = false;

  /**
        * Metodo constructor para un iterador.
        */

  public Iterador(){
   sig = cabeza;
  }

        /**
        * Metodo que comprueba si hay un elemento siguiente.
        * @return respuesta si hay o no un siguiente elemento.
        */
        @Override

  public boolean hasNext(){
   return sig != fin;
  }

  /**
        * Metodo que devuelve el siguiente elemento en la cola.
        * @return elemento siguiente en la cola.
        * @throws IllegalStateException si no hay elemento siguiente.
        */
        @Override

  public E next(){
   if(!hasNext())throw new IllegalStateException();
   E temp = (E)buffer[sig];
   sig = (sig + 1)%buffer.length;
   canRemove = true;
   return temp;
  }
  
  /**
        * Metodo que remueve el ultimo elemento devuelto por next().
        * @throws IllegalStateException si el metodo next()) no ha sido llamado
        * @throws NullPointerException  si no hay elemento que remover.
        */
        @Override

  public void remove(){
   if(!canRemove)throw new IllegalStateException("next() no ha sido llamado y/o el conjunto esta vacio.");
   if(ColaArreglo.this.isEmpty())throw new NullPointerException("No hay elemento que remover"); 
   int indiceRem = mod(sig - 1, buffer.length);
   for(int i = indiceRem; i < mod(fin - 1, buffer.length); i = (i+1)%buffer.length){
    buffer[i] = buffer[(i+1)%buffer.length];
   }
   buffer[mod(fin - 1, buffer.length)]= null;
  }

 }

 /**
    * Metodo que crea un iterador para la cola.
    * @return iterador para la cola.
    */
    public Iterador iterator(){
     return new Iterador();          
    }

     /**
     * Agrega el elemento <code>e</code> unicamente si no se encuentra uno igual,
     * de acuerdo a la definicion del metodo <code>equals</code> de <code>E</code>.
     * @param e Elemento que se quiere agregar.
     * @return Si el elemento fue agregado devuelve <code>true</code>,
     *         si ya estaba devuelve <code>false</code>.
     */    

    public boolean add(E e){
     Iterador iteract = this.iterator();
        while(iteract.hasNext()){
            if(iteract.next().equals(e))return false;
        }
        this.encolar(e);
        return true;
    }

    /** 
    * Devuelve el numero de elementos en el conjunto.
    * @return numero de elementos
    */

    public int size(){
     return tam;     
    }



 }






