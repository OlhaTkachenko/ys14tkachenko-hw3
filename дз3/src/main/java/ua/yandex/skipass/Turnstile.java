package ua.yandex.skipass;

public class Turnstile {

    private final Systema systema;
    public Date current;

    public Turnstile(Date d, Systema s) {
        systema = s;
        current = d;
    }

    boolean checkCard(Card card, Date currentDate) {
        return systema.checkCard(card, currentDate);
    }

}
