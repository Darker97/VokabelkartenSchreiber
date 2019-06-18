import java.io.*;
import java.util.Scanner;

class VokabelSchreiber{

    public static Scanner sc = new Scanner(System.in);
    public static BufferedWriter bw;

    //Liest die Daten von der Tastatur ein und gibt Sie weiter
    public static void main(String[] args) {
        System.out.println("Willkommen!\nBitte trage deine Karten in der Form Name, Frage, Antwort 1 und Antwort 2 ein. \nGibt es keine zweite Antwort, so lassen Sie das Feld frei."); 
        
        try {
            bw = new BufferedWriter(new FileWriter("Data.txt", true));
        } catch (Exception e) {
            System.out.println("ne, wir nichts");
        }

        while (true){
            String Temp_String = "";
            System.out.println("---------------------------------------------------------------");
            System.out.println("Name?");
            String Name = sc.nextLine();
            if(!Name.isEmpty()){
                Temp_String += Name;
                Temp_String += "/";
            }


            System.out.println("Frage?");
            Temp_String += sc.nextLine();
            Temp_String += "/";

            
            System.out.println("Antwort?");
            String Antwort = "";
            Temp_String += sc.nextLine();

            while(true){
                System.out.println("nächste Antwort");
                Antwort = sc.nextLine();
                if (Antwort.isEmpty()){
                    break;
                }
                Temp_String += ";" + Antwort;
            }
            schreiben(Temp_String);
        }
    }

    // Schreibt den übergebenen String in die Datei

    public static void schreiben(String Text) {

        System.out.println(Text);
        try {
            bw.write(Text);
            bw.write("\n");
            bw.flush();
        } catch (Exception e) {
            System.out.println("AHHHHHHHHH");
        }
        
    }
}