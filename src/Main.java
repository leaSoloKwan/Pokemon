import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {



        final Map<String, Integer> mappePokemons = new HashMap<>();



        try(FileReader lecteur = new FileReader("src/pokedexComplet.txt")){
            Scanner s = new Scanner(lecteur);
            while (s.hasNext()) {
                int numeroPokedex = s.nextInt();
                String nom = s.next();
                mappePokemons.put(nom, numeroPokedex);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }



        // nos attaques
        final Map<String, Attaque> mappeAttaques = new HashMap<>();
        mappeAttaques.put("tacle", new AttaqueTacle());
        mappeAttaques.put("morsure", new AttaqueMorsure());
        mappeAttaques.put("pistoletO", new AttaquePistoletO());
        mappeAttaques.put("inferno", new AttaqueInferno());
        mappeAttaques.put("feinte", new AttaqueFeinte());
        mappeAttaques.put("LeafTornado", new AttaqueLeafTornado());
        mappeAttaques.put("bulle", new AttaqueBulleO());
        mappeAttaques.put("coupDeTete", new AttaqueCoupBoule());
        mappeAttaques.put("croquer", new AttaqueCroquer());




        final ArrayList<Pokemon> pokemonList = new ArrayList<>();
        try(FileReader lecteur = new FileReader("src/InputFile.txt")){
            Scanner s = new Scanner(lecteur);
            while(s.hasNext()) {
                String nom = s.next();
                // TP 10

                int numeroPokedex = mappePokemons.get(nom);

                String type = s.next();
                int niveau = s.nextInt();
                boolean diurne = s.nextBoolean();
                int attaque = s.nextInt();
                int defense = s.nextInt();
                int attaqueSpeciale = s.nextInt();
                int defenseSpeciale = s.nextInt();
                ArrayList<Attaque> sesAttaques = new ArrayList<>();
                String nomAttaque = s.next();
                while(! nomAttaque.equals("END")) {
                    if(mappeAttaques.get(nomAttaque)!=null) {
                        sesAttaques.add(mappeAttaques.get(nomAttaque).genAttaque());
                    }
                    nomAttaque = s.next();
                }
                ArrayList<Attaque> sesAttaquesTableau = new ArrayList<Attaque>();
                for(int i = 0; i<sesAttaques.size(); i++) {

                    sesAttaquesTableau.add(sesAttaques.get(i));
                }
                pokemonList.add(new Pokemon(numeroPokedex,nom, type, niveau, diurne, attaque, defense, attaqueSpeciale, defenseSpeciale, sesAttaquesTableau));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }






        final Joueur moi = new Joueur("Cartes", "Julien", 20, new Pokemon[5], new Nourriture[5]);


        try {
            moi.getPokedex().charger("src/monPokedex.txt");
        }
        catch (FileNotFoundException e) {
            System.err.println("Je ne peux pas charger le pokedex du joueur " +moi.getPrenom() + " " +moi.getNom() + ". Ce fichier n'existe encore pas, mais il sera genere lors de votre prochaine session.");
        }
        catch (IOException e) {
            System.err.println("Je ne peux pas charger le pokedex du joueur " +moi.getPrenom() + " " +moi.getNom() + ". " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        catch (InputMismatchException e) {
            System.err.println("Je ne peux pas charger le pokedex du joueur " +moi.getPrenom() + " " +moi.getNom() + ". Le fichier a un mauvais format. " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        final Random alea = new Random();
        moi.capturer(pokemonList.get(alea.nextInt(pokemonList.size())));


        Scanner lecteur = new Scanner(System.in);
        System.out.println();

        String reponse = "";
        int index;
        int reponseEntier;

        while (!reponse.equals("stop")) {

            // interaction 1 : regarder ses pokemons
            System.out.println("Voulez-vous regarder vos pokemons ? Tapez <<oui>> ou <<non>>.");
            reponse = lecteur.next();
            while (!reponse.equals("non") && !reponse.equals("oui")) {
                System.out.println("Refaites votre choix. Tapez <<oui>> ou << non >>.");
                reponse = lecteur.next();
            }
            if (reponse.equals("oui")) {
                System.out.println(moi.afficherPokemons());
                System.out.println("Lequel de vos pokemons voulez-vous regarder ? Tapez son index ou tapez <<non>> pour passer a la prochaine etape.");
                reponse = lecteur.next();
                while(!reponse.equals("non")) {
                    System.out.println(moi.getPokemons()[Integer.parseInt(reponse)]);
                    System.out.println("Voulez-vous regarder un autre pokemon ? Tapez son index ou tapez <<non>> pour passer a la prochaine etape");
                    reponse = lecteur.next();
                }
            }

					/*
					// interaction 2 : regarder sa caisse nourriture
					System.out.println("Voulez-vous regarder votre caisse nourriture ? Tapez <<oui>> ou <<non>>.");
					reponse = lecteur.next();
					while (!reponse.equals("non") && !reponse.equals("oui")) {
						System.out.println("Refaites votre choix. Tapez <<oui>> ou << non >>.");
						reponse = lecteur.next();
					}
					if (reponse.equals("oui")) {
						System.out.println(moi.contenusCaisse());
					}

					// interaction 3 : nourrir des pokemons
					System.out.println("Voulez-vous nourrir vos pokemons ? Tapez <<oui>> ou <<non>>.");
					reponse = lecteur.next();
					while (!reponse.equals("non") && !reponse.equals("oui")) {
						System.out.println("Refaites votre choix. Tapez <<oui>> ou << non >>.");
						reponse = lecteur.next();
					}
					if (reponse.equals("oui")) {
						System.out.println("Lequel de vos pokemons voulez-vous nourrir ? Tapez son index ou tapez <<non>> pour passer a la prochaine etape.");
						reponse = lecteur.next();
						while(!reponse.equals("non")) {
							index = Integer.parseInt(reponse);
							System.out.println("Donnez l'index (dans la caisse) de la nourriture que vous voulez donner a votre pokemon ou tapez <<non>> pour passer a la prochaine etape.");
							reponse = lecteur.next();
							if (!reponse.equals("non")) {
								moi.nourrirPokemon(moi.getPokemons()[index], Integer.parseInt(reponse));
							}
						}
					}

					*/
            // interaction 4 : generer/se battre avec des pokemons

            Pokemon p = pokemonList.get(alea.nextInt(pokemonList.size())).genAlea();
            if (p == null) {
                System.out.println("Vous n'avez rien trouve. Si vous voulez vous arreter, tapez << stop >> . Sinon, tapez << non >> .");
                reponse = lecteur.next();
                while (!reponse.equals("non") && !reponse.equals("stop")) {
                    System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
                    reponse = lecteur.next();
                }
            }
            else {
                moi.rencontrer(p);
                System.out.println("Vous avez trouve un pokemon " + p.getNom() + " de niveau " + p.getNiveau() + ".");
                System.out.println("Voulez vous lui faire la bataille ? << oui / non / stop>>");
                reponse = lecteur.next();

                while (!reponse.equals("oui") && !reponse.equals("non") && !reponse.equals("stop")) {
                    System.out.println("Repetez votre choix s.v.p. Il faut taper << oui >>, << non >> ou << stop >>");
                    reponse = lecteur.next();
                }

                if (reponse.equals("oui")) {
                    System.out.println("Voici les pokemons actuellement dans votre entourage : " + moi.afficherPokemons());
                    System.out.println("Lequel de vos pokemons voulez-vous utiliser dans cette bataille ? Tapez son index.");
                    reponseEntier = lecteur.nextInt();

                    while (reponseEntier < 0 || reponseEntier >= moi.getPokemons().length || (reponseEntier >= 0 && reponseEntier < moi.getPokemons().length && moi.getPokemons()[reponseEntier] == null)) {
                        System.out.println("Il faut faire un choix valide. Tapez un index valide " + moi.afficherPokemons());
                        reponseEntier = lecteur.nextInt();
                    }

                    Bataille maBataille = new Bataille(moi.getPokemons()[reponseEntier], p);
                    maBataille.run();
                    System.out.println("Voulez-vous vous arreter ? Tapez << stop >>. Sinon, tapez << non >>");
                    reponse = lecteur.next();
                    while (!reponse.equals("non") && !reponse.equals("stop")) {
                        System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
                        reponse = lecteur.next();
                    }
                }

            }


					/*
					// interaction 4 : generer/collectionner nourriture
					Nourriture n = tartiflette.genAlea();
					if (n == null) {
						System.out.println("Vous n'avez rien trouve. Si vous voulez vous arreter, tapez << stop >> . Sinon, tapez << non >> .");
						reponse = lecteur.next();
						while (!reponse.equals("non") && !reponse.equals("stop")) {
							System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
							reponse = lecteur.next();
						}
					} else {
						System.out.println("Vous avez trouve un(e) " + n.getIngredient() + ".");
						System.out.println("Voulez vous la prendre ? << oui / non / stop>>");
						reponse = lecteur.next();

						while (!reponse.equals("oui") && !reponse.equals("non") && !reponse.equals("stop")) {
							System.out.println("Repetez votre choix s.v.p. Il faut taper << oui >>, << non >> ou << stop >>");
							reponse = lecteur.next();
						}

						if (reponse.equals("oui")) {
							moi.addNourriture(n);
							System.out.println("Voulez-vous vous arreter ? Tapez << stop >>. Sinon, tapez << non >>");
							reponse = lecteur.next();
							while (!reponse.equals("non") && !reponse.equals("stop")) {
								System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
								reponse = lecteur.next();
							}
						}

					}
					*/

            System.out.println();
        }

        moi.getPokedex().sauvegarder("src/monPokedex.txt");

    }
}
