import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * TODO!!!!!!!!!!!!!!!!!!!!!
 * 
 * @author Kozik J., Galfré K.
 */
public class Mastermind {
    /**
     * TODO!!!!!!!!!!!!!!!!!!!!!
     */
    private static Jeu jeu;

    /**
     * Réalise un "clear" du terminal. Efface toute les lignes de commande tapées avant.
     */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * TODO!!!!!!!!!!!!!!!!!!!!!
     */
    public static void sauvegardePartie(String nomFichier){
        try{
            FileOutputStream fos = new FileOutputStream(nomFichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jeu);
            oos.flush();
            oos.close();
            System.out.print("Partie sauvegardée\n");
        }
        catch(Exception e){
            System.out.print("Sauvegarde impossible\n" + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    /**
     * TODO!!!!!!!!!!!!!!!!!!!!!
     */
    public static void chargementPartie(String nomFichier){
        try{
            FileInputStream fis = new FileInputStream(nomFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);
            jeu = (Jeu) ois.readObject();
            ois.close();
            System.out.print("\n--- Partie chargée ---\n");
            //jeu.lancementJeu();
        }
        catch(Exception e){
            System.out.print("Chargement impossible\n" + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    /**
     * Méthode principale permettant d'éxécuter le programme.
     * 
     * @param args les arguments de la ligne de commande (non utilisés pour notre programme de Mastermind)
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Mastermind.clearScreen();
        System.out.println("Bienvenue dans le jeu Mastermind !\n");
        System.out.println("Souhaitez-vous charger une partie ? (Oui ou Non)");
        if(input.next().equalsIgnoreCase("Oui")){
            System.out.println("Indiquer le nom du fichier de sauvegarde");
            String nomFichier = input.next();
            chargementPartie(nomFichier);
        }
        else{
            jeu = new Jeu();
        }
        input.close();
    }
}
