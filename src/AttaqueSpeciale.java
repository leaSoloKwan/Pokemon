public class AttaqueSpeciale extends Attaque{
    //Constructeur
    public AttaqueSpeciale(String nom, String[] typePoke, int puissance, int precision, int repetition) {
        super(nom, typePoke, puissance, precision, repetition);

    }


    //Methodes
    @Override
    public void utiliser(Pokemon attaquant, Pokemon victime) {
        if(this.getRepRestante()!=0) {
            if(this.estCompatible(victime)) {
                if(attaquant.getAttaqueSpe()>=victime.getDefenseSpe()) {
                    if(this.getPrecision()>=Math.round(100 * Math.random())) {
                        victime.estBlesse(this.getPuissance());
                        this.baisseRepetitions();
                    }
                    else {
                        System.out.println("Vous avez loup� le pokemon adverse");
                        this.baisseRepetitions();
                    }

                }else {
                    System.out.println("Ce pokemon est trop fort pour vous.");
                }

            }else {
                if(attaquant.getAttaqueSpe()>=victime.getDefense()) {
                    if(this.getPrecision()>=Math.round(100 * Math.random())) {
                        victime.estBlesse(this.getPuissance());
                        this.baisseRepetitions();
                    }
                    else {
                        System.out.println("Vous avez loup� le pokemon adverse");
                        this.baisseRepetitions();
                    }

                }else {
                    System.out.println("Ce pokemon est trop fort pour vous.");
                }
            }

        }else {
            System.out.println("Il ne vous reste plus de repetition disponible pour cette attaque.");
        }

    }

    @Override
    public boolean estCompatible(Pokemon p) {
        boolean compat;
        int i;
        i=0;
        compat=false;
        while(i<this.getTypePoke().length && compat==false) {
            if(p.getType().equals(this.getTypePoke()[i])){
                compat=true;
            }
            else {
                i=i+1;
            }
        }
        return compat;
    }


    @Override
    public AttaqueSpeciale genAttaque() {
        AttaqueSpeciale a;
        a=this;
        return a;
    }
}
