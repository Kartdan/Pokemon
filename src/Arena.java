import java.io.IOException;
import java.util.*;

public class Arena
{
    Logger logger;

    public Arena(Logger logger)
    {
        this.logger = logger;
    }

    public void FirstFight(Pokemon pokemon_1, Pokemon pokemon_2, int nr) throws CloneNotSupportedException, IOException, InterruptedException {

        Random rand = new Random();
        int randomFight;
        Fights fight = new Fights(pokemon_1, logger);

        while(true)
        {
            randomFight = rand.nextInt((3 - 1) + 1) + 1;

            //pokemon vs pokemon starts
            if (randomFight == 3)
            {
                int result = fight.PokemonVsPokemon(pokemon_1, pokemon_2);
                if(nr == 4)
                {
                    if (result == 1)
                    {
                        logger.BestPokemon(pokemon_1);
                    }
                    if(result == 2)
                    {
                        logger.BestPokemon(pokemon_2);
                    }
                }
                break;
            }

            //Pokemons vs neutrel1
            if(randomFight == 1)
            {
                logger.AnnounceFightPok1();
                fight.PokemonVsNeutrel1(pokemon_1);
                logger.AnnounceFightPok2();
                fight.PokemonVsNeutrel1(pokemon_2);
            }

            //Pokemons vs neutrel2
            if(randomFight == 2)
            {
                logger.AnnounceFightPok1();
                fight.PokemonVsNeutrel2(pokemon_1);
                logger.AnnounceFightPok1();
                fight.PokemonVsNeutrel2(pokemon_2);
            }
        }
    }
}
