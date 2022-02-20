public class AbilitiesFactory
{
    public Ability check_pokemon_for_ability_1(String string)
    {
        switch(string)
        {
            case "Pikachu": return new Ability(6, "NO", "NO", 4);
            case "Bulbasaur": return new Ability(6, "NO", "NO", 4);
            case "Charmander": return new Ability(4, "YES", "NO", 4);
            case "Squirtle": return new Ability(4, "NO", "NO", 3);
            case "Snorlax": return new Ability(4, "YES", "NO", 5);
            case "Vulpix": return new Ability(8, "YES", "NO", 6);
            case "Eevee": return new Ability(5, "NO", "NO", 3);
            case "Jigglypuff": return new Ability(4, "YES", "NO", 4);
            case "Meowth": return new Ability(5, "NO", "YES", 4);
            case "Psyduck": return new Ability(2, "NO", "NO", 4);
        }
        System.out.println(string);
        throw new IllegalArgumentException("Unknown ability\n");
    }

    public Ability check_pokemon_for_ability_2(String string)
    {
        switch(string)
        {
            case "Pikachu": return new Ability(4, "YES", "YES", 5);
            case "Bulbasaur": return new Ability(5, "NO", "NO", 3);
            case "Charmander": return new Ability(7, "NO", "NO", 6);
            case "Squirtle": return new Ability(2, "YES", "NO", 2);
            case "Snorlax": return new Ability(0, "NO", "YES", 5);
            case "Vulpix": return new Ability(2, "NO", "YES", 7);
            case "Eevee": return new Ability(3, "YES", "NO", 3);
            case "Jigglypuff": return new Ability(3, "YES", "NO", 4);
            case "Meowth": return new Ability(1, "NO", "YES", 3);
            case "Psyduck": return new Ability(2, "YES", "NO", 5);
        }
        throw new IllegalArgumentException("Unknown ability\n");
    }
}
