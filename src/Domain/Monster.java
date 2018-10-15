package Domain;

import Domain.Enums.MATTACKS;
import Domain.Enums.MONSTERCLASS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ten on 10/12/18.
 */

public class Monster extends MortalEntity{
    private int level; //TODO should monsters have levels?
    private MONSTERCLASS monsterclass;
    private static final int HEALTHCAP = 1000;
    private static final int STARTHEALTH = 50;

    public Monster(MONSTERCLASS monsterclass){ //TODO additional constructors for monster levels?
        super(STARTHEALTH,HEALTHCAP);
        this.level = 1;
        this.monsterclass = monsterclass;
    }

    public MONSTERCLASS getMonsterclass() {
        return monsterclass;
    }

    public List<MATTACKS> getAttacks(){
        List<MATTACKS> attacks = new ArrayList<>();
        for (int i = 1; i <= level; i++) {
            attacks.addAll(monsterclass.getLevelMAttacks(i));
        }
        return attacks;
    }
    public String getName(){
        return monsterclass.getClass().getSimpleName();
    }
}
