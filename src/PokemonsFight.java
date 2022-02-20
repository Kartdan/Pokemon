import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class PokemonsFight
{
    Logger logger;
    Pokemon pokemon1;
    Pokemon pokemon2;
    int number;

    public PokemonsFight(Logger logger, Pokemon pokemon1, Pokemon pokemon2, int nr)
    {
        this.logger = logger;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.number = nr;
    }

    public void PokAttacksPok(Pokemon pokemon1, Pokemon pokemon2, int number) throws IOException {
        logger.DelimitateAttacks();
        logger.startAttack(pokemon1);

        //cooldown on both abilites
        if(pokemon1.getCooldown1() > 0 && pokemon1.getCooldown2() > 0)
        {
            Attack1onPokemon(pokemon1, pokemon2);
            return;
        }

        //cooldown on first ability
        if(pokemon1.getCooldown1() > 0)
        {
            Random rand = new Random();
            int randomAttack2 = rand.nextInt((2 - 1) + 1) + 1;
            if(randomAttack2 == 1)
            {
                Attack1onPokemon(pokemon1, pokemon2);
                return;
            }
            Ability2onPokemon(pokemon1, pokemon2);
            return;
        }

        //cooldown on second ability
        if(pokemon1.getCooldown2() > 0)
        {
            Random rand = new Random();
            int randomAttack2 = rand.nextInt((2 - 1) + 1) + 1;
            if(randomAttack2 == 1)
            {
                Attack1onPokemon(pokemon1, pokemon2);
                return;
            }
            Ability1onPokemon(pokemon1, pokemon2);
            return;
        }

        //normal attack/special attack
        if(number == 1)
        {
            Attack1onPokemon(pokemon1, pokemon2);
        }

        //ability 1
        if(number == 2)
        {
            Ability1onPokemon(pokemon1, pokemon2);
        }

        //ability 2
        if(number == 3)
        {
            Ability2onPokemon(pokemon1, pokemon2);
        }
    }

    public void Attack1onPokemon(Pokemon pokemon1, Pokemon pokemon2) throws IOException //for Pokemon vs Pokemon
    {
        if(pokemon1.getIs_stunned() == 1)
        {
            logger.PokemonStunned(pokemon1);
            pokemon1.setIs_stunned(0);
            logger.InfoAbilities(pokemon1);
            return;
        }

        //if pokemon2 dodges
        if(pokemon2.getDodges() != 0)
        {
            logger.dodged(pokemon2, pokemon1);
            pokemon2.setDodges(0);
            logger.InfoAbilities(pokemon1);
            return;
        }

        //if pokemon has normal attack
        if(pokemon1.getNormal_attack() != 0)
        {
            int damage = pokemon1.getNormal_attack() - pokemon2.getDefense();
            if(damage > 0)
            {
                logger.PokemonAtt1onPokemon(pokemon1, pokemon2, damage);
                pokemon2.setHP(pokemon2.getHP() - damage);
                logger.PokemonHP(pokemon2);
                if(pokemon2.getHP() < 0)
                {
                    return;
                }
            }
            else
            {
                logger.noDamage(pokemon1);
            }
        }

        //if pokemon has special attack
        if(pokemon1.getSpecial_attack() != 0)
        {
            int damage = pokemon1.getSpecial_attack() - pokemon2.getSpecial_defense();
            if(damage > 0)
            {
                logger.PokemonAtt1onPokemon(pokemon1, pokemon2, damage);
                pokemon2.setHP(pokemon2.getHP() - damage);
                logger.PokemonHP(pokemon2);
                if(pokemon2.getHP() < 0)
                {
                    return;
                }
            }
            else
            {
                logger.noDamage(pokemon1);
            }
        }
        logger.InfoAbilities(pokemon1);
    }

    public void Ability1onPokemon(Pokemon pokemon1, Pokemon pokemon2) throws IOException //for Pokemon vs Pokemon
    {
        if(pokemon1.getIs_stunned() == 1)
        {
            logger.PokemonStunned(pokemon1);
            pokemon1.setIs_stunned(0);
            logger.InfoAbilities(pokemon1);
            return;
        }
        //if second pokemon dodges
        if(pokemon2.getDodges() == 1)
        {
            logger.triedToUseAbility(pokemon1);
            pokemon2.setDodges(0);
            pokemon1.setCooldown1(pokemon1.getAbility_1().cd);
            logger.InfoAbilities(pokemon1);
            return;
        }
        logger.usedAbility1(pokemon1);
        //if is stun
        if(Objects.equals(pokemon1.getAbility_1().stun, "YES"))
        {
            pokemon2.setIs_stunned(1);
        }
        //if is dodge
        if(Objects.equals(pokemon1.getAbility_1().dodge, "YES"))
        {
            pokemon1.setDodges(1);
        }
        //damage
        pokemon2.setHP(pokemon2.getHP() - pokemon1.getAbility_1().dmg);
        logger.PokemonHP2(pokemon2);

        if(pokemon2.getHP() <= 0)
        {
            return;
        }

        //cooldown
        pokemon1.setCooldown1(pokemon1.getAbility_1().cd);
        logger.InfoAbilities(pokemon1);
    }

    public void Ability2onPokemon(Pokemon pokemon1, Pokemon pokemon2) throws IOException //for Pokemon vs Pokemon
    {
        if(pokemon1.getIs_stunned() == 1)
        {
            logger.PokemonStunned(pokemon1);
            pokemon1.setIs_stunned(0);
            logger.InfoAbilities(pokemon1);
            return;
        }
        //if second pokemon dodges
        if(pokemon2.getDodges() == 1)
        {
            logger.triedToUseAbility(pokemon1);
            pokemon2.setDodges(0);
            pokemon1.setCooldown2(pokemon1.getAbility_2().cd);
            logger.InfoAbilities(pokemon1);
            return;
        }
        logger.usedAbility2(pokemon1);
        //if is stun
        if(Objects.equals(pokemon1.getAbility_2().stun, "YES"))
        {
            pokemon2.setIs_stunned(1);
        }
        //if is dodge
        if(Objects.equals(pokemon1.getAbility_2().dodge, "YES"))
        {
            pokemon1.setDodges(1);
        }
        //damage
        pokemon2.setHP(pokemon2.getHP() - pokemon1.getAbility_2().dmg);
        logger.PokemonHP2(pokemon2);

        if(pokemon2.getHP() < 0)
        {
            return;
        }

        //cooldown
        pokemon1.setCooldown2(pokemon1.getAbility_2().cd);
        logger.InfoAbilities(pokemon1);
    }
}
