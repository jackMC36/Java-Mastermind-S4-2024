/**
 * La classe Pion représente un pion utilisé dans le jeu Mastermind.
 * Chaque pion a une couleur associée. Cette couleur est un objet définie par la classe {@link Couleur.java}.
 * 
 * @author Kozik J., Galfré K.
 */

public class Pion{
    /**
     * La couleur du pion.
     */
    private Couleur couleur;

    /**
     * Constructeur de la classe Pion.
     * 
     * @param couleur un objet Couleur qui représente la couleur du pion.
     */
    public Pion(Couleur couleur){
        this.couleur = couleur;
        }

    /**
     * Getteur permettant de récupérer la valeur de l'attribut couleur de l'objet Pion.
     *
     * @return La couleur du pion.
     */
    public Couleur getCouleur(){
        return this.couleur;
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet Pion.
     *
     * @return Une représentation du pion sous forme de chaîne de caractères.
     */
    public String toString(){
        return Couleur.mapCouleur.get(this.couleur);
    }

    /**
     * Vérifie si ce pion est égal à un autre pion donné.
     * Cette méthode compare si la couleur de 2 pions est identique
     * 
     * @param obj l'objet (ici, un pion) à comparer avec ce pion
     * @return true si les deux pions ont la même couleur, false sinon
     */
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