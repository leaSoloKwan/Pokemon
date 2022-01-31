public abstract class Item {
    private String nom;
    private int freq;
    private int nbMaxUse;
    private int nbRestUse;

    //Constructeur
    public Item(String nom,int freq,int nbMaxUse) {
        this.nom=nom;
        this.freq=freq;
        this.nbMaxUse=nbMaxUse;
        this.nbRestUse=nbMaxUse;
    }

    //Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getNbMaxUse() {
        return nbMaxUse;
    }

    public void setNbMaxUse(int nbMaxUse) {
        this.nbMaxUse = nbMaxUse;
    }

    public int getNbRestUse() {
        return nbRestUse;
    }

    public void setNbRestUse(int nbRestUse) {
        this.nbRestUse = nbRestUse;
    }


    //Methodes

    public void baisserUse(int difference) {
        this.nbRestUse=this.nbRestUse-difference;
    }

    public void monterUse(int difference) {
        this.nbRestUse=this.nbRestUse+difference;
    }

    public void resetUse() {
        this.nbRestUse=this.nbMaxUse;
    }
    public boolean seraGenere() {
        return(Math.round(100*Math.random())<this.freq);
    }

    //Methodes abstraites

    public abstract Item genAlea();

    //toString
    public String toString() {
        return("Cet item est un(e) "+this.nom+" avec une frequence de "+this.freq+", il reste "+this.nbRestUse+"/"+this.nbMaxUse+" utilisation(s)");
    }
}
