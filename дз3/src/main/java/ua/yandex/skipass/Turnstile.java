package ua.yandex.skipass;

public class Turnstile {
   public Date current;
   private static Systema systema ;
   public  Turnstile(Date c){
      systema =  new Systema(current); 
      current=c.copy();
   } 
   boolean checkCard(SkiPass card, Date currentDate) 
   {
     return systema.checkCard(card,currentDate);  
   }
   void create( String type)
   {
       systema.create(type); 
   }
}
