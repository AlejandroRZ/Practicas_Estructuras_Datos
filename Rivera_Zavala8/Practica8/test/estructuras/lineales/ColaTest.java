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
  public void testColaArreglo(){
    Cola a = new ColaArreglo();
    a.encolar(42);
    a.encolar(3);
    a.encolar(17);
    a.encolar(8);
    a.encolar(3);
    assertEquals(42,a.desencolar());
    assertEquals(3,a.mira());
    mark+=5;
  }

  @Test(expected = NoSuchElementException.class)
  public void testColaArregloMiraVacia(){
    try{
      temp = new ColaArreglo();
      temp.mira();
    }catch(NoSuchElementException e){
      mark+=1.5;
      throw e;
    }
  }

  @Test(expected = NoSuchElementException.class)
  public void testColaArregloDesencolarVacia(){
    try{
      temp = new ColaArreglo();
      temp.desencolar();
    }catch(NoSuchElementException e){
      mark+=1.5;
      throw e;
    }
  }

  @Test
  public void testColaArregloSize(){
    temp = new ColaArreglo();
    int numElementos = 50;
    int elemBorrados = 15;
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
  public void testColaArregloIsEmpty(){
    temp = new ColaArreglo();
    assertTrue(temp.isEmpty());
    temp.encolar(19);
    temp.encolar(17);
    assertFalse(temp.isEmpty());
    temp.desencolar();
    temp.desencolar();
    assertTrue(temp.isEmpty());
    mark+=0.5;
  }

  @Test
  public void testColaArregloIterator(){
    temp = new ColaArreglo();
    Iterator it = temp.iterator();
    int i;
    for (i=0;i<20;i++) {
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
  public void testColaArregloAdd(){
    temp = new ColaArreglo();
    for (int i=0;i<50;i++) {
      temp.add(i+20);
    }
    assertEquals(20,temp.mira());
    mark+=0.5;
  }
}
