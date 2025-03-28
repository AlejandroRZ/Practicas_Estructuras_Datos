/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package estructuras.lineales;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Implementación genérica de varios métodos aprovechando el iterador,
 * que deberá ser implementado por las subclases.
 * @author veronica
 */
public abstract class ColeccionAbstracta<E> implements Collection<E> {
    
    /**
     * Indica si esta colección contiene al objeto <code>o</code>.
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
     * Devuelve un arreglo con referencias a todos los elementos de la colección
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
     * Devuelve un arreglo con referencias a todos los elementos de la colección,
     * del mismo tipo que el arreglo enviado como parámetro,
     * en el orden definido por su iterador.
     * Para detalles sobre cuando se usa el arreglo enviado o cuándo se crea
     * uno nuevo, ver documentación en la interfaz <code>Collection</code>.
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
     * Indica si esta colección contiene a todos los elementos de <code>c</code>. 
     * @param c Estructura con los elementos a revisar.
     * @return true si esta estructura contiene a todos los elementos
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
     * Si la estructura subyacente impide que algún elemento se agregue,
     * lanzando la excepción correspondiente, este método permitirá que la
     * excepción se propague.
     * @param c estructura a añadir a la coleccion.
     * @return cambio respuesta si fue posible añadir todos o no.
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
     * Remueve un solo ejemplar del elemento especificado de esta colección, si
     * se encuentra presente y satisface (o==null ? e==null : o.equals(e)).
     * @param o elemento a remover si se encuentra presente.
     * @return true si la estructura cambió al remover el elemento.
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
     * Se asegura de que esta colección no contenga ninguna instancia que esté
     * en <code>c</code>.
     * Si la estructura subyacente impide que algún elemento se elimine,
     * lanzando la excepción correspondiente, este método permitirá que la
     * excepción se propague.
     * @param c estructura a remover de la coleccion.
     * @return cambio respuesta si fue posible eliminar todos los elementos de c
     * en la coleccion.
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
     * @param c Colección con los elementos que se desea conservar.
     * @return true si esta colección fue modificada.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator<E> it = iterator();
        boolean cambio = false;
        while(it.hasNext()) {
            if(!c.contains(it.next())) {
                // Utilizamos al iterador para remover al elemento porque
                // el iterador ya sabe dónde se encuentra.
                it.remove();
                cambio = true;
            }
        }
        return cambio;
    }

    /**
     * Remueve a todos los elementos de la colección uno por uno, en el orden
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
