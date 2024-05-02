import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * TODO!!!!!!!!!!!!!!!!!!!!!
 */
public class Mastermind {
    private static Jeu jeu;

    /*
    private static void save(String nomFichier){
        try{
            FileOutputStream fos = new FileOutputStream(nomFichier); //Fini en .sav
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jeu);
            oos.flush();

        }
    }
    */

    /**
     * Méthode principale permettant d'éxécuter le programme.
     * Elle initialise les paramètres généraux de jeu et lance une partie en mode solo ou multijoueur.
     * 
     * @param args les arguments de la ligne de commande (non utilisés pour notre programme de Mastermind)
     */
    public static void main(String[] args){
        jeu = new Jeu();
    }
}
