package cardnight.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GegnerNamen {
    private static final String[] namen = {
            "Carl",
            "Dieter",
            "Uwe",
            "Hans",
            "Finn",
            "Chris",
            "Marc",
            "David",
            "Henry VIII",
            "Arthur",
            "Alfred",
            "Peter",
            "James",
            "Hugo",
            "Louis XIV",
            "Marty",
            "McFly",
            "Emmett",
            "George",
            "Rick",
            "Morty",
            "Bernard",
            "Laverne",
            "Hoagie",
            "Fred",
            "Edison",
    };

    public static ArrayList<String> gibZufaelligeNamen(int anzahl) {

        assert anzahl <= namen.length;

        ArrayList<String> gegnerNamen = new ArrayList<>(Arrays.asList(namen));
        ArrayList<String> result = new ArrayList<>(anzahl);

        Random rnd = new Random();

        for (int i = 0; i < anzahl; ++i) {
            int wahl = rnd.nextInt(gegnerNamen.size());
            result.add(gegnerNamen.get(wahl));
            gegnerNamen.remove(wahl);
        }

        return result;
    }
}