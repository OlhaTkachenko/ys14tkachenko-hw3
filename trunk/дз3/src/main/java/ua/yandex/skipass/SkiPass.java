package ua.yandex.skipass;

abstract public class SkiPass {

    public Type type;
    protected int uniqueNumber;
    protected boolean active;

    public void block() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    abstract public boolean check(Date current);
}
