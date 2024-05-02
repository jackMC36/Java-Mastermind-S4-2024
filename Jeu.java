import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Jeu représente le moteur de jeu pour le Mastermind.
 * Elle gère l'initialisation et le déroulement du jeu.
 */
public class Jeu {
    /**
     * L'objet Initialisation contenant les paramètres de la partie.
     */
    private Initialisation init;

    /**
     * L'objet Tableau utilisé pour gérer le plateau de jeu (ajouter et stocker les tentatives) et stocker la ligne à deviner.
     */
    private Tableau plateau;

    /**
     * Constructeur de la classe Jeu.
     * Initialise et lance le jeu.
     */
    public Jeu(){
        init = new Initialisation();
        lancementJeu();
    }

    /**
     * Méthode permettant de lancer le jeu en fonction du mode choisi.
     * Si le mode multijoueur est activé, lance le mode multijoueur, sinon lance une partie solo.
     */
    public void lancementJeu(){
        if(init.getMulti() == true){
            this.multi();
        }
        else{
            plateau = new Tableau(init.getMulti(), init.getRobot(), init.getNiveau(), init.getNbTentative(), init.getNbPion(), init.getNbCouleur(), init.getDoublon());
            this.partie(); 
        } 
    }

    /**
     * Démarre une nouvelle partie du jeu.
     * Cette méthode gère le déroulement d'une partie du jeu de Mastermind (saisie des tentatives par l'utilisateur, vérification des tentatives et affichage du plateau de jeu).
     * Elle s'arrête lorsque le joueur découvre la bonne combinaison de pion ou lorsque le nombre maximum de tentative est atteint.
     * 
     * @return le nombre de tentatives restantes à la fin de la partie.
     */
    public int partie(){
        Scanner scanner = new Scanner(System.in);
        boolean fin = false;
        System.out.println("Début de la partie !");
        while(!fin){
            System.out.println("Entrez votre tentative : ");
            if(init.getNbCouleur() == 6){
                System.out.println("Voici les couleurs possibles : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                    ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                    ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                    ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                    ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                    ", ROSE" + (new Pion(Couleur.ROSE).toString()));
            }
            if(init.getNbCouleur() == 7){
                System.out.println("Voici les couleurs possibles : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                    ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                    ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                    ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                    ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                    ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                    ", VIOLET" + (new Pion(Couleur.VIOLET).toString()));
            }
            if(init.getNbCouleur() == 8){
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
            for(int i = 0 ; i < init.getNbPion() ; i++){
                System.out.println("Entrez la couleur du pion " + (i+1) + " : ");
                String reponse = scanner.next();
                tentative.add(new Pion(Couleur.valueOf(reponse.toUpperCase())));
            }
            plateau.ajouterTentative(tentative);
            if(init.getNiveau().equalsIgnoreCase("Facile")){
                plateau.controleModeFacile(plateau.getTabTentative().get(plateau.getTentativeActuelle()-1));
            }
            else{
                plateau.controleModeDifficile(plateau.getTabTentative().get(plateau.getTentativeActuelle()-1));
            }
            plateau.affichage();
            if(plateau.verifierTentative(tentative)){
                System.out.println("Bravo, vous avez gagné !");
                fin = true;
            }
            else if(plateau.getTentativeActuelle() == init.getNbTentative()){
                System.out.println("Désolé, vous avez perdu !");
                fin = true;
            }
        }
        return (init.getNbTentative()-plateau.getTentativeActuelle());
    }

    /**
     * Affiche la liste des prénoms des joueurs.
     * En mode multijoueur, cette fonction permet d'afficher, à la fin de la partie, la liste des prénoms de tout les joueurs (pour afficher les résultats de chacun).
     * 
     * @param nbJoueur le nombre de joueurs.
     * @param prenom la liste des prénoms des joueurs.
     */
    public void affichage(int nbJoueur, ArrayList<String> prenom){
        System.out.print("+");
        for(int e = 0 ; e < nbJoueur ; e++){
            for(int i = 0 ; i < (prenom.get(e).length() + 2) ; i++){
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
        String ligne = "| ";
        for(int j = 0 ; j < nbJoueur ; j++){
            ligne += prenom.get(j);
            ligne += " | ";                
        }
        System.out.println(ligne);
        System.out.print("+");
        for(int e = 0 ; e < nbJoueur ; e++){
            for(int i = 0 ; i < (prenom.get(e).length() + 2) ; i++){
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    /**
     * Affiche la liste des scores des joueurs.
     * En mode multijoueur, cette fonction permet d'afficher, à la fin de la partie, la liste des scores de tout les joueurs (en dessous de celle des prénoms).
     * 
     * @param nbJoueur le nombre de joueurs.
     * @param score la liste des scores des joueurs.
     * @param prenom la liste des prénoms des joueurs.
     */
    public void affichage2(int nbJoueur, ArrayList<Integer> score, ArrayList<String> prenom){
        System.out.print("+");
        for(int e = 0 ; e < nbJoueur ; e++){
            for(int i = 0 ; i < (prenom.get(e).length() + 2) ; i++){
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();
        String ligne = "| ";
        for(int j = 0 ; j < nbJoueur ; j++){
            ligne += score.get(j);
            for(int i = 0 ; i < (prenom.get(j).length() - String.valueOf(score.get(j)).length()) ; i++){
                ligne += " ";
            }
            ligne += " | ";              
        }
        System.out.println(ligne);
        System.out.print("+");
        for(int e = 0 ; e < nbJoueur ; e++){
            for(int i = 0 ; i < (prenom.get(e).length() + 2) ; i++){
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println("\n");
    }

    /**
     * Gère le mode multijoueur.
     * Cette méthode permet à plusieurs joueurs de jouer tour à tour en lançant plusieurs parties et affiche les scores à la fin de toutes les parties.
     * 
     * @param init l'objet Initialisation contenant les paramètres généraux de la partie.
     */
    public void multi(){
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < (init.getNbPartie() * init.getNbJoueur()) ; i ++){
            Tableau.clearScreen();
            System.out.println("Partie " + (i+1) + "/" + (init.getNbPartie() * init.getNbJoueur()));
            System.out.println("A vous de jouer " + init.getPrenom().get(i%init.getPrenom().size()));
            plateau = new Tableau(init.getMulti(), init.getRobot(), init.getNiveau(), init.getNbTentative(), init.getNbPion(), init.getNbCouleur(), init.getDoublon());
            int tentativeRestante = this.partie();
            init.getScore().set((i%init.getPrenom().size()), (init.getScore().get(i%init.getPrenom().size()) + tentativeRestante));
            System.out.print("\nAppuyer sur la touche Entrée pour continuer ..."); //Cette ligne et celle d'après permettent de bloquer l'exécution du programme jusqu'à que le joueur appui sur une touche du clavier
            input.nextLine();
        }
        Tableau.clearScreen();
        System.out.println("Fin de la partie ! Félicitations à vous !\n");
        System.out.println("TABLEAU DES SCORES");
        this.affichage(init.getNbJoueur(), init.getPrenom());
        this.affichage2(init.getNbJoueur(), init.getScore(), init.getPrenom());
        int gagnant = 0;
        Boolean execo = false;
        for(int i = 1 ; i < init.getNbJoueur() ; i++){
            if(init.getScore().get(i) > init.getScore().get(gagnant)){
                gagnant = i;
                execo = false;
            }
            else if(init.getScore().get(i) == init.getScore().get(gagnant)){
                execo = true;
            }
        }
        if(execo == true){
            System.out.println("Execo ! Réessayez !");
        }
        else{
            System.out.println("Félicitation au gagnant : " + init.getPrenom().get(gagnant));
        }
        input.close();
    }
}
