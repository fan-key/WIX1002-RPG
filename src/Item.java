public class Item {
    String name;
    String description;
    double effect;
    int quantity;

    Item(String name, String description, double effect, int quantity){
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.quantity = quantity;
    }

    public void use(Hero hero){
        if(name.equals("Potion")){
            if(quantity == 0){
                System.out.println("You have no more " + name + " left!");
                return; 
            }
            if(hero.getHp() + effect > hero.getMaxHp()){
                hero.setHp(hero.getMaxHp());
                System.out.println(hero.getName() + " healed to full HP!");
            }
            else{
                hero.heal(effect);
                System.out.println(hero.getName() + " healed " + effect + " HP!");
            }
            
            quantity--;
        }
        else if(name.equals("Ether")){
            if(quantity == 0){
                System.out.println("You have no more " + name + " left!");
                return;
            }
            hero.setAttack(hero.getAttack() + effect);
            System.out.println(hero.getName() + " attack increased by " + effect);
            quantity--;
        }
        else if(name.equals("Elixir")){
            if(quantity == 0){
                System.out.println("You have no more " + name + " left!");
                return;
            }
            hero.setDefense(hero.getDefense() + effect);
            System.out.println(hero.getName() + " defense increased by " + effect);
            quantity--;
        }
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getEffect(){
        return effect;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString(){
        return "\nName: " + name + "\nDescription: " + description + "\nEffect: " + effect + "\nQuantity: " + quantity;
    }
}
