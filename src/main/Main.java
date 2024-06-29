package main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

 
public class Main { 

    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        MainMenu app = new MainMenu();

        app.addWindowListener((WindowListener) new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
}