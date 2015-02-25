import java.util.* ;
public class Move
{
   int currentRow;
   int currentCol;
   Tower tower;
   Level curlevel;
   Room[][] level;
   int cur=0;
   Party party;
   Backpack pack;
   public Move(Tower tower,Party party,Backpack pack)
   {
      this.tower=tower;
      this.curlevel=tower.tower[cur];
      this.level=curlevel.level;
      this.party=party;
      this.pack=pack;
      findEntrance();//gets starting position
      System.out.println(curlevel);
   }
    
 
   public void findEntrance()
   {
      for(int row=0;row<level.length;row++)
      {
         for(int col=0;col<level[row].length;col++)
         {
            if(this.level[row][col].getRoomTypeBehavior() instanceof Entrance)
            {
               this.currentRow=row;
               this.currentCol=col;
            }//end of if
         }//end of inner for loop
      }//end of outer for loop
   }//end of method
    
   public boolean executeRoom()
   {	
      boolean win=false;
      int choice;
      Scanner kb=new Scanner(System.in);
      System.out.println(level[currentRow][currentCol]);
      if(!(this.level[currentRow][currentCol].getPotionBehavior() instanceof NoPotion))
      {
         potion(kb);   
      }//end of if
   	
      if(!(level[currentRow][currentCol].getWeaponBehavior() instanceof NoWeapon))
      {
         weapon(kb);
      }//end of if
      if(!(level[currentRow][currentCol].getMinionBehavior() instanceof NoMinions))
      {
         System.out.println("There is a bad guy in the room!!");
        	//BattlePhase.startBattle(party, b);
      }
      if(level[currentRow][currentCol].getRoomTypeBehavior() instanceof Exit)
      {
         if(curlevel.position<tower.getFinalLevel())
         {
            cur++;
            System.out.println("You reached the stairs!");
            if(curlevel.objective())
            {
               System.out.println("Oh no you have not finished your objective");
            }
            else
            {
               //unlock character
               boss();
               this.curlevel=tower.tower[cur];
               this.level=curlevel.level;
               findEntrance();
               System.out.println(curlevel);
            }
         }
         else
         {
            System.out.println("You reached the final room");
            if(curlevel.objective())
            {
               System.out.println("Oh no you have not finished your objective");
            }
            //unlock character
            boss();
            return true;
         }
      }
      if(level[currentRow][currentCol].getUniqueLevelItemBehavior() instanceof UniqueItem)
      {
         pack.list.add(this.level[currentRow][currentCol].getUniqueLevelItemBehavior());
         System.out.println(level[currentRow][currentCol].getUniqueLevelItemBehavior().toString()+" added to backpack");
         this.level[currentRow][currentCol].setUnique(new NoUniqueItems());
      }
   	
      return false;
    
   }//end
   public void boss()
   {
//       do
//       {
//       
//       }while(battle);
   }

   public void potion(Scanner kb)
   {
      int choice;
      do{
         System.out.println("You have found a health potion");
         System.out.println("What would you like to do:");
         System.out.println("1. Use it");
         System.out.println("2. Put it in your backpack");
         System.out.println("3. Leave in room");	
         System.out.println();		  	
             
             
         System.out.print("Choice-->");
         choice=kb.nextInt();
         kb.nextLine();
         System.out.println();
         if (choice<1 || choice>3)
         {
            System.out.println("I am sorry that is an invalid menu choice.");
            System.out.println("Please try again");
            System.out.println();
         }//end of if
         
      }while(choice<1 || choice>3);
      switch (choice)
      {
         case 1: 
            do{
               System.out.println("Who would you like to use the potion on");
               for(int x=0;x<3;x++)
               {
                  System.out.println((x+1)+". "+party.party[x]);
               }
               System.out.println();		  	
             
             
               System.out.print("Choice-->");
               choice=kb.nextInt();
               kb.nextLine();
               System.out.println();
            
               if (choice<1 || choice>3)
               {
                  System.out.println("I am sorry that is an invalid menu choice.");
                  System.out.println("Please try again");
                  System.out.println();
               }//end of if
            }while(choice<1 || choice>3);
         	
            party.party[choice-1].addHP(this.level[currentRow][currentCol].getPotionBehavior().getHP());
            this.level[currentRow][currentCol].setPotion(new NoPotion());
            break;
         case 2:
            pack.list.add(this.level[currentRow][currentCol].getPotionBehavior());
            this.level[currentRow][currentCol].setPotion(new NoPotion());
            break;
         default:
            break;
      }//end of switch
   
   
   }//end of method

   public void weapon(Scanner kb)
   {
      int choice;
      System.out.println("You have found a weapon");
      do{
         System.out.println("What would you like to do:");
         System.out.println("1. Use this Weapon");
         System.out.println("2. Leave in room");	
         System.out.println();		  	
             
             
         System.out.print("Choice-->");
         choice=kb.nextInt();
         kb.nextLine();
         System.out.println();
         if (choice<1 || choice>2)
         {
            System.out.println("I am sorry that is an invalid menu choice.");
            System.out.println("Please try again");
            System.out.println();
         }
      }while(choice<1 || choice>2);
                 
      switch (choice)
      {
         case 1: 
            MainCharacter main=(MainCharacter)party.getMain();
            main.setWeapon(this.level[currentRow][currentCol].getWeaponBehavior());
            this.level[currentRow][currentCol].setWeapon(new NoWeapon());
            break;
         default:
            break;
      }//end of switch
   }//end of method





    
   public boolean changeDirection()
   {int choice;
      Scanner kb=new Scanner(System.in);
       
      do{
         System.out.println("Which direction would you like to go:");
         System.out.println("1.North");
         System.out.println("2.South");
         System.out.println("3.East");
         System.out.println("4.West");
         System.out.println("5.Go back to main menu");
         System.out.println();		  	
             
             
         System.out.print("Choice-->");
         choice=kb.nextInt();
         kb.nextLine();
         System.out.println();
             
         if (choice<1 || choice>5)
         {
            System.out.println("I am sorry that is an invalid menu choice.");
            System.out.println("Please try again");
            System.out.println();
         }
             
      }
             while (choice<1 || choice>5);
          
      switch (choice)
      {
         case 1: 
            if (currentRow>0)
            {
               return moveNorth();
            }
            else
               System.out.println("Cannot move north");
            break;
         case 2:
            if (currentRow<4)
            {
               return moveSouth();
            }
            else
               System.out.println("Cannot move south");
            break;
         case 3:
            if (currentCol<4)
            {
               return moveEast();
            }
            else
               System.out.println("Cannot move east");
            break;
         case 4: 
            if (currentCol>0)
            {
               return moveWest();
            }
            else
               System.out.println("Cannot move west");
            break;
         default:
         	
            break;
      }
      return false;
   }//end of method

    
   public boolean moveEast()
   {
      this.currentCol++;
      return executeRoom();
   }
 	
   public boolean moveWest()
   {
      this.currentCol--; 
      return executeRoom(); 
   }
 	
   public boolean moveSouth()
   {
      this.currentRow++;
      return executeRoom(); 
   }
 	
   public boolean moveNorth()
   {
      this.currentRow--;
      return executeRoom();   
   }
 	
 	
}//end of class