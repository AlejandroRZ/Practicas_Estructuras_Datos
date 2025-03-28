package estructuras;
import java.util.Iterator;
import java.util.Collection;

public abstract class ColeccionAbstracta<E> implements Collection<E>{

 /** 
 * Metodo que comprueba si un determinado elemento pertenece a la coleccion
 * @param o elemento a buscar en la coleccion.
 * @return respuesta en formato booleano, si lo contiene o no.
 * @throws NullPointerException si el elemento a buscar es nulo.
 */
 public boolean contains(Object o){
  if(o==null) throw new NullPointerException("No se admiten elementos nulos");
  Iterator<E> iter = this.iterator();
  while(iter.hasNext()){
  if(iter.next().equals(o)) return true; 
  }
  return false;  
 }

 /** 
 * Metodo que devuelve un arreglo con todos los elementos en la coleccion.
 * @return el arreglo con la coleccion de elementos.
 */
 public Object[] toArray(){  
  Object[] arreg = new Object[this.size()];
  int tama = 0;
  Iterator<E> iter = this.iterator();
  while(iter.hasNext()){
   arreg[tama] = iter.next();
   tama++;
  }
  return arreg;
 }

 /** 
 * Metodo que devuelve un arreglo con todos los elementos en la coleccion.
 * @param a  arreglo en el cual se almacenara la coleccion.
 * @return el arreglo con la coleccion de elementos. 
 * @throws NullPointerException si el parametro es nulo.
 * @throws IllegalArgumentException si el parametro no tiene espacio sufieciente.
 */

 public <T> T[] toArray(T[] a){
  if(a == null) throw new NullPointerException("No es un arreglo valido");
  if(a.length < 1) throw new IllegalArgumentException("Se necesita cuando menos un espacio");
  int longitud = this.size();  
  Iterator<E> iter = this.iterator();
  if(a.length >=longitud){
   for(int x=0; x<longitud; x++){
    a[x]= (T)iter.next();
   }
  }else{
   Iterator<E> iter2 = this.iterator();
   for(int y=0; y<a.length;y++){
    a[y]= (T)iter2.next();
   }
  }
  return a;
 }  

 /** 
 * Metodo que compara la coleccion que llama el metodo con otra cualquiera.
 * @param c la coleccion con la que se ha comparar.
 * @return respuesta en formato booleano, si contiene todos estos elementos o no. 
 * @throws NullPointerException si el parametro es nulo.
 */

 public boolean containsAll(Collection<?> c){
  if(c==null) throw new NullPointerException("No se aceptan colecciones nulas");
  int cont = c.size();
  int cont1 = 0;
  Iterator<?> iter1 = c.iterator();
  while(iter1.hasNext()){
   if(this.contains(iter1.next()))cont1++;
  }
  if(cont == cont1)return true;
  return false;
 }

 /** 
 * Metodo que añade los elementos de una coleccion a otra.
 * @param c la coleccion que se añadira.
 * @return respuesta en formato booleano, si se añadio la coleccion o no. 
 * @throws NullPointerException si el parametro es nulo.
 */
 public boolean addAll(Collection<? extends E> c){
  
  Iterator<? extends E > iter = c.iterator();
  if(c==null) throw new NullPointerException("No se aceptan colecciones nulas");
  int conteo = 0;
  int longi = c.size();
  while(iter.hasNext()){  
  if(this.add(iter.next()))conteo++;  
  }  
  if(conteo == longi)return true;
  System.out.println("Alguno o varios elementos no fueron añadidos");
  return false;  
 }
 

 /** 
 * Metodo que elimina un elemento en una coleccion.
 * @param o el elemento a eliminar.
 * @return respuesta si el elemento se elimino o no. 
 */
 
 public boolean remove(Object o){
  Iterator<E> iter = this.iterator();
  int tam = this.size();
  while(iter.hasNext()){
   if(iter.next().equals(o))iter.remove();
  }
  if(this.size() < tam)return true;
  return false;
 }

 /** 
 * Metodo que elimina todos los elementos en comun entre 2 colecciones.
 * @param c coleccion de elementos a eliminar.
 * @return respuesta si la coleccion se elimino o no. 
 * @throws NullPointerException si el parametro es nulo.
 */ 
 public boolean removeAll(Collection<?> c){
  if(c == null) throw new NullPointerException("No se aceptan colecciones nulas");
  Iterator<?> iter = c.iterator();
  int conteo = 0;
  int tam = c.size();
  while(iter.hasNext()){  
  if(this.remove(iter.next()))conteo++;  
  }  
  if(conteo == tam)return true;
  System.out.println("Alguno o varios elementos no fueron eliminados");
  return false;  
  
 }

 /** 
 * Metodo que retiene todos los elementos en comun entre 2 colecciones.
 * @param c coleccion de elementos a retener.
 * @return respuesta si la coleccion se retuvo o no. 
 * @throws NullPointerException si el parametro es nulo.
 */ 
 public boolean retainAll(Collection<?> c){
 if(c == null) throw new NullPointerException("No se aceptan colecciones nulas");
 Iterator<E> itera = this.iterator();
 while(itera.hasNext()){
 	if(!(c.contains(itera.next())))itera.remove();
 }
 if(this.containsAll(c))return true;
 System.out.println("No se retuvieron todos los elementos");
 return false;
 }

 /** 
 * Metodo que elimina todos los elementos en una coleccion.*/
 public void clear(){
  Iterator<E> iter = this.iterator();
  while(iter.hasNext()){
  	iter.next();
  	iter.remove();
  }
 } 


} 