package Logic;

/**
 * Created by jack on 8/3/18.
 */
public class Lyokowarrior {
    private String username;
    private int health;
    private static int MAXHEALTH = 100;
    private int level;


    public Lyokowarrior(String username){
        this.username = username;
        this.health = MAXHEALTH;
        this.level = 1;
    }

    public Lyokowarrior(String username,int level, int health){
        this.username = username;
        this.level = level;
        if (health > MAXHEALTH){
            System.out.print(String.format("Lyokowarrior %s had %d HP assigned but the max is %d, lowering automatically",username,health,MAXHEALTH));
            this.health = MAXHEALTH;
        }else {
            this.health = health;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
    }


    public boolean isDead(){
        if (health <= 0){
            return true;
        }else {
            return false;
        }
    }
    public void kill(){
        health = 0;
    }

    public void hurt(int damage){
        if (isDead()){
            System.out.print(String.format("%s is dead already, why you hurting them?",username));
        }else {
            if (damage >= health){
                kill();
            }else {
                health =- damage;
            }
        }
    }

    public void heal(int ammount){
        if ((health+ammount) >= MAXHEALTH){
            health = MAXHEALTH;
        }else {
            health += ammount;
        }
    }
    public void heal(){
        heal(MAXHEALTH);
    }

}
