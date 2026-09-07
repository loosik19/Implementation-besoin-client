package findmyword;

import java.util.Scanner;
import java.time.*;

public class Game {
    /*VARIABLE D'INSTANCE*/
    private String nom; //Nom de l'utilisateur
    private int tentatives;
    private int tour;
    private String[][] tours;//

    /*LIEN DE COMPOSITION*/
    private Word wordGame; // Correspond au motSecret
    private WordRepository wordRepository;//Liste ou Collection de mot

    /*TEMPS*/
    private Instant debut;
    private Instant fin;


    /*CONSTRUCTEUR*/
    public Game(WordRepository repo) {
        this.wordRepository = repo;
        this.tentatives = 0;
        this.wordGame = this.wordRepository.getWord(); // Initialisation du mot secret via la collection

    }

    /*ACCESSEURS ET MUTATEURS*/

    //Nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Tentative
    public int getTentatives() {
        return tentatives;
    }

    public void setTentatives(int tentatives) {
        this.tentatives = tentatives;
    }

    //Mot Secret
    public Word getMotSecret() {
        return wordGame;
    }

    public void setMotSecret(Word motSecret) {
        this.wordGame = motSecret;
    }

    /*MÉTHODES*/

    //MÉTHODES D'AFFICHAGE (ajout)
    public void affichage(String[] analyse, String motTentative){
        String[] resultat = analyse;  //ABSENT PRESENT OK
        String[] mot = motTentative.split(""); //L I G N E

        String grille_resultat = "";
        String grille_mot = "";

        for(int i = 0; i < resultat.length; i++){
            grille_resultat += resultat[i]+" ";
            grille_mot += "[ "+mot[i].toUpperCase()+" ]";
        }

        System.out.println(grille_mot+" → "+grille_resultat);
    }

    /**
    * Construit et affiche le tableau de l'historique des parties dans la console.
    * @param tours Un tableau à deux dimensions contenant les données des parties
    * sous la forme [ [Nom joueur], [Tentatives + Mots], [Temps en secondes], [Points] ].
    * @param totalTours Le nombre total de tours effectivement joués à afficher.
    * @return void Cette méthode réalise uniquement un affichage console.
    */
    public void afficherHistorique(String[][] tours, int totalTours) {
        System.out.println("\n--- HISTORIQUE DES TOURS ---");
        System.out.println("TOUR\t| JOUEUR\t| POINTS\t| TEMPS\t| TENTATIVES (MOTS)");
        System.out.println("---------------------------------------------------------------------------------");

        for (int y = 0; y < totalTours; y++) {
            if (tours[y] != null) {
                int numeroTour = y + 1;
                String nomJoueur = tours[y][0];
                String tentativesEtMots = tours[y][1];
                String temps = tours[y][2];
                String points = tours[y][3];

                // Affichage simple par concaténation avec des tabulations (\t) pour aligner les colonnes
                System.out.println("N°" + numeroTour + "\t| " + nomJoueur + "\t| " + points + " pts\t| " + temps + " s\t| " + tentativesEtMots);
            }
        }
        System.out.println("---------------------------------------------------------------------------------\n");
    }

    //MÉTHODE VÉRIFICATION VICTOIRE (ajout)
    public boolean WIN(String[] analyse){
        for(String s:analyse){
            if(!(s.equals("OK"))){
                return false;
            }
        }
        return true;
    }

    //MÉTHODES POUR LE TEMPS (ajout)
    public void commencer(){

        if(this.tentatives > 0){return;}
        this.debut = Instant.now();
    }

    public void stop(){
         this.fin = Instant.now();
    }

    //MÉTHODE RUN
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String nom ="";
        boolean continuer = true;
        System.out.println("=====================================");
        System.out.println("FIND MY WORD - BUT1");
        System.out.println("=====================================");
        System.out.println();

        System.out.print("Entrez le nom du premier joueur : ");
        nom = scanner.nextLine();
        Joueur Joueur1 = new Joueur(nom);

