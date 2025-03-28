/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package estructuras.lineales;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Estructura "Último en entrar, primero en salir".
 * @author veronica
 */
public interface Pila<E> extends Collection<E> {
    
    /**
     * Muestra el elemento al tope de la pila.
     * @return Una referencia al elemento siguiente.
     */
    public E mira();
    
    /**
     * Devuelve el elemento al tope de la pila y lo elimina.
     * @return Una referencia al elemento siguiente.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public E expulsa() throws NoSuchElementException;
    
    /**
     * Agrega un elemento al tope de la pila.
     * @param e Referencia al elemento a agregar.
     */
    public void empuja(E e);
    
}
