import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws InterruptedException, IOException {
        Logger logger = Logger.getInstance();

        Read read_input = new Read();
        Trainer trainer1 = read_input.ReadTrainer();
        Trainer trainer2 = read_input.ReadTrainer();

        trainer1.addItemsForPokemons(trainer1);
        trainer2.addItemsForPokemons(trainer2);

        ArenaThread thread1 = new ArenaThread(trainer1.pokemons.get(0), trainer2.pokemons.get(0), logger, 1);
        ArenaThread thread2 = new ArenaThread(trainer1.pokemons.get(1), trainer2.pokemons.get(1), logger, 2);
        ArenaThread thread3 = new ArenaThread(trainer1.pokemons.get(2), trainer2.pokemons.get(2), logger, 3);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();

        Pokemon bestPokemon1 = trainer1.BestPokemon(trainer1);
        Pokemon bestPokemon2 = trainer1.BestPokemon(trainer2);

        ArenaThread finalBattle = new ArenaThread(bestPokemon1, bestPokemon2, logger, 4);
        finalBattle.start();
        finalBattle.join();

        logger.writer.close();
    }
}


