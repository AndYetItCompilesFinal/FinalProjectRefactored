public abstract class PotionBehavior
{
   public String description;
   public int HP;
   public String toString()
   {
      return ", "+description;
   }
   public int getHP()
   {
      return HP;
   }

}