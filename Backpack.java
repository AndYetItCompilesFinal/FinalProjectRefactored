import java.util.*;

public class Backpack
{
	ArrayList list;
	
	public Backpack()
	{
		this.list= new ArrayList();
	}
   public String toString()
   {
   String result="Backpack:\n";
      for(Object o:list)
      {
         result+=o.toString();
         result+="\n";
      }
      return result;
   }
	
}//end of class