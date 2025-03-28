package estructuras.lineales;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ColaTest{
  private static float mark;
  private static Cola temp;
  

  @BeforeClass
  public static void setUpClass(){
    mark = 0;
  }

  @AfterClass
  public static void tearDownClass() {
    System.out.println("==============================");
    System.out.println("Calificación automática: " + mark);
    System.out.println("==============================");
  }

  @Test
  public void testColaLigada(){
    Cola c = new ColaLigada();
    c.encolar(113);
    c.encolar(5);
    c.encolar(10);
    c.encolar(7);
    assertEquals(113,c.desencolar());
    assertEquals(5,c.mira());
    mark+=5;
  }

  @Test(expected = NoSuchElementException.class)
  public void testColaLigadaMiraVacia(){
    try{
      temp = new ColaLigada();
      temp.mira();
    }catch(NoSuchElementException e){
      mark+=1.5;
      throw e;
    }
  }

  @Test(expected = NoSuchElementException.class)
  public void testColaLigadaDesencolarVacia(){
    try{
      temp = new ColaLigada();
      temp.desencolar();
    }catch(NoSuchElementException e){
      mark+=1.5;
      throw e;
    }
  }

  @Test
  public void testColaLigadaSize(){
    temp = new ColaLigada();
    int numElementos = 25;
    int elemBorrados = 10;
    int i;
    for(i=0;i<numElementos;i++){
      temp.encolar(i);
    }
    assertEquals(numElementos,temp.size());
    for (i=0;i<elemBorrados;i++){
      temp.desencolar();
    }
    assertEquals(numElementos - elemBorrados,temp.size());
    mark+=0.5;
  }

  @Test
  public void testColaLigadaIsEmpty(){
    temp = new ColaLigada();
    assertTrue(temp.isEmpty());
    temp.encolar(24);
    temp.encolar(21);
    assertFalse(temp.isEmpty());
    temp.desencolar();
    temp.desencolar();
    assertTrue(temp.isEmpty());
    mark+=0.5;
  }

  @Test
  public void testColaLigadaIterator(){
    temp = new ColaLigada();
    Iterator it = temp.iterator();
    int i;
    for (i=0;i<10;i++) {
      temp.encolar(i);
    }
    i = 0;
    while(it.hasNext()){
      assertEquals(i,it.next());
      i++;
    }
    mark+=0.5;
  }

  @Test
  public void testColaLigadaAdd(){
    temp = new ColaLigada();
    for (int i=0;i<30;i++) {
      temp.add(i+15);
    }
    assertEquals(15,temp.mira());
    mark+=0.5;
  }
}
