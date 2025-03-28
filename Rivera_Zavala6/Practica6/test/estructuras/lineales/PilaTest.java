/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julio
 */
public class PilaTest {
    
    private static float mark;
    public PilaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        mark=0;
    }
    
    @AfterClass
    public static void tearDownClass() {

        System.out.println("==============================");
    	System.out.println("Calificación automática: " + mark);
        System.out.println("==============================");
    }
    
    @Test
    public void testPilaArregloMira(){
        Pila p=new PilaArreglo();                
        p.empuja(4);
        p.empuja(8);
        p.empuja(16);
        p.empuja(12);
        assertEquals(12,p.mira());
        mark+=1;
    }

    
    @Test
    public void testPilaArregloExpulsa(){
        Pila p=new PilaArreglo();
        p.empuja(11);
        p.empuja(13);
        p.empuja(17);
        assertEquals(17,p.expulsa());
        mark+=1;
    }
   
    @Test(expected = NoSuchElementException.class)
    public void testPilaArregloMiraVacia(){
        try{
            Pila p=new PilaArreglo();
            p.mira();       
        }catch(NoSuchElementException e){
            mark+=1;
            throw e;
        }
    }
   
    @Test(expected = NoSuchElementException.class)
    public void testPilaArregloExpulsaVacia(){
        try{
            Pila p=new PilaArreglo();
            p.expulsa();       
        }catch(NoSuchElementException e){
            mark+=1;
            throw e;
        }
    }

    @Test
    public void testSizeArreglo(){
        Pila p=new PilaArreglo();
        int numElementos=50;
        int elemBorrados=10;
        for(int i=0;i<numElementos;i++){
            p.empuja(50+i);
        }
        assertEquals(numElementos,p.size());
        for(int i=0;i<elemBorrados;i++){
            p.expulsa();
        }
        assertEquals(numElementos-elemBorrados,p.size());
        p.mira();
        p.mira();
        assertEquals(numElementos-elemBorrados,p.size());
        mark+=0.25;
    }

    @Test
    public void testIsEmptyArreglo(){
        Pila p=new PilaArreglo();
        assertTrue(p.isEmpty());
        p.empuja(15);
        p.empuja(25);
        assertFalse(p.isEmpty());
        p.expulsa();
        p.expulsa();
        assertTrue(p.isEmpty());
        mark+=0.25;
    }

    @Test
    public void testIteratorArreglo(){
        Pila p=new PilaArreglo();
        int i;
        for(i=0;i<10;i++){
            p.empuja(10+i);
        }
        Iterator it=p.iterator();
        while(it.hasNext()){
            Object next=it.next();
            assertEquals(10+(--i),next);
        }
        mark+=0.25;
    }

     
    @Test
    public void testAddArreglo(){
        Pila p=new PilaArreglo();
        for(int i=0;i<30;i++){
            p.add(i+80);
        }
        assertEquals(109,p.mira());
        mark+=0.25;
    }

}
