
# Avant-propose

## Contenu

```
FindMyWord/
├── bin
│   └── findmyword
│       ├── Game.class
│       ├── Joueur.class
│       ├── Main.class
│       ├── Word.class
│       ├── WordRepositoryAlea.class
│       ├── WordRepository.class
│       └── WordRepositoryFixe.class
├── README.md
└── src
    ├── findmyword
    │   ├── Game.java
    │   ├── Joueur.java
    │   ├── Main.java
    │   ├── Word.java
    │   ├── WordRepositoryAlea.java
    │   ├── WordRepositoryFixe.java
    │   └── WordRepository.java
    ├── wordset_bundle_etudiant
    │   ├── data
    │   │   ├── mots_fr_5_lettres_equilibres_1000.zip
    │   │   └── mots.json
    │   ├── docs
    │   │   └── javadoc-html
    │   │       ├── allclasses-index.html
    │   │       ├── allpackages-index.html
    │   │       ├── copy.svg
    │   │       ├── element-list
    │   │       ├── help-doc.html
    │   │       ├── index-all.html
    │   │       ├── index.html
    │   │       ├── legal
    │   │       │   ├── ASSEMBLY_EXCEPTION
    │   │       │   ├── jquery.md
    │   │       │   └── jqueryUI.md
    │   │       ├── link.svg
    │   │       ├── member-search-index.js
    │   │       ├── module-search-index.js
    │   │       ├── overview-tree.html
    │   │       ├── package-search-index.js
    │   │       ├── resources
    │   │       │   ├── glass.png
    │   │       │   └── x.png
    │   │       ├── script-dir
    │   │       │   ├── jquery-3.7.1.min.js
    │   │       │   ├── jquery-ui.min.css
    │   │       │   └── jquery-ui.min.js
    │   │       ├── script.js
    │   │       ├── search.html
    │   │       ├── search.js
    │   │       ├── search-page.js
    │   │       ├── stylesheet.css
    │   │       ├── tag-search-index.js
    │   │       ├── type-search-index.js
    │   │       └── words
    │   │           ├── JsonWordSet.html
    │   │           ├── package-summary.html
    │   │           ├── package-tree.html
    │   │           ├── TestWordSet.html
    │   │           └── WordSet.html
    │   ├── jar
    │   │   └── wordset.jar
    │   ├── README.md
    │   ├── tests
    │   │   └── TestWordSet.java
    │   └── words
    │       └── TestWordSet.class
    └── wordset_bundle_etudiant.zip

```

## Pour compiler les fichiers

```bash
cd FindMyWord/src #si ce n'est pas le cas
javac -d ~/FindMyWord/bin findmyword/*.java 
```

## Pour "Jouer"
```bash
cd FindMyWord/src #si ce n'est pas le cas
java -cp ~/FindMyWord/bin findmyword.Main
```

## Notes
- L'option `-d ~/FindMyWord/bin ` indique au compilateur de mettre les fichiers compilés (.class) dans le répertoire bin/ (création de ce dernier s'il n'existe pas)
- L'option `-cp ~/FindMyWord/bin` (ClassPath) indique à la VM de java où chercher les fichiers .class nécessaires à l'exécution du programme.
- Le projet doit être exécuté depuis le dossier src afin que les chemins relatifs comme wordset_bundle_etudiant/data/mots.json soient utilisés

# Comment jouer ? 
**Find My Word** est un jeu de réflexion textuel qui se joue à **deux joueurs** en face à face, sur la même console.
(inspiré du célèbre jeu Wordle)

## 1. Configuration de début

Au lancement de l'application :

* **Noms des joueurs :** Saisissez tour à tour le pseudonyme du premier et du deuxième joueur.
* **Choix des tours :** Indiquez le nombre de tours de jeu souhaité. Le nombre total de manches affiché à l'écran sera automatiquement doublé pour garantir que chaque joueur dispose du même nombre d'opportunités de deviner.

## 2. Déroulement d'un tour

Le jeu fonctionne selon un système d'alternance stricte : les tours impairs reviennent au Joueur 1, les tours pairs au Joueur 2.

Pour chaque mot secret, le joueur actif dispose de **6 tentatives au maximum**.

* **Contrainte des mots :** Chaque mot proposé doit obligatoirement comporter **5 lettres**, être purement **alphabétique** et **ne contenir aucun doublon** (aucune lettre répétée). Si une proposition ne respecte pas ces critères, elle est rejetée sans consommer d'essai.
* **Le Chronomètre :** Dès que l'invite de commande apparaît, le chronomètre du tour s'enclenche. Il s'arrête automatiquement au moment où le joueur trouve la solution ou épuise ses chances.

## 3. Système d'analyse des indices

À chaque mot proposé, la console affiche une grille de résultats comparative :

* `OK` : La lettre est correcte et idéalement placée.
* `PRESENT` : La lettre fait partie du mot secret mais se situe à un autre emplacement.
* `ABSENT` : La lettre ne figure pas du tout dans le mot recherché.

> **Exemple visuel d'affichage :**
> `[ L ] [ I ] [ G ] [ N ] [ E ] → OK ABSENT PRESENT PRESENT ABSENT`


## 4. Attribution des points et Fin de partie

Le score est calculé sur la rapidité de réflexion du joueur :

| Nombre de tentatives | Points attribués |
| --- | --- |
| **1 essai** (Premier coup) | **6 points** |
| **2 essais** | **5 points** |
| **3 essais** | **4 points** |
| **4 essais** | **3 points** |
| **5 essais** | **2 points** |
| **6 essais** | **1 point** |
| **Échec** (Non trouvé) | **0 point** |

À l'issue de l'ensemble des manches, un **Historique des tours** détaillé récapitule les performances individuelles (mots saisis, points, temps au chronomètre).

## Système de Vainqueur

Le programme calcule le score final accumulé :

1. Le gagnant est désigné selon le **cumul total des points**.
2. En cas d'égalité parfaite sur les points, les joueurs sont départagés par le **cumul total du temps le plus bas** (le joueur le plus rapide l'emporte).
3. Si (cas rare) il y a encore une égalité, alors le jeu affichera simplement "égalité".

À la fin de la session, le jeu vous propose de relancer une nouvelle partie en tapant simplement `O`.
