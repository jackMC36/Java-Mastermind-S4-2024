import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Jeu représente le moteur de jeu pour le Mastermind.
 * Elle permet de démarrer une nouvelle partie et gérer le déroulement du jeu.
 */
public class Jeu {
    /**
     * Démarre une nouvelle partie du jeu.
     * Cette méthode gère le déroulement d'une partie du jeu de Mastermind (saisie des tentatives par l'utilisateur, vérification des tentatives et affichage du plateau de jeu).
     * Elle s'arrête lorsque le joueur découvre la bonne combinaison de pion ou lorsque le nombre maximum de tentative est atteint.
     * 
     * @param init l'objet Initialisation contenant les paramètres généraux de la partie.
     * @param plateau le plateau de jeu utilisé pour stocker les tentatives et les résultats.
     * @return le nombre de tentatives restantes à la fin de la partie.
     */
    public static int partie(Initialisation init, Tableau plateau){
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
    public static void affichage(int nbJoueur, ArrayList<String> prenom){
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
    public static void affichage2(int nbJoueur, ArrayList<Integer> score, ArrayList<String> prenom){
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
     * Lance une partie en mode multijoueur.
     * Cette méthode permet à plusieurs joueurs de jouer tour à tour et affiche les scores à la fin de toutes les parties.
     * 
     * @param init l'objet Initialisation contenant les paramètres généraux de la partie.
     */
    public static void multi(Initialisation init){
        Scanner input = new Scanner(System.in);
        System.out.println("Nombre de joueur ?");
        int nbJoueur = input.nextInt();
        while(nbJoueur < 2){
            System.out.println("ATTENTION, LE NOMBRE DE JOUEUR DOIT ÊTRE SUPÉRIEUR OU ÉGALE À 2");
            System.out.println("Nombre de joueur ?");
            nbJoueur = input.nextInt();
        }
        ArrayList<String> prenom = new ArrayList<String>();
        ArrayList<Integer> score = new ArrayList<Integer>();
        for(int i = 0 ; i < nbJoueur ; i++){
            System.out.println("Joueur " + (i+1) +" : quel est votre nom ?");
            prenom.add(input.next());
            score.add(0); //On initialise tout les scores à 0
        }
        System.out.print("Saisissez le nombre de partie par joueur à réaliser : ");
        int nbPartie = input.nextInt();
        input.nextLine();
        for(int i = 0 ; i < (nbPartie * nbJoueur) ; i ++){
            Tableau.clearScreen();
            System.out.println("Partie " + (i+1) + "/" + (nbPartie * nbJoueur));
            System.out.println("A vous de jouer " + prenom.get(i%prenom.size()));
            Tableau plateauJeu = new Tableau(init.getMulti(), init.getRobot(), init.getNiveau(), init.getNbTentative(), init.getNbPion(), init.getNbCouleur(), init.getDoublon());
            int tentativeRestante = Jeu.partie(init, plateauJeu);
            score.set((i%prenom.size()), (score.get(i%prenom.size()) + tentativeRestante));
            System.out.print("\nAppuyer sur la touche Entrée pour continuer ..."); //Cette ligne et celle d'après permettent de bloquer l'exécution du programme jusqu'à que le joueur appui sur une touche du clavier
            input.nextLine();
        }
        Tableau.clearScreen();
        System.out.println("Fin de la partie ! Félicitations à vous !\n");
        System.out.println("TABLEAU DES SCORES");
        Jeu.affichage(nbJoueur, prenom);
        Jeu.affichage2(nbJoueur, score, prenom);
        int gagnant = 0;
        Boolean execo = false;
        for(int i = 1 ; i < nbJoueur ; i++){
            if(score.get(i) > score.get(gagnant)){
                gagnant = i;
                execo = false;
            }
            else if(score.get(i) == score.get(gagnant)){
                execo = true;
            }
        }
        if(execo == true){
            System.out.println("Execo ! Réessayez !");
        }
        else{
            System.out.println("Félicitation au gagnant : " + prenom.get(gagnant));
        }
        input.close();
    }

    /**
     * Méthode principale permettant d'éxécuter le programme.
     * Elle initialise les paramètres généraux de jeu et lance une partie en mode solo ou multijoueur.
     * 
     * @param args les arguments de la ligne de commande (non utilisés pour notre programme de Mastermind)
     */
    public static void main(String[] args){
        Initialisation init = new Initialisation();
        if(init.getMulti() == true){
            Jeu.multi(init);
        }
        else{
            Tableau plateau = new Tableau(init.getMulti(), init.getRobot(), init.getNiveau(), init.getNbTentative(), init.getNbPion(), init.getNbCouleur(), init.getDoublon());
            Jeu.partie(init, plateau); 
        }    
    }
}
