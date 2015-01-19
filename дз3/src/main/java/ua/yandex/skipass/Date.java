package ua.yandex.skipass;

public class Date {


    public int year, month, day, hours;
    final int MaxDaysInMonths[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public Date(int newYear, int newMonth, int newDay, int newHours) {
        if (newYear >= 0) {
            year = newYear;
        } else {
            throw new MyException("incorrect date");
        }
        if (newMonth > 0 && newMonth < 13) {
            month = newMonth;
        } else {
            throw new MyException("incorrect date");
        }
        if (newDay > 0 && MaxDaysInMonths[month] >= newDay) {
            if (month != 2 || day != 29) {
                day = newDay;

            } else if (month == 2 && day == 29 && isLeapYear(year)) {
                day = newDay;
            } else {
                throw new MyException("incorrect date");
            }
        } else {
            throw new MyException("incorrect date");
        }
        if (newHours >= 0 && newHours < 24) {
            hours = newHours;
        } else {
            throw new MyException("incorrect date");
        }
    }

    private boolean isLeapYear(int aYear) {
        if (aYear % 400 == 0) {
            return true;
        }
        if (aYear % 100 == 0) {
            return false;
        }
        return aYear % 4 == 0;
    }

    public void addHour() {
        if (hours < 23) {
            hours++;
        } else {
            hours = 0;
            addDay();
        }
    }

    public void addDay() {
        if (month == 2 && (!isLeapYear(year)) && day == 28) {
            day = 1;
            month = 3;
            return;
        }
        if (day < MaxDaysInMonths[month]) {
            day++;
        } else {
            day = 1;
            addMonth();
        }
    }

    public void addMonth() {
        if (month < 12) {
            month++;
        } else {
            month = 1;
            year++;
        }
    }

    public Date copy() {
        Date date = new Date(year, month, day, hours);
        return date;
    }

    public boolean wasAfterOrEqualWithoutHours(Date date) {
        if (year > date.year) {
            return true;
        }
        if (year < date.year) {
            return false;
        }
        if (month > date.month) {
            return true;
        }
        if (month < date.month) {
            return false;
        }
        return day >= date.day;
    }

    public boolean checkForAccess(Date dateOfBegining, int maxDays) {
        Date date = dateOfBegining.copy();
        for (int i = maxDays; i > 1; i--) {
            date.addDay();
        }
        return date.wasAfterOrEqualWithoutHours(this);
    }

    public Date firstDayInSeason() {
        Date resultDate = copy();
        resultDate.hours = 0;
        resultDate.day = 1;
        if (month <= 2) {
            resultDate.year--;
            resultDate.month = 1;
            return resultDate;
        }
        if (month == 12) {
            return resultDate;
        }
        if (month < 6) {
            resultDate.month = 3;
            return resultDate;
        }
        if (month < 9) {
            resultDate.month = 6;
            return resultDate;
        }
        resultDate.month = 9;
        return resultDate;
    }
    public boolean equalsWithoutHours(Date date){
        if(date.year != year) return false;
        if(date.month != month) return false;
        return date.day == day;
    }
   public int dayOfWeek(){
    int startYear = 2007;//1.01.2007-monday;
    int daysOf = 0;
    while (startYear > year) {
        daysOf += 371 - 365;
        if(isLeapYear(startYear)) daysOf--;
        startYear--;
        daysOf %= 7;
        //startYear -= 28;
    }
    while (startYear < year)
    {
        daysOf += 365;
        if(isLeapYear(startYear)) daysOf++;
        startYear++;
        daysOf %= 7;
    }
    int startMonth = 1;
    while (startMonth < month)
    {
        daysOf += MaxDaysInMonths[startMonth];
        startMonth++;
        daysOf %= 7;
    }
    if(month>2 && !(isLeapYear(year)))daysOf+=6;
    daysOf += day;
    daysOf %= 7;
    if(daysOf == 0)daysOf=7;
    return daysOf;
  } 
  
 public int partOfDay(){
   if( hours < 13 && hours >=9 ) return 1;
   if( hours >= 13 && hours <17 )  return 2;
   return 0;
 }
 String dateToString(){
   String temp = String.valueOf(hours);
   temp+="h_";
   temp += String.valueOf(day);
   temp+='.';
   temp += String.valueOf(month);
   temp+='.';
   temp += String.valueOf(year);
   return temp;
 }
}
