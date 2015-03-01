public class LevelWithItems extends Level
{
   public String[] target;
   public Backpack pack;
   public LevelWithItems(GoodGuy disney, WeaponBehavior weapon,BossBehavior boss,String[] items,String[] target, int position, Backpack pack)
   {
      
      this.position=position;
      this.disney=disney;
      initialize(weapon,boss);
      this.target=target;
      this.pack=pack;
      for(String item:items)
      {
         createUniqueItems(item);
      }
      changenulls();
   }
   public void createUniqueItems(String description)
   {
      int row,col;
      do
      {
         row=random();
         col=random();
      }while(!(this.level[row][col].getRoomTypeBehavior()instanceof GenericRoom)&&!(this.level[row][col].getUniqueLevelItemBehavior() instanceof NoUniqueItems));
      this.level[row][col]=new Room(row,col,new GenericRoom());
      this.level[row][col].setUnique(new UniqueItem(description));
      this.level[row][col].increaseSize();
   }
   public boolean objective()
   {
      boolean result=false;
      for(String item:target)
      {
         result=false;
         for(Object o:pack.list)
         {
            if(o instanceof UniqueItem)
            {
               if(o.toString().equals(item))
               {
               result=true;
               }
            }
         }
         if(result==false)
         {
            return result;
         }
      }
      return result;
   }
}//end of class