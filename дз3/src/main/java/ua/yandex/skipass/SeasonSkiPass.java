package ua.yandex.skipass;

public class SeasonSkiPass extends SkiPass{
    private final Date firstDayInSeason; 
    SeasonSkiPass(Date currentDate){
        active = true;
        this.type = Type.Season;
        firstDayInSeason = currentDate.firstDayInSeason(); 
    }
    @Override
    public boolean check (Date current){
     return active && firstDayInSeason.equalsWithoutHours(current.firstDayInSeason());
    }    
}    

