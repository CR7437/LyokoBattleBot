package Logic;

import Logic.Enums.ATTACKS;
import Logic.Enums.LYOKOCLASS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public class Lyokowarrior {
    private String username;
    private int health;
    private static int MAXHEALTH = 100;
    private int level;
    private LYOKOCLASS lyokoclass;
    private static int LEVELXP = 1000;
    private int xp;

    public Lyokowarrior(String username,LYOKOCLASS lyokoclass){
        this.username = username;
        this.health = MAXHEALTH;
        this.level = 1;
        this.lyokoclass = lyokoclass;
    }

    public Lyokowarrior(String username,LYOKOCLASS lyokoclass,int level, int health){
        this.username = username;
        this.level = level;
        if (health > MAXHEALTH){
            System.out.print(String.format("Lyokowarrior %s had %d HP assigned but the max is %d, lowering automatically",username,health,MAXHEALTH));
            this.health = MAXHEALTH;
        }else {
            this.health = health;
        }
        this.lyokoclass = lyokoclass;
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


    public void addXP(int ammount){
        if ((xp + ammount) >= LEVELXP){
            int remainder = (xp + ammount) - LEVELXP;
            levelUp();
            addXP(remainder);
        }else {
            xp+=ammount;
        }
    }

    public void levelUp(){
        level++;
        xp = 0;
        System.out.printf("%s levelled up! their level is now: %d\n",username,level);
    }

    public List<ATTACKS> getAttacks(){
        List<ATTACKS> attacks = new ArrayList<>();
        for (int i = 1; i <= level; i++) {
            attacks.addAll(lyokoclass.getLevelAttacks(i));
        }
        return attacks;
    }

    public int getXp() {
        return xp;
    }
}
