package menu;

//import java.awt.Color; 
import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import java.awt.GridLayout;
 
public class Fenetre extends JFrame implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Score score = new Score("Scores");
	Jeu1 papi = new Jeu1("Papillon");
	Jeu2 memo = new Jeu2("Memory");
	
public Fenetre(){             
    this.setTitle("Menu principal");
    this.setSize(340, 700);
    this.setLocationRelativeTo(null);               

    this.setLayout(new GridLayout(3, 1));

    this.getContentPane().add(papi);
    this.getContentPane().add(memo);
    this.getContentPane().add(score);


    this.setVisible(true);
  
  }

@Override
public void actionPerformed(ActionEvent arg0) {
	System.out.print("ta mere");
}       
}