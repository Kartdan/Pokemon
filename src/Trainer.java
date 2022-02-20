import java.util.*;
public class Trainer
{
    String name;
    int varsta;
    ArrayList<Pokemon> pokemons;
    ArrayList<String> pokemons_string;
    ArrayList<Item> items;

    public Trainer()
    {
        this.pokemons = new ArrayList<>(3);
        this.items = new ArrayList<>();
        this.pokemons_string = new ArrayList<>(3);
    }

    public void addItemsForPokemons(Trainer trainer)
    {
        for(Pokemon pokemon : trainer.pokemons)
        {
            for(Item item : pokemon.getItems())
            {
                pokemon.AddItemStats(pokemon, item);
            }
        }
    }

    public Pokemon BestPokemon(Trainer trainer)
    {
        Pokemon pokemon = new Pokemon();
        int s = 0;
        for(Pokemon contor: trainer.pokemons)
        {
            if(contor.TotalStats(contor) > s)
            {
                s = contor.TotalStats(contor);
                pokemon = contor;
            }
            if(contor.TotalStats(contor) == s)
            {
                if(contor.getName().compareTo(pokemon.getName()) < 0)
                {
                    pokemon = contor;
                }
            }
        }
        return pokemon;
    }
}
