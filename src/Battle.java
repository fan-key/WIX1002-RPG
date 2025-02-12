import java.util.Random;
import java.util.ArrayList;
public class Battle {
    Battle(ArrayList<Hero> party, Hero enemy){
        Random rand = new Random();
        System.out.println("Battle Start!");
        int round = 1;
        while(true){
            for(Hero hero : party){
                if(hero.getIntialSpeed() == 0 && hero.getHp() > 0){
                    hero.attack(enemy);
                    System.out.println(hero.getElement() + " dealt " + hero.getAttack() + " damage to " + enemy.getElement());
                    if(enemy.getHp() <= 0){
                        System.out.println(enemy.getElement() + " has been defeated!");
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
                enemy.attack(party.get(target));
                System.out.println(enemy.getElement() + " dealt " + enemy.getAttack() + " damage to " + party.get(target).getElement());

                if(party.get(target).getHp() <= 0){
                    System.out.println(party.get(target).getElement() + " has been defeated!");
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
}
