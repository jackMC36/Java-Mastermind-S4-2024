import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * La classe Tableau crée un plateau de jeu et le gère. Elle s'occupe de le remplir, de l'afficher, etc.
 */
public class Tableau{
    /**
     * Crée un objet de type Scanner qui permet de lire une entrée d'un utilisateur à partir de la console.
     */
    Scanner input = new Scanner(System.in);

    /**
     * Liste stockant la ligne de pion à deviner.
     */
    private ArrayList<Pion> ligneDeviner;

    /**
     * Liste de liste (= tableau à 2 dimensions) stockant les tentatives de la partie.
     */
    private ArrayList<ArrayList<Pion>> tableauTentative;

    /**
     * Liste de liste stockant les résultats (Bien placé, bonne couleur...) de chaque essai au cours d'une partie avec le niveau réglé sur facile.
     */
    private ArrayList<ArrayList<String>> controlF;

    /**
     * Liste de liste stockant les résultats (Bien placé, bonne couleur...) de chaque essai au cours d'une partie avec le niveau réglé sur difficile.
     */
    private ArrayList<ArrayList<Integer>> controlD;

    /**
     * Le niveau de la partie (Facile ou Difficile)
     */
    private String niveau;

    /**
     * Le nombre de tentatives autorisées.
     */
    private int nombreTentative;

    /**
     * Le numéro de la tenative actuelle.
     */
    private int tentativeActuelle;

    /**
     * Le nombre de pions.
     */
    private int nombrePion;

