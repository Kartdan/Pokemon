import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Fights
{
    Pokemon pokemon;
    Logger logger;

    public Fights(Pokemon pokemon, Logger logger)
    {
        this.pokemon = pokemon;
        this.logger = logger;
    }

    public int PokemonVsPokemon(Pokemon pokemon1, Pokemon pokemon2) throws CloneNotSupportedException, IOException, InterruptedException {
        logger.AnnouncePokVsPok(pokemon1, pokemon2);

        logger.PrintStats(pokemon1);
        logger.PrintStats(pokemon2);

        Pokemon pokemon_sub1 = (Pokemon)pokemon1.clone();
        Pokemon pokemon_sub2 = (Pokemon)pokemon2.clone();

        Random rand1 = new Random();
        Random rand2 = new Random();
        int randomAttack1, randomAttack2;

        //OBSERVER
        Subject subject = new Subject();
        subject.attach(pokemon_sub1);
        subject.attach(pokemon_sub2);


        while(pokemon_sub1.getHP() > 0 && pokemon_sub2.getHP() > 0)
        {
            //notify the observers
            subject.notifyAllObservers();

            //the type of attack
            randomAttack1 = rand1.nextInt((3 - 1) + 1) + 1;
            randomAttack2 = rand2.nextInt((3 - 1) + 1) + 1;

            //the threads
            AttackThread thread1 = new AttackThread(logger, pokemon_sub1, pokemon_sub2, randomAttack1);
            AttackThread thread2 = new AttackThread(logger, pokemon_sub2, pokemon_sub1, randomAttack2);

            thread1.start();
            thread1.join();

            if(pokemon_sub2.getHP() <= 0)
            {
                logger.PokemonWinsVsPokemon(pokemon_sub1, pokemon_sub2);
                logger.FinishedAdventure();
                return 1;
            }

            thread2.start();
            thread2.join();

        }

        if(pokemon_sub1.getHP() <= 0)
        {
            //the winner
            logger.PokemonWinsVsPokemon(pokemon2, pokemon1);

            //print the stats
            logger.separator();
            pokemon2.upStats(pokemon2);
            logger.PrintStats(pokemon2);
            logger.separator();

            logger.FinishedAdventure();

            return 2;
        }
        if(pokemon_sub2.getHP() <= 0)
        {
            //the winner
            logger.PokemonWinsVsPokemon(pokemon1, pokemon2);

            //print the stats
            logger.separator();
            pokemon1.upStats(pokemon1);
            logger.PrintStats(pokemon1);
            logger.separator();

            logger.FinishedAdventure();
            return 1;
        }
        return 0;
    }

    public void PokemonVsNeutrel1(Pokemon pokemon) throws CloneNotSupportedException, IOException {
        Neutrel1 neutrel1 = new Neutrel1();
        Pokemon pokemon_sub = (Pokemon)pokemon.clone();
        logger.PrintStats(pokemon);

        Random rand = new Random();
        int randomAttack;

        logger.vsNeutrel1(pokemon);

        while(neutrel1.hp > 0)
        {
            randomAttack = rand.nextInt((3 - 1) + 1) + 1;

            //Pokemon attacks Neutrel1
            PokAttacksNeutrel1(pokemon_sub, neutrel1, randomAttack);

            logger.DelimitateAttacks();
            //TimeUnit.MILLISECONDS.sleep(250);

            //now neutrel1 attacks
            Neutrel1Attacks(pokemon_sub, neutrel1);
        }

        //pokemon wins
        logger.PokemonWinsVsNeutrel(pokemon);

        //upgraded stats
        pokemon.upStats(pokemon);

        //print the new stats
        logger.PrintStats(pokemon);
    }

    public void PokemonVsNeutrel2(Pokemon pokemon) throws CloneNotSupportedException, IOException {
        Neutrel2 neutrel2 = new Neutrel2();
        Pokemon pokemon_sub = (Pokemon)pokemon.clone();

        Random rand = new Random();
        int randomAttack;

        logger.vsNeutrel2(pokemon);

        while(neutrel2.hp > 0)
        {
            randomAttack = rand.nextInt((3 -1) + 1) + 1;

            //Pokemon attacks Neutrel2
            PokAttacksNeutrel2(pokemon_sub, neutrel2, randomAttack);

            logger.DelimitateAttacks();
            //TimeUnit.MILLISECONDS.sleep(250);

            //now neutrel1 attacks
            Neutrel2Attacks(pokemon_sub, neutrel2);
        }

        //pokemon wins
        logger.PokemonWinsVsNeutrel(pokemon);

        //upgraded stats
        pokemon.upStats(pokemon);

        //print the new stats
        logger.PrintStats(pokemon);
    }

    public void PokAttacksNeutrel1(Pokemon pokemon, Neutrel1 neutrel1, int number) throws IOException {
        logger.DelimitateAttacks();
        if(pokemon.getCooldown1() > 0 && pokemon.getCooldown2() > 0)
        {
            Attack1onNeutrel1(pokemon, neutrel1);
            return;
        }

        //cooldown on first ability
        if(pokemon.getCooldown1() > 0)
        {
            Random rand = new Random();
            int randomAttack2 = rand.nextInt((2 - 1) + 1) + 1;
            if(randomAttack2 == 1)
            {
                Attack1onNeutrel1(pokemon, neutrel1);
                return;
            }
            Ability2onNeutrel1(pokemon, neutrel1);
            return;
        }

        //cooldown on second ability
        if(pokemon.getCooldown2() > 0)
        {
            Random rand = new Random();
            int randomAttack2 = rand.nextInt((2 - 1) + 1) + 1;
            if(randomAttack2 == 1)
            {
                Attack1onNeutrel1(pokemon, neutrel1);
                return;
            }
            Ability1onNeutrel1(pokemon, neutrel1);
            return;
        }

        //normal attack/special attack
        if(number == 1)
        {
            Attack1onNeutrel1(pokemon, neutrel1);
        }

        //ability 1
        if(number == 2)
        {
            Ability1onNeutrel1(pokemon, neutrel1);
        }

        //ability 2
        if(number == 3)
        {
            Ability2onNeutrel1(pokemon, neutrel1);
        }
    }

    public void PokAttacksNeutrel2(Pokemon pokemon, Neutrel2 neutrel2, int number) throws IOException {
        logger.DelimitateAttacks();
        if(pokemon.getCooldown1() > 0 && pokemon.getCooldown2() > 0)
        {
            Attack1onNeutrel2(pokemon, neutrel2);
            return;
        }

        //cooldown on first ability
        if(pokemon.getCooldown1() > 0)
        {
            Random rand = new Random();
            int randomAttack2 = rand.nextInt((2 - 1) + 1) + 1;
            if(randomAttack2 == 1)
            {
                Attack1onNeutrel2(pokemon, neutrel2);
                return;
            }
            Ability2onNeutrel2(pokemon, neutrel2);
            return;
        }

        //cooldown on second ability
        if(pokemon.getCooldown2() > 0)
        {
            Random rand = new Random();
            int randomAttack2 = rand.nextInt((2 - 1) + 1) + 1;

            if(randomAttack2 == 1)
            {
                Attack1onNeutrel2(pokemon, neutrel2);
                return;
            }
            Ability1onNeutrel2(pokemon, neutrel2);
            return;
        }

        //normal attack/special attack
        if(number == 1)
        {
            Attack1onNeutrel2(pokemon, neutrel2);
        }

        //ability 1
        if(number == 2)
        {
            Ability1onNeutrel2(pokemon, neutrel2);
        }

        //ability 2
        if(number == 3)
        {
            Ability2onNeutrel2(pokemon, neutrel2);
        }
    }

    public void Attack1onNeutrel1(Pokemon pokemon, Neutrel1 neutrel1) throws IOException {
        //if first ability is on cooldown
        if(pokemon.getCooldown1() != 0)
        {
            pokemon.setCooldown1(pokemon.getCooldown1() - 1);
        }
        //if second ability is on cooldown
        if(pokemon.getCooldown2() != 0)
        {
            pokemon.setCooldown2(pokemon.getCooldown2() - 1);
        }
        logger.InfoAbilities(pokemon);

        //if it's normal attack
        if(pokemon.getNormal_attack() != 0)
        {
            int damage = pokemon.getNormal_attack() - neutrel1.def;
            logger.attack1onNeutrel1(pokemon, damage);
            neutrel1.hp = neutrel1.hp - damage;
            logger.Neutrel1LoseHP(neutrel1);
        }

        //if it's special attack
        if(pokemon.getSpecial_attack() != 0)
        {
            int damage = pokemon.getSpecial_attack() - neutrel1.special_def;
            logger.spattack1onNeutrel(pokemon, damage);
            neutrel1.hp = neutrel1.hp - damage;
            logger.Neutrel1LoseHP(neutrel1);
        }
    }

    public void Attack1onNeutrel2(Pokemon pokemon, Neutrel2 neutrel2) throws IOException {
        //if the first ability is on cooldown
        if(pokemon.getCooldown1() != 0)
        {
            pokemon.setCooldown1(pokemon.getCooldown1() - 1);
        }

        //if the second ability is on cooldown
        if(pokemon.getCooldown2() != 0)
        {
            pokemon.setCooldown2(pokemon.getCooldown2() - 1);
        }
        logger.InfoAbilities(pokemon);

        //if it's normal attack
        if(pokemon.getNormal_attack() != 0)
        {
            int damage = pokemon.getNormal_attack() - neutrel2.def;
            logger.attack1onNeutrel1(pokemon, damage);
            neutrel2.hp = neutrel2.hp - damage;
            logger.Neutrel2LoseHP(neutrel2);

        }

        //if it's special attack
        if(pokemon.getSpecial_attack() != 0)
        {
            int damage = pokemon.getSpecial_attack() - neutrel2.special_def;
            logger.spattack1onNeutrel(pokemon, damage);
            neutrel2.hp = neutrel2.hp - damage;
            logger.Neutrel2LoseHP(neutrel2);
        }
    }

    public void Ability1onNeutrel1(Pokemon pokemon, Neutrel1 neutrel1) throws IOException {
        logger.usedAbility1(pokemon);

        //if second ability is on cooldown
        if(pokemon.getCooldown2() != 0)
        {
            pokemon.setCooldown2(pokemon.getCooldown2() - 1);
        }

        //if it's stun
        if(Objects.equals(pokemon.getAbility_1().stun, "YES"))
        {
            neutrel1.isStunned = 1;
        }

        //if it's dodge
        if(Objects.equals(pokemon.getAbility_1().dodge, "YES"))
        {
            neutrel1.miss = 1;
        }

        //cooldown
        pokemon.setCooldown1(pokemon.getAbility_1().cd);
        logger.InfoAbilities(pokemon);

        //damage
        neutrel1.hp -= pokemon.getAbility_1().dmg;
        logger.Neutrel1LoseHP(neutrel1);
    }

    public void Ability1onNeutrel2(Pokemon pokemon, Neutrel2 neutrel2) throws IOException {
        logger.usedAbility1(pokemon);

        //if second ability is on cooldown
        if(pokemon.getCooldown2() != 0)
        {
            pokemon.setCooldown2(pokemon.getCooldown2() - 1);
        }

        //if it's stun
        if(Objects.equals(pokemon.getAbility_1().stun, "YES"))
        {
            neutrel2.isStunned = 1;
        }

        //if it's dodge
        if(Objects.equals(pokemon.getAbility_1().dodge, "YES"))
        {
            neutrel2.miss = 1;
        }

        //cooldown
        pokemon.setCooldown1(pokemon.getAbility_1().cd);
        logger.InfoAbilities(pokemon);

        //damage
        neutrel2.hp -= pokemon.getAbility_1().dmg;
        logger.Neutrel2LoseHP(neutrel2);
    }

    public void Ability2onNeutrel1(Pokemon pokemon, Neutrel1 neutrel1) throws IOException {
        logger.usedAbility2(pokemon);

        //if first ability is on cooldown
        if(pokemon.getCooldown1() != 0)
        {
            pokemon.setCooldown1(pokemon.getCooldown1() - 1);
        }

        //if it's stun
        if(Objects.equals(pokemon.getAbility_2().stun, "YES"))
        {
            neutrel1.isStunned = 1;
        }

        //if it's dodge
        if(Objects.equals(pokemon.getAbility_2().dodge, "YES"))
        {
            neutrel1.miss = 1;
        }

        //cooldown
        pokemon.setCooldown2(pokemon.getAbility_2().cd);
        logger.InfoAbilities(pokemon);

        //damage
        neutrel1.hp -= pokemon.getAbility_2().dmg;
        logger.Neutrel1LoseHP(neutrel1);
    }

    public void Ability2onNeutrel2(Pokemon pokemon, Neutrel2 neutrel2) throws IOException {
        logger.usedAbility2(pokemon);

        //if first ability is on cooldown
        if(pokemon.getCooldown1() != 0)
        {
            pokemon.setCooldown1(pokemon.getCooldown1() - 1);
        }

        //if it's stun
        if(Objects.equals(pokemon.getAbility_2().stun, "YES"))
        {
            neutrel2.isStunned = 1;
        }

        //if it's dodge
        if(Objects.equals(pokemon.getAbility_2().dodge, "YES"))
        {
            neutrel2.miss = 1;
        }

        //cooldown
        pokemon.setCooldown2(pokemon.getAbility_2().cd);
        logger.InfoAbilities(pokemon);

        //damage
        neutrel2.hp -= pokemon.getAbility_2().dmg;
        logger.Neutrel2LoseHP(neutrel2);
    }

    public void Neutrel1Attacks(Pokemon pokemon, Neutrel1 neutrel1) throws IOException {
        if(neutrel1.hp <= 0)
        {
            return;
        }
        if(neutrel1.isStunned == 1)
        {
            neutrel1.isStunned = 0;
            neutrel1.miss = 0;
            logger.NeutrelisStunned();
            return;
        }
        if(neutrel1.miss == 1)
        {
            neutrel1.miss = 0;
            logger.Neutrel1Miss();
            return;
        }
        {
            if(neutrel1.normal_attack > pokemon.getDefense())
            {
                int damage = neutrel1.normal_attack - pokemon.getDefense();
                pokemon.setHP(pokemon.getHP() - damage);
                logger.NeutrelAttacks(pokemon, damage);
                logger.PokemonHP(pokemon);
            }
            else
            {
                logger.NeutrelAttackTooLow();
            }
        }

    }

    public void Neutrel2Attacks(Pokemon pokemon, Neutrel2 neutrel2) throws IOException {
        if(neutrel2.hp <= 0)
        {
            return;
        }
        if(neutrel2.isStunned == 1)
        {
            neutrel2.isStunned = 0;
            neutrel2.miss = 0;
            logger.NeutrelisStunned();
            return;
        }
        if(neutrel2.miss == 1)
        {
            neutrel2.miss = 0;
            logger.Neutrel1Miss();
            return;
        }
        {
            if(neutrel2.normal_attack > pokemon.getDefense())
            {
                int damage = neutrel2.normal_attack - pokemon.getDefense();
                pokemon.setHP(pokemon.getHP() - damage);
                logger.NeutrelAttacks(pokemon, damage);
                logger.PokemonHP(pokemon);
            }
            else
            {
                logger.NeutrelAttackTooLow();
            }
        }

    }

}
