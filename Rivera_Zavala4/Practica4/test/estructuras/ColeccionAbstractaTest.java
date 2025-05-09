/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package estructuras;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import java.util.Random;
import java.util.LinkedList;
/**
 * Batería de pruebas unitarias para la clase <code>ColeccionAbstracta</code>.
 * @author ricardo
 */
public class ColeccionAbstractaTest {
    
    private static float mark;
    
    private Random intGenerator;
    public ColeccionAbstractaTest() {
		intGenerator = new Random();
    }
    
    @BeforeClass
    public static void setUpClass() {
        mark = 0;
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n==============================");
    	System.out.println("Calificación automática: " + mark);
        System.out.println("==============================");
    }
    
    /**
     * Test of contains method, of class ColeccionAbstracta.
     */
    @Test
    public void testContains() {
		System.out.print("\nRevisando metodo contains...");
		Conjunto<String> ctest = new Conjunto<String> ();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		int rnd = intGenerator.nextInt(1000);
		assertTrue(ctest.contains("" + rnd));
		assertFalse(ctest.contains(-1));
		System.out.print("Correcto");
		mark+=1;
    }

    /**
     * Test of toArray() method, of class ColeccionAbstracta.
     */
    @Test
    public void testToArray_0args() {
		System.out.print("\nRevisando metodo toArray sin argumentos...");
		Conjunto<String> ctest = new Conjunto<String> ();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		Object [] ob = ctest.toArray();
		for(int i=0;i<1000;i++){
			assertEquals((String)ob[i],""+i);
		}
		System.out.print("Correcto");
		mark+=1;
    }

    /**
     * Test of toArray(T) method, of class ColeccionAbstracta.
     */
    @Test
    public void testToArray_GenericType() {
		System.out.print("\nRevisando metodo toArray con argumentos...");
		Conjunto<String> ctest = new Conjunto<String> ();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		String [] tmp= new String[1000];
		tmp = ctest.toArray(tmp);
		for(int i=0;i<1000;i++){
			assertEquals(tmp[i],""+i);
		}
		System.out.print("Correcto");
		mark+=1;   
    }
    
    /**
     * Test of containsAll method, of class ColeccionAbstracta.
     */
    @Test
    public void testContainsAll() {
		System.out.print("\nRevisando metodo containsAll...");
		Conjunto<String> ctest = new Conjunto<String> ();
		LinkedList<String> tmp= new LinkedList<String>();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
			tmp.add(""+i);
		}
		assertTrue(ctest.containsAll(tmp));
		System.out.print("Correcto");
		mark+=1;
    }

    /**
     * Test of addAll method, of class ColeccionAbstracta.
     */
    @Test
    public void testAddAll() {
		System.out.print("\nRevisando metodo addAll...");
		Conjunto<String> ctest = new Conjunto<String> ();
		LinkedList<String> tmp= new LinkedList<String>();
		for(int i=0;i<1000;i++){
			tmp.add(""+i);
		}
		ctest.addAll(tmp);
		for(String s : tmp)
			assertTrue(ctest.contains(s));
		System.out.print("Correcto");
		mark+=1;
    }

    /**
     * Test of remove method, of class ColeccionAbstracta.
     */
    @Test
    public void testRemove() {
		System.out.print("\nRevisando metodo remove...");
		Conjunto<String> ctest = new Conjunto<String> ();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		int rnd = intGenerator.nextInt(1000);
		assertTrue(ctest.remove(""+rnd));
		assertFalse(ctest.contains(""+rnd));
		assertFalse(ctest.remove(""+rnd));
		System.out.print("Correcto");
		mark+=1;
    }

    /**
     * Test of removeAll method, of class ColeccionAbstracta.
     */
    @Test
    public void testRemoveAll() {
		System.out.print("\nRevisando metodo removeAll...");
		Conjunto<String> ctest = new Conjunto<String> ();
		LinkedList<String> tmp= new LinkedList<String>();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		for(int i=0;i<500;i++){
			int rnd = intGenerator.nextInt(1000);
			tmp.add(""+rnd);
		}
		ctest.removeAll(tmp);
		for(String s : tmp)
			assertFalse(ctest.contains(s));
		System.out.print("Correcto");
		mark+=1;    
    }

    /**
     * Test of retainAll method, of class ColeccionAbstracta.
     */
    @Test
    public void testRetainAll() {
		System.out.print("\nRevisando metodo retainAll...");
		Conjunto<String> ctest = new Conjunto<String> ();
		LinkedList<String> tmp= new LinkedList<String>();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		for(int i=0;i<500;i++){
			int rnd = intGenerator.nextInt(1000);
			tmp.add(""+rnd);
		}
		ctest.retainAll(tmp);
		for(int i=0;i<1000;i++){
			if(tmp.contains(i+""))
			assertTrue(ctest.contains(i+""));
			else
			assertFalse(ctest.contains(i+""));
		}
		System.out.print("Correcto");
		mark+=2;
    }

    /**
     * Test of testClear method, of class ColeccionAbstracta.
     */
    @Test
    public void testClear() {
		System.out.print("\nRevisando metodo clear...");
		Conjunto<String> ctest = new Conjunto<String> ();
		for(int i=0;i<1000;i++){
			ctest.add(""+i);
		}
		ctest.clear();
		assertTrue(ctest.size()==0);
		System.out.print("Correcto");
		mark+=1;
    }
    
}
