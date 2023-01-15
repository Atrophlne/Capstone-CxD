import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

class StaffApp extends Encap {
   Scanner Scan = new Scanner(System.in);
   String RequestForm = "UserRequest.txt";

   void toDo() throws exeException {
      try {
         System.out.print("What Actions would you like to do?\n");
         System.out.print("[1] Submit Application\n");
         System.out.print("[2] View Approved Application\n");
         System.out.print("[3] Back\n> ");
         String inpt = Scan.nextLine();

         if (inpt.equals("1")) {
            String _ppReader = null;
            String _ProgCopy;
            Path Paths1 = Paths.get(RequestForm.toString());
            InputStream Inputs = Files.newInputStream(Paths1);
            BufferedReader _Reader2 = new BufferedReader(new InputStreamReader(Inputs));

            System.out.print("Enter Program Name: \n> ");
            String Acronm = Scan.nextLine();

            System.out.print("Enter Program Name: \n> ");
            String Prog = Scan.nextLine();

            System.out.print("Enter Description [Enter only when done]: \n> ");
            String Desc = Scan.nextLine();

            boolean ProgCopy = false;

            while ((_ppReader = _Reader2.readLine()) != null) {
               String Prog_Copy[] = _ppReader.split(",");
               _ProgCopy = Prog_Copy[1];

               if (_ProgCopy.equals(Prog)) {
                  ProgCopy = true;
               }
            }
            switch (ProgCopy + "-Info") {
               case "true-Info":
                  System.out.print("This Program Name Already exist\n");
                  toDo();
                  break;
               case "false-info":
            }
            setAcro(Acronm);
            setProgram(Prog);
            setDescrip(Desc);
            System.out.print("Your Application: \nProgram Name: " + Prog + "\nDescription: " + Desc + "\n");
            Confirm();

         } else if (inpt.equals("2")) {
            ShowApprv();
         } else if (inpt.equals("3")) {
            System.out.print("Going back\n");
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

   void Confirm() throws exeException {
      try {

         System.out.print("Confirm Application? [Y or N]\n> ");
         String inpt = Scan.nextLine();
         if (inpt.equalsIgnoreCase("Y")) {

            Path Path = Paths.get(RequestForm.toString());
            OutputStream Output = new BufferedOutputStream(Files.newOutputStream(Path, APPEND));
            BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(Output));

            String Desc_1 = getDescrip();
            String Prog_1 = getProgram();
            String Acro_1 = getAcro();

            Writer.write(Acro_1 + "," + Prog_1 + "," + Desc_1);
            Writer.newLine();
            Writer.close();
            Output.close();
            toDo();
         } else if (inpt.equalsIgnoreCase("N")) {
            System.out.print("Application Reset\n");
            toDo();
         } else {
            System.out.print("Cannot Confirm the input\n");
            Confirm();
         }
      } catch (Exception exeException) {
         new exeException();
      }
   }
}
