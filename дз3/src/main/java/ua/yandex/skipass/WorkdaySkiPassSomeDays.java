/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.skipass;

/**
 *
 * @author Ольга
 */
public class WorkdaySkiPassSomeDays extends SkiPass {

    Date dateOfStart;
    int days;

    WorkdaySkiPassSomeDays(Date current, int d) {
        if (!(d == 0 || d == 1 || d == 2 || d == 5)) {
            throw new MyException("You can not ctreate "
                    + "skipass with this amount of days");
        }
        dateOfStart = current.copy();
        type = Type.WorkdayDays;
        days = d;
        active = true;
    }

    @Override
    public boolean check(Date current) {
        if (!active) {
            return false;
        }
        if (days == 0) {
            return dateOfStart.dayOfWeek() <= 5
                    && dateOfStart.equalsWithoutHours(current)
                    && dateOfStart.partOfDay() == current.partOfDay()
                    && current.partOfDay() != 0;
        }
        return current.checkForAccess(dateOfStart, days);
    }
}
