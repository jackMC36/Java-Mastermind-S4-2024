import java.util.Scanner;

public class Initialisation {
    Scanner input = new Scanner(System.in);
    private Boolean multi;
    private Boolean robot;
    private String niveau;
    private int nombreTentative;
    private int nombrePion;
    private int nombreCouleur;
    private Boolean doublon;

    /* méthode permettant de faire un 'clear' du terminal */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public Initialisation(){
        Initialisation.clearScreen();

        System.out.println("Bienvenue dans le jeu Mastermind !");

        System.out.println("Séléctionner le mode de jeu : (Solo ou Multijoueur)");
        String mode = input.next();
        if(mode.equalsIgnoreCase("Solo")){
            this.multi = false;
            this.robot = true;
        }
        else{
            this.multi = true;
            System.out.println("Souhaitez-vous choisir manuellement le modèle à deviner ? (Oui ou Non)");
            String choix = input.next();
            if(choix.equalsIgnoreCase("Oui")){
                this.robot = false;
            }
            else{
                this.robot = true;
            }
        }

        System.out.println("Choisissez le niveau de jeu : (Facile ou Difficile*)");
        System.out.println("*FACILE : à chaque tour, il vous sera indiqué précisément pour chaque pion si la couleur et la position sont bonnes.");
        System.out.println("*DIFFICILE : à chaque tour, il vous sera uniquement indiqué le nombre de pion avec la bonne couleur et bien placé ainsi que le nombre de pion avec la bonne couleur mais mal placé.");
        this.niveau = input.next();

        System.out.println("Combien de tentatives voulez-vous ? (10 ou 12)");
        this.nombreTentative = input.nextInt();
           
        System.out.println("Combien de pions voulez-vous ? (4 ou 5)");
        this.nombrePion = input.nextInt();

        System.out.println("Combien de couleurs voulez-vous ? (6 à 8)");
        this.nombreCouleur = input.nextInt();

        System.out.println("Voulez vous autorisez les doublons ? (Oui ou Non)");
        String choix2 = input.next();
        if(choix2.equalsIgnoreCase("Oui")){
            this.doublon = true;
        }
        else{
            this.doublon = false;
        }
    }

    public Boolean getMulti(){
        return this.multi;
    }

    public Boolean getRobot(){
        return this.robot;
    }

    public String getNiveau(){
        return this.niveau;
    }

    public int getNbTentative(){
        return this.nombreTentative;
    }

    public int getNbPion(){
        return this.nombrePion;
    }

    public int getNbCouleur(){
        return this.nombreCouleur;
    }

    public Boolean getDoublon(){
        return this.doublon;
    }
}
