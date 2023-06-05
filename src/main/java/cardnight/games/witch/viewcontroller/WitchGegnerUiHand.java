package cardnight.games.witch.viewcontroller;

import cardnight.games.witch.WitchGegner;
import cardnight.games.witch.WitchKarte;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;

public class WitchGegnerUiHand {
    public Text sticheText;
    public Text nameText;
    public HBox kartenBox;
    public ProgressIndicator thinkingProgress;

    private WitchGegner spieler;

    public void uiErstellen(WitchGegner spieler) {
        this.spieler = spieler;
        nameText.setText(spieler.name);
        setThinkingProgress(false);
        updateUi();
    }

    private void setThinkingProgress(boolean thinking) {
        thinkingProgress.setVisible(thinking);
    }

    public void updateUi() {
        setThinkingProgress(spieler.istAmZug());
        sticheText.setText(String.valueOf(spieler.gibAnzahlErzhaltenderStiche()));

        kartenBox.getChildren().clear();

        for (WitchKarte ignored : spieler.gibHandkarten()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cardnight/game-views/witch/karten-rueckseite.fxml"));

            try {
                kartenBox.getChildren().add(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
