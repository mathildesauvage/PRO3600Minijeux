package resultat;
import javax.swing.JFrame;



public class Main {
	public static void main (String[] args) {
		Actualisation.actualisation();
		JFrame fenetre = new JFrame();
	    fenetre.setVisible(true);
	    fenetre.setTitle("Tableau score runner");
	    fenetre.setSize(400, 150);
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fenetre.setContentPane(new Panneau());
	    fenetre.setVisible(true);

	 
	}

}