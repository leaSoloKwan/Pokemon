public abstract class Attaque {
    //Attributs
    private String nom;
    private String[] typePoke;
    private int puissance;
    private int precision;
    private int repetition;
    private int repRestante;



    //Constructeurs
    public Attaque(String nom, String[] typePoke,int puissance,int precision,int repetition) {
        this.nom=nom;
        this.typePoke=typePoke;
        this.puissance=puissance;
        this.precision=precision;
        this.repetition=repetition;
        this.repRestante=repetition;
    }

    public Attaque(String nom,int puissance,int precision,int repetition) {
        this.nom=nom;
        this.typePoke=new String[] {"tout"};
        this.puissance=puissance;
        this.precision=precision;
        this.repetition=repetition;
        this.repRestante=repetition;
    }

    //Getters And Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String[] getTypePoke() {
        return typePoke;
    }

    public void setTypePoke(String[] typePoke) {
        this.typePoke = typePoke;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public int getRepRestante() {
        return repRestante;
    }

    public void setRepRestante(int repRestante) {
        this.repRestante = repRestante;
    }

    //Méthodes

    public void resetRepetitions() {
        this.repRestante=this.repetition;
    }

    public void baisseRepetitions() {
        this.repRestante=this.repRestante-1;

    }

    public abstract void utiliser(Pokemon attaquant,Pokemon victime);
    public abstract boolean estCompatible(Pokemon p);
    public abstract Attaque genAttaque();

    //toString
    public String toString() {
        String compatibilites = this.typePoke[0]; // le String compatibilites met les elements du tableau compatibilites
        // dans un String ou les elements sont mis en ordre.
        for (int i = 1; i < this.typePoke.length; ++i) {
            compatibilites = compatibilites + ", " + this.typePoke[i];
        }

        return("Cette attaque est "+this.nom+", elle a une puissance de "+this.puissance+", une precision de"+this.precision+", il reste "+this.repRestante+"/"+this.repetition+"repetition(s), compatible avec les types :"+compatibilites);
    }
}
