public class Jeu {
    public static void main(String[] args){
        Pion pion1 = new Pion(Couleur.ROUGE);
        Pion pion1b = new Pion(Couleur.ROUGE);
        Pion pion2 = new Pion(Couleur.JAUNE);
        Pion pion3 = new Pion(Couleur.VERT);
        Pion pion4 = new Pion(Couleur.BLEU);
        Pion pion5 = new Pion(Couleur.CYAN);
        Pion pion6 = new Pion(Couleur.ROSE);
        Pion pion7 = new Pion(Couleur.VIOLET);
        Pion pion8 = new Pion(Couleur.BLANC);
        System.out.println(pion1.toString() + (pion2.toString()) + (pion3.toString()) + (pion4.toString()) + (pion5.toString()) + (pion6.toString()) + (pion7.toString()) + (pion8.toString()));
        System.out.println(pion1.equals(pion1b));
        System.out.println(pion1.equals(pion2));
    }
}
