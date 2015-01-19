package ua.yandex.skipass;

public class WeekendSkiPassSomeRises extends SkiPass {

    private int rises;

    WeekendSkiPassSomeRises(int times) {
        if (!(times == 10 || times == 20 || times == 50 || times == 100)) {
            throw new MyException("You can not ctreate skipass with this amount of rises");
        }
        rises = times;
        type = Type.WeekendRises;
        active = true;
    }

    @Override
    public boolean check(Date date) {
        if (date.dayOfWeek() > 5 && active && rises > 0) {
            rises--;
            return true;
        } 
        return false;
        
    }

}
