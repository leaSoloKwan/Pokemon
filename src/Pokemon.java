import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String nom;
    private String type;
    private int niveau;
    private boolean diurne;
    private String nomDonne;
    private Joueur monJoueur;
    private int appetit;
    private int satisfaction;
    private int loyaute;
    private int attaque;
    private int defense;
    private int attaqueSpe;
    private int defenseSpe;
    private int frequence; // probabilit� de rencontrer un pokemon de ce type
    private int HP;
    private ArrayList<Attaque> sesAttaques = new ArrayList<>();

    private int numeroPokedex;

    //Constructeurs
    public Pokemon(int numeroPokedex,String Nom, String Type, int Niveau, boolean Diurne,String nomDonne,Joueur monJoueur,int attaque,int defense,int attaqueSpe,int defenseSpe,int frequence,Attaque[] sesAttaques){
        this.numeroPokedex=numeroPokedex;
        this.nom=Nom;
        this.type=Type;
        this.niveau=Niveau;
        this.diurne=Diurne;
        this.nomDonne=nomDonne;
        this.monJoueur=monJoueur;
        this.appetit=50;
        this.satisfaction=50;
        this.loyaute=0;
        this.attaque=attaque;
        this.defense=defense;
        this.attaqueSpe=attaqueSpe;
        this.defenseSpe=defenseSpe;
        this.frequence=frequence;
        this.HP=30;
        this.sesAttaques=new ArrayList<Attaque>();
        for(int i=0;i<4;i++) {
            if(sesAttaques[i]!=null) {
                this.sesAttaques.add(sesAttaques[i]);
            }
        }

    }
    public Pokemon(int numeroPokedex,String Nom, String Type, int Niveau, boolean Diurne,int attaque,int defense,int attaqueSpe,int defenseSpe,int frequence,ArrayList<Attaque> arrayList){
        this.numeroPokedex=numeroPokedex;
        this.nom=Nom;
        this.type=Type;
        this.niveau=Niveau;
        this.diurne=Diurne;
        this.nomDonne=null;
        this.monJoueur=null;
        this.appetit=50;
        this.satisfaction=50;
        this.loyaute=0;
        this.attaque=attaque;
        this.defense=defense;
        this.attaqueSpe=attaqueSpe;
        this.defenseSpe=defenseSpe;
        this.frequence=frequence;
        this.HP=30;
        this.sesAttaques=new ArrayList<Attaque>();
        int length = 4;
        if (arrayList.size() > 4) {
            System.out.println("Vous avez mis une liste trop longue d'attaques; je ne prendrai en compte que les premiers 4.");
        }
        else {
            length = arrayList.size();
        }

        for (int i = 0; i < length; i++) {
            this.sesAttaques.add(arrayList.get(i));
        }
    }
    public Pokemon(int numeroPokedex,String Nom, String Type, int Niveau, boolean Diurne,int appetit,int attaque,int defense,int attaqueSpe,int defenseSpe,int frequence,Attaque[] sesAttaques){
        this.numeroPokedex=numeroPokedex;
        this.nom=Nom;
        this.type=Type;
        this.niveau=Niveau;
        this.diurne=Diurne;
        this.nomDonne=null;
        this.monJoueur=null;
        this.appetit=appetit;
        this.satisfaction=50;
        this.loyaute=0;
        this.attaque=attaque;
        this.defense=defense;
        this.attaqueSpe=attaqueSpe;
        this.defenseSpe=defenseSpe;
        this.frequence=frequence;
        this.HP=30;
        this.sesAttaques=new ArrayList<Attaque>();
        int length = 4;
        if (sesAttaques.length > 4) {
            System.out.println("Vous avez mis une liste trop longue d'attaques; je ne prendrai en compte que les premiers 4.");
        }
        else {
            length = sesAttaques.length;
        }

        for (int i = 0; i < length; i++) {
            this.sesAttaques.add(sesAttaques[i]);
        }
    }

    public Pokemon(int numeroPokedex,String nom, String type, int niveau, boolean diurne,
                   String nomDonne, Joueur monJoueur, int attaque, int defense,
                   int attaqueSpeciale, int defenseSpeciale, Attaque[] sesAttaques) {
        this.numeroPokedex=numeroPokedex;
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
        this.diurne = diurne;

        // TP 2
        this.nomDonne = nomDonne;
        this.monJoueur = monJoueur;

        // TP 3
        this.appetit = 50;
        this.satisfaction = 50;
        this.loyaute = 0;

        // TP 6

        this.attaque = attaque;
        this.defense = defense;
        this.attaqueSpe = attaqueSpeciale;
        this.defenseSpe= defenseSpeciale;
        this.HP = 30;
        int length = 4;
        if (sesAttaques.length > 4) {
            System.out.println("Vous avez mis une liste trop longue d'attaques; je ne prendrai en compte que les premiers 4.");
        }
        else {
            length = sesAttaques.length;
        }

        for (int i = 0; i < length; i++) {
            this.sesAttaques.add(sesAttaques[i]);
        }
    }


	/*
	public Pokemon(String name, String type2, int niveau2, boolean diurne2, int attaque2, int defense2,
			int attaqueSpeciale, int defenseSpeciale, Attaque[] sesAttaquesTableau) {
		this.nom=name;
		this.type=type2;
		this.niveau=niveau2;
		this.diurne=diurne2;
		this.attaque=attaque2;
		this.defense=defense2;
		this.attaqueSpe=attaqueSpeciale;
		this.defenseSpe=defenseSpeciale;
		this.sesAttaques=sesAttaquesTableau;
	}
	*/


    public Pokemon(Integer integer, String name, String type2, int niveau2, boolean diurne2, int attaque2, int defense2,
                   int attaqueSpeciale, int defenseSpeciale, ArrayList<Attaque> sesAttaquesTableau) {
        this.numeroPokedex=integer;
        this.nom=name;
        this.type=type2;
        this.niveau=niveau2;
        this.diurne=diurne2;
        this.attaque=attaque2;
        this.defense=defense2;
        this.attaqueSpe=attaqueSpeciale;
        this.defenseSpe=defenseSpeciale;
        this.sesAttaques=sesAttaquesTableau;

    }

    //Getters et Setters
    public String getNom() {
        return this.nom;
    }
    public int getNumeroPokedex() {
        return numeroPokedex;
    }
    public String getType() {
        return this.type;
    }
    public int getNiveau() {
        return this.niveau;
    }
    public String getNomDonne(){
        return(this.nomDonne);
    }

    public Joueur getMonJoueur() {
        return(this.monJoueur);
    }

    public void setNomDonne(String nvNom) {
        if(null==this.nomDonne) {
            this.monteLoyaute(10);
        }
        else {
            this.baisseLoyaute(10);
        }
        this.nomDonne=nvNom;
    }

    public void setMonJoueur(Joueur nvJoueur) {
        this.monJoueur=nvJoueur;
    }

    public int getAppetit() {
        return(this.appetit);
    }
    public int getSatisfaction() {
        return(this.satisfaction);
    }
    public int getLoyaute() {
        return(this.loyaute);
    }
    public void setAppetit(int x) {
        this.appetit=x;
    }
    public void setSatisfaction(int x) {
        this.satisfaction=x;
    }
    public void setLoyaute(int x) {
        this.loyaute=x;
    }



    public boolean isDiurne() {
        return diurne;
    }
    public void setDiurne(boolean diurne) {
        this.diurne = diurne;
    }
    public int getAttaque() {
        return attaque;
    }
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getAttaqueSpe() {
        return attaqueSpe;
    }
    public void setAttaqueSpe(int attaqueSpe) {
        this.attaqueSpe = attaqueSpe;
    }
    public int getDefenseSpe() {
        return defenseSpe;
    }
    public void setDefenseSpe(int defenseSpe) {
        this.defenseSpe = defenseSpe;
    }
    public int getFrequence() {
        return frequence;
    }
    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int hP) {
        HP = hP;
    }
    public List<Attaque> getSesAttaques() {
        return sesAttaques;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    //Methodes
    public void direBonjour(String periode){
        if ("jour".equals(periode)){
            if(this.diurne){
                System.out.println(this.nom+" dit bonjour ! ");
            }
            else{
                System.out.println(this.nom+" : zzzzzzzzzzz");
            }
        }
        else{
            if(this.diurne){
                System.out.println(this.nom+" : zzzzzzzzzzz");
            }
            else{
                System.out.println(this.nom+" dit bonsoir ! ");
            }

        }
    }


    public void estCapture() {
        this.loyaute=0;
        if(this.satisfaction>10) {
            this.satisfaction=10;
        }
        if(this.appetit>10) {
            this.appetit=10;
        }
    }

    public void estLibere() {
        if(this.loyaute>10) {
            this.baisseSatisfaction(this.loyaute-10);
        }
        this.loyaute=0;
    }
    public void baisseAppetit(int difference) {
        this.appetit=this.appetit-difference;
        if(this.appetit<0) {
            this.appetit=0;
        }
    }
    public void monteAppetit(int difference) {
        this.appetit=this.appetit+difference;
        if(this.appetit>100) {
            this.appetit=100;
        }
    }
    public void baisseSatisfaction(int difference) {
        this.satisfaction=this.satisfaction-difference;
        if(this.satisfaction<0) {
            this.satisfaction=0;
        }
    }
    public void monteSatisfaction(int difference) {
        this.satisfaction=this.satisfaction+difference;
        if(this.satisfaction>100) {
            this.satisfaction=100;
        }
    }
    public void baisseLoyaute(int difference) {
        this.loyaute = this.loyaute - difference;
        if (this.loyaute < 0) {
            this.loyaute = 0;
        }
    }
    public void monteLoyaute(int difference) {
        this.loyaute = this.loyaute + difference;
        if (this.loyaute > 100) {
            this.loyaute = 100;
        }
    }

    public void utiliser(Utilisable itemUtilisable) {
        if(this.monJoueur!=null) {
            itemUtilisable.utiliser(this.monJoueur, this.getIndex());
        }
    }

    public void miseANiveau() {
        this.niveau=this.niveau+1;
    }

    public String statPoke(){
        return("Le pokemon "+this.nom+" a un appetit de "+this.appetit+", une satisfaction de "+this.satisfaction+" et une loyaute de "+this.loyaute);
    }

    public void addAttaque(Attaque a) {
        int i=0;
        if(a.estCompatible(this)) {
            while(this.sesAttaques.get(i)!=null && i<4) {
                i=i+1;
            }
            if(this.sesAttaques==null) {
                this.sesAttaques.add(i, a);
            }
            else {
                System.out.println(" Votre pokemon a deja 4 attaques.");
            }
        }
        else {
            System.out.println("Votre pokemon n'est pas compatible avec cette attaque.");
        }
    }

    public void removeAttaque(int index) {
        if(index>=0 && index<4) {
            this.sesAttaques.add(index, null);
        }
        else {
            System.out.println("Votre index est faux.");
        }
    }

    public void regarderAttaques() {
        int i=0;
        while(i<4) {
            if(this.sesAttaques.get(i)!=null) {
                System.out.println(" Cette attaque est a la position "+(i+1)+", il reste "+this.sesAttaques.get(i).getRepRestante()+" repetitions pour cette attaque.");
            }
            i=i+1;
        }
    }

    public void resetAttaques() {
        int i=0;
        while(i<4) {
            if(this.sesAttaques.get(i)!=null) {
                this.sesAttaques.get(i).resetRepetitions();
            }
            i=i+1;
        }
    }

    public boolean sEstEvanoui() {
        return this.HP==0;
    }

    public void estBlesse(int dommage) {
        this.HP=this.HP-dommage;
        if(this.HP<0) {
            this.HP=0;
        }
        System.out.println(this.getNom()+" a encore : "+this.HP+" HP.");
    }
    public void utiliseAttaque(int index,Pokemon victime) {
        if(!this.sEstEvanoui() && !victime.sEstEvanoui() && index>=0 && index<4 && this.sesAttaques.get(index)!=null) {
            this.sesAttaques.get(index).utiliser(this, victime);
        }
    }

    private int getIndex() {
        int i=0;
        if(this.monJoueur!=null) {
            while(this.monJoueur.getPokemons()[i]!=this || i<this.monJoueur.getPokemons().length) {
                i=i+1;
            }
            return i;
        }else {
            return -1;
        }
    }

    public Pokemon dupliquer() {
        return this;
    }

    public Pokemon genAlea() {
        if (Math.round(100 * Math.random()) < this.getNiveau()/100) {
            return this;
        }
        else {
            return null;
        }
    }
    //toString
    public String toString(){
        String attaques = this.sesAttaques.get(0).getNom();
        // dans un String ou les elements sont mis en ordre.
        for (int i = 1; i < this.sesAttaques.size(); ++i) {
            attaques = attaques + ", " + this.sesAttaques.get(i).getNom();
        }
        if(monJoueur!=null) {
            if(nomDonne!=null) {
                return(this.nomDonne+" est un pokemon de genre "+this.nom+", du type "+this.type+", qui a le niveau "+this.niveau+" ce pokemon appartient � "+monJoueur.getNom()+" "+
                        monJoueur.getPrenom()+". Il/Elle a un appetit de "+this.appetit+", un niveau de satisfaction de "+this.satisfaction+" et une loyaute aupres de son maitre de "+this.loyaute+
                        ". Ses points d'attaque sont de :"+this.attaque+", ses points de defense sont de : "+this.defense+", ses point d'attaques sp�ciales sont de : "+this.attaqueSpe+", ses points de defense spe sont de : "+
                        this.defenseSpe+". La probabilite de rencontrer un pokemon de ce type est de "+this.frequence+". HP= "+this.HP+". Ses attaques sont : "+attaques);
            }
            else {
                return("Un pokemon de genre "+this.nom+", du type "+this.type+", qui a le niveau "+this.niveau+" ce pokemon appartient � "+monJoueur.getNom()+" "+monJoueur.getPrenom()+
                        ". Il/Elle a un appetit de "+this.appetit+", un niveau de satisfaction de "+this.satisfaction+" et une loyaute aupres de son maitre de "+this.loyaute+". Ses points d'attaque sont de :"+this.attaque+", ses points de defense sont de : "+
                        this.defense+", ses point d'attaques sp�ciales sont de : "+this.attaqueSpe+", ses points de defense spe sont de : "+
                        this.defenseSpe+". La probabilite de rencontrer un pokemon de ce type est de "+this.frequence+". HP= "+this.HP+". Ses attaques sont : "+attaques);
            }
        }
        else {
            return("Un pokemon de genre "+this.nom+", du type "+this.type+", qui a le niveau "+this.niveau+" ce pokemon n a pas encore de maitre. Il/Elle a un appetit de "+this.appetit+
                    ", un niveau de satisfaction de "+this.satisfaction+" et une loyaute de "+this.loyaute+". Ses points d'attaque sont de :"+this.attaque+", ses points de defense sont de : "+this.defense+", ses point d'attaques sp�ciales sont de : "+this.attaqueSpe+", ses points de defense spe sont de :" +
                    this.defenseSpe+". La probabilite de rencontrer un pokemon de ce type est de "+this.frequence+". HP= "+this.HP+". Ses attaques sont : "+attaques);

        }
    }
}
