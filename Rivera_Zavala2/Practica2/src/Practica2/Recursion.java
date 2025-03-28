package Practica2;
import java.io.IOException;
import java.io.FileWriter;

/*
* Clase para estudiar el comportamiento de metodos iterativos y recursivos.
* @author DSO
*/

public class Recursion implements RecursionInterfaz{
/*Atributos para contabilizar numero de operaciones y guardar datos.*/
private int contadorPascal = 0;
private int contadorFibonacci = 0;
private int contadorFactorial = 0;
private String cadenaArchivo = "";


/*
* Metodo auxiliar que calcula el factorial de un numero de forma iterativa.
* @param numero valor del cual se calculara su factorial.
* @return el factorial de dicho numero.
*/

private int factorialIt(int numero){
	int factorialis = 1;
	if(numero == 1 || numero == 0)return 1;
	for(int x = 2; x <= numero; x++){
		factorialis *= x;
		contadorFactorial++;
	}
	return factorialis;
}

/*
* Asigna el nombre del archivo en el cual se guardara el reporte
* del numero de operaciones que tardo el ultimo metodo ejecutado.
* @param cadena con el nombre del archivo en el que se guardara la informacion.
*/
public void asignaNombreDeArchivo(String archivo){
 cadenaArchivo = archivo;
}

/*
* Metodo para calcular de forma recursiva el elemento en la fila </code>i</code>
* en la columa </code>j</code> del triangulo de Pascal.
* @param i el numero de fila.
* @param j el numero de columna.
* @return el elemento en la </code>i</code>-esima  fila y la
* </code>j</code>-esima columna del triangulo de Pascal.
* @throws IndexOutOfBoundsException cuando se indica una posicion no valida.
*/
public int tPascalRec(int x, int y){
	int resultadoFinal = this.tPascalRecInterno(x,y);
	try(FileWriter fout = new FileWriter(this.cadenaArchivo + ".dat", true);){
		fout.write(x + "	" + y + "	" + contadorPascal + "\n");
		contadorPascal = 0;
	}catch(IOException ioe){
		System.err.print("El archivo " + this.cadenaArchivo + " no pudo ser guardado");
	}
	return resultadoFinal;
}

/* Metodo en el que se efectua la operacion recursiva.
* @param i el numero de fila.
* @param j el numero de columna.
* @return el elemento en la </code>i</code>-esima  fila y la
* </code>j</code>-esima columna del triangulo de Pascal.
**/
private int tPascalRecInterno(int i, int j){
	contadorPascal++;
	if(j>i) throw new IndexOutOfBoundsException("Posicion no valida");
	if(i==0 || j==0 || i==j)return 1;
	return(tPascalRec(i-1,j-1) + tPascalRec(i-1,j));
}


/*
* Metodo para calcular de forma iterativa el elemento en la fila </code>i</code>
* en la columa </code>j</code> del triangulo de Pascal.
* @param i el numero de fila.
* @param j el numero de columna.
* @return el elemento en la </code>i</code>-esima  fila y la
* </code>j</code>-esima columna del triangulo de Pascal.
* @throws IndexOutOfBoundsException cuando se indica una posicion no valida.
*/
public int tPascalIt(int i, int j){
	int contador = 0;
	int result = 0;
	if(i<0 || j<0) throw new IndexOutOfBoundsException("Posicion no valida");
	for(int x = 0; x <= i;x++){		
		for(int y = 0; y<x+1; y++){
			result = this.factorialIt(x)/( this.factorialIt(y)* this.factorialIt(x-y));
			contador++;	
			if(x == i && y == j) break;	
		}
		contador++;		
	}	
	try(FileWriter fout = new FileWriter(this.cadenaArchivo + ".dat", true);){
		int contadorTotal = contador + contadorFactorial;
		fout.write(i + "	" + j +"	" + contadorTotal + "\n");
		contadorFactorial = 0;
	}catch(IOException iep){
		System.err.print("El archivo " + this.cadenaArchivo + " no pudo ser guardado");
	}
	return result;	
}

/*
* Devuelve el n-esimo elemento calculado de forma recursiva de la sucesion
* de Fibonacci.
* @param n el el indice del elemento que se desea calcular
* @return el n-esimo elemento en la sucesion de Fibonacci.
**/
public int fibonacciRec(int m){
	int resultadoFinal = fibonacciRecInterno(m);
	try(FileWriter fout = new FileWriter(this.cadenaArchivo + ".dat", true);){
		fout.write(m + "	" + this.contadorFibonacci + "\n");
		contadorFibonacci = 0;
	}catch(IOException iepo){
		System.err.print("El archivo " + this.cadenaArchivo + " no pudo ser guardado");
	}
	return resultadoFinal;
}

/* Metodo en el que se efectua la operacion recursiva.
* @param n el el indice del elemento que se desea calcular
* @return el n-esimo elemento en la sucesion de Fibonacci.
* @throws IndexOutOfBoundsException cuando se indica una posicion no valida.
**/
private int fibonacciRecInterno(int n){
	contadorFibonacci++;
	if(n<0) throw new IndexOutOfBoundsException("Posicion no valida");
	if(n == 0)return 0;
	if(n == 1)return 1;
	return fibonacciRecInterno(n-1) + fibonacciRecInterno(n-2);
}

/*
* Devuelve el n-esimo elemento calculado de forma iterativa de la sucesion
* de Fibonacci.
* @param n el el indice del elemento que se desea calcular
* @return el n-esimo elemento en la sucesion de Fibonacci.
* @throws IndexOutOfBoundsException cuando se indica una posicion no valida.
*/
public int fibonacciIt(int n){
	int contador = 0;
	if(n == 0 || n== 1)return 1;
	if(n<0) throw new IndexOutOfBoundsException("Posicion no valida");
	int a=0,b=1,c = 0;
	for(int x = 1; x < n; x++){
		c= a+b;
		a= b;
		b= c;
		contador++;
	}
	try(FileWriter fout = new FileWriter(this.cadenaArchivo + ".dat", true);){
		fout.write(n + "	" + contador + "\n");
	}catch(IOException iepe){
		System.err.print("El archivo " + this.cadenaArchivo + " no pudo ser guardado");
	}
	return c;
}	

/*Entrada a main*/
public static void main (String[]args){
	Recursion prueba = new Recursion();
	
	prueba.asignaNombreDeArchivo("arch1");
	prueba.fibonacciIt(3);
	prueba.fibonacciIt(5);
	prueba.fibonacciIt(7);
	prueba.fibonacciIt(19);
	prueba.fibonacciIt(21);
	
	prueba.asignaNombreDeArchivo("arch2");
	prueba.fibonacciRec(5);
	prueba.fibonacciRec(5);
	prueba.fibonacciRec(7);
	prueba.fibonacciRec(19);
	prueba.fibonacciRec(21);

	prueba.asignaNombreDeArchivo("arch3");
	prueba.tPascalIt(3, 2);
	prueba.tPascalIt(5, 3);
	prueba.tPascalIt(7, 3);
	prueba.tPascalIt(19, 11);
	prueba.tPascalIt(21, 9);

	prueba.asignaNombreDeArchivo("arch4");
	prueba.tPascalRec(3, 2);
	prueba.tPascalRec(5, 3);
	prueba.tPascalRec(7, 3);
	prueba.tPascalRec(19, 11);
	prueba.tPascalRec(21, 9);



}


}