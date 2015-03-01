public class Room
{
   public WeaponBehavior weapon=null;
   public MinionBehavior minion=null;
   public BossBehavior boss=null;
   public UniqueLevelItemBehavior unique=null;
   public RoomTypeBehavior type=null;
   public PotionBehavior potion=null;
   public int locationRow;
   public int locationCol;
   public int size;
   public Room(int row,int col,RoomTypeBehavior type)
   {
      this.locationRow=row;
      this.locationCol=col;
      this.type=type;
      this.size=0;
   }
   public void increaseSize()
   {
      this.size++;
   }
   public int getSize()
   {
      return this.size;
   }
   public String toString()
   {
      String result="";
      result+=type.toString();
      if(this.size==0)
      {
         result+=" is empty";
      }
      else
      {
         if(!(weapon instanceof NoWeapon))
         {
            result+=weapon.toString();
         }
         if(!(minion instanceof NoMinions))
         {
            result+=minion.toString();
         }
         if(!(potion instanceof NoPotion))
         {
            potion.toString();
         }
         if(!(unique instanceof NoUniqueItems))
         {
            unique.toString();
         }
      }
      return result;
   }
   
}//end of class