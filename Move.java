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
   GoodGuyFactory factory;
   public Move(Tower tower,Party party,Backpack pack, GoodGuyFactory factory)
   {
      this.factory=factory;
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
            if(this.level[row][col].type instanceof Entrance)
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
      if(!(this.level[currentRow][currentCol].potion instanceof NoPotion))
      {
         potion(kb);   
      }//end of if
   	
      if(!(level[currentRow][currentCol].weapon instanceof NoWeapon))
      {
         weapon(kb);
      }//end of if
      if(!(level[currentRow][currentCol].minion instanceof NoMinions))
      {
         System.out.println("There is a bad guy in the room!!");
         System.out.println("Battle "+level[currentRow][currentCol].minion.numofminions+ "Minions");
         curlevel.enemiesDefeated+=level[currentRow][currentCol].minion.numofminions;
        	//BattlePhase.startBattle(party, b);
      }
      if(level[currentRow][currentCol].type instanceof Exit)
      {
         if(curlevel.position<tower.getFinalLevel())
         {
            cur++;
            System.out.println("You reached the stairs!");
            if(!curlevel.objective())
            {
               System.out.println("Oh no you have not finished your objective");
            }
            else
            {
               System.out.println("You completed the level objective!");
               factory.unlockCharacter(curlevel.disney,party);//unlock character
               boss();
               deleteItems();
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
               return false;
            }
            factory.unlockCharacter(curlevel.disney,party);//unlock character
            boss();
            deleteItems();
            return true;
         }
      }//end 
      int index;
      if(level[currentRow][currentCol].unique instanceof UniqueItem)
      {   boolean result=false;

         for(Object o:pack.list)
         {
            if(level[currentRow][currentCol].unique.description.equals(o.toString()))
            {
               UniqueItem obj=(UniqueItem)o;
               obj.quantity++;
               o=obj;
               result=true;
            }
         }  
         if(!result)
         {
            pack.list.add(this.level[currentRow][currentCol].unique);
         }         
      
         
         
         System.out.println(level[currentRow][currentCol].unique.toString()+" added to backpack\n");
         this.level[currentRow][currentCol].unique=new NoUniqueItems();
         this.level[currentRow][currentCol].size--;
      }
      
      System.out.println(curlevel);
      return false;
      
    
   }//end
   
   public void boss()
   {
   
   }
   public void deleteItems()
   {
      for(int i=0;i<pack.list.size();i++)
      {
         if(pack.list.get(i) instanceof UniqueItem)
         {
            pack.list.remove(i);
            i--;
         }
      }
   
   }

   public void potion(Scanner kb)
   {
      int choice;
      do{
         System.out.println("You have found a potion");
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
         	
            party.party[choice-1].addHP(this.level[currentRow][currentCol].potion.getHP());
            this.level[currentRow][currentCol].potion=new NoPotion();
            break;
         case 2:
            pack.list.add(this.level[currentRow][currentCol].potion);
            this.level[currentRow][currentCol].potion=new NoPotion();
            this.level[currentRow][currentCol].size--;
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
            main.setWeapon(this.level[currentRow][currentCol].weapon);
            this.level[currentRow][currentCol].weapon=new NoWeapon();
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