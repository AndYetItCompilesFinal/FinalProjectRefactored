/**
 * Created by Zoe on 3/5/2015.
 */
public class MinionBase extends BadGuy {
   public MinionBase(){
      name = "Minion";
      int maxHP;
      int HP;
      int defense;
      int speed;
      int attack;
      boolean alive;
      boolean good;
      String greeting;
      String goodBye;
   }

   public abstract int attack1(){
      System.out.println("The Minion tried to kick you!");
      return 1;
   }

   public abstract int attack2(){
      System.out.println("The Minion tried to punch you!");
      return 1;
   }

   public abstract int attack3(){
      System.out.println("The Minion tried to headbutt you!");
      return 1;
   }
}
