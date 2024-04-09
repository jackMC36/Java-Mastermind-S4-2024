import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Tableau{
    Scanner input = new Scanner(System.in);
    private ArrayList<Pion> ligneDeviner; //tableau stockant la ligne de pion à deviner
    private ArrayList<ArrayList<Pion>> tableauTentative; //tableau stockant les tentatives
    private int nombreTentative;
    private int nombrePion;
    private int tentativeActuelle = 0;
    private int nombreCouleur;

    public Tableau(boolean machine) {

        this.tableauTentative = new ArrayList<ArrayList<Pion>>();

        System.out.println("Bienvenue dans le jeu Mastermind !");

        System.out.println("Combien de tentatives voulez-vous ?(10 ou 12)");
        this.nombreTentative = input.nextInt();
           
        System.out.println("Combien de pions voulez-vous ?(4 ou 5)");
        this.nombrePion = input.nextInt();

        System.out.println("Combien de couleurs voulez-vous ?(6 ou 8)");
        this.nombreCouleur = input.nextInt();

        if(machine){
            this.ligneDeviner = new ArrayList<Pion>();
            for(int i=0;i<nombrePion;i++){
                Random rand = new Random();
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
        }
        else{
            System.out.println("Entrez la ligne à deviner : ");
            this.ligneDeviner = new ArrayList<Pion>();
            for(int i=0;i<nombrePion;i++){
                if(nombreCouleur == 6){
                    System.out.println("Il y a les couleurs suivantes: ROUGE, JAUNE, VERT, BLEU, CYAN, ROSE");
                }
                if(nombreCouleur == 8){
                    System.out.println("Il y a les couleurs suivantes: ROUGE, JAUNE, VERT, BLEU, CYAN, ROSE, VIOLET, BLANC");
                }
                System.out.println("Entrez la couleur du pion " + (i+1) + " : ");
                this.ligneDeviner.add(new Pion(Couleur.valueOf(input.nextLine())));
            }
        }
    }

<<<<<<< HEAD
    /*ajouterTentative, methode qui ajoute une tentative au tableau de tentative */
=======
    //ajouterTentative, methode qui ajoute une tentative au tableau de tentative
>>>>>>> refs/remotes/origin/main
    public void ajouterTentative(ArrayList<Pion> tentative){
        tableauTentative.add(tentative);
        tentativeActuelle++;
    }
<<<<<<< HEAD
    /* verifierTentative, methode qui verifie si la tentative correspond au resultat attendu */
=======
    //verifierTentative, methode qui verifie si la tentative correspond au resultat attendu
>>>>>>> refs/remotes/origin/main
    public boolean verifierTentative(ArrayList<Pion> tentative){
        int bienPlace = this.getNombreCorrect(tentative);
        if(bienPlace == nombrePion){
            return true;
        }
        else{
            return false;
        }
    }

<<<<<<< HEAD
    public int getNombreCorrect(ArrayList<Pion> tentative){
        int bienPlace = 0;
        for(int i=0;i<nombrePion;i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                bienPlace++;
            }
        }
        return bienPlace;
    }

=======
<<<<<<< HEAD
    /* affichage, methode qui affiche le tableau de tentative */
=======
>>>>>>> 3899f6560299f6d6bbd26518a6369a730ac1d9ab
    //affichage, methode qui affiche le tableau de tentative
>>>>>>> refs/remotes/origin/main
    public void affichage(){
        for(int i = 0 ; i < (nombreTentative - tentativeActuelle) ; i++){
                    String ligne = "[";
                    for(int j=0;j<nombrePion;j++){
                        ligne += " * ";
                        if(j!=nombrePion-1){
                            ligne+= " ; ";
                        }                
                    }
                    ligne+="]";
                    System.out.println(ligne);
        }

        for(int i = 0 ; i < tentativeActuelle ; i++){
            String ligne = "[";
            for(int j=0;j<nombrePion;j++){
                ligne += tableauTentative.get(i).get(j).toString();
                if(j!=nombrePion-1){
                    ligne+= " ; ";
                }                
            }
            ligne+="] ";
            ligne+="Bien placé : " + getNombreCorrect(tableauTentative.get(i));
            System.out.println(ligne);
        }
    }

    //debutPartie, methode qui lance une partie
    public void debutPartie(){
        boolean fin = false;
        while(!fin){
            System.out.println("Entrez votre tentative : ");
            ArrayList<Pion> tentative = new ArrayList<Pion>();
            for(int i=0;i<nombrePion;i++){
                if(nombreCouleur == 6){
                    System.out.println("Il y a les couleurs suivantes: ROUGE, JAUNE, VERT, BLEU, CYAN, ROSE");
                }
                if(nombreCouleur == 8){
                    System.out.println("Il y a les couleurs suivantes: ROUGE, JAUNE, VERT, BLEU, CYAN, ROSE, VIOLET, BLANC");
                }
                System.out.println("Entrez la couleur du pion " + (i+1) + " : ");
                tentative.add(new Pion(Couleur.valueOf(input.next())));
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
    }
}