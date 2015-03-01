import java.util.Iterator;
import java.util.Scanner;

public class BattlePhase {
   public void battle(Character[] good, Character[] bad) {
      BattleSetup order = new BattleSetup();
      //add characters to order based on speed stat
      Character[] a = {good[0], good[1], good[2], bad[0], bad[1], bad[2]};
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

      round(order);
   }

   public void swap(int i, int j, Character[] ara) {
      Character temp;
      temp = ara[i];
      ara[i] = ara[j];
      ara[j] = temp;
   }

   public void round(BattleSetup order) {
      for (Character c : order) {
         if (c.good) {
            int choice = displayMenu();
            if (choice == 1) {
               int attack = turn(c);
               int dmg = damage(attack + c.attack);
               //Choose which enemy to attack.

            } else {
               //pull up the backpack to use the item
            }
         } else {
            int total = villanTurn(c);
            int choice = ((int)(Math.random() * ((3 - 1)+1)));
         }
      }
   }

   public static int damage(int base) {
      int dmg = 0;
      int temp;
      for (int i = 1; i <= base; i++) {
         dmg = dmg + ((int) (Math.random() * (6 - 1) + 1));
      }
      dmg = dmg + base;
      return dmg;
   }

   public int turn(Character c) {
      System.out.println("Choose your Attack!");
      System.out.println("1. " + c.attack1);
      System.out.println("2. " + c.attack2);
      System.out.println("3. " + c.attack3);
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter number now: ");
      int attack = sc.nextInt();
      return attack;

   }

   public int displayMenu() {
      Scanner kb = new Scanner(System.in);
      System.out.println("Do you want to: ");
      System.out.println("1. Attack");
      System.out.println("2. Item");
      System.out.println("Enter your choice: ");
      int choice = kb.nextInt();
      return choice;
   }

   public int villanTurn(Character c) {
      int baseAttack;
      int damage;
      baseAttack = c.chooseAttack();
      damage = damage(c.attack + baseAttack);
      return damage;
   }

}
