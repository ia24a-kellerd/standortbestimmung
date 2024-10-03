package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StandortbestimmungArrayList {
    public void main() {
        Scanner scanner = new Scanner(System.in);

        int eingabe = 0;
        String aufgabe = "";

        ArrayList<String> AufgabenListe = new ArrayList<>();

        while (eingabe != 5) {
            System.out.println("Wähle eine Opiton");

            System.out.println("1: Aufgabe hinzufügen");
            System.out.println("2: Alle Aufgabe anzeigen");
            System.out.println("3: Aufgabe bearbeiten");
            System.out.println("4: Aufgabe löschen");
            System.out.println("5: Programm beenden");
            System.out.println("--------------------------------------------");

            eingabe = scanner.nextInt();
            switch (eingabe) {
                case 1:
                    System.out.println("Gib mir die Aufgabe, damit ich sie deiner TodoList hinzufügen kann");
                    aufgabe = scanner.next();
                    aufgabeHinzufueger(aufgabe, AufgabenListe);
                    break;
                case 2:
                    System.out.println(aufgabenAnzeiger(AufgabenListe));
                    break;
                case 3:
                    aufgabenBearbeiter(AufgabenListe);
                    break;
                case 4:
                    aufgabeLoescher(AufgabenListe);
                    break;
                case 5:
                    System.out.println("Programm beendet");
                    break;
                default:
            }
        }
    }

    public static ArrayList<String> aufgabeHinzufueger(String aufgabe, ArrayList<String> AufgabenListe) {
        AufgabenListe.add(aufgabe);
        return AufgabenListe;
    }

    public static String aufgabenAnzeiger(ArrayList<String> AufgabenListe) {
        System.out.println("Hier ist Ihre TodoList:");

        int zaehler = 0;
        String ausgabe = "";

        for (int i = 0; i < AufgabenListe.size(); i++) {
            zaehler++;
            ausgabe += zaehler + "\t" + AufgabenListe.get(i) + "\n";
        }
        return ausgabe;
    }

    public static void aufgabenBearbeiter(ArrayList<String> AufgabenListe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Aufgabe möchtest Sie bearbeiten?");
        System.out.println(aufgabenAnzeiger(AufgabenListe));

        int eingabe = scanner.nextInt();

        System.out.println("Diese Aufgabe möchten Sie bearbeiten: " + AufgabenListe.get(eingabe-1));
        System.out.println("Was ist die neue Aufgabe?");
        String neueAufgabe = scanner.next();
        AufgabenListe.set(eingabe-1, neueAufgabe);
    }

    public static void aufgabeLoescher(ArrayList<String> AufgabenListe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Aufgabe möchtest Sie löschen?");
        System.out.println(aufgabenAnzeiger(AufgabenListe));

        int eingabe = scanner.nextInt();

        System.out.println("Diese Aufgabe wird gelöscht: " + AufgabenListe.get(eingabe-1));
        AufgabenListe.remove(eingabe-1);

        System.out.println("Die neu TodoList:");
        System.out.println(aufgabenAnzeiger(AufgabenListe));
    }
}
