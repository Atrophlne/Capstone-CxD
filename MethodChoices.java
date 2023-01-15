import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class MethodChoices extends MethodAbs {
   Scanner Scan = new Scanner(System.in);

   void StaffUser() {
      try {
         System.out.print("Enter Staff Code: ");
         String inpt = Scan.nextLine();

         if (inpt.equals("staff123")) {
            /* Procced to the Staff Request */
            StaffApp SA = new StaffApp();
            SA.toDo();
         } else if (inpt.equalsIgnoreCase("back")) {
            new MainCap();
         } else {
            System.out.print("This code doesn't Exist\n");
            StaffUser();
         }
      } catch (Exception exeException) {
         new exeException();
      }

   }

   void AdminUser() {
      try {
         System.out.print("Enter Admin Code: ");
         String inpt = Scan.nextLine();

         if (inpt.equals("admin1234")) {
            /* Proceed to the Admin Approval */
            AdminApp AP = new AdminApp();
            AP.toDo();
         } else if (inpt.equalsIgnoreCase("back")) {
            new MainCap();
         } else {
            System.out.print("This code doesn't Exist\n");
            AdminUser();
         }
      } catch (Exception exeException) {
         new exeException();
      }
   }
}
