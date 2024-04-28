import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {

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
            Tableau plateauJeu = new Tableau(init.getMulti(), init.getRobot(), init.getNbTentative(), init.getNbPion(), init.getNbCouleur(), init.getDoublon());
            int tentativeRestante = plateauJeu.debutPartie();
            score.set((i%prenom.size()), (score.get(i%prenom.size()) + tentativeRestante));
            System.out.println("\nAppuyer sur n'importe quelle touche pour continuer ..."); //Cette ligne et celle d'après permettent de bloquer l'exécution du programme jusqu'à que le joueur appui sur une touche du clavier
            input.nextLine();
        }
        Tableau.clearScreen();
        System.out.println("Fin de la partie ! Félicitations à vous !\n");
        System.out.println("TABLEAU DES SCORES");
        Jeu.affichage(nbJoueur, prenom); //Voir si je peut accéder à la fonction d'affichage de la méthode Tableau, sinon, la copier-coller dans cet objet
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

    public static void main(String[] args){

        Initialisation init = new Initialisation();
        if(init.getMulti() == true){
            Jeu.multi(init);
        }
        else{
            Tableau plateau = new Tableau(init.getMulti(), init.getRobot(), init.getNbTentative(), init.getNbPion(), init.getNbCouleur(), init.getDoublon());
            plateau.debutPartie(); 
        }
        
    }
}
