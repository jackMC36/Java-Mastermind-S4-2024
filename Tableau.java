import java.util.ArrayList;

public class Tableau{
    private ArrayList<Pion> ligneDeviner; //tableau stockant la ligne de pion à deviner
    private ArrayList<ArrayList<Pion>> tableauTentative; //tableau stockant les tentatives
    private int nombreTentative;
    private int nombrePion;
    private int tentativeActuelle = 0;

    public Tableau(ArrayList<Pion> ligne, int T, int P) {
        this.ligneDeviner = ligne;
        this.tableauTentative = new ArrayList<ArrayList<Pion>>();
        this.nombreTentative = T;
        this.nombrePion = P;
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
        int bienPlace = 0;
        int malPlace = 0;
        for(int i=0;i<nombrePion;i++){
            if(tentative.get(i).equals(ligneDeviner.get(i))){
                bienPlace++;
            }
            else{
                for(int j=0;j<nombrePion;j++){
                    if(tentative.get(i).equals(ligneDeviner.get(j))){
                        malPlace++;
                    }
                }
            }
        }
        if(bienPlace == nombrePion){
            return true;
        }
        else{
            return false;
        }
    }

<<<<<<< HEAD
    /* affichage, methode qui affiche le tableau de tentative */
=======
    //affichage, methode qui affiche le tableau de tentative
>>>>>>> refs/remotes/origin/main
    public void affichage(){
        for(int i=0;i<tentativeActuelle;i++){
            String ligne = "[";
            for(int j=0;j<nombrePion;j++){
                ligne += tableauTentative.get(i).get(j).toString();
                if(j!=nombrePion-1){
                    ligne+= " ; ";
                }                
            }
            ligne+="]";
            System.out.println(ligne);
        }

        for(int i=0;i<nombreTentative-tentativeActuelle;i++){
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
    }
}