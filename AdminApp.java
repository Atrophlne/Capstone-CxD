import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

class AdminApp extends AdminHander {
   Scanner Scan = new Scanner(System.in);
   String Approved = "Approved.txt";

   /* First Method */
   void toDo() throws exeException {
      try {

         System.out.print("What Actions would you like to do?\n");
         System.out.print("[1] Check for applications\n");
         System.out.print("[2] Application Approval\n");
         System.out.print("[3] Approved Application List\n");
         System.out.print("[4] Back\n> ");
         String inpt = Scan.nextLine();

         if (inpt.equals("1")) {
            System.out.print("Here are the list of the Applications: \n");
            ShoApps();
         } else if (inpt.equals("2")) {
            Approve();
         } else if (inpt.equals("3")) {
            ShowApprv();
         } else if (inpt.equals("4")) {
            new MainCap();
         } else {
            System.out.print("This action is not usable\n");
            toDo();
         }

      } catch (Exception exeException) {
         new exeException();
      }
   }

   void ShowApprv() throws exeException {
      BufferedReader reader;
      try {
         reader = new BufferedReader(new FileReader("Approved.txt"));
         String line = reader.readLine();
         System.out.print("List of the Approved Applications\n");
         while (line != null) {
            String Prog1;
            String Desc1;
            String Prog[] = line.split(",");
            String Desc[] = line.split(",");
            Prog1 = Prog[0];
            Desc1 = Desc[1];

            System.out.print("Program Name: " + Prog1 + "\nDescription: " + Desc1 + "\n\n");

            line = reader.readLine();
         }
         reader.close();
         toDo();
      } catch (Exception exeException) {
         new exeException();
      }
   }

   void ShoApps() throws exeException {
      BufferedReader reader;
      try {
         reader = new BufferedReader(new FileReader("UserRequest.txt"));
         String line = reader.readLine();

         while (line != null) {
            String Prog1;
            String Desc1;
            String Acr;
            String Prog[] = line.split(",");
            String Desc[] = line.split(",");
            String Arc1[] = line.split(",");
            Acr = Arc1[0];
            Prog1 = Prog[1];
            Desc1 = Desc[2];

            System.out.print("Acronym: " + Acr + "\nProgram Name: " + Prog1 + "\nDescription: " + Desc1 + "\n\n");

            line = reader.readLine();
         }
         reader.close();
         toDo();
      } catch (Exception exeException) {
         new exeException();
      }
   }

   void Approve() throws exeException {
      ArrayList<String> Finder = new ArrayList<String>();
      try {
         System.out.print("Enter a Program Acronym to Approve: \n> ");
         String inpt = Scan.nextLine();

         String _ppReader = null;
         String _ProgCopy;
         Path Paths1 = Paths.get(Approved.toString());
         InputStream Inputs = Files.newInputStream(Paths1);
         BufferedReader _Reader2 = new BufferedReader(new InputStreamReader(Inputs));

         boolean ProgCopy = false;

         while ((_ppReader = _Reader2.readLine()) != null) {
            String Prog_Copy[] = _ppReader.split(",");
            _ProgCopy = Prog_Copy[0];

            if (_ProgCopy.equals(inpt)) {
               ProgCopy = true;
            }
         }

         switch (ProgCopy + "-Info") {
            case "true-Info":
               System.out.print("This Program is Already Approved\n");
               toDo();
               break;

            case "false-Info":

               Scanner Scanner3 = new Scanner(new File("UserRequest.txt"));
               Scanner3.useDelimiter("\r?\n");
               String ProgName, Descript;
               while (Scanner3.hasNext()) {
                  Finder.add(Scanner3.next());
               }

               for (String Item : Finder) {
                  if (Item.contains(inpt)) {

                     String Finding[] = Item.split(",");
                     ProgName = Finding[1];
                     Descript = Finding[2];

                     Path Path = Paths.get(Approved.toString());
                     OutputStream Output = new BufferedOutputStream(Files.newOutputStream(Path, APPEND));
                     BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(Output));

                     Writer.write(ProgName + "," + Descript);
                     Writer.newLine();
                     Writer.close();
                     Output.close();

                     System.out.print("Application Approved!\n");
                     toDo();
                  }
               }

               break;
            default:
         }

      } catch (Exception exeException) {
         new exeException();
      }
   }
}

class dummy {
   void repeater() {
      AdminApp loops = new AdminApp();
      try {
         loops.toDo();
      } catch (Exception exeException) {
         new exeException();
      }
   }
}
