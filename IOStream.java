
import java.io.*;
import java.util.Scanner;

public class IOStream {

    public static void main(String[] args) throws IOException {

        FileWriter fw = null; // output channel or stream
        FileReader fr = null;
        String s;
        try {
            fw = new FileWriter("output.txt"); // output.txt is created and it where my streams data will be placed
            PrintWriter pw = new PrintWriter(fw); // filtered output stream or channel

            // getting user input from console (readline)
            Scanner in = new Scanner(System.in);

            int countLine = 0;
            System.out.println("Enter input: ");
            s = in.nextLine();
            while (!s.isEmpty()) {
                countLine++;
                s = countLine + ": " + s;
                System.out.println(s);
                pw.println(s);
                s = in.nextLine();
            }
            if (s.isEmpty()) {
                System.out.println("Closed application...");
            }
            pw.flush();
            pw.close();
            fw.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        ////// start of reading file try-catch//////
        try {
            fr = new FileReader("output.txt");
            BufferedReader br = new BufferedReader(fr);
            s = br.readLine();
            while (s != null) {
                System.out.println(s);
                s = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println("While reading data could not find file");
        }



    ////// end of reading file try-catch//////

    

    } // end of main

} // end of IOStream public class
