import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class MainCap {
   public MainCap() throws exeException, IOException {
      Scanner Scan = new Scanner(System.in);
      try {
         MethodChoices MC = new MethodChoices();
         System.out.print("Greetings what are your actions?\n");
         System.out.print("[1] Use Staff Code\n");
         System.out.print("[2] Use Admin Code\n> ");
         String inpt = Scan.next();

         if (inpt.equals("1")) {
            /* This will use a Staff Code */
            MC.StaffUser();
         } else if (inpt.equals("2")) {
            /* This will use a Admin Code */
            MC.AdminUser();
         } else {
            System.out.print("Sorry this miht not be in the Choices\n");
            new MainCap();
         }

      } catch (Exception exeException) {
         throw new exeException();
      }
   }

   public static void main(String[] args) throws IOException, exeException {
      new MainCap();
   }
}

class exeException extends Exception {
   public exeException() {
      super("A Problem has occured in the System");
   }
}
