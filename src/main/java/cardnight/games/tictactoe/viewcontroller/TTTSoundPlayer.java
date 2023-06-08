package cardnight.games.tictactoe.viewcontroller;

import cardnight.Main;
import cardnight.SoundPlayer;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Random;

public class TTTSoundPlayer {

    private static Clip[] ueberlegenSounds;
    private static Clip feldAusgesuchtSound;
    private static Clip hatGewonnenSound;

    public static void ladeSounds() {
        feldAusgesuchtSound = ladeClip("TicTacToe_Ausgesucht.wav");
        hatGewonnenSound = ladeClip("TicTacToe_Gewinner_Sound.wav");

        ueberlegenSounds = new Clip[3];
        for (int i = 0; i < 3; ++i)
            ueberlegenSounds[i] = ladeClip("TicTacToe_Uberlegen_" + (i + 1) + ".wav");
    }

    private static Clip ladeClip(String pfad) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/cardnight/game-views/tictactoe/sounds/" + pfad));
            Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
            clip.open(audioInputStream);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void feldAusgesucht() {
        SoundPlayer.playSoundAsync(feldAusgesuchtSound);
    }

    public static void gewonnen() {
        SoundPlayer.playSoundAsync(hatGewonnenSound);
    }

    public static void randomUeberlegen() {
        SoundPlayer.playSoundAsync(ueberlegenSounds[new Random().nextInt(ueberlegenSounds.length)]);
    }
}
