import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    private static final Logger logger = new Logger();

    private Logger(){}

    FileWriter writer;

    {
        try {
            writer = new FileWriter("/Users/Dani Cartale/Desktop/Facultate/Anul 2/Sem 1/POO/Proiect_final/src/output/output_1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance()
    {
        return logger;
    }

    public void vsNeutrel1(Pokemon pokemon) throws IOException {
        System.out.println("Pokemon " + pokemon.getName() + " is fighting against a Neutrel1 pokemon");
        writer.write("Pokemon " + pokemon.getName() + " is fighting against a Neutrel1 pokemon\n");
    }

    public void vsNeutrel2(Pokemon pokemon) throws IOException {
        System.out.println("Pokemon " + pokemon.getName() + " is fighting against a Neutrel2 pokemon");
        writer.write("Pokemon " + pokemon.getName() + " is fighting against a Neutrel2 pokemon\n");
    }

    public void attack1onNeutrel1(Pokemon pokemon, int damage) throws IOException {
        System.out.println(pokemon.getName() + " normal attack -> neutrel loses " + damage);
        writer.write(pokemon.getName() + " normal attack -> neutrel loses " + damage + "\n");
    }

    public void spattack1onNeutrel(Pokemon pokemon, int damage) throws IOException {
        System.out.println(pokemon.getName() + " special attack -> neutrel loses " + damage);
        writer.write(pokemon.getName() + " special attack -> neutrel loses " + damage + "\n");

    }

    public void Neutrel1LoseHP(Neutrel1 neutrel1) throws IOException {
        if(neutrel1.hp > 0)
        {
            System.out.println("Neutrel1 HP is " + neutrel1.hp);
            writer.write("Neutrel1 HP is " + neutrel1.hp + "\n");
        }
        else
        {
            System.out.println("Neutrel1 is defeated");
            writer.write("Neutrel1 is defeated\n");
        }
    }

    public void Neutrel2LoseHP(Neutrel2 neutrel2) throws IOException
    {
        if(neutrel2.hp > 0)
        {
            System.out.println("Neutrel2 HP is " + neutrel2.hp);
            writer.write("Neutrel2 HP is " + neutrel2.hp + "\n");
        }
        else
        {
            System.out.println("Neutrel2 HP is defeated");
            writer.write("Neutrel2 is defeated\n");
        }
    }

    public void NeutrelisStunned() throws IOException {
        System.out.println("Neutrel is stunned");
        writer.write("Neutrel is stunned\n");
    }

    public void usedAbility1(Pokemon pokemon) throws IOException {
        System.out.println(pokemon.getName() + " used his first ability");
        writer.write(pokemon.getName() + " used his first ability\n");

    }

    public void usedAbility2(Pokemon pokemon) throws IOException {
        System.out.println(pokemon.getName() + " used his second ability");
        writer.write(pokemon.getName() + " used his second ability\n");
    }

    public void triedToUseAbility(Pokemon pokemon) throws IOException {
        System.out.println(pokemon.getName() + " tried to use an ability but missed");
        writer.write(pokemon.getName() + " tried to use an ability but missed\n");

    }

    public void Neutrel1Miss() throws IOException {
        System.out.println("Neutrel1 misses");
        writer.write("Neutrel1 misses\n");
    }

    public void NeutrelAttacks(Pokemon pokemon, int damage) throws IOException {
        System.out.println("Neutrel normal attack -> " + pokemon.getName() + " loses " + damage);
        writer.write("Neutrel normal attack -> " + pokemon.getName() + " loses " + damage + "\n");
    }

    public void PokemonHP(Pokemon pokemon) throws IOException {
        if(pokemon.getHP() > 0)
        {
            System.out.println(pokemon.getName() + " HP is " + pokemon.getHP());
            writer.write(pokemon.getName() + " HP is " + pokemon.getHP() + "\n");
        }
        else
        {
            System.out.println(pokemon.getName() + " is defeated");
            writer.write(pokemon.getName() + " is defeated\n");
        }
    }

    public void PokemonHP2(Pokemon pokemon) throws IOException {
        if(pokemon.getHP() > 0)
        {
            System.out.println(pokemon.getName() + " HP is " + pokemon.getHP());
            writer.write(pokemon.getName() + " HP is " + pokemon.getHP() + "\n");
        }
    }

    public void NeutrelAttackTooLow() throws IOException {
        System.out.println("Neutrel didn't produce any damage");
        writer.write("Neutrel didn't produce any damage\n");
    }

    public void PokemonWinsVsNeutrel(Pokemon pokemon) throws IOException {
        System.out.println("Pokemon " + pokemon.getName() + " wins");
        writer.write("Pokemon " + pokemon.getName() + " wins\n");
    }

    public void PrintStats(Pokemon pokemon) throws IOException {
        System.out.println("Stats for " + pokemon.getName() + "\nHit points : "  + pokemon.getHP() +  "\nNormal attack: " + pokemon.getNormal_attack() + "\nSpecial attack: " +
                pokemon.getSpecial_attack() + "\nDefense: " + pokemon.getDefense() + "\nSpecial defense: " + pokemon.getSpecial_defense());
        writer.write("Stats for " + pokemon.getName() + "\nHit points : "  + pokemon.getHP() +  "\nNormal attack: " + pokemon.getNormal_attack() + "\nSpecial attack: " +
                pokemon.getSpecial_attack() + "\nDefense: " + pokemon.getDefense() + "\nSpecial defense: " + pokemon.getSpecial_defense() + "\n");
    }

    public void AnnounceFightPok1() throws IOException {
        System.out.println("===================================");
        System.out.println("The first pokemon is going to fight");
        System.out.println("===================================");
        writer.write("===================================\n");
        writer.write("The first pokemon is going to fight\n");
        writer.write("===================================\n");
    }

    public void AnnounceFightPok2() throws IOException {
        System.out.println("====================================");
        System.out.println("The second pokemon is going to fight");
        System.out.println("====================================");
        writer.write("===================================\n");
        writer.write("The second pokemon is going to fight\n");
        writer.write("===================================\n");
    }

    public void InfoAbilities(Pokemon pokemon) throws IOException {
        if(pokemon.getCooldown1() >= 0)
        {
            System.out.println(pokemon.getName() + " has " + pokemon.getCooldown1() + " cooldown on the first ability");
            writer.write(pokemon.getName() + " has " + pokemon.getCooldown1() + " cooldown on the first ability\n");
        }
        if(pokemon.getCooldown2() >= 0)
        {
            System.out.println(pokemon.getName() + " has " + pokemon.getCooldown2() + " cooldown on the second ability");
            writer.write(pokemon.getName() + " has " + pokemon.getCooldown2() + " cooldown on the second ability\n");
        }
    }

    public void DelimitateAttacks() throws IOException {
        System.out.println("---------------------------------------------------------");
        writer.write("---------------------------------------------------------\n");
    }

    public void AnnouncePokVsPok(Pokemon pokemon1, Pokemon pokemon2) throws IOException {
        System.out.println("===========================================");
        System.out.println(pokemon1.getName() + " is going to fight vs " + pokemon2.getName());
        System.out.println("===========================================");
        writer.write("===========================================\n");
        writer.write(pokemon1.getName() + " is going to fight vs " + pokemon2.getName() + "\n");
        writer.write("===========================================\n");
    }

    public void PokemonWinsVsPokemon(Pokemon pokemon1, Pokemon pokemon2) throws IOException {
        System.out.println(pokemon1.getName() + " wins against " + pokemon2.getName());
        writer.write(pokemon1.getName() + " wins against " + pokemon2.getName() + "\n");
    }

    public void dodged(Pokemon pokemon, Pokemon pokemon2) throws IOException {
        System.out.println(pokemon.getName() + " dodged " + pokemon2.getName() + "'s attack");
        writer.write(pokemon.getName() + " dodged " + pokemon2.getName() + "'s attack\n");
    }

    public void PokemonStunned(Pokemon pokemon) throws IOException {
        System.out.println(pokemon.getName() + " is stunned");
        writer.write(pokemon.getName() + " is stunned\n");
    }

    public void PokemonAtt1onPokemon(Pokemon pokemon1, Pokemon pokemon2, int damage) throws IOException {
        System.out.println(pokemon1.getName() + " normal attack -> " + pokemon2.getName() +  " loses " + damage);
        writer.write(pokemon1.getName() + " normal attack -> " + pokemon2.getName() +  " loses " + damage + "\n");
    }

    public void noDamage(Pokemon pokemon) throws IOException {
        System.out.println(pokemon.getName() + " didn't produce any damage");
        writer.write(pokemon.getName() + " didn't produce any damage\n");
    }

    public void separator() throws IOException {
        System.out.println("========================================================");
        writer.write("========================================================\n");
    }

    public void FinishedAdventure() throws IOException {
        System.out.println("===================================");
        System.out.println("F I N I S H E D   A D V E N T U R E");
        System.out.println("===================================");
        writer.write("===================================\n");
        writer.write("F I N I S H E D   A D V E N T U R E\n");
        writer.write("===================================\n");
    }

    public void BestPokemon(Pokemon pokemon) throws IOException {
        System.out.print("========================================================");
        writer.write("========================================================");

        for(int i = 0; i < pokemon.getName().length(); i++)
        {
            System.out.print("=");
            writer.write("=");
        }

        System.out.println("===");
        writer.write("===\n");

        System.out.println("|| THE BEST POKEMON AND THE WINNER OF THE TOURNAMENT IS " + pokemon.getName().toUpperCase() + " ||");
        writer.write("|| THE BEST POKEMON AND THE WINNER OF THE TOURNAMENT IS " + pokemon.getName().toUpperCase() +  " ||\n");

        System.out.print("========================================================");
        writer.write("========================================================");

        for(int i = 0; i < pokemon.getName().length(); i++)
        {
            System.out.print("=");
            writer.write("=");
        }

        System.out.println("===");
        writer.write("===\n");
    }

    public void startAttack(Pokemon pokemon) throws IOException {
        System.out.println("POKEMON " + pokemon.getName());
        writer.write("POKEMON " + pokemon.getName() + "\n");
    }
}
