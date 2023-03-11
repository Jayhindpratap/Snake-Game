import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	static final int SCREEN_WIDTH =600;
	static final int SCREEN_HEIGHT=600;
	static final int UNIT_SIZE =25;
	static final int GAME_UNITS =(SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY =75;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int ApplesEaten;
	int applex;
	int appley;
	char direction ='R';
	boolean running = false;
	Timer timer;
	Random random;
	
GamePanel(){
	random = new Random();
	   this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
	   this.setBackground(Color.black);
	   this.setFocusable(true);
	   this.addKeyListener(new MykeyAdapter());
	   startGame();

	}
   public void startGame() {
	   newApple();
	   running = true;
	   timer = new Timer(DELAY,this);
	   timer.start();
	   
	   
   }
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);	   
   }
   public void draw(Graphics g) {
	   g.setColor(Color.red);
	 g.fillOval(applex, appley, UNIT_SIZE, UNIT_SIZE);
	 	for(int i=0;i<bodyParts;i++) {
	 		if(i==0) {
	 		g.setColor(Color.green);
	 		g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
	 		}
	 		else {
	 			g.setColor (new Color(45,180,0));
	 		g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
	 		}
	 	}
	 
		   
	   
	 
  }
   public void newApple() {
	  
	   
   }
   public void move() {
	  for (int i=bodyParts;i>0;i--) {
		  x[i]=x[i-1];
		  y[i]=y[i-1];
				  
	  }
	  switch(direction) {
	  case 'U':
		  y[0]=y[0]-UNIT_SIZE;
		  break;
	  case'D':
		  y[0]=y[0]+UNIT_SIZE;
		  break;
	  case 'L':
		  x[0]=x[0]-UNIT_SIZE;
		  break;
	  case 'R':
		  x[0]=x[0]+UNIT_SIZE;
	  }
	   }
   public void checkApple() {
	   
   }
   public void checkCollission() {
	   
   }
   public void gameover(Graphics g) {
	   
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public class MykeyAdapter extends KeyAdapter{
	
		public void KeyPressed(KeyEvent e) {
		
			
		}
		
	}

}
