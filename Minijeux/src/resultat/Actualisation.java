package resultat;
import java.io.*;
public class Actualisation {


public static void actualisation (){
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
	int score_runner = runner.Fenetre.score;
	String score = Integer.toString(score_runner);
	while (score.length()<6) {
		score= "0"+score;
	}
	

	for (int i=0; i<tab.length;i++) {
		if (score.compareTo(tab[i])>0) {
			b=b+1;}}
	if (b==1) {
		tab[2]=score;
	}else if (b==2) {
		tab[2]=tab[1];
		tab[1]=score;
	}else if (b==3){
		tab[2]=tab[1];
		tab[1]=tab[0];
		tab[0]=score;}
	
   FileWriter scores = new FileWriter("resources/score.txt", false);
 
    for (int i=0; i<tab.length; i++) {
    	scores.write(tab[i]+"\r\n");
    }
 
    scores.close();
    br.close();
}
catch(IOException e)
{
    System.err.println(e.getMessage());
}

}
}
