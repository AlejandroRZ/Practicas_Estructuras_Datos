package estructuras.lineales;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Estructura "Ultimo en entrar, ultimo en salir".
 * @author DSO
 */

public class ColaLigada<E> extends ColeccionAbstracta<E> implements Cola<E>{
    private Nodo<E> inicio = null;
    private Nodo<E> fin = null;
    private int tamano = 0;


    public ColaLigada(){}    
    

    public ColaLigada(ColaLigada<E> cl){
        inicio = cl.inicio;
        fin = cl.fin;
        tamano = cl.tamano;
    }    

    /**
     * Indica si la cola esta vacia.
     * @return si la cola esta vacia o no.
     */
    public boolean isEmpty(){
     return inicio == null;
    }   


    /**
     * Muestra el elemento al inicio de la Cola
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElemntException si la Cola esta vacia.
     */
    public E mira() throws NoSuchElementException{
     if(isEmpty())throw new NoSuchElementException("No hay elementos en la cola");
     return inicio.getDato();
    }

        
    /**
     * Agrega un elemento al final de la Cola.
     * @param e Referencia al elemento a agregar.
     * @throws IllegalArgumentException si el elemnto a agregar es nulo.
     */
    public void encolar(E e){
     if(e == null)throw new IllegalArgumentException("No se admiten elementos nulos");
     Nodo<E> agregado = new Nodo<E>(e,null);
     if(isEmpty()){inicio = fin = agregado;}else{
        fin.setDireccion(agregado); 
        fin = fin.getDireccion();
     }      
     tamano++;    
    }

    /**
     * Devuelve el elemento al inicio de la Cola y lo elimina.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la Cola esta vacia.
     */
    public E desencolar() throws NoSuchElementException{
     if(isEmpty())throw new NoSuchElementException("No hay elementos en la cola");
     E temporal = this.mira();
     if(inicio == fin){inicio = null; fin = null;}else{
     inicio = inicio.getDireccion(); 
     }
     tamano--;
     return temporal;
    }

    
    /**
    * Clase interna que define un iterador para ColaLigada.
    * @author DSO
    */    

    public class Iterador implements Iterator<E>{
     private boolean canRemove;
     private int contador;
     private int tamanoTotal;
     private ColaLigada<E> copiaDeCola;
     private E ultimoLlamado;

        /**
        * Constructor de la clase interna Iterador.
        */
        
        public Iterador(){
            canRemove = false;
            contador = 0;
            copiaDeCola = new ColaLigada<E>(ColaLigada.this);
            tamanoTotal = ColaLigada.this.tamano;
        }


     

        /**
        * Metodo que comprueba si hay un elemento siguiente.
        * @return respuesta si hay o no un siguiente elemento.
        */
        @Override

     public boolean hasNext(){
      return contador < tamanoTotal;
     }

     /**
        * Metodo que devuelve el siguiente elemento en la cola.
        * @return elemento siguiente en la cola.
        * @throws IllegalStateException si no hay elemento siguiente.
        */
        @Override

     public E next(){
      if(!hasNext()) throw new IllegalStateException();
      E temporal = copiaDeCola.desencolar();
      contador++;
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

     public void remove(){
      if(!canRemove) throw new IllegalStateException("next() no ha sido llamado y/o el conjunto está vacío.");
      if(ColaLigada.this.isEmpty())throw new NullPointerException("No hay elemento que remover");
      E eliminado;
      do{
       eliminado = ColaLigada.this.desencolar();
      }while(!(eliminado.equals(ultimoLlamado)));
      canRemove = false;
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
     return tamano;     
    }
    
 
    
public static void main (String [] args){
 ColaLigada<String> colaD = new ColaLigada<String>();
 colaD.encolar("1");
 colaD.encolar("2");
 colaD.encolar("3");
 colaD.encolar("4");
 colaD.encolar("5");
 colaD.encolar("6");
 colaD.encolar("7");
 System.out.println(colaD.size());
 System.out.println(colaD.mira());
 colaD.desencolar();
 colaD.desencolar();
 colaD.desencolar();

}



}

