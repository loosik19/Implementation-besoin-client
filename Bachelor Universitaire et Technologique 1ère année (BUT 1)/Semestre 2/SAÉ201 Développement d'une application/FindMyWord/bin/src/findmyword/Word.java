package findmyword;

import java.util.*;

/**
 *Classe représentant un mot dans le jeu.
 *Un mot doit contenir exactement 5 lettres minuscules.
 */
public class Word {
    /*VARIABLE D'INSTANCE*/
    private String word;

    /**
     * Constructeur de la classe Word.
     * @param word Le mot à initialiser.
     */
    public Word(String word) {
        this.word = word;
    }
    /**
     * Retourne le mot actuel.
     * @return Le mot stocké.
     */
    public String getWord() {
        return this.word;
    }
    /**
     * Modifie le mot si celui-ci est valide.
     * @param word Le nouveau mot à définir.
     */
    public void setWord(String word) {
        // Sauvegarde temporaire pour tester la validité
        if(this.isValide()){
            this.word = word; // Restaure l'ancien si le nouveau est invalide
        }
    }

    /**
     * Vérifie si le mot respecte les règles :
     * 5 lettres, minuscules uniquement, et aucune lettre en double.
     * @return true si le mot est valide, false sinon.
     */
    public boolean isValide() {
        boolean valide = true;
        // Vérification de nullité
        if(this.word == null){return false;}
        // Vérification de la longueur (doit être 5)
        else if(!(this.word.length() == 5)){return false;}
        // Vérification du format (lettres minuscules a-z uniquement)
        else if(!(this.word.matches("[a-z]+"))){return false;}
        else{
            // Vérification de l'unicité des lettres
            String[] motString = this.word.split("");
            ArrayList<String> mot = new ArrayList<String>();

            int i = 0;
            while(i < motString.length){

                if(!mot.contains(motString[i])){
                    mot.add(motString[i]);
                    }
                else{
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    /**
     * Compare le mot proposé avec le mot secret (this).
     * @param w Le mot proposé par l'utilisateur.
     * @return Un tableau de 5 chaînes indiquant "OK", "PRESENT" ou "ABSENT".
     */
    public String[] analyse(Word w) {
        String secret = this.word;
        String proposition = w.getWord();
        String[] resultat = new String[5];

        // Étape 1 : Détecter les lettres bien placées (OK)
        for (int i = 0; i < 5; i++) {
            if (proposition.charAt(i) == secret.charAt(i)) {
                    resultat[i] = "OK";
                }
            }

        // Étape 2 : Détecter les lettres PRESENT OU ABSENT
        for (int i = 0; i < 5; i++) {
            if (resultat[i] == null) { // Si pas déjà marqué OK
                char proposition_char = proposition.charAt(i);

                // Vérification de la présence
                if (secret.contains(String.valueOf(proposition_char))) {
                    resultat[i] = "PRESENT";
                }
                else {
                    resultat[i] = "ABSENT";
                }
            }
                }
        return resultat;
    }

    /*public static void main(String[] args){
        Word w = new Word("cacas");
        System.out.println(w.isValide());
    }*/
}
