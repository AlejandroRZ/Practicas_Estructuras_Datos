/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package estructuras.lineales;

import java.util.Collection;
import java.util.NoSuchElementException;

public interface Cola<E> extends Collection<E> {
    
    /**
     * Muestra el elemento al inicio de la Cola
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElemntException si la Cola esta vacía.
     */
    public E mira() throws NoSuchElementException;

    /**
     * Devuelve el elemento al inicio de la Cola y lo elimina.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la Cola esta vacía.
     */
    public E desencolar() throws NoSuchElementException;
    
    /**
     * Agrega un elemento al final de la Cola.
     * @param e Referencia al elemento a agregar.
     */
    public void encolar(E e);
    
}
