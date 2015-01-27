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
public class SystemaTest {

    public SystemaTest() {
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
     * Test of create method, of class Systema.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        TypeForCreation type = TypeForCreation.Season;
        Date current = mock(Date.class);
        Systema instance = new Systema(current);
        instance.create(type);
        verify(current).firstDayInSeason();
    }


    @Test
    public void testCheckCard() {
        System.out.println("checkCard");
        TypeForCreation type = TypeForCreation.Season;
        Date currentDate = mock(Date.class);
        Date date = mock(Date.class);
        when(currentDate.firstDayInSeason()).thenReturn(currentDate);
        when(date.firstDayInSeason()).thenReturn(date);
        Systema instance = new Systema(currentDate);
        Card card = instance.create(type);
        boolean result = instance.checkCard(card, date);
        verify(date).firstDayInSeason();
    }


    @Test
    public void testStatisticsForOneType() {
        System.out.println("statisticsForOneType");
        String type = (TypeForCreation.Season).toString();
        Date current = new Date(2015, 1, 12, 1);
        Systema systema = new Systema(current);
        Card s = systema.create(TypeForCreation.Season);
        Card s2 = systema.create(TypeForCreation.WorkdaysRises20);
        systema.checkCard(s, current);
        systema.checkCard(s2, current);
        boolean success = true;
        int expResult = 1;
        int result = systema.statisticsForOneType(type, success);
        assertEquals(expResult, result);
    }


    @Test
    public void testStatistics() {
        System.out.println("statistics");
        boolean success = true;
        Date current = new Date(2015, 1, 12, 1);
        Systema systema = new Systema(current);
        Card s = systema.create(TypeForCreation.Season);
        Card s2 = systema.create(TypeForCreation.WeekendRises20);
        systema.checkCard(s, current);
        systema.checkCard(s2, current);
        int expResult = 1;
        int result = systema.statistics(success);
        assertEquals(expResult, result);
    }

}
