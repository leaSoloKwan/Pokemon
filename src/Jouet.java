public class Jouet extends Item implements Modifiable,Utilisable{
    private int apportAppetit;
    private int apportSatisfaction;
    private int apportLoyaute;

    //Constructeurs
    public Jouet(String nom,int freq,int nbMaxUse,int apportAppetit,int apportSatisfaction,int apportLoyaute) {
        super(nom,freq,nbMaxUse);
        this.apportAppetit=apportAppetit;
        this.apportSatisfaction=apportSatisfaction;
        this.apportLoyaute=apportLoyaute;
    }

    //Methodes
    @Override
    public void utiliser(Joueur j, int indexPoke) {
        if(indexPoke>0 && indexPoke<j.getPokemons().length) {
            if(j.getPokemons()[indexPoke]!=null) {
                if(this.getNbRestUse()>0) {
                    j.getPokemons()[indexPoke].baisseAppetit(this.apportAppetit);
                    j.getPokemons()[indexPoke].monteLoyaute(this.apportLoyaute);
                    j.getPokemons()[indexPoke].monteSatisfaction(this.apportSatisfaction);
                    this.baisserUse(1);
                }else {
                    System.out.println("Ce jouet ne peut plus etre utilise");
                }
            }else {
                System.out.println("Il n'y a pas de pokemon a cet index");
            }
        }else {
            System.out.println("L'index donn� est faux");
        }
    }

    @Override
    public void modifier() {
        this.setNom(this.getNom()+" magique");
        this.apportAppetit=this.apportAppetit+20;
        this.apportLoyaute=this.apportLoyaute+15;
        this.apportSatisfaction=this.apportSatisfaction+10;
        this.setNbRestUse(this.getNbMaxUse());

    }

    @Override
    public Jouet genAlea() {
        if (Math.round(100 * Math.random()) < this.getFreq()) {
            return new Jouet(this.getNom(),this.getFreq(),this.getNbMaxUse(),this.apportAppetit,this.apportSatisfaction,this.apportLoyaute);
        }
        else {
            return null;
        }
    }

    //toString
    public String toString() {
        return("Ce jouet est un(e) "+this.getNom()+" avec une frequence de "+this.getFreq()+", un apport appetit de "+this.apportAppetit+", un apport satisfaction de "+this.apportSatisfaction+", un apport de loyaute de "+this.apportLoyaute+", il reste "+this.getNbRestUse()+"/"+this.getNbMaxUse()+" utilisations.");
    }
}
