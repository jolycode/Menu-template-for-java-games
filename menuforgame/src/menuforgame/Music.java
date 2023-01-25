package menuforgame;
import java.net.URL;

import javax.sound.sampled.*;

public class Music {
	    private Clip clip;
	      public static Music sound1 = new Music("/win.wav");
	      public static Music sound2 = new Music("/menu.wav");
	    /*...*/
	    
	    public Music (String fileName) {
	        try {
	            AudioInputStream ais = AudioSystem.getAudioInputStream(Music.class.getResource(fileName));
	            clip = AudioSystem.getClip();
	            clip.open(ais);
	        } catch (Exception e) {
	            e.printStackTrace();}}
	    public static Music getAudioInputStream(URL resource) {
			return null;
	    }
		public void play() { // to run music
			try {
	            if (clip != null) {
	                new Thread() {
	                    public void run() {
	                        synchronized (clip) {
	                            clip.stop();
	                            clip.setFramePosition(0);
	                            clip.start();}}
	                }.start();}} 
	        catch (Exception e) {
	        	e.printStackTrace();}}
	
}

