public class MainCharacter extends GoodGuy
{
   String name;
	WeaponBehavior weapon;
   //Weapon
   public MainCharacter(String name,WeaponBehavior weapon)
   {
		this.weapon=weapon;
      this.HP=50;
      this.defense=50;
      this.speed=5;
      this.attack=20;
      this.name=name;
   }
   public String toString()
   {
      return this.name;
   }
	public void setWeapon(WeaponBehavior weapon)
	{
		this.weapon=weapon;
	}
	
	
}//end of class