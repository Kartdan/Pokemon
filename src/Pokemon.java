import java.util.*;

public class Pokemon extends Observer implements Cloneable
{
    String name;
    private int HP;
    private int normal_attack;
    private int special_attack;
    private int defense;
    private int special_defense;
    private Ability ability_1;
    private Ability ability_2;

    private int cooldown1 = 0;
    private int cooldown2 = 0;

    private int is_stunned;
    private int dodges;
    private ArrayList<Item> items;

    //for observer
    public void update()
    {
        if(this.cooldown1 > 0)
        {
            this.cooldown1 --;
        }
        if(this.cooldown2 > 0)
        {
            this.cooldown2 --;
        }
    }


    public Pokemon(String nume, int HP, int normal_attack, int special_attack,
                   int defense, int special_defense, Ability ability_1, Ability ability_2)
    {
        this.name = nume;
        this.HP = HP;
        this.normal_attack = normal_attack;
        this.special_attack = special_attack;
        this.defense = defense;
        this.special_defense = special_defense;
        this.ability_1 = ability_1;
        this.ability_2 = ability_2;
        this.items = new ArrayList<>(3);
    }
    public Pokemon()
    {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getNormal_attack() {
        return normal_attack;
    }

    public void setNormal_attack(int normal_attack) {
        this.normal_attack = normal_attack;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public void setSpecial_defense(int special_defense) {
        this.special_defense = special_defense;
    }

    public int getIs_stunned() {
        return is_stunned;
    }

    public void setIs_stunned(int is_stunned) {
        this.is_stunned = is_stunned;
    }

    public Ability getAbility_1() {
        return ability_1;
    }

    public void setAbility_1(Ability ability_1) {
        this.ability_1 = ability_1;
    }

    public Ability getAbility_2() {
        return ability_2;
    }

    public void setAbility_2(Ability ability_2) {
        this.ability_2 = ability_2;
    }

    public int getCooldown1() {
        return cooldown1;
    }

    public void setCooldown1(int cooldown1) {
        this.cooldown1 = cooldown1;
    }

    public int getCooldown2() {
        return cooldown2;
    }

    public void setCooldown2(int cooldown2) {
        this.cooldown2 = cooldown2;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getDodges() {
        return dodges;
    }

    public void setDodges(int dodges) {
        this.dodges = dodges;
    }

    public void AddItemStats(Pokemon pokemon, Item item)
    {
        if(item.getHp() != 0)
        {
            pokemon.HP += item.getHp();
        }
        if(item.getAttack() != 0)
        {
            if(pokemon.normal_attack != 0)
            {
                pokemon.normal_attack += item.getAttack();
            }
        }
        if(item.getSpecial_attack() != 0)
        {
            if(pokemon.special_attack != 0)
            {
                pokemon.special_attack += item.getSpecial_attack();
            }
        }
        if(item.getDefense() != 0)
        {
            pokemon.defense += item.getDefense();
        }
        if(item.getSpecial_defense() != 0)
        {
            pokemon.special_defense += item.getSpecial_defense();
        }
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public void upStats(Pokemon pokemon)
    {
        pokemon.HP ++;
        if(pokemon.normal_attack != 0)
        {
            pokemon.normal_attack++;
        }
        else
        {
            pokemon.special_attack++;
        }
        pokemon.defense ++;
        pokemon.special_defense ++;
    }

    public int TotalStats(Pokemon pokemon)
    {
        int sum = 0;
        sum += pokemon.getHP();
        if(pokemon.getNormal_attack() > 0)
        {
            sum += pokemon.getNormal_attack();
        }
        else
        {
            sum += pokemon.getSpecial_attack();
        }
        sum += pokemon.getDefense();
        sum += pokemon.getSpecial_defense();

        return sum;
    }
}
