import java.util.EnumMap;

/**
 * L'énumérateur Couleur représente les possibilités de couleur pour un pion.
 * 
 * @author Kozik J., Galfré K.
 */

public enum Couleur implements java.io.Serializable{
    ROUGE, JAUNE, VERT, BLEU, CYAN, ROSE, VIOLET, BLANC;

    /**
     * EnumMap permettant de donner une représentation sous forme de chaîne de caractère pour chaque couleur.
     */
    static EnumMap<Couleur, String> mapCouleur = new EnumMap<>(Couleur.class);

    static{
        mapCouleur.put(Couleur.ROUGE, "\033[31m \u0394 \033[0m");
        mapCouleur.put(Couleur.JAUNE, "\033[33m \u0394 \033[0m");
        mapCouleur.put(Couleur.VERT, "\033[32m \u0394 \033[0m");
        mapCouleur.put(Couleur.BLEU, "\033[34m \u0394 \033[0m");
        mapCouleur.put(Couleur.CYAN, "\033[36m \u0394 \033[0m");
        mapCouleur.put(Couleur.ROSE, "\033[38;2;230;40;171m \u0394 \033[0m");
        mapCouleur.put(Couleur.VIOLET, "\033[35m \u0394 \033[0m");
        mapCouleur.put(Couleur.BLANC, "\033[38;2;255;255;255m \u0394 \033[0m");
    }

}
