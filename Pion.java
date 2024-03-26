public class Pion{
    private Couleur couleur;

    public Pion(Couleur couleur){
        this.couleur = couleur;
    }

    public Couleur getCouleur(){
        return this.couleur;
    }

    public String toString(){
        return Couleur.mapCouleur.get(this.couleur);
    }

    public Boolean equals(Pion pion){
        return this.couleur == pion.couleur;
    }
}