public class CombatLevel extends Level
{
   public int enemiesDefeated;
   public int minions;
   public MinionFactory minionFactory;
   public CombatLevel(GoodGuy disney, WeaponBehavior weapon, BossBehavior boss, int minions, int position)
   {
      this.minionFactory=new MinionFactory();
      this.enemiesDefeated=0;
      this.position=position;
      this.disney=disney;
      this.minions=minions;
      initialize(weapon,boss);
      for(int i=0;i<minions;i++)
      {
         createMinions();
      }
      changenulls();
   }
   public void createMinions()
   {
      int row,col;
      do
      {
         row=random();
         col=random();
      }while(!(this.level[row][col].getRoomTypeBehavior()instanceof GenericRoom)&&!(this.level[row][col].getMinionBehavior() instanceof NoMinions));
      this.level[row][col].setMinion(minionFactory.createParty());
      this.level[row][col].increaseSize();
   }
   public boolean objective()
   {
      if(this.minions==this.enemiesDefeated)
      {
         return true;
      }
      return false;
   }
}//end of class