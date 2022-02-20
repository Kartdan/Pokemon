public class ItemFactory
{
    public Item checkItem(String string)
    {
        Item item;
        switch (string) {
            case "Scut" -> {
                item = new ItemBuilder().withName(string).withDefense(2).withSpecialDefense(2).build();
                return item;
            }
            case "Vestă" -> {
                item = new ItemBuilder().withName(string).withHP(10).build();
                return item;
            }
            case "Săbiuță" -> {
                item = new ItemBuilder().withName(string).withAttack(3).build();
                return item;
            }
            case "Baghetă Magică" -> {
                item = new ItemBuilder().withName(string).withSpecialAttack(3).build();
                return item;
            }
            case "Vitamine" -> {
                item = new ItemBuilder().withName(string).withHP(2).withAttack(2).withSpecialAttack(2).build();
                return item;
            }
            case "Brad de Crăciun" -> {
                item = new ItemBuilder().withName(string).withAttack(3).withDefense(1).build();
                return item;
            }
            case "Pelerină" -> {
                item = new ItemBuilder().withName(string).withSpecialDefense(3).build();
                return item;
            }
        }
        System.out.println(string);
        throw new IllegalArgumentException("Unknown item\n");
    }

    public void addItems(Trainer trainer, String[] list, int j)
    {
        for (String s : list)
        {
            trainer.pokemons.get(j).getItems().add(checkItem(s));
        }
    }
}
