import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.io.IOException;

public class Storico_viewer extends Trasparent_Jpanel {
    private CardLayout cardLayout;
    private Storico[] storici;
    private JPanel cardPanel;
	protected Button_from_imm IndietroButton;


    public Storico_viewer() throws IOException {
    	super(Color.black, 0.5f);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);

        storici = new Storico[3];
        storici[0] = new Storico("C:\\Users\\nicol\\eclipse-workspace\\PROVA\\Game_Source\\StoricoPartitie1.txt");
        storici[1] = new Storico("C:\\Users\\nicol\\eclipse-workspace\\PROVA\\Game_Source\\StoricoPartitie2.txt");
        storici[2] = new Storico("C:\\Users\\nicol\\eclipse-workspace\\PROVA\\Game_Source\\StoricoPartite3.txt");
        
        addStoricoPanel(storici[0], "Storico Difficoltà FACILE");
        addStoricoPanel(storici[1], "Storico Difficoltà NORMALE");
        addStoricoPanel(storici[2], "Storico Difficoltà ESTREMA");

        

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        Trasparent_Jpanel buttonPanel = new Trasparent_Jpanel(new Color(211,186,130), 0.8f);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton nextButton = createStyledButton("Prossimo");
        JButton prevButton = createStyledButton("Precedente");

        nextButton.addActionListener(e -> cardLayout.next(cardPanel));
        prevButton.addActionListener(e -> cardLayout.previous(cardPanel));

        IndietroButton = new Button_from_imm("C:\\Users\\nicol\\eclipse-workspace\\PROVA\\Game_Source\\PulsanteIndietro.png");
        buttonPanel.add(IndietroButton);

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);


        add(buttonPanel, BorderLayout.SOUTH);
    }
    private void addStoricoPanel(Storico storici2, String title) {
        Trasparent_Jpanel panel = new Trasparent_Jpanel(new Color(211,186,130), 0.8f);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 24));
        titleLabel.setOpaque(false);
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(storici2, BorderLayout.CENTER);
        cardPanel.add(panel, title);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.ITALIC, 18));
        button.setForeground(Color.BLACK);
        button.setContentAreaFilled(false); // Rende il pulsante trasparente
        button.setOpaque(false);            // Imposta lo sfondo trasparente
        button.setBorderPainted(true);      // Imposta il bordo dipinto
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Aggiunge un bordo nero
        return button;
    }


    public void aggiungiGiocatore(int classificaIndex, String nickname, int livelliCompletati, int tentativi) throws IOException {
        if (classificaIndex >= 0 && classificaIndex < storici.length) {
            storici[classificaIndex].aggiungiGiocatore(nickname, livelliCompletati, tentativi);
        } else {
            throw new IllegalArgumentException("Indice classifica non valido. Deve essere 0, 1 o 2.");
        }
    }
}