        System.out.print("Entrez le nom du deuxième joueur : ");
        nom = scanner.nextLine();
        Joueur Joueur2 = new Joueur(nom);

        System.out.println();
        System.out.println("Bienvenue "+ Joueur1.getNom() +" et "+ Joueur2.getNom()+" dans Find My Word !");
        System.out.println("Devinez le mot secret de 5 lettres (sans doublons).");

        while(continuer){
            System.out.print("Combien de tours voulez-vous : ");

            // Lit l'entier directement comme du texte pour vider le tampon et éviter le bug du retour à la ligne
            this.tour =  Integer.parseInt(scanner.nextLine());

            while(this.tour <= 0){
                System.out.print("Veuillez rentrez un nombre valide (1 ou +) ");
                this.tour = Integer.parseInt(scanner.nextLine());
            }
            System.out.println();

            System.out.println("Vous avez choisit "+this.tour+" tour(s)");
            System.out.println("De ce fait, il y aura "+this.tour*2+", étant donné qu'il y a deux joueurs");


            //Variable locale
            //Pour stoker le nombre de tours
            this.tours = new String[this.tour*2][4];

            for(int i = 0; i < this.tour*2; i++){
                System.out.println();//juste pour que l'affichage soit propre
                //Pour stocker les futurs mots de ce tour (Max 6)
                String[] entreeTentative = new String[6];
                int indexTentative = 0;

                boolean WIN = false;

                System.out.println("------Tours : "+(i+1)+"/"+this.tours.length+"------\n");//affichage de nombre de tours
                if((i+1)%2 != 0){
                    System.out.println("C'est à "+Joueur1.getNom()+" de jouer !");
                }
                else{
                    System.out.println("C'est à "+Joueur2.getNom()+" de jouer !");
                }

                while (tentatives < 6 && !WIN) {
                    this.commencer();//commence le chronomètre

                    System.out.println("Entrez un mot");
                    String proposition = scanner.nextLine();
                    Word motPropose = new Word(proposition);

                    while(!motPropose.isValide()){//On oblige l'utilisateur à entrer un mot valide
                        System.out.println("Mot invalide ! (Il doit faire 5 lettres, être alphabétique et sans doublon).");
                        proposition = scanner.nextLine();
                        motPropose = new Word(proposition);
                    }

                    // Sauvegarde du mot valide dans le tableau local
                    entreeTentative[indexTentative] = proposition.toUpperCase();
                    indexTentative += 1;

                    if(this.tentatives == 0){
                        System.out.println("\nTentative */* - : [ ][ ][ ][ ][ ] → ****** ****** ****** ****** ******");
                        System.out.println("-------------");
                    }

                    System.out.print("\nTentative " + (tentatives + 1) + "/6 - : ");

                    this.tentatives++;
                    this.affichage(wordGame.analyse(motPropose), proposition);//AFFICHAGE DE LA GRILLE
                    System.out.println("-------------");

                    // Vérification de la victoire (si toutes la grille est "OK")
                    WIN = this.WIN(wordGame.analyse(motPropose));
                }
                this.stop();//fin du chronomètre

                //On assemble tout les mots du joueur immédiatement ici
                String motsJoues = "";
                for (int n = 0; n < indexTentative; n++) {
                    motsJoues += "[" + entreeTentative[n] + "] ";
                }

                Duration duree = Duration.between(this.debut, this.fin);
                System.out.println("Votre Temps est de : "+duree.getSeconds()+" secondes");

                //Stockage dans l'historique et ceux des joueurs
                int points = 0;

                if (WIN) {
                    points = 7 - this.tentatives;
                }
                else {
                    points = 0; // Aucun point s'il n'a pas trouvé le mot au bout de 6 essais
                }

                if((i+1)%2 != 0){
                    this.tours[i][0] = Joueur1.getNom();
                    Joueur1.ajouterTemps(duree.getSeconds());
                    Joueur1.ajouterPoints(points);

                    }
                else{
                    this.tours[i][0] = Joueur2.getNom();
                    Joueur2.ajouterTemps(duree.getSeconds());
                    Joueur2.ajouterPoints(points);
                    }

                this.tours[i][1] = ""+this.tentatives+ " " + motsJoues.trim();
                this.tours[i][2] = ""+duree.getSeconds();
                this.tours[i][3] = ""+points;

                if (WIN) {

                    if(duree.getSeconds() < 3){
                        System.out.println("\nFélicitations ! Vous avez trouvé le mot en " + this.tentatives + " tentatives.");
                        System.out.println("Suspicion de triche mais nous avons rien pour le prouver (à moins que vous soyez dans le mode test) !");
                    }
                    else{
                        System.out.println("\nFélicitations ! Vous avez trouvé le mot en " + this.tentatives + " tentatives.");
                    }
                }
                else {
                    System.out.println("\nDommage ! Vous avez épuisé vos 6 tentatives. Le mot était : " + wordGame.getWord());
                }

                //Initialisation
                this.tentatives = 0;

                if(!(this.wordRepository instanceof WordRepositoryFixe)){//Si le jeu est "en mode test", ce n'est pas logique de changer de mot
                    this.wordGame = this.wordRepository.getWord();
                }
            }


            this.afficherHistorique(this.tours, this.tour*2);
            System.out.print("Total du temps de : "+Joueur1.getNom()+" : ");
            System.out.print(Joueur1.getTempsCumuleSeconds()+"s");
            System.out.print(" | Total des points : "+Joueur1.getPointsCumules());

            System.out.println();

            System.out.print("Total du temps de : "+Joueur2.getNom()+" : ");
            System.out.print(Joueur2.getTempsCumuleSeconds()+"s");
            System.out.print(" | Total des points : "+Joueur2.getPointsCumules());

            System.out.println();


            //Système de vainqueur
            int ecart_points = Joueur1.getPointsCumules() - Joueur2.getPointsCumules();//Si positif => Joueur1 gagné, sinon Joueur2 gagné
            long ecart_temps = Joueur1.getTempsCumuleSeconds() - Joueur2.getTempsCumuleSeconds();//Si positif => Joueur1 gagné, sinon Joueur2 gagné

            if(ecart_points > 0){//Joueur 1 a gagné par ecart de points
                System.out.println("Félicitations "+Joueur1.getNom()+" d'avoir remporté la partie avec un écart de "+ecart_points+"s !");
                System.out.println(Joueur2.getNom()+" n'abandonne pas, la prochaine sera la bonne !");
            }

            else if(ecart_points == 0){//Exaequo en terme de points

                if(ecart_temps < 0){//Joueur 1 a gagné par ecart de temps
                    System.out.println("Félicitations "+Joueur1.getNom()+" d'avoir remporté la partie avec un écart de "+Math.abs(ecart_temps)+"s !");
                    System.out.println(Joueur2.getNom()+" n'abandonne pas, la prochaine sera la bonne !");
                }

                else if(ecart_temps == 0){
                    System.out.println("Vous êtes à égalité en terme de points et de temps !");
                    System.out.println("Refaites une partie pour vous departager !");
                }
                else{
                    System.out.println("Félicitations "+Joueur2.getNom()+" d'avoir remporté la partie avec un écart de "+Math.abs(ecart_temps)+"s !");
                    System.out.println(Joueur1.getNom()+" n'abandonne pas, la prochaine sera la bonne !");
                }

            }
            else{
                System.out.println("Félicitations "+Joueur2.getNom()+" d'avoir remporté la partie avec un écart de "+ecart_points+" !");
                System.out.println(Joueur1.getNom()+" n'abandonne pas, la prochaine sera la bonne !");
            }

            //Système de rejouabilité
            System.out.println("Voulez-vous continuer ? (O/n)");
            String choix = scanner.nextLine();

            if((choix.toUpperCase().trim()).equals("O")){
                continuer = true;
            }
            else{
                continuer = false;
            }
        }//fin while(continuer)

    }//fin run()
}//fin Game
