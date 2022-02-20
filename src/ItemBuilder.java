public class ItemBuilder
{
    private final Item item = new Item();

    public Item build(){return item;}

    public ItemBuilder withName(String name)
    {
        item.setName(name);
        return this;
    }
    public ItemBuilder withHP(int hp)
    {
        item.setHp(hp);
        return this;
    }
    public ItemBuilder withAttack(int attack)
    {
        item.setAttack(attack);
        return this;
    }
    public ItemBuilder withSpecialAttack(int specialAttack)
    {
        item.setSpecial_attack(specialAttack);
        return this;
    }
    public ItemBuilder withDefense(int defense)
    {
        item.setDefense(defense);
        return this;
    }
    public ItemBuilder withSpecialDefense(int specialDefense)
    {
        item.setSpecial_defense(specialDefense);
        return this;
    }
}
