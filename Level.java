import java.util.*;
public abstract class Level
{
   Room[][] level=new Room[5][5];
	int position;
	GoodGuy disney;
	public abstract boolean objective();
   public void initialize(WeaponBehavior weapon,BossBehavior boss)
   {
      entrance();
      exit(boss);
      levelWeapon(weapon);
      generateRooms();
      potion(new HealthPotionHP10());//10hp
      potion(new HealthPotionHP15());//15hp
      potion(new MaxHealthPotion());//maxhp
      potion(new Poison10HP());//poison
   }//end of class
   public void entrance()
   {
      int row=random();
      int col=random();
      this.level[row][col]=new Room(row,col,new Entrance());
   }
   public void exit(BossBehavior boss)
   {
      int row,col;
      do
      {
         row=random();
         col=random();
      }while(this.level[row][col]!=null);
      this.level[row][col]=new Room(row,col,new Exit());
      this.level[row][col].setBoss(boss);
   }
   public void levelWeapon(WeaponBehavior weapon)
   {
      int row,col;
      do
      {
         row=random();
         col=random();
      }while(this.level[row][col]!=null);
      this.level[row][col]=new Room(row,col,new GenericRoom());
      this.level[row][col].setWeapon(weapon);
      this.level[row][col].increaseSize();
   }
   public void generateRooms()
   {
      for (int row=0;row<level.length;row++)
      {
         for(int col=0;col<level[row].length;col++)
         {
            if(this.level[row][col]==null)
            {
               this.level[row][col]=new Room(row,col,new GenericRoom());
            }
         }
      }
   }
   public void potion(PotionBehavior potion)
   {
      int row,col;
      do
      {
         row=random();
         col=random();
      }while(!(this.level[row][col].getRoomTypeBehavior()instanceof GenericRoom)&&!(this.level[row][col].getPotionBehavior() instanceof NoPotion));
      this.level[row][col].setPotion(potion);
      this.level[row][col].increaseSize();
   }
   public void changenulls()
   {
      Room room;
      for (int row=0;row<level.length;row++)
      {
         for(int col=0;col<level[row].length;col++)
         {
         
            if(this.level[row][col].getWeaponBehavior()==null)
            {
               this.level[row][col].setWeapon(new NoWeapon());
            }
            if(this.level[row][col].getMinionBehavior()==null)
            {
               this.level[row][col].setMinion(new NoMinions());
            }
            if(this.level[row][col].getBossBehavior()==null)
            {
               this.level[row][col].setBoss(new NoBoss());
            }
            if(this.level[row][col].getUniqueLevelItemBehavior()==null)
            {
               this.level[row][col].setUnique(new NoUniqueItems());
            }
         
            if(this.level[row][col].getPotionBehavior()==null)
            {
               this.level[row][col].setPotion(new NoPotion());
            }
         }//inner for loop
      }//outer for loop
   }
   public String itemType(Room room)
   {
      if(room.getSize()>1)
      {
         return "M";
      }
      if(room.getRoomTypeBehavior() instanceof Entrance)
      {
         return "I";
      }
      if(room.getRoomTypeBehavior() instanceof Exit)
      {
         return "O";
      }
      if(room.getSize()==0)
      {
         return "E";
      }
      if(room.getUniqueLevelItemBehavior() instanceof UniqueItem)
      {
         return "U";
      }
      if(!(room.getPotionBehavior() instanceof NoPotion))
      {
         return "P";
      }
      if(!(room.getWeaponBehavior() instanceof NoWeapon))
      {
         return "W";
      }
      if(!(room.getMinionBehavior() instanceof NoMinions))
      {
         return "B";
      }
      return "";
   }
   
   public String toString()
   {
      String result="***********";
      for (int row=0;row<this.level.length;row++)
      {
         result=result+"\n*";
         for(int col=0;col<this.level[row].length;col++)
         {
            if(col<level[row].length-1)
            {
               result=result+itemType(this.level[row][col])+"|";
            }
            else
               result=result+itemType(this.level[row][col])+"*";
         }//end of first inner for loop
         result=result+"\n*";
         for(int col2=0;col2<this.level[row].length;col2++)
         {	
            if(row<4)
            {
               result=result+"-*";
            }
         }//end of second inner for loop
      }//end of outer for loop
      result=result+"**********";
      	
      return result;
      
   }//end of method
   
   public int random()
   {
      Random random= new Random();
      return random.nextInt(5);
   }//end of method
}//end of class