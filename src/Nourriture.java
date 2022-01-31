public class Nourriture extends Item implements Utilisable{
    private int apport;
    private String[] compatibilites;

    //Constructeurs
    public Nourriture(String nom,int freq,int apport,String[] compatibilites) {
        super(nom,freq,1);
        this.apport=apport;
        this.compatibilites=compatibilites;
    }

    //Getters and Setters
    public int getApport() {
        return apport;
    }

    public void setApport(int apport) {
        this.apport = apport;
    }

    public String[] getCompatibilites() {
        return compatibilites;
    }

    public void setCompatibilites(String[] compatibilites) {
        this.compatibilites = compatibilites;
    }

    //Methodes
    public boolean estCompatible(Pokemon p) {
        boolean compat;
        int i;
        i=0;
        compat=false;
        while(i<this.compatibilites.length && compat==false) {
            if(p.getType().equals(this.compatibilites[i]) || this.compatibilites[i].equals("tous")){
                compat=true;
            }
            else {
                i=i+1;
            }
        }
        return compat;
    }
    @Override
    public void utiliser(Joueur j, int indexPoke) {
        Pokemon mangeur;
        if(indexPoke>0 && indexPoke<j.getPokemons().length) {
            if(j.getPokemons()[indexPoke]!=null) {
                if(estCompatible(j.getPokemons()[indexPoke])) {
                    if(this.getNbRestUse()>0) {
                        mangeur=j.getPokemons()[indexPoke];
                        mangeur.baisseAppetit(this.apport);
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


    @Override
    public Nourriture genAlea() {
        if (Math.round(100 * Math.random()) < this.getFreq()) {
            return new Nourriture(this.getNom(),this.getFreq(),this.apport,this.compatibilites);
        }
        else {
            return null;
        }
    }



    //ToString
    @Override
    public String toString() {
        String compatibilites = this.compatibilites[0]; // le String compatibilites met les elements du tableau compatibilites
        // dans un String ou les elements sont mis en ordre.
        for (int i = 1; i < this.compatibilites.length; ++i) {
            compatibilites = compatibilites + ", " + this.compatibilites[i];
        }
        return(super.toString()+", un apport de "+this.apport+", les types compatibles sont : "+compatibilites);
    }
}
