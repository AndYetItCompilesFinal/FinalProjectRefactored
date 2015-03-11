
public class BattleTester {
   public static void main(String[] args){
      GoodGuy a = new Ariel() ;
      GoodGuy b = new Aladdin();
      GoodGuy c = new Belle();
      Party p = new Party(a, b, c);

      BadGuy[] b = new BadGuy[3];
      b[0] = new MinionBase();
      b[1] = new MinionBase();
      b[2] = new MinionBase();

      boolean victory = BattlePhase.damage(p, b);
      if(victory){
         System.out.println("You are free to continued on.");
      }else{
         System.out.println("You lost, and can quit or retry");
      }
   }
}

