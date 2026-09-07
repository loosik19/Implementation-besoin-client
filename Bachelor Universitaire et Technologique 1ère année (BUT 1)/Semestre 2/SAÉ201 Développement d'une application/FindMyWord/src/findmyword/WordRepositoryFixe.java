package findmyword;

/**
 * Implémentation concrète de WordRepository
 * Cette classe retourne toujours un mot spécifique défini à l'instanciation
 */
public class WordRepositoryFixe extends WordRepository {
    // Le mot fixe qui sera retourné
    private String fixeWord;

    public WordRepositoryFixe(String fixeWord) {
        // Appel du constructeur parent, puis écrasement/configuration du mot fixe
        super();
        this.fixeWord = fixeWord;
    }

    //Redéfinition de la méthode de la mère
    public Word getWord() {
        return new Word(this.fixeWord);
    }
}
