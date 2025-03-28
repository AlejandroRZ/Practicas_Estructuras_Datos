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
    public void testPilaLigadaMira(){
        Pila p=new PilaLigada();
        p.empuja(1);
        p.empuja(2);
        p.empuja(5);
        p.empuja(10);
        assertEquals(10,p.mira());
        mark+=1;
    }
    
    @Test
    public void testPilaLigadaExpulsa(){
        Pila p=new PilaLigada();
        p.empuja(2);
        p.empuja(3);
        p.empuja(5);
        p.empuja(7);
        assertEquals(7,p.expulsa());
        mark+=2;
    }
    
     
    @Test(expected = NoSuchElementException.class)
    public void testPilaLigadaMiraVacia(){
        try{
            Pila p=new PilaLigada();
            p.mira();       
        }catch(NoSuchElementException e){
            mark+=1;
            throw e;
        }
    }
   
    
    @Test(expected = NoSuchElementException.class)
    public void testPilaLigadaExpulsaVacia(){
        try{
            Pila p=new PilaLigada();
            p.expulsa();       
        }catch(NoSuchElementException e){
            mark+=1;
            throw e;
        }
    }
   
    
    @Test
    public void testSizeLigada(){
        Pila p=new PilaLigada();
        int numElementos=20;
        int elemBorrados=15;
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
        mark+=1;
    }


    @Test
    public void testIsEmptyLigada(){
        Pila p=new PilaLigada();
        assertTrue(p.isEmpty());
        p.empuja(1);
        p.empuja(2);
        assertFalse(p.isEmpty());
        p.expulsa();
        p.expulsa();
        assertTrue(p.isEmpty());
        mark+=1;
    }


    @Test
    public void testIteratorLigada(){
        Pila p=new PilaLigada();
        Iterator it=p.iterator();
        int i;
        for(i=0;i<10;i++){
            p.empuja(i);
        }
        while(it.hasNext()){
            assertEquals(--i,it.next());
        }
        mark+=2;
    }

    
    @Test
    public void testAddLigada(){
        Pila p=new PilaLigada();
        for(int i=0;i<40;i++){
            p.add(i+20);
        }
        assertEquals(59,p.mira());
        mark+=1;
    }

}
