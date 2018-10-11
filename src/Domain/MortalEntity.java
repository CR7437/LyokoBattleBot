package Domain;

/**
 * Created by jack on 9/27/18.
 */
//TODO: make toString and use that for log output
public class MortalEntity {
    private int health;
    private final int HEALTHCAP;
    private int maxHealth;

    public MortalEntity(int health, int maxHealth, int healthcap) {
        this.maxHealth = maxHealth;
        this.HEALTHCAP = healthcap;
        if (health > HEALTHCAP){
            System.out.print(String.format("Entity had %d HP assigned but the max is %d, lowering automatically",health));
            this.health = HEALTHCAP;
        }else {
            this.health = health;
        }
    }
    public MortalEntity(int fullhealth, int healthcap){
        this(fullhealth,fullhealth,healthcap);
    }

    public int getHealth() {
        return health;
    }

    public int getHEALTHCAP() {
        return HEALTHCAP;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void heal(int ammount){
        if ((health+ammount) >= maxHealth){
            health = maxHealth;
        }else {
            health += ammount;
        }
    }
    public void kill(){
        health = 0;
    }

    public void heal(){
        heal(maxHealth);
    }
    public void hurt(int damage){
        if (isDead()){
            System.out.print(String.format("is dead already, why you hurting them?"));
        }else {
            if (damage >= health){
                kill();
            }else {
                health =- damage;
            }
        }
    }

    public boolean isDead(){
        if (health <= 0){
            return true;
        }else {
            return false;
        }
    }


}
