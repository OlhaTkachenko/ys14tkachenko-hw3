package ua.yandex.skipass;
public enum TypeForCreation {

    WeekendDays0(Type.WeekendDays), WeekendDays1(Type.WeekendDays), WeekendDays2(Type.WeekendDays),
    WorkdaysDays0(Type.WorkdaysDays), WorkdaysDays1(Type.WorkdaysDays),
    WorkdaysDays2(Type.WorkdaysDays), WorkdaysDays5(Type.WorkdaysDays),
    WeekendRises10(Type.WeekendRises), WeekendRises20(Type.WeekendRises),
    WeekendRises50(Type.WeekendRises), WeekendRises100(Type.WeekendRises),
    WorkdaysRises10(Type.WorkdaysRises), WorkdaysRises20(Type.WorkdaysRises),
    WorkdaysRises50(Type.WorkdaysRises), WorkdaysRises100(Type.WorkdaysRises),
    Season(Type.Season);
    public Type kind;
    TypeForCreation(Type s) {
        kind = s;
    }

}
