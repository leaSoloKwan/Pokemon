import java.util.Scanner;

public class Joueur {
    private String nom;
    private String prenom;
    private int age;
    private Pokemon[] tabpoke;
    private Nourriture[] caisseNourriture;
    private Item[] sac;
    private Pokedex pokedex;
    //Constructeurs
    public Joueur(String Nom,String Prenom,int Age,Pokemon Tabpoke[],Nourriture[] caisseNourriture) {
        this.nom=Nom;
        this.prenom=Prenom;
        this.age=Age;
        this.tabpoke=Tabpoke;
        this.caisseNourriture=caisseNourriture;
        this.sac=new Item[15];
        this.pokedex=new Pokedex();

        for (int i = 0; i < this.tabpoke.length; i++) {
            if(this.tabpoke[i]!=null) {
                this.pokedex.getSetPokemon().add(this.tabpoke[i].getNumeroPokedex());
            }
        }
    }


    public Joueur(String Nom,String Prenom,int Age) {
        this.nom=Nom;
        this.prenom=Prenom;
        this.age=Age;
        this.tabpoke=new Pokemon[5];
        this.caisseNourriture=new Nourriture[10];
        this.sac=new Item[15];
        this.pokedex=new Pokedex();
        for (int i = 0; i < this.tabpoke.length; i++) {
            if(this.tabpoke[i]!=null) {
                this.pokedex.getSetPokemon().add(this.tabpoke[i].getNumeroPokedex());
            }
        }

    }

    //Getters et Setters
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public int getAge() {
        return this.age;
    }
    public Pokemon[] getPokemons(){
        return this.tabpoke;
    }


    public Pokedex getPokedex() {
        return pokedex;
    }


    public Item[] getSac() {
        return sac;
    }


    public void setSac(Item[] sac) {
        this.sac = sac;
    }


    //Methodes
	/*
	public void capturer(Pokemon nvPokemon) {
		int i;
		i=0;
		Scanner lecteur=new Scanner(System.in);
		this.pokedex.rencontrer(nvPokemon);
		if(nvPokemon.getMonJoueur()==null) {
			while(this.tabpoke[i]!=null && i<this.tabpoke.length ) {
				i=i+1;
			}
			if(this.tabpoke[i]==null) {
				this.tabpoke[i]=nvPokemon;
				this.tabpoke[i].setMonJoueur(this);
				this.tabpoke[i].estCapture();
				if(this.tabpoke[i].getSatisfaction()>=10) {
					this.tabpoke[i].setSatisfaction(10);
				}
			}
			else {
				System.out.println("Vous devez d'abord renoncer � un de vos pokemon. Voulez vous lib�rer un pokemon ? Tapez <<oui>> ou <<non>>");
				String reponse=lecteur.next();
				while (!reponse.equals("non") && !reponse.equals("oui")) {
					System.out.println("Refaites votre choix. Tapez << oui >> ou << non >>");
					reponse = lecteur.next();
				}
				if(reponse.equals("oui")) {
					this.afficherTabPoke();
					System.out.println("Saisir l'indice du pokemon a supprimer entre 1et 4");
					int rep=lecteur.nextInt();
					while (rep<0 || rep>4) {
						System.out.println("Refaites votre choix entre 1 et 4");
						reponse = lecteur.next();
					}
					this.liberer(this.tabpoke[i]);
					while(this.tabpoke[i]!=null && i<this.tabpoke.length ) {
						i=i+1;
					}
					if(this.tabpoke[i]==null) {
						this.tabpoke[i]=nvPokemon;
						this.tabpoke[i].setMonJoueur(this);
						this.tabpoke[i].estCapture();
						if(this.tabpoke[i].getSatisfaction()>=10) {
							this.tabpoke[i].setSatisfaction(10);
						}
					}
				}

			}

		}
		else {
			System.out.println("Le pokemon apparitent d�j� � un joueur");
		}
	}
	*/
    public void capturer(Pokemon p) {
        boolean capture = false;
        int i = 0;
        Scanner lecteur=new Scanner(System.in);

        if (p.getMonJoueur() != null) {
            throw new DejaUnMaitreException("Vous ne pouvez pas capturer ce pokemon il a un autre maitre.");
        }
        else{
            while (!capture && i < this.tabpoke.length) {
                if (this.tabpoke[i] == null && !capture) {
                    this.tabpoke[i] = p;
                    p.setMonJoueur(this);

                    // TP3
                    p.estCapture();

                    // TP2
                    capture = true;

                    // TP10
                    this.rencontrer(p);
                }
                i++;
            }
            if (!capture) {
                throw new PlusDePlaceException("Vous n'avez plus de place. Vous devez d'abord liberer un pokemon.");
            }
        }
    }
    public void afficherTabPoke(){
        int i;
        Pokemon poke;
        for(i=0;i<this.tabpoke.length;i++) {
            if(this.tabpoke[i]!=null) {
                System.out.print("Dans le pok�ball "+i+" il y a : ");
                poke=this.tabpoke[i];
                System.out.println(poke.toString());
            }
        }
    }
    public void liberer(Pokemon poke)  {
        boolean libere=false;
        int i;
        i=0;
        if(poke.getMonJoueur()!=null) {
            while(!libere && i<this.tabpoke.length) {
                if(this.tabpoke[i]==poke) {
                    this.tabpoke[i].setNomDonne(null);
                    this.tabpoke[i].setMonJoueur(null);
                    this.tabpoke[i].estLibere();
                    libere=true;
                    this.tabpoke[i]=null;
                }
                i++;
            }
            if(!libere) {
                throw new LibererDUnAutreMaitreException("Ce pokemon appartient a un autre maitre");
            }
        }
        else {
            throw new LibererLibreException("Ce pokemon est deja libre");
        }
    }

