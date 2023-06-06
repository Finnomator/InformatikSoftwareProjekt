package cardnight.games.tictactoe.viewcontroller;

import cardnight.games.tictactoe.TicTacToeSpieler;
import cardnight.games.ueno.UenoKarte;
import cardnight.games.ueno.UenoSpieler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class TTTGegnerUiHand extends TTTUiHand {
    public HBox kartenBox;
    public ProgressIndicator thinkingProgress;

    @Override
    public void uiErstellen(TicTacToeSpieler spieler) {
        this.spieler = spieler;
        setThinkingStatus(false);
        updateUi();
    }

    private void setThinkingStatus(boolean thinking) {
        thinkingProgress.setVisible(thinking);
    }

    @Override
    public void updateUi() {

        setThinkingStatus(spieler.istAmZug());

        kartenBox.getChildren().clear();
        for (int i = 0; i < spieler.gibAnzahlHandKarten(); ++i) {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("/cardnight/game-views/tictactoe/karten-rueckseite.fxml"));
            try {
                kartenBox.getChildren().add(loader.load());
            } catch (IOException ex) {
                throw new RuntimeException();
            }
        }
    }
}