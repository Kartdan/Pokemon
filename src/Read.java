import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Read
{
    File file;
    Scanner scan;

    public Read()
    {
        this.file = new File("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Proiect_final/src/input/input_1");
        try
        {
            this.scan = new Scanner(this.file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Trainer ReadTrainer()
    {
        Trainer trainer = new Trainer();
        String[] arr = scan.nextLine().split(" ");
        trainer.name = arr[0];
        trainer.varsta = Integer.parseInt(arr[1]);
        trainer.pokemons_string.add(arr[2]);
        trainer.pokemons_string.add(arr[3]);
        trainer.pokemons_string.add(arr[4]);

        PokemonFactory check_pokemon = new PokemonFactory();

        for(int i = 2; i <=4; i++)
        {
            Pokemon pokemon = check_pokemon.checkPokemon(arr[i]);
            trainer.pokemons.add(pokemon);
        }

        String[] items = scan.nextLine().split(", ");
        String[] items2 = scan.nextLine().split(", ");
        String[] items3 = scan.nextLine().split(", ");

        ItemFactory itemFactory = new ItemFactory();
        itemFactory.addItems(trainer, items, 0);
        itemFactory.addItems(trainer, items2, 1);
        itemFactory.addItems(trainer, items3, 2);

        return trainer;
    }
}
