public abstract class BadGuy extends Character
{

   public int chooseAttack()
   {
      int baseAttack;
      int choice = ((int)(Math.random() * ((3 - 1) + 1)));
      if(choice == 1){
         baseAttack = attack1();
      }else if(choice == 2){
         baseAttack = attack2();
      }else{
         baseAttack = attack3();
      }
      return baseAttack;

   }

}//end of class