import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Battle {

    ArrayList<Item> items;

    Battle(ArrayList<Hero> party, Hero enemy, ArrayList<Item> items){
        this.items = items;
        Random rand = new Random();
        System.out.println("Battle Start!");
        int round = 1;
        while(true){
            double damage = 0;
            for(Hero hero : party){
                if(hero.getIntialSpeed() == 0 && hero.getHp() > 0){
                    action(hero, enemy);
                    if(enemy.getHp() <= 0){
                        System.out.println(enemy.getName() + " has been defeated!");
                        enemy.setHp(0);
                        return;
                    }
                    hero.resetInitialSpeed();
                }
                else{
                    hero.reduceSpeed();
                }
                
            }

            if(enemy.getIntialSpeed() == 0 && enemy.getHp() > 0){
                int target = rand.nextInt(party.size());
                damage = enemy.getAttack() - party.get(target).getDefense();
                party.get(target).getDamage(damage);
                System.out.println("\n" + enemy.getName() + " dealt " + damage   + " damage to " + party.get(target).getName());
                System.out.println(party.get(target).getName() + " HP: " + party.get(target).getHp());

                if(party.get(target).getHp() <= 0){
                    System.out.println(party.get(target).getName() + " has been defeated!");
                    party.remove(target);
    
                }

                enemy.resetInitialSpeed();
            }
            else{
                enemy.reduceSpeed();
            }


            if(party.size() == 0){
                System.out.println("Party has been defeated!");
                return;
            }

        }
    }

    public void action(Hero hero, Hero enemy ){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("\n"+hero.getName() + "'s turn!");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("Choice: ");
            choice = sc.nextInt();

        switch (choice) {
            case 1:
                double damage = hero.getAttack() - enemy.getDefense();
                enemy.getDamage(damage);
                System.out.println(hero.getName() + " dealt " + damage + " damage to " + enemy.getName());
                System.out.println(enemy.getName() + " HP: " + enemy.getHp());
                break;
            
            case 2: 
                int itemChoice = 0;

                if(items.get(0).getQuantity() == 0 && items.get(1).getQuantity() == 0 && items.get(2).getQuantity() == 0){
                    System.out.println("You have no more items left!");
                    break;
                }
                do{ 
                    System.out.println("Items: ");
                    for(Item item : items){
                        System.out.println((items.indexOf(item)+1) + ". " + item.getName() + " - " + item.getDescription() + " x" + item.getQuantity());
                    }
                    System.out.println("Choice: ");
                    itemChoice = sc.nextInt();

                    if(items.get(itemChoice-1).getQuantity() == 0){
                        System.out.println("You have no more " + items.get(itemChoice-1).getName() + " left!");
                    }

                }while(items.get(itemChoice-1).getQuantity() == 0);
                items.get(itemChoice-1).use(hero);
                
                break;
                

            default:
                break;
        }
        }while(choice != 1 && choice != 2);
        
    }
}
