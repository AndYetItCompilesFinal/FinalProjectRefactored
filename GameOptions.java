import java.util.*;
   public class GameOptions
   {
      public Move move;
   	public boolean win;
      public Backpack pack;
      public Party party;
      public GameOptions(Move move, Backpack pack, Party party)
      {
         this.party=party;
         this.pack=pack;
      	this.move=move;
      	win=false;
      	run();
      }
      
      public void run()
      {
      	int choice;
      	Scanner kb= new Scanner(System.in);
         do{
            do{
               System.out.println("Please select from the following menu choices:");
               System.out.println("1.Move through the castle");
               System.out.println("2.Open Backpack");
               System.out.println("3.View Party Stats");
               System.out.println("4.Quit");
               System.out.println();		  	
               
               
               System.out.print("Choice-->");
               choice=kb.nextInt();
               kb.nextLine();
               System.out.println();
               
               if (choice<1 || choice>4)
               {
                  System.out.println("I am sorry that is an invalid menu choice.");
                  System.out.println("Please try again");
                  System.out.println();
               }
               
            } while (choice<1 || choice>4);
            
            switch (choice)
            {
               case 1: 
                  this.win=move.changeDirection();
                  break;
               case 2:
                 System.out.println(pack);
                  break;
               case 3:
                  for(GoodGuy member:party.party)
                  {
                     System.out.println(member.printStats());
                     System.out.println();
                     
                  }
               default:
						win=true;
                  break;
            }
         }while (win==false);
      }//end of method
   }//end of class