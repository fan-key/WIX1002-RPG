import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList <Hero> party = new ArrayList<Hero>();
        party.add(new Hero("Natsu",105, 10, 2, "Fire", 15));
        party.add( new Hero("Juvia",100, 10, 5, "Water", 10));
        party.add( new Hero("Wendy",100, 50, 10, "Wind", 5));
        party.add(new Hero("Sting", 200, 20, 3, "Light", 15));

        ArrayList <Item> items = new ArrayList<Item>();
        items.add(new Item("Potion", "Heals 50 HP", 50, 2));
        items.add(new Item("Ether", "Increases attack by 15", 15, 5));
        items.add(new Item("Elixir", "Increases defense by 10", 10, 5));

        Hero enemy = new Hero("Zeref",1000, 35, 5, "Darkness", 12);


        System.out.println(enemy.toString());
        System.out.println();
        
        for(Hero hero : party){
            System.out.println(hero.toString());
            System.out.println();
        }

        Battle battle = new Battle(party, enemy, items);

        System.out.println(enemy.toString());
        System.out.println();

        for(Hero hero : party){
            System.out.println(hero.toString());
            System.out.println();
        }

    }
}
