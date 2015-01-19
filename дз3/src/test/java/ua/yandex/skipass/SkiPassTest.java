/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.skipass;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Ольга
 */
public class SkiPassTest {
    
    public SkiPassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of block method, of class SkiPass.
     */
    @Test
    public void testBlock() {
        System.out.println("block");
        SkiPass instance = new SkiPassImpl();
        instance.block();
        boolean expResult = false;  
        assertEquals(expResult, instance.isActive());
    }
  public void testIsActive() {
        System.out.println("isAcrive");
        SkiPass instance = new SkiPassImpl();
        boolean expResult = true;  
        assertEquals(expResult, instance.isActive());
    }

    public class SkiPassImpl extends SkiPass {      
         SkiPassImpl(){
             active = true;
         }
        public boolean check(Date current) {
            return false;
        }
    } 
}
