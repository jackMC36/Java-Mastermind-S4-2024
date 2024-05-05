import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe principale représentant le jeu Mastermind.
 * 
 * @author Kozik J., Galfré K.
 */
/**
    * Classe principale représentant le jeu Mastermind.
    */
/**
 * La classe Mastermind représente le jeu Mastermind.
 * Elle contient des méthodes pour sauvegarder et charger une partie, ainsi que la méthode principale pour exécuter le programme.
 */
public class Mastermind {
    /**
     * Attribut représentant le jeu Mastermind.
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
     * Sauvegarde la partie actuelle dans un fichier.
     * 
     * @param nomFichier le nom du fichier de sauvegarde
     * @param tableau le tableau de jeu
     * 
     */
    public static void sauvegardePartie(Tableau tableau, String nomFichier){

        //pass
        /*
        FileWriter writer = null;
        try{
            ArrayList<Pion> ligneADeviner = tableau.getLigneDeviner();
            ArrayList<ArrayList<Pion>> lignesJouees = tableau.getTabTentative();
            ArrayList<ArrayList<Integer>> controlD = tableau.getControlD();
            ArrayList<ArrayList<String>> controlF = tableau.getControlF();
    
            writer = new FileWriter(nomFichier);
            writer.write("Ligne à deviner\n");
            for(Pion pion : ligneADeviner){
                writer.write(pion.getCouleur() + " ");
            }
            writer.write("\n\nLignes jouées\n");
            for(ArrayList<Pion> ligne : lignesJouees){
                for(Pion pion : ligne){
                    writer.write(pion.getCouleur() + " ");
                }
                writer.write("\n");
            }
            writer.write("\nContrôles\n");
            for(ArrayList<Integer> control : controlD){
                for(Integer c : control){
                    writer.write(c + " ");
                }
                writer.write("\n");
            }
            writer.write("\n");

            for(ArrayList<String> control : controlF){
                for(String c : control){
                    writer.write(c + " ");
                }
                writer.write("\n");
            }

            writer.write("Niveau\n");
            writer.write(Integer.toString(tableau.getNiveau()));
            writer.write("\n");
    
            writer.write("Nombre de tentatives\n");
            writer.write(Integer.toString(tableau.getNbTentatives()));
            writer.write("\n");
    
            writer.write("Nombre de pions\n");
            writer.write(Integer.toString(tableau.getNbPions()));
            writer.write("\n");
            
            writer.flush();
            System.out.print("Partie sauvegardée\n");
        }
        catch(Exception e){
            System.out.print("Sauvegarde impossible\n" + e.getClass() + ": " + e.getMessage() + "\n");
        }
        finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch(IOException e) {
                    System.out.print("Erreur lors de la fermeture du fichier\n" + e.getClass() + ": " + e.getMessage() + "\n");
                }
            }
        }*/
    } 

    /**
     * Charge une partie à partir d'un fichier de sauvegarde.
     * 
     * @param nomFichier le nom du fichier de sauvegarde
     * @return le tableau de jeu
     */
    public static Tableau chargementPartie(String nomFichier){
        /*
        try{
            Tableau tableau = new Tableau();
            File file = new File(nomFichier);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals("Ligne à deviner")) {
                    String[] ligneADeviner = scanner.nextLine().split(" ");
                    ArrayList<Pion> ligneADevinerPion = new ArrayList<Pion>();
                    for(String couleur : ligneADeviner){
                        ligneADevinerPion.add(new Pion(couleur));
                    }
                    tableau.setLigneADeviner(ligneADevinerPion);
                }
                else if(line.equals("Lignes jouées")){
                    while(scanner.hasNextLine() && !line.equals("Contrôles")){
                        String[] ligneJouee = scanner.nextLine().split(" ");
                        ArrayList<Pion> ligneJoueePion = new ArrayList<Pion>();
                        for(String couleur : ligneJouee){
                            ligneJoueePion.add(new Pion(couleur));
                        }
                        tableau.ajouterTentative(ligneJoueePion);
                    }
                }
                else if(line.equals("Contrôles")){
                    String[] controlD = scanner.nextLine().split(" ");
                    for(String control : controlD){
                        tableau.ajouterControlD(control);
                    }
                    // Assuming there's a second control line
                    if(scanner.hasNextLine()) {
                        String[] controlF = scanner.nextLine().split(" ");
                        for(String control : controlF){
                            tableau.ajouterControlF(control);
                        }
                    }
                }
            }
            scanner.close();
            return tableau;
        }
        catch(Exception e){
            System.out.print("Chargement impossible\n" + e.getClass() + ": " + e.getMessage() + "\n");
            return null;
        }
    } */
        Tableau tableau = new Tableau();
        return tableau;
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

