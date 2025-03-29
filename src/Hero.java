public class Hero {
    String name;
    double maxHp;
    double hp;
    double attack;
    double defense;
    String element;
    int intialSpeed = 100;
    int speed;

    Hero(String name ,double hp, double attack, double defense, String element, int speed){
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.element = element;
        this.speed = speed;   
    }

    public void useItem(Item item){
        item.use(this);
    }

    public void getDamage(double damage){
        hp -= damage;
        if(hp < 0){
            hp = 0;
        }
    }

    public void resetInitialSpeed(){
        intialSpeed = 100;
    }

    public void reduceSpeed(){
        intialSpeed -= speed;
        if(intialSpeed < 0){
            intialSpeed = 0;
        }   
    }

    public void heal(double heal){
        hp += heal;
    }



    public void setHp(double hp){
        this.hp = hp;
    }



    public void setAttack(double attack){
        this.attack = attack;
    }

    public void setDefense(double defense){
        this.defense = defense;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }   

    public String getName(){
        return name;
    }

    public double getHp(){
        return hp;
    }

    public double getMaxHp(){
        return maxHp;
    }

    public double getAttack(){
        return attack;
    }

    public double getDefense(){
        return defense;
    }

    public String getElement(){
        return element;
    }   

    public int getSpeed(){
        return speed;
    }

    public int getIntialSpeed(){
        return intialSpeed;
    }

    public String toString(){
        return "Name: " + name + "\nHP: " + hp + "\nAttack: " + attack + "\nDefense: " + defense + "\nElement: " + element + "\nSpeed: " + speed;
    }
}
