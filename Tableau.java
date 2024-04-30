import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/* Classe Tableau, qui représente le tableau de jeu du Mastermind */
public class Tableau{
    Scanner input = new Scanner(System.in);
    private ArrayList<Pion> ligneDeviner; //tableau stockant la ligne de pion à deviner
    private ArrayList<ArrayList<Pion>> tableauTentative; //tableau stockant les tentatives
    private ArrayList<ArrayList<String>> controlF; //tableau stockant les résultats de chaque essai au cours d'une partie en mode facile
    private ArrayList<ArrayList<Integer>> controlD; //tableau stockant les résultats de chaque essai au cours d'une partie en mode facile difficile
    private String niveau;
    private int nombreTentative;
    private int tentativeActuelle;
    private int nombrePion;
    private int nombreCouleur;

    /* méthode permettant de faire un 'clear' du terminal */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * Le tableau contient les informations sur les tentatives, les pions et les couleurs utilisées.
     * Il peut être utilisé pour jouer contre l'ordinateur ou contre un autre joueur.
    */
    public Tableau(Boolean multi, Boolean robot, String niveau, int nombreTentative, int nombrePion, int nombreCouleur, Boolean doublon){
        this.tableauTentative = new ArrayList<ArrayList<Pion>>();
        this.controlF = new ArrayList<ArrayList<String>>();
        this.controlD = new ArrayList<ArrayList<Integer>>();
        this.niveau = niveau;
        this.nombreTentative = nombreTentative;
        this.tentativeActuelle = 0;
        this.nombrePion = nombrePion;
        this.nombreCouleur = nombreCouleur;
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

    /* ajouterTentative, methode qui ajoute une tentative au tableau de tentative */
    /**
     * Ajoute une tentative au tableau de tentatives.
     * 
     * @param tentative La liste des pions de la tentative à ajouter.
     */
    public void ajouterTentative(ArrayList<Pion> tentative){
        tableauTentative.add(tentative);
        tentativeActuelle++;
    }

    /**
     * Vérifie si une tentative est correcte. C'est-à-dire qu'elle vérifie si la tentative correspond à la ligne à deviner.
     * 
     * @param tentative La liste des pions de la tentative.
     * @return true si la tentative correspond à la ligne à deviner, sinon false.
     */
    public boolean verifierTentative(ArrayList<Pion> tentative){
        int bienPlace = this.getNombreCorrect(tentative);
        if(bienPlace == nombrePion){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Calcule le nombre de pions correctement placés dans une tentative donnée.
     * 
     * @param tentative la liste des pions de la tentative
     * @return le nombre de pions correctement placés
     */
    public int getNombreCorrect(ArrayList<Pion> tentative){
        int bienPlace = 0;
        for(int i = 0 ; i < nombrePion ; i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                bienPlace++;
            }
        }
        return bienPlace;
    }

    /* Choix fait : si notre ligne à deviner contient un seul pion rouge et que la ligne de 
    tentative en contient 2 dont aucun n'est à la bonne place, on dira que le premier est 
    BC/MP et le deuxième sera considéré comme faux (ni BC, ni BP) */

    /* Cette première fonction fait le controle en facile, elle détaille pour chaque pion s'ils
    ont la bonne couleur, puis s'ils sont bien placés */

    public ArrayList<ArrayList<String>> controleModeFacile(ArrayList<Pion> tentative){
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
        return controlF;
    }

    /* Cette deuxième fonction fait le controle en difficile, elle n'indique que le nombre
    de pion par catégorie (BC/BP & BC/MP) */

    public ArrayList<ArrayList<Integer>> controleModeDifficile(ArrayList<Pion> tentative){
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
        return controlD;
    }

    /**
     * Affiche le tableau de jeu avec les tentatives précédentes et les résultats.
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
                ligne += " BC / MP : " + controlD.get(i-1).get(1);
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

    /**
     * Démarre une partie du jeu.
     * Le joueur doit entrer une série de tentatives jusqu'à ce qu'il gagne ou atteigne le nombre maximum de tentatives.
     * Affiche les messages appropriés en fonction du résultat de chaque tentative.
     */
    public int debutPartie(){
        boolean fin = false;
        System.out.println("Début de la partie !");
        while(!fin){
            System.out.println("Entrez votre tentative : ");
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
            ArrayList<Pion> tentative = new ArrayList<Pion>();
            for(int i=0;i<nombrePion;i++){
                System.out.println("Entrez la couleur du pion " + (i+1) + " : ");
                String reponse = input.next();
                tentative.add(new Pion(Couleur.valueOf(reponse.toUpperCase())));
            }
            ajouterTentative(tentative);
            if(niveau.equalsIgnoreCase("Facile")){
                ArrayList<ArrayList<String>> controlF = controleModeFacile(tableauTentative.get(tentativeActuelle-1));
            }
            else{
                ArrayList<ArrayList<Integer>> controlD = controleModeDifficile(tableauTentative.get(tentativeActuelle-1));
            }
            affichage();
            if(verifierTentative(tentative)){
                System.out.println("Bravo, vous avez gagné !");
                fin = true;
            }
            else if(tentativeActuelle == nombreTentative){
                System.out.println("Désolé, vous avez perdu !");
                fin = true;
            }
        }
        return (nombreTentative-tentativeActuelle); //Nombre de tentative - 1 puisque l'on part de zéro
    }
}