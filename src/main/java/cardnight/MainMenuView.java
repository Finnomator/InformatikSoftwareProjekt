package cardnight;

import cardnight.games.tictactoe.TicTacToeView;
import cardnight.games.ueno.viewcontroler.UenoView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainMenuView {

    public Slider soundVolumeSlider;

    public void initialize() {
        soundVolumeSlider.setValue(Main.SOUND_VOLUME);
    }

    public void onTicTacToeClick() throws IOException {
        ScreenController.activateNewPane(TicTacToeView.loadScene());
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
}
