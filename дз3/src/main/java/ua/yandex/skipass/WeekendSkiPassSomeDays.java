package ua.yandex.skipass;

public class WeekendSkiPassSomeDays extends SkiPass {
    Date dateOfStart;
    int days;
    WeekendSkiPassSomeDays(Date current, int d){
      if (!(d == 0 || d == 1 || d == 2)) {
           throw new MyException("You can not ctreate skipass with this amount of days");
      }
      dateOfStart = current.copy();
      type = Type.WeekendDays; 
      days = d;
      active = true;
    }
    @Override
    public boolean check(Date current){
        if( active == false ) return false;
        if( days == 0){
            return dateOfStart.equalsWithoutHours(current) && 
                    dateOfStart.partOfDay()== current.partOfDay() && current.partOfDay()!=0;
        }
        return current.checkForAccess(dateOfStart, days);
    }
}
