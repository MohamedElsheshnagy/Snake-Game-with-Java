import java.awt.Color;

import javax.swing.JFrame;

public class mainSnake {

	public static void main(String[] args) {
		 JFrame f =new JFrame() ; 
		 GamePlay gameplay =new GamePlay();
	        f.setBounds(500, 120, 905, 700);
	        f.setVisible(true);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setResizable(false);
	        f.setBackground(Color.darkGray);
	        f.setTitle("Snake Game");
	        
	        f.add(gameplay); 
	}

}
