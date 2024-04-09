import java.util.ArrayList;

public class Jeu {
    public static void main(String[] args){
        ArrayList<Pion> ligne = new ArrayList<Pion>();
        Pion pion1 = new Pion(Couleur.ROUGE);
        Pion pion1b = new Pion(Couleur.ROUGE);
        Pion pion2 = new Pion(Couleur.JAUNE);
        Pion pion3 = new Pion(Couleur.VERT);
        Pion pion4 = new Pion(Couleur.BLEU);
        ligne.add(pion1);
        ligne.add(pion2);
        ligne.add(pion3);
        ligne.add(pion4);

        ArrayList<Pion> add = new ArrayList<Pion>();
        Pion pion5 = new Pion(Couleur.CYAN);
        Pion pion6 = new Pion(Couleur.ROSE);
        Pion pion7 = new Pion(Couleur.VIOLET);
        Pion pion8 = new Pion(Couleur.BLANC);
        add.add(pion5);
        add.add(pion6);
        add.add(pion7);
        add.add(pion8);
        Tableau T = new Tableau(ligne, 10, 4);
        T.ajouterTentative(add);
        T.affichage();
        System.out.println(pion1.toString() + (pion2.toString()) + (pion3.toString()) + (pion4.toString()) + (pion5.toString()) + (pion6.toString()) + (pion7.toString()) + (pion8.toString()));
        System.out.println(pion1.equals(pion1b));
        System.out.println(pion1.equals(pion2));
    }
}
