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
      boolean result=true;
      for(String item:target)
      {
         for(Object o:pack.list)
         {
            if(o instanceof UniqueItem&&o.description.equals(item))
            {
            
            }
         }
      }
      return result;
   }
}//end of class