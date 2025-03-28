/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArregloTest {
    private static float mark;
    private static Arreglo a;
    private static Arreglo b;
    
    public ArregloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        mark=0;
        a = new Arreglo(new int [] {4,5});
        b = new Arreglo(new int [] {3,5,2});
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("==============================");
    	System.out.println("Calificación automática: " + mark);
        System.out.println("==============================");
    }

    @Test
    public void testBidimensional() {
        System.out.println("2-dimensiones");
        int count = 1;
        for(int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                a.almacenarElemento(new int [] {i,j},count);
                count++;
            }
        }
        int [] indices = {3,2};
        int result = a.obtenerElemento(indices);
        assertEquals(result,18);
        mark += 4;
    }

    @Test
    public void testTridimensional(){
        System.out.println("3-dimensiones");
        int count = 1;
        for(int i=0;i<3;i++){
            for (int j=0;j<5;j++) {
                for (int k=0;k<2;k++) {
                    b.almacenarElemento(new int [] {i,j,k},count);
                    count++;    
                }
            }
        }
        int [] indices = {2,3,0};
        int result = b.obtenerElemento(indices);
        assertEquals(result,27);
        mark +=4;
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testThrow1(){
        System.out.println("obtener indice en almacenarElemento - excepcion");
        try{
            b.almacenarElemento(new int [] {0,10,2},100);
        }catch(IndexOutOfBoundsException e){
            mark += 1;
            throw e;
        }

    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testThrow2(){
        System.out.println("obtener indice en obtenerElemento- excepcion");
        try{
            b.obtenerElemento(new int [] {0,10,2});
        }catch(IndexOutOfBoundsException e){
            mark += 1;
            throw e;
        }

    }
}
