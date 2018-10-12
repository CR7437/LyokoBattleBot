package Domain;

import Domain.Enums.MONSTERCLASS;

/**
 * Created by ten on 10/12/18.
 */

public class Monster extends MortalEntity{
    private int level;
    private MONSTERCLASS monsterclass;
    private static final int HEALTHCAP = 1000;
    private static final int STARTHEALTH = 50;

    public Monster(MONSTERCLASS monsterclass){
        super(STARTHEALTH,HEALTHCAP);
        this.level = 1;
        this.monsterclass = monsterclass;
    }

    public MONSTERCLASS getMonsterclass() {
        return monsterclass;
    }
}
