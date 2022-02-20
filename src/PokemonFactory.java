public class PokemonFactory
{
    public AbilitiesFactory ability = new AbilitiesFactory();


    public Pokemon checkPokemon(String string)
    {
        Ability ability_1 = ability.check_pokemon_for_ability_1(string);
        Ability ability_2 = ability.check_pokemon_for_ability_2(string);
        switch(string)
        {
            case "Pikachu": return new Pokemon(string, 35, 0, 4, 2, 3,
                    ability_1, ability_2);
            case "Bulbasaur": return new Pokemon(string, 42, 0, 5, 3, 1,
                    ability_1, ability_2);
            case "Charmander": return new Pokemon(string, 50, 4, 0, 3, 2,
                    ability_1, ability_2);
            case "Squirtle": return new Pokemon(string, 60, 0, 3, 5, 5,
                    ability_1, ability_2);
            case "Snorlax": return new Pokemon(string, 62, 3, 0, 6, 4,
                    ability_1, ability_2);
            case "Vulpix": return new Pokemon(string, 36, 5, 0, 2, 4,
                    ability_1, ability_2);
            case "Eevee": return new Pokemon(string, 39, 0, 4, 3, 3,
                    ability_1, ability_2);
            case "Jigglypuff": return new Pokemon(string, 34, 4, 0, 2, 3,
                    ability_1, ability_2);
            case "Meowth": return new Pokemon(string, 41, 3, 0, 4, 2,
                    ability_1, ability_2);
            case "Psyduck": return new Pokemon(string, 43, 3, 0, 3, 3,
                    ability_1, ability_2);
        }
        throw new IllegalArgumentException("Unknown pokemon\n");
    }
}
