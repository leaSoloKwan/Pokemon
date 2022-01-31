import java.util.Scanner;

public class Bataille {
    private Pokemon p1;
    private Pokemon p2;
    private Scanner lecteur;
    private boolean batailleFinie;

    public Bataille(Pokemon p1,Pokemon p2) {
        this.p1=p1;
        this.p2=p2;
        this.lecteur=new Scanner(System.in);
        this.batailleFinie=false;
    }

    public void run() {
        while(!batailleFinie) {
            if(p1.sEstEvanoui()||p2.sEstEvanoui()) {
                batailleFinie=true;
            }
            choisirAction(p1, p2);
            if(!p1.sEstEvanoui() && !p2.sEstEvanoui()) {
                choisirAction(p2, p1);
            }

        }
        p1.resetAttaques();
        p2.resetAttaques();
        if(p2.sEstEvanoui()){
            System.out.println(p1.getNom()+" a gagn�");
        }
        if(p1.sEstEvanoui()){
            System.out.println(p2.getNom()+" a gagn�");
        }
    }

    public void choisirAction(Pokemon pokemonActif,Pokemon pokemonPassif) {
        pokemonActif.regarderAttaques();
        System.out.println("Pour : "+pokemonActif.getNom()+"choisissez l'index de l'attaque pour combattre : "+pokemonPassif.getNom());
        int ind=lecteur.nextInt();
        while (ind < 0 || ind > pokemonActif.getSesAttaques().size()) {
            System.out.println("Refaites votre choix. Il doit etre superieur a zero et inferieur a "+pokemonActif.getSesAttaques().size());
            ind = lecteur.nextInt();
        }
        pokemonActif.utiliseAttaque(ind, pokemonPassif);
        if(pokemonPassif.sEstEvanoui()) {
            batailleFinie=true;
            if(pokemonPassif.getMonJoueur()==null && pokemonActif.getMonJoueur()!=null) {
                System.out.println("Voulez vous capturer le pokemon : "+pokemonPassif.getNom()+" Tapez <<oui>> ou <<non>>");
                String reponse=lecteur.next();
                while (!reponse.equals("non") && !reponse.equals("oui")) {
                    System.out.println("Refaites votre choix. Tapez << oui >> ou << non >>");
                    reponse = lecteur.next();
                }
                if(reponse.equals("oui")) {
                    pokemonActif.getMonJoueur().capturer(pokemonPassif);
                }


            }
        }
    }
}
