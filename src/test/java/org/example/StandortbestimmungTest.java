package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandortbestimmungTest {

    Standortbestimmung standortbestimmung = new Standortbestimmung();

    @Test
    void testAufgabeHinzufueger() {
        String[] AufgabenListe = new String[1];
        String[] aufgabe = standortbestimmung.aufgabeHinzufueger("putzen", AufgabenListe);
        String[] aufgabeListeLosung = {"putzen"};
        Assertions.assertEquals(aufgabeListeLosung[0], aufgabe[0]);
    }

    @Test
    void testAufgabenAnzeiger() {
        String[] AufgabenListe = new String[100];
        AufgabenListe[0] = "putzen";
        String aufgabe = standortbestimmung.aufgabenAnzeiger(AufgabenListe);
        String vergleich = "1\tputzen";
        assertEquals(vergleich, aufgabe);
    }

}