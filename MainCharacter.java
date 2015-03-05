public class MainCharacter extends GoodGuy
{
	WeaponBehavior weapon;
   //Weapon
   public MainCharacter(String name,WeaponBehavior weapon)
   {
      this.weapon=weapon;
      HP=50;
      defense=50;
      speed=5;
      attack=20;
      name=name;
   }

	public void setWeapon(WeaponBehavior weapon)
	{
		this.weapon=weapon;
	}
	
	
}//end of class