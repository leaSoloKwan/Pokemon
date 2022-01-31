public class AttaquePhysique extends Attaque{
    public AttaquePhysique(String nom, int puissance, int precision, int repetition) {
        super(nom, puissance, precision, repetition);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void utiliser(Pokemon attaquant, Pokemon victime) {
        if(this.getRepRestante()!=0) {
            if(attaquant.getAttaque()>=victime.getDefense()) {
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
            System.out.println("Il ne vous reste plus de repetition disponible pour cette attaque.");
        }
    }

    @Override
    public boolean estCompatible(Pokemon p) {
        return true;
    }

    @Override
    public AttaquePhysique genAttaque() {
        AttaquePhysique a;
        a=this;
        return a;
    }
}
