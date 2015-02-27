import java.util.*;
public class MinionFactory
{
   public MinionBehavior createParty()
   {
      int num=random();
      MinionBehavior minionBehavior;
      if(num==0)
      {
         minionBehavior=new Minion();
      }
      else
       if(num==1)
      {
         minionBehavior=new MinionParty2();
      }
      else
      {
         minionBehavior=new MinionParty3();
      }
      return minionBehavior;
   }



   public int random()
   {
      Random random= new Random();
      return random.nextInt(3);
   }//end of method

}//end of class
