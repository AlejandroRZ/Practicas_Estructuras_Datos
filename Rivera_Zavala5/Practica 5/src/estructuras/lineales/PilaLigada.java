package estructuras.lineales;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Estructura "Último en entrar, primero en salir".
 * @author DSO
 */
public class PilaLigada<E> extends ColeccionAbstracta<E> implements Pila<E>{
	private Nodo<E> cabeza;
	int tama = 0;

   /**
     * Muestra el elemento al tope de la pila.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la pila esta vacia.
     */
    public E mira(){
    	if(cabeza == null)throw new NoSuchElementException("La pila esta vacia");
    	return	(E)cabeza.getDato();
    }
    
    /**
     * Devuelve el elemento al tope de la pila y lo elimina.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public E expulsa() throws NoSuchElementException{
    	if(cabeza == null) throw new NoSuchElementException("La pila esta vacia, no hay elemento a expulsar");
    	E datoExpulsado = (E)cabeza.getDato();
    	cabeza = cabeza.getDireccion();
    	tama--;
    	return datoExpulsado;
    	
    }
    
    /**
     * Agrega un elemento al tope de la pila.
     * @param e Referencia al elemento a agregar.
     * @throws IllegalArgumentException si el elemento dado es nulo
     */
    public void empuja(E e){
    	if(e == null)throw new IllegalArgumentException("No se admiten elementos nulos");
    	Nodo nuevo = new Nodo(e,cabeza);
    	cabeza = nuevo;
    	tama++;
    }
   
    /**
      * Clase interna que define un iterador para PilaLigada.
      * @author DSO
      */    
    public class Iterador implements Iterator<E>{
    	private int x;
        private boolean canRemove;
        private PilaLigada<E> copiaPila;
        private E ultimoLlamado;

        /**
        * Metodo constructor para el iterador de la pila.
        */
        public Iterador(){
        	x = 0;
        	canRemove = false;
        	copiaPila = PilaLigada.this;
        	ultimoLlamado = null;
        }

        /**
        * Metodo que comprueba si hay un elemento siguiente.
        * @return respuesta si hay o no un siguiente elemento.
        */

        @Override
        public boolean hasNext() {
            return x < tama;
        }
        
        /**
        * Metodo que devuelve el siguiente elemento en la pila.
        * @return elemento siguiente en la pila.
        * @throws IllegalStateException si no hay elemento siguiente.
        */

        @Override
        public E next() {
            if(!hasNext()) throw new IllegalStateException();
            E temporal = copiaPila.expulsa();
            x++;
            canRemove = true;
            ultimoLlamado = temporal;
            return temporal;
        }
        
        /**
        * Metodo que remueve el ultimo elemento devuelto por next().
        * @throws IllegalStateException si el metodo next()) no ha sido llamado
        * @throws NullPointerException  si no hay elemento que remover.
        */
        @Override
        public void remove() {
            if(!canRemove) throw new IllegalStateException("next() no ha sido llamado y/o el conjunto está vacío.");
            if(PilaLigada.this.cabeza == null)throw new NullPointerException("No hay elemento que remover");
            do{
            PilaLigada.this.expulsa();             	
            } while( !(PilaLigada.this.mira().equals(ultimoLlamado))); 
            canRemove = false;       
        }


    }

    /**
    * Metodo que crea un iterador para la pila.
    * @return iterador para la pila.
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
    @Override
    public boolean add(E e){
        Iterador iter = this.iterator();
        while(iter.hasNext()){
            if(iter.next().equals(e))return false;
        }
        this.empuja(e);
        return true;
    }

    /** 
    * Devuelve el numero de elementos en el conjunto.
    * @return numero de elementos
    */
    @Override
    public int size() {
        return tama;
    }

    /**
     * Indica si la pila esta vacia.
     * @return si la pila esta vacia o no.
     */
    @Override
    public boolean isEmpty() {
        return tama == 0;
    }
	
}