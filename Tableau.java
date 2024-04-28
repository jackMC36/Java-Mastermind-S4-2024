import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

/* Classe Tableau, qui représente le tableau de jeu du Mastermind */
public class Tableau{
    Scanner input = new Scanner(System.in);
    private ArrayList<Pion> ligneDeviner; //tableau stockant la ligne de pion à deviner
    private ArrayList<ArrayList<Pion>> tableauTentative; //tableau stockant les tentatives
    private int nombreTentative;
    private int tentativeActuelle = 0;
    private int nombrePion;
    private int nombreCouleur;

    /* méthode permettant de faire un 'clear' du terminal */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Le tableau contient les informations sur les tentatives, les pions et les couleurs utilisées.
     * Il peut être utilisé pour jouer contre l'ordinateur ou contre un autre joueur.
    */
    
    public Tableau(Boolean multi, Boolean robot, int nombreTentative, int nombrePion, int nombreCouleur, Boolean doublon){
        this.tableauTentative = new ArrayList<ArrayList<Pion>>();
        this.nombreTentative = nombreTentative;
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
            ArrayList<String> couleurs = new ArrayList<String>();
            this.ligneDeviner = new ArrayList<Pion>();
            for(int i = 0 ; i < nombrePion ; i++){
                if(nombreCouleur == 6){
                    System.out.println("Il y a les couleurs suivantes : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                     ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                     ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                     ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                     ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                     ", ROSE" + (new Pion(Couleur.ROSE).toString()));
                }
                if(nombreCouleur == 7){
                    System.out.println("Il y a les couleurs suivantes : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                     ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                     ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                     ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                     ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                     ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                     ", VIOLET" + (new Pion(Couleur.VIOLET).toString()));
                }
                if(nombreCouleur == 8){
                    System.out.println("Il y a les couleurs suivantes : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                     ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                     ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                     ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                     ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                     ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                     ", VIOLET" + (new Pion(Couleur.VIOLET).toString()) +
                                                                     ", BLANC" + (new Pion(Couleur.BLANC).toString()));
                }
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

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

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

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /* verifierTentative, methode qui verifie si la tentative correspond au resultat attendu */

    /**
     * Vérifie si une tentative est correcte.
     * 
     * @param tentative La liste des pions de la tentative.
     * @return true si la tentative est correcte, sinon false.
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

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Calcule le nombre de pions correctement placés dans une tentative donnée.
     * 
     * @param tentative la liste des pions de la tentative
     * @return le nombre de pions correctement placés
     */
    public int getNombreCorrect(ArrayList<Pion> tentative){
        int bienPlace = 0;
        for(int i=0;i<nombrePion;i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                bienPlace++;
            }
        }
        return bienPlace;
    }

/* ---------------------------------------------------------------------------------------------------------------------------------------- */


    /* affichage, methode qui affiche le tableau de tentative */
    /**
     * Affiche le tableau de jeu avec les tentatives précédentes et les résultats.
     */
    public void affichage(){
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
            ligne += " Bien placé : " + getNombreCorrect(tableauTentative.get(i-1));
            System.out.println(ligne);
            System.out.print("   +");
            for(int e = 0 ; e < nombrePion ; e++){
                System.out.print("-----+");
            }
            System.out.println();
        }
        System.out.println();
    }

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /* debutPartie, methode qui lance une partie */
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
            ArrayList<Pion> tentative = new ArrayList<Pion>();
            for(int i=0;i<nombrePion;i++){
                if(nombreCouleur == 6){
                    System.out.println("Il y a les couleurs suivantes : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                     ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                     ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                     ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                     ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                     ", ROSE" + (new Pion(Couleur.ROSE).toString()));
                }
                if(nombreCouleur == 7){
                    System.out.println("Il y a les couleurs suivantes : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                     ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                     ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                     ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                     ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                     ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                     ", VIOLET" + (new Pion(Couleur.VIOLET).toString()));
                }
                if(nombreCouleur == 8){
                    System.out.println("Il y a les couleurs suivantes : ROUGE" + (new Pion(Couleur.ROUGE).toString()) + 
                                                                     ", JAUNE" + (new Pion(Couleur.JAUNE).toString()) +
                                                                     ", VERT" + (new Pion(Couleur.VERT).toString()) +
                                                                     ", BLEU" + (new Pion(Couleur.BLEU).toString()) +
                                                                     ", CYAN" + (new Pion(Couleur.CYAN).toString()) +
                                                                     ", ROSE" + (new Pion(Couleur.ROSE).toString()) +
                                                                     ", VIOLET" + (new Pion(Couleur.VIOLET).toString()) +
                                                                     ", BLANC" + (new Pion(Couleur.BLANC).toString()));
                }
                System.out.println("Entrez la couleur du pion " + (i+1) + " : ");
                String reponse = input.next();
                tentative.add(new Pion(Couleur.valueOf(reponse.toUpperCase())));
            }
            ajouterTentative(tentative);
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
/* ---------------------------------------------------------------------------------------------------------------------------------------- */
}