package Practica2;


/* Calcula el número de operaciones que tarda un método en ser ejecutado.*/
public interface RecursionInterfaz{

/*
* Asigna el nombre del archivo en el cual se guardara el reporte
* del numero de operaciones que tardo el ultimo metodo ejecutado.
*/
public void asignaNombreDeArchivo(String archivo);

/*
* Metodo para calcular de forma recursiva el elemento en la fila </code>i</code>
* en la columa </code>j</code> del triangulo de Pascal.
* @param i el numero de fila.
* @param j el numero de columna.
* @return el elemento en la </code>i</code>-esima  fila y la
* </code>j</code>-esima columna del triangulo de Pascal.
*/
public int tPascalRec(int i, int j);

/*
* Metodo para calcular de forma iterativa el elemento en la fila </code>i</code>
* en la columa </code>j</code> del triangulo de Pascal.
* @param i el numero de fila.
* @param j el numero de columna.
* @return el elemento en la </code>i</code>-esima  fila y la
* </code>j</code>-esima columna del triangulo de Pascal.
*/
public int tPascalIt(int i, int j);

/*
* Devuelve el n-esimo elemento calculado de forma recursiva de la sucesion
* de Fibonacci.
* @param n el el indice del elemento que se desea calcular
* @return el n-esimo elemento en la sucesion de Fibonacci.
*/

public int fibonacciRec(int n);

/*
* Devuelve el n-esimo elemento calculado de forma iterativa de la sucesion
* de Fibonacci.
* @param n el el indice del elemento que se desea calcular
* @return el n-esimo elemento en la sucesion de Fibonacci.
*/
public int fibonacciIt(int i);	

}