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
public class SeasonSkiPassTest {
    
    public SeasonSkiPassTest() {
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
     * Test of check method, of class SeasonSkiPass.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Date actived =mock(Date.class);
        Date current = mock(Date.class);
        when(actived.firstDayInSeason()).thenReturn(actived);
        when(current.firstDayInSeason()).thenReturn(actived);
        when(actived.equalsWithoutHours(actived)).thenReturn(true);
        SeasonSkiPass instance = new SeasonSkiPass(actived);
        boolean expResult = true;
        boolean result = instance.check(current);
        assertEquals(expResult, result);
    }
     @Test
     public void testCheckBehavior() {
        System.out.println("check behavior");
        Date current = mock(Date.class);
        SeasonSkiPass instance = new SeasonSkiPass(current);
        verify(current).firstDayInSeason();
    }
}
