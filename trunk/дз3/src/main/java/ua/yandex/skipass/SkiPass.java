package ua.yandex.skipass;

abstract public class SkiPass{  
    protected int uniqueNumber;
    protected boolean active;
    public Type type;  
    public void block(){
        active = false;
    }
    public boolean isActive(){
        return active;
    }
    abstract public boolean check(Date current);
} 


