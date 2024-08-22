
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Index {
	//ciao
    private static Clip clip;

	public static void main(String[] args) throws IOException {
		
		
		JFrame finestra_principale= new JFrame("JWorldhardestGame");
		finestra_principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BackgroundImage Sfondo= new BackgroundImage("C:\\Users\\nicol\\OneDrive\\Immagini\\SfondoArcade.png");
		Menu_viewer menu= new Menu_viewer();
		
        finestra_principale.add(Sfondo);
        Sfondo.add(menu);
        
        finestra_principale.pack();
        finestra_principale.setLocationRelativeTo(null);
        finestra_principale.setVisible(true);
        playBackgroundMusic("C:\\Users\\nicol\\Downloads\\Gymnopdie.wav");

       
        
        menu.StoricoButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
       		Storico_viewer StoricoPage;
			try {
				StoricoPage = new Storico_viewer();
				swapPanels(StoricoPage, Sfondo);
	               StoricoPage.IndietroButton.addActionListener(new ActionListener() {
	                   @Override
	                   public void actionPerformed(ActionEvent e) {
	                       swapPanels(menu, Sfondo);
	                       
	                   }
	               });
			} catch (IOException e1) {
				e1.printStackTrace();
			}

               
           }
           
       });
      
       menu.PlayButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   String Nickname= menu.textPanel.Nickname.getText();
        	   
        	   Game_viewer SchermataDiGioco= new Game_viewer(Nickname);
               swapPanels(SchermataDiGioco, Sfondo);
               stopBackgroundMusic();
               playBackgroundMusic("C:\\Users\\nicol\\Downloads\\ColonnaSonora.wav");
               
               SchermataDiGioco.IndietroButton.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       swapPanels(menu, Sfondo);
                       stopBackgroundMusic();
                       playBackgroundMusic("C:\\Users\\nicol\\Downloads\\Gymnopdie.wav");


                       
                       try {
						Storico_viewer StoricoPage= new Storico_viewer();
						StoricoPage.aggiungiGiocatore(Dynamic_Archive.getDiff(),Nickname, SchermataDiGioco.getCompletedLevels(), SchermataDiGioco.getAttempts());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                       
                       
                       
                       
                   }
               });
               
           }
           
           
       });
       
      		
       

     }
	   private static void swapPanels(JPanel panel, JPanel Sfondo) {
	        Sfondo.removeAll();
	        Sfondo.add(panel);
	        Sfondo.revalidate();
	        Sfondo.repaint();
	    }
	    private static void playBackgroundMusic(String filepath) {
	        try {
	            File file = new File(filepath);
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop continuo della traccia audio
	            clip.start();
	        } catch (Exception e) {
	            System.out.println("Errore durante la riproduzione del file audio: " + e.getMessage());
	        }
	    }
	    private static void stopBackgroundMusic() {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	            clip.close();
	        }
	    }
	   
	
	
	}

