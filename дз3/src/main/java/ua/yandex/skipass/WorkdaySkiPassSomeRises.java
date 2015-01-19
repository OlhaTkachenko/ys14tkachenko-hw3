package ua.yandex.skipass;

public class WorkdaySkiPassSomeRises extends SkiPass {

    private int rises;

    WorkdaySkiPassSomeRises(int times) {
        if (!(times == 10 || times == 20 || times == 50 || times == 100)) {
            throw new MyException("You can not ctreate "
                    + "skipass with this amount of rises");
        }
        rises = times;
        type = Type.WorkdayRises;
        active = true;
    }

    @Override
    public boolean check(Date date) {
        if (date.dayOfWeek() <= 5 && active && rises > 0) {
            rises--;
            return true;
        } else {
            return false;
        }
    }

}
