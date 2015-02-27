import java.util.*;
public class GoodGuyFactory
{
   ArrayList characters;
   public GoodGuyFactory(ArrayList characters)
   {
      this.characters=characters;
   }
   public Party createParty()
   {
      Party party=new Party(mainCharacter(),chooseCharacter(),chooseCharacter());
      return party;
   }
   
   public GoodGuy mainCharacter()
   {
      String name;
      WeaponBehavior weapon= new Weapon(10);
      Scanner kb= new Scanner(System.in);
      System.out.println("What is your name?");
      name=kb.nextLine();
      GoodGuy main= new MainCharacter(name,weapon);
      return main;
   }

   public GoodGuy chooseCharacter()
   {
      int choice;
      int available=characters.size();
      GoodGuy character=null;
      String name;
      Scanner kb= new Scanner(System.in);
      do{
      	//Gives user the character choices
         for(int i=0;i<available;i++)
         {
            System.out.println((i+1)+") "+characters.get(i));
         }
         System.out.print("Choice-->");
         choice=kb.nextInt();
         kb.nextLine();
         System.out.println();
         //checks for invalid choice
         if (choice<1 || choice>available)
         {
            System.out.println("I am sorry that is an invalid menu choice.");
            System.out.println("Please try again");
            System.out.println();
         }
         
      }while(choice<1 || choice>available);
      
      name=(characters.get(choice-1)).toString();
      System.out.println(name);
      //creates the character chosen
      if("Pooh Bear".equals(name))
      {
         character=new PoohBear();
         characters.remove("Pooh Bear");  
      }
      if("Pocahontas".equals(name))
      {
         character=new Pocahontas();
         characters.remove("Pocahontas");  
      }
      if("Chicken Little".equals(name))
      {
         character=new ChickenLittle();
         characters.remove("Chicken Little");  
      }
      if("Stitch".equals(name))
      {
         character=new Stitch();
         characters.remove("Stitch");  
      }
      if("Dumbo".equals(name))
      {
         character=new Dumbo();
         characters.remove("Dumbo");  
      }
      if("Pluto".equals(name))
      {
         character=new Pluto();
         characters.remove("Pluto");  
      }
      
      return character;
   }
   public void unlockCharacter(GoodGuy character, Party party)
   {
      int choice;
      characters.add(character);
      Scanner kb= new Scanner(System.in);
      do
      {
         System.out.println("You have unlocked "+character.toString());
         System.out.println("Would you like to add them to your party?");
         System.out.println("1) yes");
         System.out.println("2) no");
        
         choice=kb.nextInt();
      
         if(choice!=1&&choice!=2)
         {
            System.out.println("I am sorry that is an invalid menu choice.");
            System.out.println("Please try again");
            System.out.println();
         
         }
      
      }while(choice==1||choice==2);
      if(choice==1)
      {
         do
         {
            System.out.println("Would would you like to swap?");
            System.out.println("1) "+party.party[1].toString());
            System.out.println("2) "+party.party[2].toString());
            choice=kb.nextInt();
         
            if(choice!=1&&choice!=2)
            {
               System.out.println("I am sorry that is an invalid menu choice.");
               System.out.println("Please try again");
               System.out.println();
            }
         }while(choice==1||choice==2);
         characters.add(party.party[choice]);
         party.setParty(character,choice);
      }
   
   }


}//end of class