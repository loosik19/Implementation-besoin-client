package findmyword;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Quel mode voulez-vous jouer ? (1 = Aléatoire, 2 = Test)");
    	int choix = scanner.nextInt();
    	
    	WordRepositoryAlea depotAlea = new WordRepositoryAlea();//Mode Test (Sélection fixe)
    	WordRepositoryFixe depotTest = new WordRepositoryFixe("codes");// Mode Réel (Sélection aléatoire depuis le dépôt JSON)
    	
    	//Lancement du Jeu
    	if(choix == 1){
       		Game partieTest = new Game(depotAlea);
       		partieTest.run();

    	}
    	else{
    		System.out.println("Le mot secret est codes...");
        	Game partieTest = new Game(depotTest);
        	partieTest.run();
    	}
    }
}
