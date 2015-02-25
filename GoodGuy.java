public abstract class GoodGuy extends Character
{

   public String printStats()
   {
      return toString() +"\n"+ "HP: "+this.HP+"\nDefense: "+this.defense+"\nSpeed: "+this.speed+"\nAttack: "+this.attack;
   }
   public void addHP(int HP)
   {
      this.HP+=HP;
   }


}//end of class