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

    /* méthode permettant de faire un 'clear' du terminal */
    public static void clearScreen(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public Tableau(boolean machine) {

        this.tableauTentative = new ArrayList<ArrayList<Pion>>();

        Tableau.clearScreen();

        System.out.println("Bienvenue dans le jeu Mastermind !");

        System.out.println("Combien de tentatives voulez-vous ? (10 ou 12)");
        this.nombreTentative = input.nextInt();
           
        System.out.println("Combien de pions voulez-vous ? (4 ou 5)");
        this.nombrePion = input.nextInt();

        System.out.println("Combien de couleurs voulez-vous ? (6 à 8)");
        this.nombreCouleur = input.nextInt();

        System.out.println("Voulez vous autorisez les doublons ?(Oui ou Non)");
        String doublon = input.next();

        if(machine){
            this.ligneDeviner = new ArrayList<Pion>();
            ArrayList<Integer> couleurs = new ArrayList<Integer>();
            for(int i=0;i<nombrePion;i++){
                Random rand = new Random();
                if(doublon=="Oui"){
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
            System.out.println("Entrez la ligne à deviner : ");
            ArrayList<String> couleurs = new ArrayList<String>();
            this.ligneDeviner = new ArrayList<Pion>();
            // Pion pion1 = new Pion(Couleur.ROUGE);
            // Pion pion2 = new Pion(Couleur.JAUNE);
            // Pion pion3 = new Pion(Couleur.VERT);
            // Pion pion4 = new Pion(Couleur.BLEU);
            // Pion pion5 = new Pion(Couleur.CYAN);
            // Pion pion6 = new Pion(Couleur.ROSE);
            // Pion pion7 = new Pion(Couleur.VIOLET);
            // Pion pion8 = new Pion(Couleur.BLANC);
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
                while(couleurs.contains(couleur.toUpperCase())){
                    System.out.println("Cette couleur est déjà utilisée, veuillez en choisir une autre : ");
                    couleur = input.next();
                }
                couleurs.add(couleur.toUpperCase());

                this.ligneDeviner.add(new Pion(Couleur.valueOf(couleur.toUpperCase())));
            }
        }
        Tableau.clearScreen();
    }

    /* ajouterTentative, methode qui ajoute une tentative au tableau de tentative */
    public void ajouterTentative(ArrayList<Pion> tentative){
        tableauTentative.add(tentative);
        tentativeActuelle++;
    }

    /* verifierTentative, methode qui verifie si la tentative correspond au resultat attendu */

    public boolean verifierTentative(ArrayList<Pion> tentative){
        int bienPlace = this.getNombreCorrect(tentative);
        if(bienPlace == nombrePion){
            return true;
        }
        else{
            return false;
        }
    }

    /* affichage, methode qui affiche le tableau de tentative */

    public int getNombreCorrect(ArrayList<Pion> tentative){
        int bienPlace = 0;
        for(int i=0;i<nombrePion;i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                bienPlace++;
            }
        }
        return bienPlace;
    }


    /* affichage, methode qui affiche le tableau de tentative */
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
            for(int j=0;j<nombrePion;j++){
                ligne += tableauTentative.get(i-1).get(j).toString();
                if(j!=nombrePion-1){
                    ligne+= " | ";
                }                
            }
            ligne+=" |";
            System.out.print(String.format("%2d ", (i)));
            ligne+=" Bien placé : " + getNombreCorrect(tableauTentative.get(i-1));
            System.out.println(ligne);
            System.out.print("   +");
            for(int e = 0 ; e < nombrePion ; e++){
                System.out.print("-----+");
            }
            System.out.println("\n");
        }
    }

    /* debutPartie, methode qui lance une partie */
    public void debutPartie(){
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