import java.util.*;
public abstract class Level
{
   Room[][] level=new Room[5][5];
	int position;
	GoodGuy disney;
   public int enemiesDefeated;
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
      this.level[row][col].boss=boss;
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
      this.level[row][col].weapon=weapon;
      this.level[row][col].size++;
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
      }while(!(this.level[row][col].type instanceof GenericRoom)||(this.level[row][col].potion!=null));
      this.level[row][col].potion=potion;
      this.level[row][col].size++;
   }
   public void changenulls()
   {
      for (int row=0;row<level.length;row++)
      {
         for(int col=0;col<level[row].length;col++)
         {
         
            if(this.level[row][col].weapon==null)
            {
               this.level[row][col].weapon=new NoWeapon();
            }
            if(this.level[row][col].minion==null)
            {
               this.level[row][col].minion=new NoMinions();
            }
            if(this.level[row][col].boss==null)
            {
               this.level[row][col].boss=new NoBoss();
            }
            if(this.level[row][col].unique==null)
            {
               this.level[row][col].unique=new NoUniqueItems();
            }
         
            if(this.level[row][col].potion==null)
            {
               this.level[row][col].potion=new NoPotion();
            }
         }//inner for loop
      }//outer for loop
   }
   public String itemType(Room room)
   {
      
      if(room.type instanceof Entrance)
      {
         return "I";
      }
      if(room.type instanceof Exit)
      {
         return "O";
      }
      if(room.size>1)
      {
         return "M";
      }
      else if(room.unique instanceof UniqueItem)
      {
         return "U";
      }
      else if(!(room.potion instanceof NoPotion))
      {
         return "P";
      }
      else if(!(room.weapon instanceof NoWeapon))
      {
         return "W";
      }
      else if(!(room.minion instanceof NoMinions))
      {
         return "B";
      }
      else
      {
         return "E";
      }
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