/**
 * La classe Pion représente un pion utilisé dans le jeu Mastermind.
 * Chaque pion a une couleur associée.
 */

public class Pion{
    /**
     * La couleur du pion.
     */
    private Couleur couleur;

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Constructeur de la classe Pion.
     * @param couleur la couleur du pion.
     */
    public Pion(Couleur couleur){
        this.couleur = couleur;
        }

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Renvoie l'attribut couleur de l'objet Pion.
     *
     * @return La couleur du pion.
     */
    public Couleur getCouleur(){
        return this.couleur;
    }

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet Pion.
     *
     * @return La couleur du pion sous forme de chaîne de caractères.
     */
    public String toString(){
        return Couleur.mapCouleur.get(this.couleur);
    }

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Vérifie si ce pion est égal à un autre pion donné.
     * 
     * @param pion le pion à comparer avec ce pion
     * @return true si les deux pions ont la même couleur, sinon false
     */
    public Boolean equals(Pion pion){
        return this.couleur == pion.couleur;
    }

/* ---------------------------------------------------------------------------------------------------------------------------------------- */

    /* Pour comparer si 2 objets pions ont la même couleur alors que par défaut, la méthode 'equals'
    compare si ils ont la même adresse mémoire */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pion other = (Pion) obj;
        return couleur.equals(other.couleur);
    }
}