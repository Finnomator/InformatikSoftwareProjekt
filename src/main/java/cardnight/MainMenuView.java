package cardnight;

import cardnight.games.tictactoe.TicTacToeView;
import cardnight.games.ueno.viewcontroler.UenoView;
import cardnight.games.witch.WitchView;
import javafx.scene.control.Slider;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MainMenuView {

    public Slider soundVolumeSlider;

    public void initialize() {
        soundVolumeSlider.setValue(Main.SOUND_VOLUME);
    }

    public void onTicTacToeClick() throws IOException {
        ScreenController.activateNewPane(TicTacToeView.loadScene());
    }

    public void onWitchClick() throws IOException {
        ScreenController.activateNewPane(WitchView.loadScene());
    }

    public void onBeendenClick() {
        System.exit(0);
    }

    public void onUenoClick() throws IOException {
        ScreenController.activateNewPane(UenoView.loadScene());
    }

    public void onSoundSliderMouseClick() {
        Main.SOUND_VOLUME = soundVolumeSlider.getValue();
        System.out.println("Sound bei " + Main.SOUND_VOLUME + "%");
    }

    public static void openLinkInBrowser(String link) {
        try {
            Desktop.getDesktop().browse(new URL(link).toURI());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void githubRepoLinkClick() {
        openLinkInBrowser(Main.GitHubRepo);
    }

    public void reportBugLinkClick() {
        openLinkInBrowser(Main.BugReportUrl);
    }
}