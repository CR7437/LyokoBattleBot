package Logic;

import Logic.Enums.ATTACKS;
import Logic.Enums.LYOKOCLASS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public class Lyokowarrior extends MortalEntity{
    private String username;
    private int level;
    private LYOKOCLASS lyokoclass;
    private static int LEVELXP = 1000;
    private int xp;
    private static final int HEALTHCAP = 1000;
    private static final int STARTHEALTH = 50;
    public Lyokowarrior(String username,LYOKOCLASS lyokoclass){
        super(STARTHEALTH,HEALTHCAP);
        this.username = username;
        this.level = 1;
        this.lyokoclass = lyokoclass;
    }

    public Lyokowarrior(String username,LYOKOCLASS lyokoclass,int level, int health){
        super(health,health,HEALTHCAP); //TODO DEFINITELY MAKE A FORMULA FOR MAXHEALTH
        this.username = username;
        this.level = level;
        this.lyokoclass = lyokoclass;
    }


    public int getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
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
