import java.io.IOException;

public class AttackThread extends Thread
{
    Logger logger;
    Pokemon pokemon1;
    Pokemon pokemon2;
    int number;

    public AttackThread(Logger logger, Pokemon pokemon1, Pokemon pokemon2, int nr)
    {
        this.logger = logger;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.number = nr;
    }

    public void run()
    {
        PokemonsFight pokemonsFight = new PokemonsFight(logger, pokemon1, pokemon2, number);
        try {
            pokemonsFight.PokAttacksPok(pokemon1, pokemon2, number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
