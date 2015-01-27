package ua.yandex.skipass;

import ua.yandex.collections.MyArrayList;

public class Systema {

    private final Date current;
    private final MyArrayList createdCards;
    private final MyArrayList statisticsOfPassage;
    private int lastUsedNumber;

    public Systema(Date date) {
        lastUsedNumber = 0;
        current = date;
        createdCards = new MyArrayList();
        statisticsOfPassage = new MyArrayList();
    }

    public Card create(TypeForCreation type) {
        Card newSkiPass = new Card(type, current, lastUsedNumber);
        lastUsedNumber++;
        createdCards.add((type.kind).toString());
        return newSkiPass;
    }

    public boolean checkCard(Card card, Date currentDate) {
        boolean flag = card.check(currentDate);
        String inf = String.valueOf(card.getNumber());
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
