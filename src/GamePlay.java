import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener , ActionListener{
	  
	  private int[] snakexlength=new int[750];
	  private int[] snakeylength=new int[750];
	  
	  private boolean up=false;
	  private boolean down=false;
	  private boolean right=false;
	  private boolean left=false;
	  
	  private ImageIcon rightmouth;
	  private ImageIcon uptmouth;
	  private ImageIcon downmouth;
	  private ImageIcon lefttmouth;
	  
	  private int lengthofsnake =3;
	  
	  
	  
	  private Timer timer;
	  private int delay =100;
	  private ImageIcon snakeimage;
	  
	  private int [] enemyxpos= {25,50,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,
			  					475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	  private int [] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,
			  					350,375,400,425,450,475,500,525,550,575,600,625};
	  private ImageIcon enemyimage;
	  
	  private Random rand =new Random() ;
	  
	  private int xpos =rand.nextInt(34);
	  private int ypos =rand.nextInt(23);
	  
	  private int score =0;
	  
	  private int moves=0;
	  private ImageIcon imagetitle ;
	    
	    public   GamePlay(){
	        
	    	addKeyListener(this);
	    	setFocusable(true);
	    	setFocusTraversalKeysEnabled(false);
	    	timer =new Timer(delay, this);
	    	timer.start();
	    }
	    
	    public void paint(Graphics g){
	    	
	    	if(moves==0) {
	    		
	    		snakexlength[2]=50;
	    		snakexlength[1]=75;
	    		snakexlength[0]=100;
	    		
	    		snakeylength[2]=100;
	    		snakeylength[1]=100;
	    		snakeylength[0]=100;
	    		
	    		
	    	}
	    	
	        g.setColor(Color.WHITE);
	        g.drawRect(24, 10, 851, 55);
	        
	       imagetitle=new ImageIcon("snaketitle.jpg");
	       imagetitle.paintIcon(this, g, 25, 11);
	       
	       g.setColor(Color.WHITE);
	       g.drawRect(24, 74, 851, 577);
	       
	       
	        g.setColor(Color.BLACK);
	        g.fillRect(25, 75, 850, 575);
	        
	        rightmouth =new ImageIcon("rightmouth.png");
	        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
	        
	        g.setColor(Color.white);
	        g.setFont(new Font("arial", Font.PLAIN, 14));
	        g.drawString("Scores: "+score, 780, 30);
	        
	        
	        g.setColor(Color.white);
	        g.setFont(new Font("arial", Font.PLAIN, 14));
	        g.drawString("Length: "+lengthofsnake, 780, 50);
	        
	        
	        
	        for(int i=0;i<lengthofsnake;i++) {
	        	if(i==0 && right) {
	        		 rightmouth =new ImageIcon("rightmouth.png");
	     	        rightmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
	        	}
	        	if(i==0 && left) {
	        		 lefttmouth =new ImageIcon("leftmouth.png");
	     	        lefttmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
	        	}
	        	if(i==0 && down) {
	        		downmouth =new ImageIcon("downmouth.png");
	        		downmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
	        	}
	        	
	        	if(i==0 && up) {
	        		 uptmouth =new ImageIcon("upmouth.png");
	     	        uptmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
	        	}
	        	if(i!=0) {
	        		 snakeimage =new ImageIcon("snakeimage.png");
	        		 snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);
	        	}
	        }
	        
	        enemyimage =new ImageIcon("enemy.png");
	        
	        if((enemyxpos[xpos]==snakexlength[0])&&(enemyypos[ypos]==snakeylength[0])) {
	        	score++;
	        	lengthofsnake++;
	        	xpos =rand.nextInt(34);
	      	  	ypos =rand.nextInt(23);
	        }
	        
	        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
	        
	        for(int i=1;i<lengthofsnake;++i) {
	        	if((snakexlength[i]==snakexlength[0])&&(snakeylength[i]==snakeylength[0])) {
	        		right=false;
	        		left=false;
	        		up=false;
	        		down=false;
	        		
	        		g.setColor(Color.white);
	        		g.setFont(new Font("arial", Font.BOLD, 50));
	        		g.drawString("Game Over", 300, 300);
	        		
	        		g.setFont(new Font("arial", Font.BOLD, 20));
	        		g.drawString("Space to RESTART", 350, 340);
	        	}
	        }
	        
	        g.dispose();

}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			timer.start();
			if(right) {
				for(int i=lengthofsnake-1; i>=0;i--)
				{
					snakeylength[i+1]=snakeylength[i];
				}
				for(int i=lengthofsnake;i>=0;i--)
				{
					if(i==0) {
						snakexlength[i]=snakexlength[i]+25;
					}
					else {
						snakexlength[i]=snakexlength[i-1];
					}
					if(snakexlength[i]>850) {
						snakexlength[i]=25;
					}
				}
				
				repaint();
				
				
			}
			if(left) {
				for(int i=lengthofsnake-1; i>=0;i--)
				{
					snakeylength[i+1]=snakeylength[i];
				}
				for(int i=lengthofsnake;i>=0;i--)
				{
					if(i==0) {
						snakexlength[i]=snakexlength[i]-25;
					}
					else {
						snakexlength[i]=snakexlength[i-1];
					}
					if(snakexlength[i]<25) {
						snakexlength[i]=850;
					}
				}
				
				repaint();
				
				
			}
			if(down) {
				for(int i=lengthofsnake-1; i>=0;i--)
				{
					snakexlength[i+1]=snakexlength[i];
				}
				for(int i=lengthofsnake;i>=0;i--)
				{
					if(i==0) {
						snakeylength[i]=snakeylength[i]+25;
					}
					else {
						snakeylength[i]=snakeylength[i-1];
					}
					if(snakeylength[i]>625) {
						snakeylength[i]=75;
					}
				}
				
				repaint();
				
				
			}
			if(up) {
				for(int i=lengthofsnake-1; i>=0;i--)
				{
					snakexlength[i+1]=snakexlength[i];
				}
				for(int i=lengthofsnake;i>=0;i--)
				{
					if(i==0) {
						snakeylength[i]=snakeylength[i]-25;
					}
					else {
						snakeylength[i]=snakeylength[i-1];
					}
					if(snakeylength[i]<75) {
						snakeylength[i]=625;
					}
				}
				
				repaint();
				
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				moves=0;
				score=0;
				lengthofsnake =3;
				repaint();
			}
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				moves++;
				right=true;
				if(!left) {
					right=true;
				}
				else {
					right=false;
					left=true;
				}
				up=false;
				down=false;
				
			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				moves++;
				left=true;
				if(!right) {
					left=true;
				}
				else {
					left=false;
					right=true;
				}
				up=false;
				down=false;
				
			}
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				moves++;
				up=true;
				if(!down) {
					up=true;
				}
				else {
					up=false;
					down=true;
				}
				right=false;
				left=false;
				
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				moves++;
				down=true;
				if(!up) {
					down=true;
				}
				else {
					down=false;
					up=true;
				}
				right=false;
				left=false;
				
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
