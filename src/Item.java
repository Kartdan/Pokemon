public class Item
{
    String name;
    int hp;
    int attack;
    int special_attack;
    int defense;
    int special_defense;

    public Item(String name, int hp, int attack, int special_attack, int defense, int special_defense)
    {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.special_attack = special_attack;
        this.defense = defense;
        this.special_defense = special_defense;
    }
    public Item()
    {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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
}
