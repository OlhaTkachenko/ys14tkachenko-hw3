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
import org.mockito.InOrder;
import org.mockito.Matchers;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;
/**
 *
 * @author Ольга
 */
public class TurnstileTest {
    
    public TurnstileTest() {
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
     * Test of checkCard method, of class Turnstile.
     */
    @Test
    public void testCheckCard() {
        System.out.println("checkCard");
        Date date = mock(Date.class);
        Turnstile instance = new Turnstile(date);
        verify(date).copy();
    }
}
