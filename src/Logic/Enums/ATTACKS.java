package Logic.Enums;

/**
 * Created by jack on 8/3/18.
 */
public enum ATTACKS {
    KATANASTRIKE(3,10),
    IMPACT(1,5),
    ENERGYSHIELD(1,5),
    FANSTRIKE(1,5),
    LASERARROW(1,5);


    private final int damage;
    private final int level;
    ATTACKS(int level, int damage){
        this.level = level;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }
}
