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

public class DateTest {
    
    public DateTest() {
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
     * Test of addHour method, of class Date.
     */
    @Test
    public void testAddHourThisDay() {
        System.out.println("addHour");
        Date instance = new Date(1000, 12, 12, 22);
        Date result = new Date(1000, 12, 12, 23);
        instance.addHour();    
        assertEquals(instance.dateToString(), result.dateToString());
       }
    
   @Test
    public void testAddHourNextDay() {
        System.out.println("addHour");
        Date instance = new Date(1000, 12, 12, 23);
        Date result = new Date(1000, 12, 13, 0);
        instance.addHour();    
        assertEquals(instance.dateToString(), result.dateToString());
       }
    /**
     * Test of addDay method, of class Date.
     */
    @Test
    public void testAddDayLeapYear() {
        System.out.println("addDay");
        Date instance = new Date(2015, 2, 28, 23);
        Date result = new Date(2015, 3, 1, 23);
        instance.addDay();    
        assertEquals(instance.dateToString(), result.dateToString());
    }
    @Test
    public void testAddDayThisMonth() {
        System.out.println("addDay");
        Date instance = new Date(2015, 2, 2, 23);
        Date result = new Date(2015, 2, 3, 23);
        instance.addDay();    
        assertEquals(instance.dateToString(), result.dateToString());
    }
    @Test
    public void testAddDayNextMonth() {
        System.out.println("addDay");
        Date instance = new Date(2015, 1, 31, 23);
        Date result = new Date(2015, 2, 1, 23);
        instance.addDay();    
        assertEquals(instance.dateToString(), result.dateToString());
    }
    /**
     * Test of addMonth method, of class Date.
     */
    @Test
    public void testAddMonthThisYear() {
        System.out.println("addMonth");
        Date instance =new Date(2015, 1, 1, 23);
        Date result = new Date(2015, 2, 1, 23);
        instance.addMonth();
        assertEquals(instance.dateToString(), result.dateToString());
    }
   @Test
    public void testAddMonthNextYear() {
        System.out.println("addMonth");
        Date instance =new Date(2015, 12, 1, 23);
        Date result = new Date(2016, 1, 1, 23);
        instance.addMonth();
        assertEquals(instance.dateToString(), result.dateToString());
    } 
    /**
     * Test of copy method, of class Date.
     */
    @Test
    public void testCopy() {
        System.out.println("copy");
        Date instance = new Date(2016, 1, 1, 23);
        Date expResult =  new Date(2016, 1, 1, 23);
        Date result = instance.copy();
        assertEquals(expResult.dateToString(), result.dateToString());
    }

    /**
     * Test of wasAfterOrEqualWithoutHours method, of class Date.
     */
    @Test
    public void testWasAfterOrEqualWithoutHoursEqual() {
        System.out.println("wasAfterOrEqualWithoutHours");
        Date date = new Date(2016, 1, 1, 2);
        Date instance = new Date(2016, 1, 1, 23);
        boolean expResult = true;
        boolean result = instance.wasAfterOrEqualWithoutHours(date);
        assertEquals(expResult, result);
    }
   @Test
    public void testWasAfterOrEqualWithoutHoursfalse() {
        System.out.println("wasAfterOrEqualWithoutHours");
        Date date = new Date(2016, 1, 1, 2);
        Date instance = new Date(2015, 1, 1, 23);
        boolean expResult = false;
        boolean result = instance.wasAfterOrEqualWithoutHours(date);
        assertEquals(expResult, result);
    }
    /**
     * Test of checkForAccess method, of class Date.
     */
    @Test
    public void testCheckForAccessFalse() {
        System.out.println("checkForAccess");
        Date dateOfBegining = new Date(2015, 1, 1, 23);
        int maxDays = 2;
        Date instance = new Date(2015, 1, 3, 23);
        boolean expResult = false;
        boolean result = instance.checkForAccess(dateOfBegining, maxDays);
        assertEquals(expResult, result);      
    }
  @Test
    public void testCheckForAccessTrue() {
        System.out.println("checkForAccess");
        Date dateOfBegining = new Date(2015, 1, 1, 23);
        int maxDays = 5;
        Date instance = new Date(2015, 1, 5, 23);
        boolean expResult = true;
        boolean result = instance.checkForAccess(dateOfBegining, maxDays);
        assertEquals(expResult, result);      
    }
    /**
     * Test of firstDayInSeason method, of class Date.
     */
    @Test
    public void testFirstDayInSeasonWinter() {
        System.out.println("firstDayInSeason");
        Date instance = new Date(1000, 2,6,6);
        Date expResult = new Date(999,1,1,0);
        Date result = instance.firstDayInSeason();
        assertEquals(expResult.dateToString(), result.dateToString());
    }
   @Test
    public void testFirstDayInSeasonSpring() {
        System.out.println("firstDayInSeason");
        Date instance = new Date(1000, 5,6,6);
        Date expResult = new Date(1000,3,1,0);
        Date result = instance.firstDayInSeason();
        assertEquals(expResult.dateToString(), result.dateToString());
    }
      @Test
    public void testFirstDayInSeasonSummer() {
        System.out.println("firstDayInSeason");
        Date instance = new Date(1000, 7,6,6);
        Date expResult = new Date(1000,6,1,0);
        Date result = instance.firstDayInSeason();
        assertEquals(expResult.dateToString(), result.dateToString());
    }
      @Test
    public void testFirstDayInSeasonAutumn() {
        System.out.println("firstDayInSeason");
        Date instance = new Date(1000, 11,6,6);
        Date expResult = new Date(1000,9,1,0);
        Date result = instance.firstDayInSeason();
        assertEquals(expResult.dateToString(), result.dateToString());
    }
    /**
     * Test of equalsWithoutHours method, of class Date.
     */
    @Test
    public void testEqualsWithoutHours() {
        System.out.println("equalsWithoutHours");
        Date date = new Date(1000, 11,6,6);
        Date instance = new Date(1000, 11,6,21);
        boolean expResult = true;
        boolean result = instance.equalsWithoutHours(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of dayOfWeek method, of class Date.
     */
    @Test
    public void testDayOfWeekWasAfter2007() {
        System.out.println("dayOfWeek");
        Date instance = new Date(2015, 3, 1,1);
        int expResult = 7;
        int result = instance.dayOfWeek();
        assertEquals(expResult, result);
    }   
    @Test
    public void testDayOfWeeWasBefore2007() {
        System.out.println("dayOfWeek");
        Date instance = new Date(2006, 1, 2,1);
        int expResult = 1;
        int result = instance.dayOfWeek();
        assertEquals(expResult, result);
    }
    /**
     * Test of partOfDay method, of class Date.
     */
    @Test
    public void testPartOfDayMorning() {
        System.out.println("partOfDay");
        Date instance = new Date( 1000,1,1,10);
        int expResult = 1;
        int result = instance.partOfDay();
        assertEquals(expResult, result);
    }
    @Test
    public void testPartOfDayEvening() {
        System.out.println("partOfDay");
        Date instance = new Date(1000,1,1,13);
        int expResult = 2;
        int result = instance.partOfDay();
        assertEquals(expResult, result);
    }
     @Test
    public void testPartOfDayNight() {
        System.out.println("partOfDay");
        Date instance = new Date( 1000,1,1,0);
        int expResult = 0;
        int result = instance.partOfDay();
        assertEquals(expResult, result);
    }
    /**
     * Test of dateToString method, of class Date.
     */
    @Test
    public void testDateToString() {
        System.out.println("dateToString");
        Date instance = new Date( 1000,1,1,13);
        String expResult = "13h_1.1.1000";
        String result = instance.dateToString();
        assertEquals(expResult, result);
    }
    
}
