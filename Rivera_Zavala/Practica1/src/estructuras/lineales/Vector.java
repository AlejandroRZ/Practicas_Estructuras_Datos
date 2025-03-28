/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo resuelto a estudiantes actuales o potenciales.
 */
package estructuras.lineales;

/**
 * Arreglo redimensionable.
 * @author DSO.
 */
public class Vector< T extends Object> {
    public static final int INC = 10;
    private Object[] buffer;
    
    /**
     * Constructor que crea un <code>Vector</code> con capacidad inicial INC.
     */
    public Vector() {
        buffer = new Object[INC];
    }
    
    /// MÉTODOS DE ACCESO
    
    /**
     * Devuelve el elemento almacenado en la posición <code>i</code>.
     * @param i el índice del objeto a recuperar.
     * @return el elemento almacenado en la posición <code>i</code>.
     * @throws IndexOutOfBoundsException si
     *         <code>!(0 &lt;= i &lt; this.leeCapacidad()) </code>.
     */
    public T lee(int i) {
    if(i < 0 || i >= this.leeCapacidad()){
    	throw new IndexOutOfBoundsException("Esa no es una posicion valida");
    }else{ 
    	if(buffer[i] != null){
    		return  (T)(buffer[i]);}else{ return null;}
    	}          
    }
    
    /**
     * Devuelve la capacidad actual de este <code>Vector</code>.
     * @return la capacidad actual del <code>Vector</code>.
     */
    public int leeCapacidad() {
        return buffer.length;       
    }
    
    /// MÉTODOS DE MANIPULACIÓN
    
    /**
     * Almacena el elemento <code>e</code> en la posición <code>i</code>.
     * @param i el índice en el cual <code>e</code> será almacenado. 
     *          Debe cumplirse <code>0 &lt;= i &lt; this.leeCapacidad() </code>.
     * @param e el elemento a almacenar.
     * @throws IndexOutOfBoundsException si
     *         <code>!(0 &lt;= i &lt; this.leeCapacidad()) </code>.
     */
    public void asigna(int i, T e) {
    	if(i < 0 || i >= this.leeCapacidad()){
    	throw new IndexOutOfBoundsException("Esa no es una posicion valida");
        }else{this.buffer[i] = e;}    	
    }
    
    /**
     * Asigna la capacidad del <code>Vector</code>.
     * Si <code>n &lt; this.leeCapacidad()</code> los elementos de
     * <code>n</code> en adelante son descartados.
     * Si <code>n &gt; this.leeCapacidad()</code> se agregan <code>null</code>
     * en los espacios agregados.
     * @param n la nueva capacidad del <code>Vector</code>, debe ser mayor que
     *          cero.
     * @throws IllegalSizeException si <code>n &lt; 1</code>.
     */
    public void asignaCapacidad(int n) {
    	Object[] arreg;
    	if(n < 1)throw new IllegalSizeException("Capacidad no valida");
        if(n == this.leeCapacidad())return;
        arreg = new Object[n];

        for(int x = 0; x < n; x++){
            if(x >= this.leeCapacidad()){arreg[x] = null;
            }else{
                arreg[x] = this.lee(x);
            }                                  
        }  
    	this.buffer = arreg;    	
    }    	 
    
    /**
     * Garantiza que el <code>Vector</code> cuente al menos con capacidad para
     * almacenar <code>n</code> elementos.
     * Si <code>n &gt; this.leeCapacidad()</code> el tamaño del
     * <code>Vector</code> es incrementado de tal modo que el requerimiento
     * sea satisfecho con cierta holgura.
     * @param n capacidad mínima que debe tener el <code>Vector</code>,
     *          no puede ser menor a cero.
     */
    public void aseguraCapacidad(int n) {
    	if(n < 1)throw new IllegalSizeException("Capacidad no valida");
    	if(n <= this.leeCapacidad()){
    		System.out.println("Capacidad asegurada");}else{
    			for(int i = this.leeCapacidad(); i < n; i*= 2){
    		        this.asignaCapacidad(i*2);
    	        }
    	        System.out.println("Capacidad asegurada");
    	}    	
    }


}
