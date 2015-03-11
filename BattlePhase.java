import java.util.Iterator;
import java.util.Scanner;

public class BattlePhase {
   //Sets up turn order and sets attack into motion
   public void battle(Party good, BadGuy[] bad) {
      BattleSetup order = new BattleSetup();
      //add characters to order based on speed stat
      Character[] a = {good.getParty(0), good.getParty(1), good.getParty(2), bad[0], bad[1] bad[2]};
      for (int i = 1; i < a.length; i++) {
         Character temp = a[i];
         int j;
         for (j = i - 1; j >= 0 && temp.speed < (a[j].speed); j--) {
            a[j + 1] = a[j];
            a[j + 1] = temp;
         } //for j
      }

      for (Character c : a) {
         order.addChar(a[i]);
      }

      boolean win = round(order, good, bad);
      if(win){
         System.out.println("Your team won the fight!");
      }else{
         System.out.println("Your team lost the fight!");
      }
   }

   //Swap only used in sorting the turn order by speed stat
   public void swap(int i, int j, Character[] ara) {
      Character temp;
      temp = ara[i];
      ara[i] = ara[j];
      ara[j] = temp;
   }

   //Continues to go through turn order and runs turn operations
   public boolean round(BattleSetup order, Party good, BadGuy[] bad) {
      boolean survivedTurn;
      for (Character c : order) {
         if (c.isGood()) {
            int choice = displayMenu();
            if (choice == 1) {
               int baseAttack = ((GoodGuy)c).attackMenu();
               int dmg = damage(baseAttack);
               int index = chooseTarget(c, bad);
               if(bad[index].dodgeAttempt()){
                  System.out.println(c.toString() + " missed the attack.")
               }else{
                  System.out.println("The attack hit for " + dmg +".");
                  boolean alive = bad[index].applyDamage(dmg);
                  if (!alive){
                     if(victory(bad)){
                        return true;
                     }
                  }
               }
            } else {
               //pull up the backpack to use the item
               System.out.println("Access the backpack items here.")
            }
         } else {
            survivedTurn = villanTurn(c);
            if(!survivedTurn){
              if(!good.partyAlive()){
                 return false;
              }
            }
         }
      }
      return false;
   }

   //Calculates a random damage in a range
   public static int damage(int base) {
      int dmg = 0;
      int temp;
      for (int i = 1; i <= base; i++) {
         dmg = dmg + ((int) (Math.random() * (6 - 1) + 1));
      }
      dmg = dmg + base;
      return dmg;
   }

   //Lets user pick to attack or use an item
   public int displayMenu() {
      Scanner kb = new Scanner(System.in);
      System.out.println("Do you want to: ");
      System.out.println("1. Attack");
      System.out.println("2. Item");
      System.out.println("Enter your choice: ");
      int choice = kb.nextInt();
      return choice;
   }

   //Automatically runs through the villan's turn, returning whether the hero survived the attack
   public boolean villanTurn(Character c, Party good) {
      int baseAttack;
      int damage;
      baseAttack = c.chooseAttack();
      damage = damage(baseAttack);
      // choose hero to attack
      int choice = ((int)(Math.random() * ((3 - 1)+1)));
      boolean survived = true;
      do {
         if (good.getParty(choice).isAlive()) {
            if (good.getParty(choice).dodgeAttempt()) {
               System.out.println("The attack missed.");
            } else {
               System.out.println("The attack hit for " + damage + ".");
               survived = good.getParty(choice).applyDamage(damage);
            }
         }
      }while(!good.getParty(choice).isAlive());
      return survived;
   }

   //Lets the user choose the target to attack
   public int chooseTarget(Character c, BadGuy[] bad){
      int target = 0;
      while(target < 1 || target > 3) {
         System.out.println("Who do you want to attack?");
         System.out.println("1. " + bad[0].toString());
         System.out.println("2. " + bad[1].toString());
         System.out.println("3. " + bad[2].toString());
         System.out.println("Enter the number here: ");
         Scanner sc = new Scanner(System.in);
         target = sc.nextInt();
         if(target < 1 || target > 3){
            System.out.println("Invalid number.")
         }
      }
      return target-1;
   }

   //returns whether the good guys won or not
   public boolean victory(BadGuy[] bad){
      if(!bad[0].isAlive() && !bad[1].isAlive() && !bad[2].isAlive()){
         return true;
      }
      return false;
   }

}
