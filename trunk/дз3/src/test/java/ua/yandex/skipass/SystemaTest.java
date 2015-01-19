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
        String type = "Season";
        Date current = mock(Date.class);
        Systema instance = new Systema(current);
        instance.create(type);
        verify(current).firstDayInSeason();
    }

    /**
     * Test of checkCard method, of class Systema.
     */
    @Test
    public void testCheckCard() {
        System.out.println("checkCard");
        SkiPass card = mock(SkiPass.class);
        Date currentDate = mock(Date.class);
        Systema instance = new Systema(currentDate);
        boolean expResult = false;
        boolean result = instance.checkCard(card, currentDate);
        verify(card).check(currentDate);
    }

    /**
     * Test of statisticsForOneType method, of class Systema.
     */
    @Test
    public void testStatisticsForOneType() {
        System.out.println("statisticsForOneType");
        String type = "Season";
        Date current = new Date(2015, 1, 12, 1);
        Systema systema = new Systema(current);
        SeasonSkiPass s = (SeasonSkiPass) systema.create("Season");
        WorkdaySkiPassSomeRises s2 = (WorkdaySkiPassSomeRises) systema.create("WorkdayRises010");
        systema.checkCard(s, current);
        systema.checkCard(s2, current);
        boolean success = true;
        int expResult = 1;
        int result = systema.statisticsForOneType(type, success);
        assertEquals(expResult, result);
    }

    /**
     * Test of statistics method, of class Systema.
     */
    @Test
    public void testStatistics() {
        System.out.println("statistics");
        boolean success = true;
        Date current = new Date(2015, 1, 12, 1);
        Systema systema = new Systema(current);
        SeasonSkiPass s = (SeasonSkiPass) systema.create("Season");
        WeekendSkiPassSomeRises s2 = (WeekendSkiPassSomeRises) systema.create("WeekendRises100");
        systema.checkCard(s, current);
        systema.checkCard(s2, current);
        int expResult = 1;
        int result = systema.statistics(success);
        assertEquals(expResult, result);
    }

}
