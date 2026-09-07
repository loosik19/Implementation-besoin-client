package findmyword;

import java.util.Random;

/**
 * Implémentation concrète de WordRepository.
 * Cette classe sélectionne un mot de manière aléatoire parmi la liste chargée.
 */
public class WordRepositoryAlea extends WordRepository {

    public WordRepositoryAlea() {
        super(); // Appelle le constructeur de WordRepository qui charge le JSON
    }

    /**
     * Sélectionne un mot aléatoire dans la liste.
     * @return Un nouvel objet Word contenant un mot choisi au hasard, 
     * ou null si la liste est vide.
     */
    public Word getWord() {
        // Vérification de sécurité : si la liste est vide, on ne peut pas choisir de mot
        if (this.getWordsList().isEmpty()) {
            return null;
    }

        // Création d'une instance de Random pour générer un index aléatoire
        Random random = new Random();
        int index = random.nextInt(this.getWordsList().size());

        // Retourne une nouvelle instance de Word avec le mot situé à l'index choisi
        return new Word(this.getWordsList().get(index));
    }
        }
