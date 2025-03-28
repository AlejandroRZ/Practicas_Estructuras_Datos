package estructuras.lineales;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Estructura "Ultimo en entrar, primero en salir".
 * @author DSO
 */
public class PilaArreglo<E> extends ColeccionAbstracta<E> implements Pila<E>{
	private final int LONGITUD = 10;
	private Object[] buffer = new Object[LONGITUD];
	private int cabeza = 0;
	
	/**
     * Indica si la pila esta vacia.
     * @return si la pila esta vacia o no.
     */	
	public boolean isEmpty(){
		return buffer[0]== null;
	}


	/**
     * Muestra el elemento al tope de la pila.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la pila esta vacia.
     */
    public E mira(){
    	if(this.isEmpty())throw new NoSuchElementException("La pila esta vacia");
    	return (E)buffer[cabeza - 1];
    }
    
    
    /**
     * Devuelve el elemento al tope de la pila y lo elimina.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public E expulsa(){
    	if(this.isEmpty())throw new NoSuchElementException("La pila esta vacia no hay elementos a eliminar");
    	E expulsado = (E)buffer[cabeza - 1];
    	buffer[cabeza -1] = null;
    	cabeza--;
    	return expulsado;
    }
    
    /**
     * Agrega un elemento al tope de la pila.
     * @param e Referencia al elemento a agregar.
     * @throws IllegalArgumentException cuando el parametro es nulo. 
     */
    public void empuja(E e){
    	if(e == null)throw new IllegalArgumentException("No se aceptan elementos nulos");
    	if(cabeza < buffer.length){
    		buffer[cabeza] = e;
    		cabeza++;
    	}else{
    		Object[] temporal = new Object[buffer.length * 2];
    		/* Se podria haber empleado el iterador pero dada la implementacion actual
            * se pueden ahorrar algunas operaciones resolviendo de la forma mostrada a
            * continuacion*/
    		for(int x = 0; x < cabeza; x++){
    			temporal[x] = buffer[x];    			
    		}
    		temporal[cabeza] = e;
    		cabeza++;
    		buffer = temporal;
    	}
    }

    public class Iterador implements Iterator<E>{
    	private boolean canRemove = false;
    	private int tam = cabeza - 1;

    	/**
        * Metodo que comprueba si hay un elemento siguiente.
        * @return respuesta si hay o no un siguiente elemento.
        */

        @Override
        public boolean hasNext() {
            return tam >= 0;
        }

         /**
        * Metodo que devuelve el siguiente elemento en la pila.
        * @return elemento siguiente en la pila.
        * @throws IllegalStateException si no hay elemento siguiente.
        */

        @Override
        public E next() {
            if(!hasNext())throw new IllegalStateException("No hay elemento siguiente");
            E temporal = (E)buffer[tam];
            tam--;
            canRemove = true;
            return temporal;
        }


        /**
        * Metodo que remueve el ultimo elemento devuelto por next().
        * @throws IllegalStateException si el metodo next()) no ha sido llamado
        * @throws NullPointerException  si no hay elemento que remover.
        */
        @Override
        public void remove() {
            if(!canRemove) throw new IllegalStateException("next() no ha sido llamado y/o el conjunto esta vacio.");
            if(PilaArreglo.this.isEmpty())throw new NullPointerException("No hay elemento que remover");
            PilaArreglo.this.expulsa();
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
        Iterador iterante = this.iterator();
        while(iterante.hasNext()){
            if(iterante.next().equals(e))return false;
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
        return cabeza;
    }


}