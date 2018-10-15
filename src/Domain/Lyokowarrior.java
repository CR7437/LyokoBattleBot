package Domain;

import Domain.Enums.ATTACKS;
import Domain.Enums.LYOKOCLASS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public class Lyokowarrior extends MortalEntity implements LevelAble{
    private long id;
    private int level;
    private LYOKOCLASS lyokoclass;
    private static int LEVELXP = 1000;
    private int xp;
    private static final int HEALTHCAP = 1000;
    private static final int STARTHEALTH = 50;
    public Lyokowarrior(long id,LYOKOCLASS lyokoclass){
        super(STARTHEALTH,HEALTHCAP);
        this.id = id;
        this.level = 1;
        this.lyokoclass = lyokoclass;
    }

    public Lyokowarrior(long id,LYOKOCLASS lyokoclass,int level, int health){
        super(health,health,HEALTHCAP); //TODO DEFINITELY MAKE A FORMULA FOR MAXHEALTH
        this.id = id;
        this.level = level;
        this.lyokoclass = lyokoclass;
    }


    public int getLevel() {
        return level;
    }

    public long getId() {
        return id;
    }

    public int addXP(int ammount){
        if ((xp + ammount) >= LEVELXP){
            int remainder = (xp + ammount) - LEVELXP;
            levelUp();
            addXP(remainder);
        }else {
            xp+=ammount;
        }
        return xp;
    }

    public void levelUp(){
        level++;
        xp = 0;
        System.out.printf("%s levelled up! their level is now: %d\n", id,level);
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

    public LYOKOCLASS getLyokoclass() {return lyokoclass;}
}
