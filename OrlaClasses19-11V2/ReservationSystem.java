
import java.io.IOException;
/**
 * Allows you to run the roomMenu
 * @author Orla
 */
public class ReservationSystem
{  
   public static void main(String[] args)
        throws IOException
   { 
      RoomMenu menu = new RoomMenu();
      menu.run();
   }
}