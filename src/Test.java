import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList <Hero> party = new ArrayList<Hero>();
        party.add(new Hero("Natsu",100, 10, 5, "Fire", 5));
        party.add( new Hero("Juvia",100, 10, 5, "Water", 5));
        party.add( new Hero("Wendy",100, 10, 5, "Wind", 5));
        Hero enemy = new Hero("Zeref",1000, 10, 5, "Darkness", 10);
        Battle battle = new Battle(party, enemy);

    }
}
