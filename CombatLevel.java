public class CombatLevel extends Level
{
   public CombatLevel(GoodGuy disney, WeaponBehavior weapon, BossBehavior boss, int minions, int position)
   {
		this.position=position;
		this.disney=disney;
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
      this.level[row][col].setMinion(new Minion());
      this.level[row][col].increaseSize();
   }
	public boolean objective()
	{
	
	}
}//end of class