public class Pion{
    private Couleur couleur;

    public Pion(Couleur couleur){
        this.couleur = couleur;
    }

    public Couleur getCouleur(){
        return this.couleur;
    }

    public String toString(){
        switch (couleur) {
            case ROUGE:
                return "\033[31m \u0394 \033[0m";
            case JAUNE:
                return "\033[33m \u0394 \033[0m";
            case VERT:
                return "\033[32m \u0394 \033[0m";
            case BLEU:
                return "\033[34m \u0394 \033[0m";
            case CYAN:
                return "\033[36m \u0394 \033[0m";
            case ROSE:
                return "\033[38;2;230;40;171m \u0394 \033[0m";    
            case VIOLET:
                return "\033[35m \u0394 \033[0m";
            case BLANC:
                return "\033[38;2;255;255;255m \u0394 \033[0m";
            default:
                return "\u0394";
        }
        //return "\u0394";
    }
}