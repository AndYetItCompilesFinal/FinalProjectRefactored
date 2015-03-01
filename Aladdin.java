public class Aladdin extends GoodGuy
{

   public Aladdin()
   {
      maxHP = 50;
      HP = 50;
      defense = 50;
      speed = 5;
      attack = 20;
      alive = true;
      attack1 = "ATTACK ONE NAME";
      attack2 = "ATTACK TWO NAME";
      attack3 = "ATTACK THREE NAME";
   }
   public String toString()
   {
      return "Aladdin";
   }

   public int attack1(){
      return 0;
   }

   public int attack2(){
      return 0;
   }

   public int attack3(){
      return 0;
   }

}//end of class