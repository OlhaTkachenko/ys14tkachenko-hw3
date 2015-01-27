package ua.yandex.skipass;

public final class Card {

    final private SkiPass pass;
    private final int uniqueNumber;

    public Card(TypeForCreation type, Date date, int number) {
        uniqueNumber = number;
        String s = type.name();
        int c = findNumberInTheEnd(s);
        switch (type.kind) {
            case Season:
                pass = new Season(date);
                break;
            case WeekendDays: {
                pass = new WeekendDays(date, c);
                break;
            }
            case WeekendRises:
                pass = new WeekendRises(c);
                break;
            case WorkdaysDays:
                pass = new WorkdaysDays(date, c);
                break;
            case WorkdaysRises:
                pass = new WorkdaysRises(c);
                break;
            default:
                throw new MyException("not existing type");
        }
        pass.type = type.kind;
        pass.active = true;
    }

    private int findNumberInTheEnd(String s) {
        int result = 0;
        for (int i = s.length() - 1, j = 1; isNumber(s.charAt(i)); i--, j *= 10) {
            result += Character.getNumericValue(s.charAt(i)) * j;
        }
        return result;
    }

    private boolean isNumber(char s) {
        return s >= '0' && s <= '9';
    }

    public boolean check(Date d) {
        return pass.check(d);
    }

    public void block() {
        pass.block();
    }

    public boolean isActive() {
        return pass.isActive();
    }

    public int getNumber() {
        return uniqueNumber;
    }

    abstract private class SkiPass {

        public Type type;
        protected boolean active;

        protected void block() {
            active = false;
        }

        protected boolean isActive() {
            return active;
        }

        abstract protected boolean check(Date current);
    }

    final private class WeekendDays extends SkiPass {

        final private Date dateOfStart;
        final private int days;

        WeekendDays(Date current, int d) {
            dateOfStart = current.copy();
            type = Type.WeekendDays;
            days = d;
            active = true;
        }

        @Override
        protected boolean check(Date current) {
            if (!active) {
                return false;
            }
            if (days == 0) {
                return dateOfStart.equalsWithoutHours(current)
                        && dateOfStart.partOfDay() == current.partOfDay()
                        && current.partOfDay() != 0;
            }
            return current.checkForAccess(dateOfStart, days);
        }
    }

    final private class WeekendRises extends SkiPass {

        private int rises;

        WeekendRises(int times) {
            rises = times;
            type = Type.WeekendRises;
            active = true;
        }

        @Override
        protected boolean check(Date date) {
            if (date.dayOfWeek() > 5 && active && rises > 0) {
                rises--;
                return true;
            }
            return false;
        }
    }

    final private class WorkdaysDays extends SkiPass {

        private final Date dateOfStart;
        final private int days;

        WorkdaysDays(Date current, int d) {
            dateOfStart = current.copy();
            type = Type.WorkdaysDays;
            days = d;
            active = true;
        }

        @Override
        protected boolean check(Date current) {
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

    final private class WorkdaysRises extends SkiPass {

        private int rises;

        WorkdaysRises(int times) {
            rises = times;
            type = Type.WorkdaysRises;
            active = true;
        }

        @Override
        protected boolean check(Date date) {
            if (date.dayOfWeek() <= 5 && active && rises > 0) {
                rises--;
                return true;
            } else {
                return false;
            }
        }

    }

    final private class Season extends SkiPass {

        private final Date firstDayInSeason;

        Season(Date currentDate) {
            active = true;
            this.type = Type.Season;
            firstDayInSeason = currentDate.firstDayInSeason();
        }

        @Override
        protected boolean check(Date current) {
            return active && firstDayInSeason.equalsWithoutHours(
                    current.firstDayInSeason());
        }
    }

}
