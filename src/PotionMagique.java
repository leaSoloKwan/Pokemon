public class PotionMagique extends Nourriture{
    //constructeurs
    public PotionMagique(String nom,int freq) {
        super(nom,freq,0,new String[] {"tous"});
    }

    //Methodes
    @Override
    public PotionMagique genAlea() {
        if (Math.round(100 * Math.random()) < this.getFreq()) {
            return new PotionMagique(this.getNom(),this.getFreq());
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
                        mangeur.miseANiveau();
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
    public String toString() {
        return(super.toString());
    }
}

