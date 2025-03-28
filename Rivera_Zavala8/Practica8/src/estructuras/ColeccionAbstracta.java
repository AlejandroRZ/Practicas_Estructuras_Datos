/*
 * Codigo utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didacticos en forma personal,
 * pero no esta permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package estructuras.lineales;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Implementacion generica de varios metodos aprovechando el iterador,
 * que debera ser implementado por las subclases.
 * @author veronica
 */
public abstract class ColeccionAbstracta<E> implements Collection<E> {
    
    /**
     * Indica si esta coleccion contiene al objeto <code>o</code>.
     * Asume que puede haber elementos nulos dentro de la estructura.
     * @param o El objeto a buscar.
     * @return true si el objeto se encuentra.
     */
    @Override
    public boolean contains(Object o) {
        for(E elemento : this) {
            if(o == null ? elemento == null : o.equals(elemento)) return true;
        }
        return false;
    }
    
    /**
     * Devuelve un arreglo con referencias a todos los elementos de la coleccion
     * en el orden definido por su iterador.
     * @return arreglo con referencias.
     */
    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[size()];
        int i = 0;
        for(E elemento : this) {
            arreglo[i] = elemento;
            i++;
        }
        return arreglo;
    }

    /**
     * Devuelve un arreglo con referencias a todos los elementos de la coleccion,
     * del mismo tipo que el arreglo enviado como parametro,
     * en el orden definido por su iterador.
     * Para detalles sobre cuando se usa el arreglo enviado o cuando se crea
     * uno nuevo, ver documentacion en la interfaz <code>Collection</code>.
     * @return arreglo con referencias.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        int tam = size();
        if(a.length < tam){
            a = Arrays.copyOf(a, tam);
        }
        int i = 0;
        for(E obj : this){
            a[i++] = (T)obj;
        }
        if(a.length > tam){
            a[tam] = null;
        }
        return a;
    }

    /** 
     * Indica si esta coleccion contiene a todos los elementos de <code>c</code>. 
     * @param c estructura con los elementos a revisar.
     * @return <code>true</code> si esta estructura contiene a todos los elementos
     *         de <code>c</code>.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c) {
            if(!this.contains(c)) return false;
        }
        return true;
    }

    /**
     * Intenta agregar a todos los elementos en <code>c</code>.
     * Si la estructura subyacente impide que algun elemento se agregue,
     * lanzando la excepcion correspondiente, este metodo permitira¡ que la
     * excepcion se propague.
     * @param c estructura a añadir.
     * @return cambio respuesta si se añdieron todos los elementos en c o no.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean cambio = false;
        for(E elem : c) {
            if(add(elem) == true) cambio = true;
        }
        return cambio;
    }

    /**
     * Remueve un solo ejemplar del elemento especificado de esta coleccion, si
     * se encuentra presente y satisface (o==null ? e==null : o.equals(e)).
     * @param o elemento a remover si se encuentra presente.
     * @return true si la estructura cambio al remover el elemento.
     */
    @Override
    public boolean remove(Object o) {
        Iterator<E> it = this.iterator();
        while(it.hasNext()) {
            E elemento = it.next();
            if (o == null ? elemento == null : o.equals(elemento)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Se asegura de que esta coleccion no contenga ninguna instancia que esta
     * en <code>c</code>.
     * Si la estructura subyacente impide que algun elemento se elimine,
     * lanzando la excepcion correspondiente, este metodo permitira que la
     * excepcion se propague.
     * @param c la coleccion a remover.
     * @return cambio respuesta si se eliminaron todos los elementos de c.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean cambio = false;
        for(Object o : c) {
            while(remove(o)) cambio = true;
        }
        return cambio;
    }

    /**
     * Remueve todos los elementos que no se encuentren en <code>c</code>.
     * @param c Coleccion con los elementos que se desea conservar.
     * @return true si esta coleccion fue modificada.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator<E> it = iterator();
        boolean cambio = false;
        while(it.hasNext()) {
            if(!c.contains(it.next())) {
                // Utilizamos al iterador para remover al elemento porque
                // el iterador ya sabe dÃ³nde se encuentra.
                it.remove();
                cambio = true;
            }
        }
        return cambio;
    }

    /**
     * Remueve a todos los elementos de la coleccion uno por uno, en el orden
     * dictado por el iterador.
     */
    @Override
    public void clear() {
        Iterator<E> it = iterator();
        while(it.hasNext()) {
            it.remove();
        }
    }
    
}
