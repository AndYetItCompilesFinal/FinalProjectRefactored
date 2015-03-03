import java.util.*;
public class Tower
{
   Level level1,level2,level3,level4,level5,level6,level7,level8,level9,level10;
	Level[] tower;
	public int finallevel=2;
   public Tower(Backpack pack)
   {
   this.level1=new LevelWithItems(new PeterPan(),new Weapon(10),new Hades(),new String[]{"Fairy Dust","Fairy Dust","Fairy Dust","Treasure","Treasure","Teddy Bear"},new String[]{"Fairy Dust","Fairy Dust","Treasure","Teddy Bear"},1,pack);
   this.level2=new CombatLevel(new Stitch(),new Weapon(10), new Hades(), 1, 2);
	
//    level3=new LevelWithItems(new Belle(),new Weapon(10),new Hades(),new String[]{"Rose","Teacup","Clock","Candlestick","Book","Book","Book"},new String[]{"Rose","Book","Book","Teacup"},3,pack);
//    level4=new LevelWithItems(new PeterPan(),new Weapon(10),new Hades(),new String[]{"Fairy Dust","Fairy Dust","Fairy Dust","Treasure","Treasure","Teddy Bear"},new String[]{"Fairy Dust","Fairy Dust","Treasure","Teddy Bear"},4,pack);
//    level5=new Level();
//    level6=new LevelWithItems(new Aladdin(),new Weapon(10),new Hades(),new String[]{"Magic Carpet","Treasure","Treasure","Magic Lamp","Apple","Apple"},new String[]{"Magic Carpet","Treasure","Magic Lamp","Apple"},6,pack);
//    level7=new Level();
//    level8=new Level();
//    level9=new LevelWithItems(new Mike(),new Weapon(10),new Hades(),new String[]{"Doll","Door","Door","Door","Scream","Scream"},new String[]{"Doll","Door","Sream","Scream"},9,pack);
//    level10=new LevelWithItems(new Ariel(),new Weapon(10),new Hades(),new String[]{"Fork","Thimble","Statue","Painting","Chess Piece","Book"},new String[]{"Fork","Thimble","Painting","Chess Piece"},10,pack);
   tower= new Level[]{level1,level2,level3,level4,level5,level6,level7,level8,level9,level10};
   
   }
	public int getFinalLevel()
	{
		return finallevel;
	}

}//end of class