import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Pokedex {
    private Set<Integer> setPokemon;

    public Pokedex() {
        this.setPokemon=new TreeSet<Integer>();
    }



    public Set<Integer> getSetPokemon() {
        return setPokemon;
    }



    public void rencontrer(Pokemon p) {
        this.setPokemon.add(p.getNumeroPokedex());

    }
    public void rencontrer(Pokemon[] pokemons) {

        for(int i=0;i<pokemons.length;i++) {
            if(pokemons[i]!=null) {
                this.setPokemon.add(pokemons[i].getNumeroPokedex());
            }
        }
    }

    public void charger(String chemin) throws FileNotFoundException {
        try(FileReader lecteur = new FileReader(chemin)){
            Scanner s = new Scanner(lecteur);
            while(s.hasNextInt()) {
                this.setPokemon.add(s.nextInt());
            }
        }
        catch (IOException e) {
            System.err.println("Je ne peux pas charger le pokedex du joueur ");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void sauvegarder(String chemin) {
        try {
            FileWriter scrib=new FileWriter(chemin);//fermer les flux
            PrintWriter afficheur=new PrintWriter(scrib);
            Iterator<Integer> monIterator=this.setPokemon.iterator();
            while(monIterator.hasNext()) {
                afficheur.println(monIterator.next());

            }
        }catch(IOException e) {
            System.err.println("Je ne peux pas sauvegarder le pokedex du joueur ");
            e.printStackTrace();
        }
    }
}
