import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;


public class Storico extends Trasparent_Jpanel {
    private JTextArea textArea;
    private String filePath;
    private List<Giocatore> giocatori;


    public Storico(String filepath) throws IOException {
    	super(new Color(0,0,0), 0.5f);
    	this.filePath=filepath;
        setLayout(new GridBagLayout());
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 20));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(null);
        textArea.setBackground(new Color(0,0,0,25));
        
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Errore nella lettura del file.");
        }
        
        this.giocatori = new ArrayList<>();
        caricaClassifica();
        aggiornaTextArea();

        
        
        
       

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        scrollPane.setOpaque(false); 
        scrollPane.getViewport().setOpaque(false);
        int textAreaWidth = 400;
        int textAreaHeight = 400;
        scrollPane.setPreferredSize(new Dimension(textAreaWidth, textAreaHeight));
        scrollPane.setBorder(null);
        
        

        // Personalizzazione del JScrollPane
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(120,67,21); 
                this.trackColor = new Color(180,130,30); 
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }});
        
       
        
        BackgroundImage backgroundPanel= new BackgroundImage("C:\\Users\\nicol\\eclipse-workspace\\PROVA\\Game_Source\\SfondoPergamena.jpg");
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(55,55,55,55);
        gbc.fill = GridBagConstraints.BOTH;

        backgroundPanel.add(scrollPane, gbc);
        
        add(backgroundPanel);
        setOpaque(false);
        setVisible(true);
    }
    private void caricaClassifica()  {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line;
	        try {
				while ((line = reader.readLine()) != null) {
				    String[] parti = line.split(" - ");
				    if (parti.length == 2) {
				        String[] info = parti[1].split(", ");
				        String nickname = parti[0];
				        int livelli = Integer.parseInt(info[0].split(": ")[1]);
				        int tentativi = Integer.parseInt(info[1].split(": ")[1]);
				        giocatori.add(new Giocatore(nickname, livelli, tentativi));
				    }
				}
				 reader.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        ordinaClassifica();
    }

    private void ordinaClassifica() {
        Collections.sort(giocatori, (g1, g2) -> {
            int confrontoLivelli = Integer.compare(g2.livelliCompletati, g1.livelliCompletati);
            if (confrontoLivelli == 0) {
                return Integer.compare(g1.tentativi, g2.tentativi);
            }
            return confrontoLivelli;
        });
    }

    public void aggiungiGiocatore(String nickname, int livelliCompletati, int tentativi) throws IOException {
        giocatori.add(new Giocatore(nickname, livelliCompletati, tentativi));
        ordinaClassifica();
        salvaClassifica();
    }

    private void salvaClassifica() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (Giocatore giocatore : giocatori) {
            writer.write(giocatore.toString());
            writer.newLine();
        }
        writer.close();
    }

    private void aggiornaTextArea() {
        StringBuilder sb = new StringBuilder();
        int posizione = 1;
        for (Giocatore giocatore : giocatori) {
            sb.append("#").append(posizione).append(" ").append(giocatore.toString()).append("\n");
            posizione++;
        }
        textArea.setText(sb.toString());
    }
    

    // Classe interna per rappresentare i dati del giocatore
    private static class Giocatore {
        String nickname;
        int livelliCompletati;
        int tentativi;

        Giocatore(String nickname, int livelliCompletati, int tentativi) {
            this.nickname = nickname;
            this.livelliCompletati = livelliCompletati;
            this.tentativi = tentativi;
        }

        @Override
        public String toString() {
            return nickname + " - Livelli: " + livelliCompletati + ", Tentativi: " + tentativi+ "\n\t";
        }
    }
}







