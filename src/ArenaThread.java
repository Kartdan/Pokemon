import java.io.IOException;

public class ArenaThread extends Thread
{
    Pokemon pokemon1;
    Pokemon pokemon2;
    Logger logger;
    int nr;

    public ArenaThread(Pokemon pokemon1, Pokemon pokemon2, Logger logger, int nr)
    {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.logger = logger;
        this.nr = nr;
    }

    public void run()
    {
        try
        {
            Arena arena = new Arena(logger);
            arena.FirstFight(pokemon1, pokemon2, nr);
        } catch (CloneNotSupportedException | IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
