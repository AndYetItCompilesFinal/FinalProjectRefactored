import java.util.Scanner;

public abstract class GoodGuy extends Character
{
   String attack1;
   String attack2;
   String attack3;

   public String printStats()
   {
      return toString() +"\n"+ "HP: "+this.HP+"\nDefense: "+this.defense+"\nSpeed: "+this.speed+"\nAttack: "+this.attack;
   }

   public void addHP(int HP)
   {
      this.HP+=HP;
   }

}//end of class