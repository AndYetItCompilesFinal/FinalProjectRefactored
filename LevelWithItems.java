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
      System.out.println(disney+" needs your help!!\n");
      System.out.println("Find these items for "+disney+":");
      for(String item:target)
      {
         System.out.println(item);
      }
      System.out.println();
   }
   public void createUniqueItems(String description)
   {
      int row,col;
      do
      {
         row=random();
         col=random();
      }while(!(this.level[row][col].type instanceof GenericRoom)||(this.level[row][col].unique!=null));
      this.level[row][col].unique=new UniqueItem(description);
      this.level[row][col].size++;
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