    /**
     * Réalise un "clear" du terminal. Efface toute les lignes de commande tapées avant.
     */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * Constructeur de la classe Tableau.
     * 
     * @param multi Le mode de jeu (Solo ou Multijoueur).
     * @param robot Indique si la ligne à deviner et choisi aléatoirement ou manuellement par l'utilisateur.
     * @param niveau Le niveau de difficulté du jeu (Facile ou Difficile).
     * @param nombreTentative Le nombre de tentatives autorisées.
     * @param nombrePion Le nombre de pions dans une ligne.
     * @param nombreCouleur Le nombre de couleurs possibles pour les pions.
     * @param doublon Indique si les doublons de pion sont autorisés.
     */
    public Tableau(Boolean multi, Boolean robot, String niveau, int nombreTentative, int nombrePion, int nombreCouleur, Boolean doublon){
        this.tableauTentative = new ArrayList<ArrayList<Pion>>();
        this.controlF = new ArrayList<ArrayList<String>>();
        this.controlD = new ArrayList<ArrayList<Integer>>();
        this.niveau = niveau;
        this.nombreTentative = nombreTentative;
        this.tentativeActuelle = 0;
        this.nombrePion = nombrePion;
        if(robot){
            this.ligneDeviner = new ArrayList<Pion>();
            ArrayList<Integer> couleurs = new ArrayList<Integer>();
            for(int i=0;i<nombrePion;i++){
                Random rand = new Random();
                if(doublon == true){
                    int couleur = rand.nextInt(nombreCouleur);
                    switch(couleur){
                        case 0:
                            this.ligneDeviner.add(new Pion(Couleur.ROUGE));
                            break;
                        case 1:
                            this.ligneDeviner.add(new Pion(Couleur.JAUNE));
                            break;
                        case 2:
                            this.ligneDeviner.add(new Pion(Couleur.VERT));
                            break;
                        case 3:
                            this.ligneDeviner.add(new Pion(Couleur.BLEU));
                            break;
                        case 4:
                            this.ligneDeviner.add(new Pion(Couleur.CYAN));
                            break;
                        case 5:
                            this.ligneDeviner.add(new Pion(Couleur.ROSE));
                            break;
                        case 6:
                            this.ligneDeviner.add(new Pion(Couleur.VIOLET));
                            break;
                        case 7:
                            this.ligneDeviner.add(new Pion(Couleur.BLANC));
                            break;
                    }
                }
                else{
                    int couleur = rand.nextInt(nombreCouleur);
                    while(couleurs.contains(couleur)){
                        couleur = rand.nextInt(nombreCouleur);
                    }
                    couleurs.add(couleur);
                    switch(couleur){
                        case 0:
                            this.ligneDeviner.add(new Pion(Couleur.ROUGE));
                            break;
                        case 1:
                            this.ligneDeviner.add(new Pion(Couleur.JAUNE));
                            break;
                        case 2:
                            this.ligneDeviner.add(new Pion(Couleur.VERT));
                            break;
                        case 3:
                            this.ligneDeviner.add(new Pion(Couleur.BLEU));
                            break;
                        case 4:
                            this.ligneDeviner.add(new Pion(Couleur.CYAN));
                            break;
                        case 5:
                            this.ligneDeviner.add(new Pion(Couleur.ROSE));
                            break;
                        case 6:
                            this.ligneDeviner.add(new Pion(Couleur.VIOLET));
                            break;
                        case 7:
                            this.ligneDeviner.add(new Pion(Couleur.BLANC));
                            break;
                    }
                }
            }
        }
        else{
            System.out.println("Création de la ligne à deviner : ");
            if(nombreCouleur == 6){
                System.out.println("Voici les couleurs possibles : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                    ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                    ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                    ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                    ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                    ", ROSE" + (new Pion(Couleur.ROSE).toString()));
            }
            if(nombreCouleur == 7){
                System.out.println("Voici les couleurs possibles : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                    ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                    ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                    ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                    ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                    ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                    ", VIOLET" + (new Pion(Couleur.VIOLET).toString()));
            }
            if(nombreCouleur == 8){
                System.out.println("Voici les couleurs possibles : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                    ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                    ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                    ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                    ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                    ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                    ", VIOLET" + (new Pion(Couleur.VIOLET).toString()) +
                                                                    ", BLANC" + (new Pion(Couleur.BLANC).toString()));
            }
            ArrayList<String> couleurs = new ArrayList<String>();
            this.ligneDeviner = new ArrayList<Pion>();
            for(int i = 0 ; i < nombrePion ; i++){
                System.out.println("Entrez la couleur du pion " + (i+1) + " : ");
                String couleur = input.next();
                if(doublon == false){
                    while(couleurs.contains(couleur.toUpperCase())){
                        System.out.println("Cette couleur est déjà utilisée, veuillez en choisir une autre : ");
                        couleur = input.next();
                    }
                    couleurs.add(couleur.toUpperCase());
                }
                this.ligneDeviner.add(new Pion(Couleur.valueOf(couleur.toUpperCase())));
            }
        }
        Tableau.clearScreen();
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>tableauTentative</em>.
     * @return la liste de liste stockant toutes les tentatives déjà réalisées.
     */
    public ArrayList<ArrayList<Pion>> getTabTentative(){
        return this.tableauTentative;
    }

    /**
     * Getteur renvoyant la valeur de l'attribut privé <em>tentativeActuelle</em>.
     * @return le numéro de la tentative actuelle.
     */
    public int getTentativeActuelle(){
        return this.tentativeActuelle;
    }

    /**
     * Rempli le tableau de tentatives. Ajoute la dernière tentative au tableau de tentatives et incrémente le compteur de tentative déjà réalisée <em>tentativeActuelle</em>.
     * 
     * @param tentative La liste des pions de la dernière tentative, celle à ajouter.
     */
    public void ajouterTentative(ArrayList<Pion> tentative){
        tableauTentative.add(tentative);
        tentativeActuelle++;
    }

    /**
     * Vérifie si une tentative est correcte. C'est-à-dire vérifie si la tentative correspond à la ligne à deviner.
     * 
     * @param tentative La liste des pions de la tentative.
     * @return true si la tentative correspond à la ligne à deviner, false sinon.
     */
    public boolean verifierTentative(ArrayList<Pion> tentative){
        if(tentative.equals(ligneDeviner)){
            return true;
        }
        return false;
    }

    /* Choix d'implémentation concernant les 2 fonctions suivantes : si notre ligne à deviner contient un seul pion rouge et 
    que la ligne de tentative en contient 2 dont aucun n'est à la bonne place, on dira que le premier est BC/MP 
    et le deuxième sera considéré comme faux (ni BC, ni BP) */

    /**
     * Contrôle, si le niveau a été défini sur Facile, la dernière tentative.
     * Cette méthode compare une tentative avec la ligne à deviner et donne des indications pour chaque pion sur sa couleur et sa position.
     * Les correspondances sont stockées dans une liste de contrôle temporaire qui est ajoutée à la liste de contrôles globale, une liste de liste qui permet ensuite de faire l'affichage dans la console.
     * Les indications de correspondance sont les suivantes :
     * - "BC/BP" si la couleur et la position du pion sont correctes.
     * - "BC/MP" si la couleur est correcte mais la position est incorrecte.
     * - "-" si aucun critère de correspondance n'est rempli.
     *
     * @param tentative la tentative de l'utilisateur à comparer avec la ligne à deviner.
     */

    public void controleModeFacile(ArrayList<Pion> tentative){
        ArrayList<String> controlTmp = new ArrayList<String>();
        ArrayList<Pion> tmp = new ArrayList<Pion>(ligneDeviner);
        for(int i = 0 ; i < nombrePion ; i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                controlTmp.add("BC/BP");
                for(int j = 0 ; j < tmp.size() ; j++){
                    if(tentative.get(i).equals(tmp.get(j))){
                        tmp.remove(j);
                        break;
                    }
                }
            }
            else if(ligneDeviner.contains(tentative.get(i)) && tmp.contains(tentative.get(i))){
                controlTmp.add("BC/MP");
                for(int j = 0 ; j < tmp.size() ; j++){
                    if(tentative.get(i).equals(tmp.get(j))){
                        tmp.remove(j);
                        break;
                    }
                }
            }
            else{
                controlTmp.add("-");
            }
        }
        controlF.add(controlTmp);
    }

    /* Cette deuxième fonction fait le controle en difficile, elle n'indique que le nombre
    de pion par catégorie (BC/BP & BC/MP) */

    /**
     * Contrôle, si le niveau a été défini sur Difficile, la dernière tentative.
     * Cette méthode compare une tentative avec la ligne à deviner et donne des indications sur le nombre de pion dont la couleur et bonne et qui sont bien placé ainsi que sur le nombre de pion dont la couleur est bonne mais qui sont mal placé.
     * Les valeurs sont stockées dans une liste de contrôle temporaire qui est ajoutée à la liste de contrôles globale, une liste de liste qui permet ensuite de faire l'affichage dans la console.
     *
     * @param tentative la tentative de l'utilisateur à comparer avec la ligne à deviner.
     */

    public void controleModeDifficile(ArrayList<Pion> tentative){
        ArrayList<Integer> controlTmp = new ArrayList<Integer>();
        controlTmp.add(0);
        controlTmp.add(0); //On initialise les 2 colonnes (celle des BC/BP et celle des BC/MP) à 0 puis par la suite on utilise set pour mettre à jour
        ArrayList<Pion> tmp = new ArrayList<Pion>(tentative);
        for(int i = 0 ; i < nombrePion ; i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                controlTmp.set(0, (controlTmp.get(0) + 1));
                for(int j = 0 ; j < tmp.size() ; j++){
                    if(tentative.get(i).equals(tmp.get(j))){
                        tmp.remove(j);
                        break;
                    }
                }
            }
            else if(ligneDeviner.contains(tentative.get(i)) && tmp.contains(tentative.get(i))){
                controlTmp.set(1, (controlTmp.get(1) + 1));
                for(int j = 0 ; j < tmp.size() ; j++){
                    if(tentative.get(i) == tmp.get(j)){
                        tmp.remove(j);
                        break;
                    }
                }
            }
        }
        controlD.add(controlTmp);
    }

    /**
     * Affiche le plateau de jeu avec les tentatives précédentes et leurs résultats.
     * Cette méthode affiche le plateau de jeu en affichant les tentatives précédentes ainsi que les indications correspondantes pour chaque tentative. Les tentatives sont affichées avec leur numéro correspondant.
     */
    public void affichage(){
        System.out.println("\n-----");
        System.out.println("\nLégende :\nBC = Bonne couleur \nBP = Bien placé \nMP = Mal placé \n - = Ni bonne couleur, ni bien placé");
        System.out.print("\n   +");
        for(int e = 0 ; e < nombrePion ; e++){
            System.out.print("-----+");
        }
        System.out.println();
        for(int i = 0 ; i < (nombreTentative - tentativeActuelle) ; i++){
            String ligne = "|";
            for(int j=0;j<nombrePion;j++){
                ligne += "     ";
                if(j!=nombrePion-1){
                    ligne+= "|";
                }                
            }
            ligne+="|";
            System.out.print(String.format("%2d ", (nombreTentative - i)));
            System.out.println(ligne);
            System.out.print("   +");
            for(int e = 0 ; e < nombrePion ; e++){
                System.out.print("-----+");
            }
            System.out.println();
        }
        for(int i = tentativeActuelle ; i > 0 ; i--){
            String ligne = "| ";
            for(int j = 0 ; j < nombrePion ; j++){
                ligne += tableauTentative.get(i-1).get(j).toString();
                if(j != nombrePion-1){
                    ligne += " | ";
                }                
            }
            ligne += " |";
            System.out.print(String.format("%2d ", (i)));
            if(niveau.equalsIgnoreCase("Facile")){
                for(int e = 0 ; e < nombrePion ; e++){
                    ligne += " Pion " + (e+1) + " : " + controlF.get(i-1).get(e);
                }
            }
            else{
                ligne += " BC / BP : " + controlD.get(i-1).get(0);
                ligne += " - BC / MP : " + controlD.get(i-1).get(1);
            }
            System.out.println(ligne);
            System.out.print("   +");
            for(int e = 0 ; e < nombrePion ; e++){
                System.out.print("-----+");
            }
            System.out.println();
        }
        System.out.println();
    }
}