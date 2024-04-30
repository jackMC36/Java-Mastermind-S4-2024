import java.util.Scanner;

/**
 * La classe Initialisation initialise le jeu. Elle récupère, par le biai de saisie clavier par l'utilisateur, les paramètres de la partie.
 */
public class Initialisation {
    /**
     * Crée un objet de type Scanner qui permet de lire une entrée d'un utilisateur à partir de la console.
     */
    Scanner input = new Scanner(System.in);

    /**
     * Le mode de jeu. multi = true si le mode de jeu est défini sur multijoueur, false s'il est défini sur solo.
     */
    private Boolean multi;

    /**
     * Indique si la ligne à deviner doit être choisi manuellement par un joueur ou automatiquement par un robot. robot = true si elle est choisi par "un robot", false sinon.
     */
    private Boolean robot;

    /**
     * Le niveau du jeu.
     */
    private String niveau;

    /**
     * Le nombre de tentatives autorisées.
     */
    private int nombreTentative;

    /**
     * Le nombre de pions.
     */
    private int nombrePion;

    /**
     * Le nombre de couleurs possibles.
     */
    private int nombreCouleur;

    /**
     * Indique s'il est possible qu'une couleur de pion soit présente en double. doublon = true si les doublons sont autorisés, false sinon.
    */
    private Boolean doublon;

    /**
     * Réalise un "clear" du terminal. Efface toute les lignes de commande tapées avant.
     */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * Constructeur de la classe Initialisation. Il initialise les paramètres du jeu en fonction des choix de l'utilisateur.
     */
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
        while((nombreTentative != 10) && (nombreTentative != 12)){ //10 ou 12 conformément aux consignes
            System.out.println("Saisie incorrecte, veuillez choisir une des propositions suivantes : 10 ou 12");
            this.nombreTentative = input.nextInt();
        }
           
        System.out.println("Combien de pions voulez-vous ? (4 ou 5)");
        this.nombrePion = input.nextInt();
        while((nombrePion != 4) && (nombrePion != 5)){ //4 ou 5 conformément aux consignes
            System.out.println("Saisie incorrecte, veuillez choisir une des propositions suivantes : 4 ou 5");
            this.nombrePion = input.nextInt();
        }

        System.out.println("Combien de couleurs voulez-vous ? (6 à 8)");
        this.nombreCouleur = input.nextInt();
        while((nombreCouleur != 6) && (nombreCouleur != 7) && (nombreCouleur != 8)){ //entre 6 et 8 conformément aux consignes
            System.out.println("Saisie incorrecte, veuillez choisir un chiffre entre 6 et 8");
            this.nombreCouleur = input.nextInt();
        }

        System.out.println("Voulez vous autorisez les doublons ? (Oui ou Non)");
        String choix2 = input.next();
        if(choix2.equalsIgnoreCase("Oui")){
            this.doublon = true;
        }
        else{
            this.doublon = false;
        }
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>multi</em>.
     * 
     * @return true si le mode de jeu est multijoueur, false sinon.
     */
    public Boolean getMulti(){
        return this.multi;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>robot</em>.
     * 
     * @return true si la ligne à deviner doit être générée automatiquement par un robot, false si elle doit être saisie manuellement par l'utilisateur.
     */
    public Boolean getRobot(){
        return this.robot;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>niveau</em>.
     * 
     * @return la valeur de l'attribut niveau (Facile ou Difficile).
     */
    public String getNiveau(){
        return this.niveau;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>nombreTentative</em>.
     * 
     * @return la valeur de l'attribut nombreTentative (comprise entre 10 et 12).
     */
    public int getNbTentative(){
        return this.nombreTentative;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>nombrePion</em>.
     * 
     * @return la valeur de l'attribut nombrePion (4 ou 5).
     */
    public int getNbPion(){
        return this.nombrePion;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>nombreCouleur</em>.
     * 
     * @return la valeur de l'attribut nombreCouleur (comprise entre 6 et 8).
     */
    public int getNbCouleur(){
        return this.nombreCouleur;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>doublon</em>.
     * 
     * @return true si les doublons de pions (on parle ici de la couleur) sont autorisés, false sinon.
     */
    public Boolean getDoublon(){
        return this.doublon;
    }
}