    public void nommmerPoke(Pokemon poke,String nvNom) {
        if(poke.getMonJoueur()==this) {
            poke.setNomDonne(nom);
        }
        else {
            System.out.println("Vous ne pouvez pas nommer ce pokemon car vous n'�tes pas son maitre!");
        }
    }
    public void donnerPoke(Pokemon poke,Joueur autreJoueur) {
        boolean donne=false;
        int i=0;

        while(!donne && i<this.getPokemons().length) {
            if(this.tabpoke[i]==poke) {
                int j=0;
                while(!donne && j<autreJoueur.tabpoke.length) {
                    if(autreJoueur.tabpoke[j]==null) {
                        this.tabpoke[i]=null;
                        autreJoueur.tabpoke[j]=poke;
                        poke.setMonJoueur(autreJoueur);
                        donne=true;
                    }
                    j++;
                }
                if(!donne) {
                    System.out.println("Vous ne pouvez pas donner ce pokemon a"+autreJoueur.prenom+"puisqu'il a deja 5 pokemons dans son entourage !");
                }
            }
            i++;
        }
        if(!donne) {
            System.out.println("Vous ne pouvez pas donner ce pokemon puisque vous n'etes pas son maitre !");
        }
    }

    public void echangerPoke(Pokemon p, Joueur autreJoueur,Pokemon autrePokemon) {
        boolean echange=false;
        int i=0;
        while(!echange && i<this.tabpoke.length) {
            if(this.tabpoke[i]==p) {
                int j=0;
                while(!echange && j<autreJoueur.tabpoke.length) {
                    if(autreJoueur.tabpoke[j]==autrePokemon) {
                        tabpoke[i]=autrePokemon;
                        autreJoueur.tabpoke[j]=p;

                        p.setMonJoueur(autreJoueur);
                        autrePokemon.setMonJoueur(this);
                        echange=true;
                        this.pokedex.rencontrer(autrePokemon);
                    }
                    j++;
                }
                if(!echange) {
                    System.out.println("Vous ne pouvez pas echanger ce pokemon avec " + autreJoueur.prenom + " puisque " +
                            autreJoueur.nom + " n'est pas le maitre du pokemon que vous souhaitez !");
                }
            }
            i++;
        }
        if(!echange) {
            System.out.println("Vous ne pouvez pas echanger ce pokemon avec " + autreJoueur.prenom + " puisque vous n'etes pas son maitre");

        }
    }

    public boolean estPleineCaisseNourriture() {
        int i;
        i=0;
        boolean cap;
        cap=true;
        while(this.caisseNourriture[i]!=null && i<this.caisseNourriture.length-1) {
            i=i+1;
        }
        if(this.caisseNourriture[i]==null) {
            cap=false;
        }
        return cap;
    }
    public boolean estVideCaisseNourriture() {
        int i;
        i=0;
        boolean cap;
        cap=false;
        while(this.caisseNourriture[i]!=null && i<this.caisseNourriture.length-1) {
            i=i+1;
        }
        if(i==0) {
            cap=true;
        }
        return cap;
    }

    public int placeCaisseNourriture() {
        int i;
        i=0;
        while(this.caisseNourriture[i]!=null && i<this.caisseNourriture.length) {
            i=i+1;
        }
        return i;

    }

    public void addNourriture(Nourriture nouv) {
        if(!(this.estPleineCaisseNourriture())){
            this.caisseNourriture[this.placeCaisseNourriture()]=nouv;
            System.out.println("Vous avez ajout� la nourriture a votre caisse");
        }
        else {
            System.out.println(" Votre caisse de nourriture est pleine");
        }
    }

    public void afficherCaisseNourriture(){
        int i;
        Nourriture nourr;
        for(i=0;i<10;i++) {
            if(this.caisseNourriture[i]!=null) {
                System.out.print(i+" : ");
                nourr=this.caisseNourriture[i];
                System.out.println(nourr.toString());
            }
        }
    }

