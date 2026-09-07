package findmyword;

public class Joueur {
    private String nom;
    private int pointsCumules;
    private long tempsCumuleSeconds; // Utilisation du type long pour la précision du temps

    //CONSTRUCTEUR
    /**
    * Constructeur pour initialiser un joueur avec son nom.
    * Les points et le temps commencent naturellement à 0.
    *
    * @param nom Le nom du joueur saisi au départ.
    */
    public Joueur(String nom) {
        this.nom = nom;
        this.pointsCumules = 0;
        this.tempsCumuleSeconds = 0;
        }

    //ACCESSEURS ET MUTATEURS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
        }

    public int getPointsCumules() {
        return pointsCumules;
    }

    public void setPointsCumules(int pointsCumules) {
        this.pointsCumules = pointsCumules;
        }

    public long getTempsCumuleSeconds() {
        return tempsCumuleSeconds;
    }

    public void setTempsCumuleSeconds(long tempsCumuleSeconds) {
        this.tempsCumuleSeconds = tempsCumuleSeconds;
    }

    //MÉTHODES

    /**
    * Ajoute des points au total du joueur à la fin d'un tour.
    *
    * @param pointsLeTour Nombre de points obtenus (ex: 6 - tentatives).
    */
    public void ajouterPoints(int pointsLeTour) {
        if (pointsLeTour > 0) {
            this.pointsCumules += pointsLeTour;
            }
        }

    /**
    * Ajoute le temps passé lors du tour actuel au total global du joueur.
    *
    * @param secondesLeTour Temps chronométré en secondes sur le tour.
    */
    public void ajouterTemps(long secondesLeTour) {
        if (secondesLeTour > 0) {
            this.tempsCumuleSeconds += secondesLeTour;
            }
    }
}
