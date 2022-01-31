public class Gourmandise extends Nourriture{
    private int apportSatisfaction;
    private int apportLoyaute;

    //constructeur
    public Gourmandise(String nom,int freq,int apport,String[] compatibilites,int apportSatisfaction,int apportLoyaute) {
        super(nom,freq,apport,compatibilites);
        this.apportSatisfaction=apportSatisfaction;
        this.apportLoyaute=apportLoyaute;
    }

    //Methodes
    @Override
    public Gourmandise genAlea() {
        if (Math.round(100 * Math.random()) < this.getFreq()) {
            return new Gourmandise(this.getNom(),this.getFreq(),this.getApport(),this.getCompatibilites(),this.apportSatisfaction,this.apportLoyaute);
        }
        else {
            return null;
        }
    }
    @Override
    public void utiliser(Joueur j, int indexPoke) {
        Pokemon mangeur;
        if(indexPoke>0 && indexPoke<j.getPokemons().length) {
            if(j.getPokemons()[indexPoke]!=null) {
                if(estCompatible(j.getPokemons()[indexPoke])) {
                    if(this.getNbRestUse()>0) {
                        mangeur=j.getPokemons()[indexPoke];
                        mangeur.baisseAppetit(this.getApport());
                        mangeur.baisseLoyaute(this.apportLoyaute);
                        mangeur.baisseSatisfaction(this.apportSatisfaction);
                        this.baisserUse(1);
                    }else {
                        System.out.println("Cette nourriture ne peut plus etre utilise");
                    }
                }else {
                    System.out.println("Ce pokemon n'est pas compatible avec cette nourriture.");
                }
            }else {
                System.out.println("Il n'y a pas de pokemon a cet index");
            }
        }else {
            System.out.println("L'index donn� est faux");
        }
    }

    //toString
    @Override
    public String toString() {
        return(super.toString()+"Cette nourriture est une gourmandise qui augmente la loyaute de "+this.apportLoyaute+" et augmente la satisfaction de "+this.apportSatisfaction);
    }
}
