public class Outil extends Item implements ChangeItems{
    //Constructeur
    public Outil(String nom,int freq,int nbMaxUse) {
        super(nom,freq,nbMaxUse);
    }

    //Methodes
    @Override
    public void utiliser(Modifiable item) {
        if(this.getNbRestUse()>0) {
            item.modifier();
            this.baisserUse(1);
        }
        else {
            System.out.println(" Il ne vous reste plus d'utilisation pour cet outil.");
        }

    }

    @Override
    public Outil genAlea() {
        if (Math.round(100 * Math.random()) < this.getFreq()) {
            return new Outil(this.getNom(),this.getFreq(),this.getNbMaxUse());
        }
        else {
            return null;
        }
    }
}
