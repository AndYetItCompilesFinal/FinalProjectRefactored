import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

public class BattleSetup implements Iterable{
   LinkedList turnOrder;

   public BattleSetup(){
      turnOrder = new LinkedList;
   }

   public boolean addChar(Character c){
      boolean added;
      added = turnOrder.add(c);
      if(added) {
         System.out.println("Character successfully added to turn order.");
      }else {
         System.out.println("Character was not added to the turn order.");
      }
      return added;
   }

   public

   public Iterator iterator() {
      return new BattleOrder(turnOrder);
   }
}
