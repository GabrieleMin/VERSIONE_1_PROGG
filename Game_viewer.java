import javax.swing.*;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Game_viewer extends Trasparent_Jpanel implements ScoreObserver{
	private JTextField Punteggio;
	protected Button_from_imm IndietroButton;
	private String score;
	private int tentativi;
	private int livelliCompletati;
	
	public Game_viewer(String s) {
		
		super(Color.GRAY, 0.5f);
	
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600,525));
		
		Game gioco = new Game();
		gioco.addScoreObserver(this);
		Trasparent_Jpanel TopPanel= new Trasparent_Jpanel(Color.black, 0.5f);
		TopPanel.setLayout(new BorderLayout());
		
		JTextField Nickname= new JTextField(s);
		Nickname.setOpaque(false);
		Nickname.setBorder(null);
		Nickname.setEditable(false);
		Nickname.setFont(new Font("Times New Roman", Font.BOLD| Font.ITALIC, 30));
		Nickname.setForeground(Color.WHITE);
		
		
		
		Punteggio=new JTextField();
		Punteggio.setForeground(Color.WHITE);
		Punteggio.setOpaque(false);
		Punteggio.setBorder(null);
		Punteggio.setEditable(false);
		Punteggio.setFont(new Font("Times New Roman", Font.BOLD| Font.ITALIC, 30));
		Punteggio.setText("Punteggio:0/1");
		TopPanel.add(Nickname, BorderLayout.WEST);
		TopPanel.add(Punteggio, BorderLayout.EAST);
		TopPanel.setBackground(Color.BLACK);
		
		try {
			IndietroButton = new Button_from_imm("C:\\Users\\nicol\\eclipse-workspace\\PROVA\\Game_Source\\PulsanteIndietro.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Trasparent_Jpanel BottomPanel=new Trasparent_Jpanel(Color.DARK_GRAY, 0.5f);
		BottomPanel.setLayout(new BorderLayout());
		BottomPanel.add(IndietroButton, BorderLayout.WEST);
		
		
		add(TopPanel, BorderLayout.NORTH);
		add(BottomPanel, BorderLayout.SOUTH);
		add(gioco, BorderLayout.CENTER);
		
        SwingUtilities.invokeLater(() -> gioco.requestFocusInWindow());
        setVisible(true);
		
		
		
		
	}
	@Override
    public void updateScore(int attempts, int completedLevels) {
		score= completedLevels+"/"+attempts;
		tentativi=attempts;
		livelliCompletati= completedLevels;
        Punteggio.setText("Punteggio:"+ score );
    }
	public String getScore() {
		return score;
	}
	public int getAttempts() {
		return tentativi;
	}
	
	public int getCompletedLevels() {
		return livelliCompletati;
	}
}
