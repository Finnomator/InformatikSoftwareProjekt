package cardnight.games.ueno.viewcontroler;

import cardnight.Main;
import cardnight.games.ueno.UenoFarbe;
import cardnight.games.ueno.UenoKarte;
import javafx.scene.image.Image;

import java.util.HashMap;

public class UenoKartenBilder {
    private static HashMap<UenoFarbe, Image[]> zahlenKarten;
    private static HashMap<UenoFarbe, Image> aussetzenKarten;
    private static HashMap<UenoFarbe, Image> zweiZiehenKarten;
    private static HashMap<UenoFarbe, Image> vierZiehenKarten;
    private static HashMap<UenoFarbe, Image> farbwahlKarten;
    private static HashMap<UenoFarbe, Image> richtungswechselKarten;
    public static final Image uenoKartenRueckseite = UenoKartenBilder.ladeBild("UNO_Rückseite.png", 0, Main.GEGNERKARTE_HOEHE);
    private static final String bilderPfad = "/cardnight/game-views/ueno/images/";

    private static boolean bilderWurdenSchonmalGeladen;

    public static void ladeBilder() {

        if (bilderWurdenSchonmalGeladen)
            return;

        bilderWurdenSchonmalGeladen = true;

        zahlenKarten = new HashMap<>();
        aussetzenKarten = new HashMap<>();
        zweiZiehenKarten = new HashMap<>();
        vierZiehenKarten = new HashMap<>();
        farbwahlKarten = new HashMap<>();
        richtungswechselKarten = new HashMap<>();

        for (UenoFarbe farbe : UenoFarbe.values()) {

            String farbeString = farbe.toString().toLowerCase();

            // Zahlenkarten
            Image[] karten = new Image[10];
            for (int i = 0; i < 10; ++i)
                karten[i] = ladeBild("zahlen/" + farbeString + "/UNO_" + i + "_" + farbeString + ".png");
            zahlenKarten.put(farbe, karten);

            aussetzenKarten.put(farbe, ladeBild("aussetzen/UNO_Aussetzen_" + farbeString + ".png"));

            farbwahlKarten.put(farbe, ladeBild("farbwahl/UNO_Farbwahl " + farbeString + ".png"));

            richtungswechselKarten.put(farbe, ladeBild("richtungswechsel/UNO_Reverse_" + farbeString + ".png"));

            vierZiehenKarten.put(farbe, ladeBild("vier-ziehen/UNO_Karte_vier_ziehen_" + farbeString + ".png"));

            zweiZiehenKarten.put(farbe, ladeBild("zwei-ziehen/UNO_Karte_zwei_ziehen_" + farbeString + ".png"));
        }

        farbwahlKarten.put(null, ladeBild("farbwahl/UNO_Farbwahl schwarz.png"));
        vierZiehenKarten.put(null, ladeBild("vier-ziehen/UNO_Karte_vier_ziehen_schwarz.png"));
    }

    private static Image ladeBild(String subPath) {
        return new Image(Main.class.getResourceAsStream(bilderPfad + subPath),
                Main.HANDKARTE_BREITE, 0.0, true, true);
    }

    public static Image ladeBild(String subPath, double breite, double hoehe) {
        return new Image(Main.class.getResourceAsStream(bilderPfad + subPath),
                breite, hoehe, true, true);
    }

    public static Image karteZuBild(UenoKarte karte) {
        switch (karte.art) {
            case ZAHL:
                return zahlenKarten.get(karte.farbe)[karte.wert];
            case PLUS_ZWEI:
                return zweiZiehenKarten.get(karte.farbe);
            case PLUS_VIER:
                return vierZiehenKarten.get(karte.farbe);
            case RICHTUNGSWECHSEL:
                return richtungswechselKarten.get(karte.farbe);
            case FARBWAHL:
                return farbwahlKarten.get(karte.farbe);
            case AUSSETZEN:
                return aussetzenKarten.get(karte.farbe);
        }

        throw new RuntimeException();
    }
}
