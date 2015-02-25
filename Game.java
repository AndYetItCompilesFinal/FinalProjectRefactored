import java.util.*;
public class Game
{
   public static void main(String[] args)
   {
      ArrayList<String> goodguys= new ArrayList<String>(Arrays.asList("Pooh Bear","Pocahontas","Chicken Little","Stitch","Dumbo","Pluto"));
      //make party
		WeaponBehavior weapon= new Weapon(10);
      GoodGuyFactory partyfactory=new GoodGuyFactory(goodguys);
      Party party=partyfactory.createParty();
      System.out.println(party);
      //make tower
		Tower tower=new Tower();
      
      Backpack pack=new Backpack();
      Move move=new Move(tower,party,pack);
      GameOptions run= new GameOptions(move);
   }
}//end of class