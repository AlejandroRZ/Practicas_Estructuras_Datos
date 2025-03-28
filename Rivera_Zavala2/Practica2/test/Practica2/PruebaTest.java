package Practica2;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author julio
 */
public class PruebaTest {
    private static float mark;
    private static RecursionInterfaz rec;
    public PruebaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        mark=0;
        rec=new Recursion();
    }
    
    @AfterClass
    public static void tearDownClass() {    
        System.out.println("==============================");
    	System.out.println("Calificación automática: " + mark);
        System.out.println("==============================");
    }
    
    @Test
    public void testFibIt(){
        System.out.println("cálculo fibonacci iterativo");
        assertEquals(21,rec.fibonacciIt(8));
        assertEquals(144,rec.fibonacciIt(12));
        mark+=2;
    }
    
    @Test
    public void testFibRec(){
        System.out.println("cálculo fibonacci recursivo");        	       
        assertEquals(8,rec.fibonacciRec(6));
        assertEquals(21,rec.fibonacciRec(8));           
        mark+=2;
    }
    
    @Test
    public void testPascalIt(){
        System.out.println("cálculo pascal iterativo");	       
        assertEquals(20,rec.tPascalIt(6,3));
        assertEquals(3,rec.tPascalIt(3, 2));
        mark+=2;
    }
    
    @Test
    public void testPascalRec(){
        System.out.println("cálculo pascal recursivo");
        assertEquals(10,rec.tPascalRec(5, 2));	       
        assertEquals(3,rec.tPascalRec(3, 2));
        mark+=2;
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testFibItInvalido(){
        System.out.println("cálculo fibonacci valor inválido");
        try{
            rec.fibonacciIt(-5);
        }catch(IndexOutOfBoundsException e){              
            mark+=0.5;
            throw e;
        }
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testFibRecInvalido(){
	System.out.println("cálculo fibonacci valor inválido2");
	try{
            rec.fibonacciIt(-10);
        }catch(IndexOutOfBoundsException e){              
            mark+=0.5;
            throw e;
        }
        mark+=0.5;
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testPascalInvalido(){
	System.out.println("cálculo pascal valor inválido");
	try{
            rec.tPascalIt(-5,1);
        }catch(IndexOutOfBoundsException e){              
            mark+=0.5;
            throw e;
        }
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testPascalRecInvalido(){
	System.out.println("cálculo pascal valor inválido2");
        try{
            rec.tPascalIt(-5,1);
        }catch(IndexOutOfBoundsException e){              
            mark+=0.5;
            throw e;
        }        
    }
}
