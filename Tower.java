import java.util.*;
public class Tower
{
   Level level1,level2,level3,level4,level5,level6,level7,level8,level9,level10;
	Level[] tower;
	public int finallevel=2;
   public Tower(Backpack pack)
   {
   this.level1=new LevelWithItems(new Stitch(),new Weapon(10),new Hades(),new String[]{"one","two"},new String[]{"one"},1,pack);
   this.level2=new CombatLevel(new Stitch(),new Weapon(10), new Hades(), 1, 2);
	tower= new Level[]{level1,level2,level3,level4,level5,level6,level7,level8,level9,level10};
//    level3=new Level();
//    level4=new Level();
//    level5=new Level();
//    level6=new Level();
//    level7=new Level();
//    level8=new Level();
//    level9=new Level();
//    level10=new Level();
   }
	public int getFinalLevel()
	{
		return finallevel;
	}

}//end of class