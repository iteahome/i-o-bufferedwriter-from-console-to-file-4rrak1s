import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferedWriterfromScanner {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Write away... If you wish to flush the text to the output, type 'exit'...");
            BufferedWriter bw = null;
            String toWrite = "";
            while (true) {
                String mycontent = sc.nextLine();
                toWrite = toWrite + mycontent + "\n";

                //List of commands

                if (mycontent.equals("exit")) {

                    try {
                        File file = new File("output.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file);
                        bw = new BufferedWriter(fw);
                        bw.write(toWrite);

                        System.out.println("File written Successfully");


                        if (mycontent.equals("exit")) {
                            System.out.println("Bye-Bye!");
                            sc.close();
                        }

                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally {
                        try {
                            if (bw != null)
                                bw.close();
                        } catch (Exception ex) {
                            System.out.println("Error in closing the BufferedWriter" + ex);
                        }
                    }
                    break;
                }
            }
        }
    }

