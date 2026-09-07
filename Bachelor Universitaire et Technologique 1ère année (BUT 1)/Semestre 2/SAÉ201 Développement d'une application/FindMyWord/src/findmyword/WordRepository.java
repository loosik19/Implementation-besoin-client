package findmyword;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

/** 
 * Classe abstraite gérant le chargement et la récupération des mots.
 * Elle sert de modèle pour les différentes stratégies de sélection (aléatoire, fixe).
 */
public abstract class WordRepository {
    // Liste stockant les mots chargés depuis le fichier JSON
    private ArrayList<String> wordsList;

    //Constructeur : initialise la liste et lance le chargement des données    
    public WordRepository() {
        this.wordsList = new ArrayList<>();
        this.chargerJson();
    }

    /**
     * Accesseur pour récupérer la liste complète des mots.
     * @return ArrayList contenant tous les mots.
     */
    public ArrayList<String> getWordsList(){ //AJOUT
        return this.wordsList;
    }
    /**
     * Lit le fichier JSON, nettoie les caractères superflus et remplit la liste.
     */
    private void chargerJson() {
        try {
            // Lecture intégrale du fichier JSON
            String mots_string = Files.readString(Paths.get("wordset_bundle_etudiant/data/mots.json"));
            // Suppression des crochets et séparation par la virgule
            mots_string = mots_string.replace("[", " ").replace("]", " ").trim();
            String[] table = mots_string.split(",");
            // Ajout des mots dans la liste après nettoyage des guillemets
            for (String s : table) {
                // Nettoyage optionnel des guillemets si le JSON en contient
                this.wordsList.add(s.replace("\"", "").trim());
                }
            }
            catch (Exception e) {
                // Gestion basique des erreurs de lecture de fichier
                System.out.println(e.toString());
            }
        }

    // Méthode abstraite à implémenter dans les classes filles (concrètes)
    public abstract Word getWord();
}
