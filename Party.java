public class Party
{
   Character[] party;
   
   public Party(Character a, Character b, Character c){
	party = new Character[3];
      party[0] = a;
      party[1] = b;
      party[2] = c;
   }
   
   public Character getParty(int index){
      return party[index];
   }
   
   public void setParty(Character chara, int index){
      party[index] = chara;
   }
   
   public String toString(){
     String str = ("This party consists of " + party[0].toString()+ ", " + party[1].toString() + ", and " + party[2].toString() + ". ");
	  return str;
   }
	
	public Character getMain()
	{
		return (MainCharacter)party[0];
	}
   
      
}//end of class