    public void lacherNourriture(int index) {
        if(index>=0 && index<this.caisseNourriture.length) {
            this.caisseNourriture[index]=null;
        }
        else {
            System.out.println("Votre index est faux.");
        }
    }

    public void regarderPokemon(Pokemon p) {
        if(p.getMonJoueur()==(this)) {
            System.out.println("Ce pokemon "+p.getNom()+" a un appetit de "+p.getAppetit());
        }
        else {
            System.out.println("Ce pokemon n'est pas a vous, vous ne pouvez donc pas voir si il a faim.");
        }
    }

    public void nourrir(Pokemon p,int index) {
        if(p.getMonJoueur()==(this) && this.caisseNourriture[index]!=null) {
            if(this.caisseNourriture[index].estCompatible(p)) {
                p.utiliser(this.caisseNourriture[index]);
                this.caisseNourriture[index]=null;
            }
            else {
                System.out.println(" Ce pokemon n'est pas compatible avec la nourriture");
            }
        }
        else {
            if(!(p.getMonJoueur()==(this))) {
                System.out.println(" Ce pokemon n'est pas a vous, vous ne pouvez pas le nourrir");
            }
            else {
                System.out.println("L'index est faux");
            }
        }
    }

    public Pokemon retournePoke(int ind) {
        return this.tabpoke[ind];
    }

    public void donnerItem(int indexPokemon,int indexItem) {
        if(indexItem>=0 && indexItem<15 && sac[indexItem]!=null) {
            if(indexPokemon<=0 && indexPokemon<5 && tabpoke[indexPokemon]!=null) {
                if(this.sac[indexItem] instanceof Utilisable) {
                    Utilisable u = (Utilisable) this.sac[indexItem];
                    this.tabpoke[indexPokemon].utiliser(u);
                    this.sac[indexItem].baisserUse(1);
                    if(this.sac[indexItem].getNbRestUse()==0) {
                        this.sac[indexItem]=null;
                    }
                }else {
                    System.out.println("Cette item n'est pas utilisable.");
                }
            }else {
                System.out.println("L'index de votre pokemon n'est pas valide");
            }
        }else {
            System.out.println("L'index de votre objet n'est pas valide");
        }
    }

    public void modifierItem(int indexChangeur,int indexAModifier) {
        if(indexChangeur>=0 && indexChangeur<15 && sac[indexChangeur]!=null) {
            if(indexAModifier>=0 && indexAModifier<15 && sac[indexAModifier]!=null) {
                if(this.sac[indexChangeur] instanceof ChangeItems) {
                    if(this.sac[indexAModifier] instanceof Modifiable) {
                        Modifiable m = (Modifiable) this.sac[indexAModifier];
                        ChangeItems c = (ChangeItems) this.sac[indexChangeur];
                        c.utiliser(m);
                        if(this.sac[indexChangeur].getNbRestUse()==0) {
                            this.sac[indexChangeur]=null;
                        }

                    }else {
                        System.out.println("L'objet "+this.sac[indexAModifier].getNom()+" n'est pas un objet modifiable");
                    }
                }else {
                    System.out.println("L'objet "+this.sac[indexChangeur].getNom()+" n'est pas un objet changeur");
                }

            }else {
                System.out.println("L'index de l'objet a modifier est faux.");
            }

        }else {
            System.out.println("L'index de l'objet a changer est faux.");
        }
    }
    public boolean estPleinSac() {
        int i;
        i=0;
        boolean cap;
        cap=true;
        while(this.sac[i]!=null && i<this.sac.length-1) {
            i=i+1;
        }
        if(this.sac[i]==null) {
            cap=false;
        }
        return cap;
    }
    public int placeSac() {
        int i;
        i=0;
        while(this.sac[i]!=null && i<this.sac.length) {
            i=i+1;
        }
        return i;

    }
    public void addItem(Item item) {
        if(!(this.estPleinSac())){
            this.sac[this.placeSac()]=item;
            System.out.println("Vous avez ajout� l'item "+item.getNom()+" a votre sac");
        }
        else {
            System.out.println(" Votre sac d'item est plein");
        }
    }
    public void lacherItem(int index) {
        if(index>=0 && index<this.sac.length) {
            this.sac[index]=null;
        }
        else {
            System.out.println("Votre index est faux.");
        }
    }
    public void contenuSac(){
        int i;
        Item item;
        for(i=0;i<10;i++) {
            if(this.sac[i]!=null) {
                System.out.print(i+" : ");
                item=this.sac[i];
                System.out.println(item.toString());
            }
        }
    }

    //TP9
    public void rencontrer(Pokemon p) {
        this.pokedex.rencontrer(p);
    }
    public String afficherPokemons() {
        String mesPokemons = "";
        for (int i = 0; i<this.tabpoke.length; i++) {
            if (null != this.tabpoke[i]) {
                mesPokemons += i + " : " + this.tabpoke[i] + "\n";
            }
        }
        return mesPokemons;
    }
}
