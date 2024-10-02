package org.example;

import java.util.Scanner;

public class Standortbestimmung {


    public void main() {
        Scanner scanner = new Scanner(System.in);

        int eingabe = 0;
        String aufgabe = "";

        String[] AufgabenListe = new String[100];

        while (eingabe != 5) {
            System.out.println("Wähle eine Opiton");

            System.out.println("1: Aufgabe hinzufügen");
            System.out.println("2: Alle Aufgabe anzeigen");
            System.out.println("3: Aufgabe bearbeiten");
            System.out.println("4: Aufgabe löschen");
            System.out.println("5: Programm beenden");

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

    public static String[] aufgabeHinzufueger(String aufgabe, String[] AufgabenListe) {
        boolean frage = true;
        for (int i = 0; i < AufgabenListe.length && frage; i++) {

            if (AufgabenListe[i] == null) {
                AufgabenListe[i] = aufgabe;
                frage = false;
            }

        }

        return AufgabenListe;
    }

    public static String aufgabenAnzeiger(String[] AufgabenListe) {
        System.out.println("Hier ist Ihre TodoList:");

        boolean frage = true;
        int zaehler = 0;
        String ausgabe = "";

        for (int i = 0; i < AufgabenListe.length && frage; i++) {
            if (AufgabenListe[i] != null) {
                zaehler++;
                ausgabe += zaehler + "\t" + AufgabenListe[i];
                if (AufgabenListe[i + 1] == null) {
                    frage = false;
                }
            }
        }
        return ausgabe;
    }

    public static void aufgabenBearbeiter(String[] AufgabenListe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Aufgabe möchtest Sie bearbeiten?");
        aufgabenAnzeiger(AufgabenListe);

        int eingabe = scanner.nextInt();

        for (int i = 0; i < AufgabenListe.length; i++) {
            if (eingabe == i + 1) {
                System.out.println("Diese Aufgabe möchtest du bearbeiten: " + AufgabenListe[i]);
                System.out.println("Gib die neue Aufgabe ein.");
                String neueAufgabe = scanner.next();

                AufgabenListe[i] = neueAufgabe;
            }
        }
    }

    public static void aufgabeLoescher(String[] AufgabenListe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Aufgabe möchtest Sie löschen?");
        aufgabenAnzeiger(AufgabenListe);

        int eingabe = scanner.nextInt();

        for (int i = 0; i < AufgabenListe.length; i++) {
            if (eingabe == i + 1) {
                System.out.println("Diese Aufgabe möchtest du löschen: " + AufgabenListe[i]);
                for (int j = i; j < AufgabenListe.length - i - 1; j++) {
                    if (AufgabenListe[j + 1] != null) {
                        AufgabenListe[j] = AufgabenListe[j + 1];
                    }
                    if (AufgabenListe[j + 1] == null) {
                        AufgabenListe[j] = null;
                    }
                }
            }
        }
        System.out.println("Die neu TodoList:");
        aufgabenAnzeiger(AufgabenListe);
    }
}
