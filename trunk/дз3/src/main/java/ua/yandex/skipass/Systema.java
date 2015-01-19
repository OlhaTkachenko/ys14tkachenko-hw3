package ua.yandex.skipass;

/**
 *
 * @author Ольга
 */
public class Systema {

    static private int lastUsedNumber;
    private Date current;
    private final MyArrayList createdCards;
    private final MyArrayList statisticsOfPassage;

    public Systema(Date date) {
        current = date;
        createdCards = new MyArrayList();
        statisticsOfPassage = new MyArrayList();
        lastUsedNumber = -1;
    }

    public SkiPass create(String type) {
        int accessory;
        SkiPass newSkiPass;
        if ("Season".equals(type)) {
            newSkiPass = new SeasonSkiPass(current);
        } else {
            int size = type.length();
            accessory = Integer.parseInt(type.substring(size - 3, size));
            type = type.substring(0, size - 3);
            switch (type) {
                case "WeekendDays":
                    if (accessory + current.dayOfWeek() - 1 > 7) {
                        throw new MyException("This weekend has not enough days");
                    }
                    newSkiPass = new WeekendSkiPassSomeDays(current, accessory);
                    break;
                case "WorkdayDays":
                    if (accessory + current.dayOfWeek() - 1 > 5) {
                        throw new MyException("This workdayshas not enough days");
                    }
                    newSkiPass = new WorkdaySkiPassSomeDays(current, accessory);
                    break;
                case "WeekendRises":
                    newSkiPass = new WeekendSkiPassSomeRises(accessory);
                    break;
                case "WorkdayRises":
                    newSkiPass = new WorkdaySkiPassSomeRises(accessory);
                    break;
                default:
                    throw new MyException("not existing type");
            }
        }
        createdCards.add(type);
        newSkiPass.active = true;
        lastUsedNumber++;
        newSkiPass.uniqueNumber = lastUsedNumber;
        return newSkiPass;
    }

    public boolean checkCard(SkiPass card, Date currentDate) {
        boolean flag = card.check(currentDate);
        String inf = String.valueOf(card.uniqueNumber);
        if (flag) {
            inf += '+';
        } else {
            inf += '-';
        }
        statisticsOfPassage.add(inf);
        return flag;
    }

    public int statisticsForOneType(String type, boolean success) {
        int counter = 0;
        int uniqueNumber;
        for (int i = 0; i < statisticsOfPassage.size(); i++) {
            boolean flag = false;
            String temp = (String) statisticsOfPassage.get(i);
            if (temp.charAt(temp.length() - 1) == '+') {
                flag = true;
            }
            temp = temp.substring(0, temp.length() - 1);
            uniqueNumber = (int) Integer.parseInt(temp);
            System.out.write(uniqueNumber);
            if (success == flag
                    && type.equals(createdCards.get(uniqueNumber))) {
                counter++;
            }
        }
        return counter;
    }

    public int statistics(boolean success) {
        int counter = 0;
        for (int i = 0; i < statisticsOfPassage.size(); i++) {
            String temp = (String) statisticsOfPassage.get(i);
            boolean flag = false;
            if (temp.charAt(temp.length() - 1) == '+') {
                flag = true;
            }
            if (success == flag) {
                counter++;
            }
        }
        return counter;

    }
}
