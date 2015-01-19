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
public class WorkdaySkiPassSomeDaysTest {
    
    public WorkdaySkiPassSomeDaysTest() {
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
     * Test of check method, of class WorkdaySkiPassSomeDays.
     */
    @Test
    public void testCheckPartOfDay() {
        System.out.println("check");
        Date current = mock(Date.class);
        when(current.copy()).thenReturn(current);
        WorkdaySkiPassSomeDays instance = new WorkdaySkiPassSomeDays(current, 0);
        when(current.partOfDay()).thenReturn(1);
        when(current.equalsWithoutHours(current)).thenReturn(true);
        when(current.dayOfWeek()).thenReturn(2);
        boolean expResult = true;
        boolean result = instance.check(current);
        assertEquals(expResult, result);
    }
    
     @Test
      public void testCheck() {
        System.out.println("check");
        Date current = mock(Date.class);
        when(current.copy()).thenReturn(current);
        WorkdaySkiPassSomeDays instance = new WorkdaySkiPassSomeDays(current, 2);
        when(current.equalsWithoutHours(current)).thenReturn(true);
        when(current.dayOfWeek()).thenReturn(2);
        when(current.checkForAccess(current, 2)).thenReturn(true);
        boolean expResult = true;
        boolean result = instance.check(current);
        assertEquals(expResult, result);
    }
      @Test
      public void testCheckBehavior() {
        System.out.println("check");
        Date current = mock(Date.class);
        when(current.copy()).thenReturn(current);
        WorkdaySkiPassSomeDays instance = new WorkdaySkiPassSomeDays(current, 2);
        when(current.equalsWithoutHours(current)).thenReturn(true);
        when(current.dayOfWeek()).thenReturn(2);
        when(current.checkForAccess(current, 2)).thenReturn(true);
        boolean result = instance.check(current);
        verify(current).checkForAccess(current, 2);
    }
      
}
