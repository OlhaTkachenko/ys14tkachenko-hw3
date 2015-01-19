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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Ольга
 */
public class WeekendSkiPassSomeRisesTest {
    
    public WeekendSkiPassSomeRisesTest() {
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
     * Test of check method, of class WorkdaySkiPassSomeRises.
     */
    @Test
    public void testCheckYes() {
        System.out.println("check");
        Date date = mock(Date.class);
        WeekendSkiPassSomeRises instance = new WeekendSkiPassSomeRises(1);
        boolean expResult = true;
        when(date.dayOfWeek()).thenReturn(6);
        boolean result = instance.check(date);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckNo() {
        System.out.println("check");
        Date date = mock(Date.class);
        WeekendSkiPassSomeRises instance = new WeekendSkiPassSomeRises(1);
        boolean expResult = false;
        when(date.dayOfWeek()).thenReturn(1);
        boolean result = instance.check(date);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckBehavior() {
        System.out.println("check behavior");
        Date date = mock(Date.class);
        WeekendSkiPassSomeRises instance = new WeekendSkiPassSomeRises(1);
        //when(date.dayOfWeek()).thenReturn(6);
        boolean result = instance.check(date);
        verify(date).dayOfWeek();
    } 
    
}
