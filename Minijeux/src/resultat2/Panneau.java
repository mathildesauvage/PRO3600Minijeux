package resultat2;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.*;

public class Panneau extends JPanel {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		try {
			String[] tab = new String[3];
			int c=0;
			BufferedReader br = new BufferedReader(new FileReader("resources/score.txt"));
			String line;
			while ((line = br.readLine()) != null && c<3) {
				tab[c]=line;
				c+=1;

			
		}
		int b=0;
		for(int j = 0; j<tab.length; j++) {
			g.drawString(String.valueOf(tab[j]), 10, 20+b);
			b+=10;
			}

		br.close();}
		catch (NullPointerException e) {
			
		}
		catch (IOException e) {
			
		}
}
}