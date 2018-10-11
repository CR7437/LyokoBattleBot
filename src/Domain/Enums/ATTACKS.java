package Domain.Enums;

/**
 * Created by jack on 8/3/18.
 */
public enum ATTACKS {
    KATANASTRIKE("KatanaStrike",3,10),
    IMPACT("Impact",1,5),
    ENERGYSHIELD("EnergyShield",1,5),
    FANSTRIKE("FanStrike",1,5),
    LASERARROW("LaserArrow",1,5);


    private final int damage;
    private final int level;
    private final String name;
    ATTACKS(String name,int level, int damage){
        this.level = level;
        this.damage = damage;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("--%s--\nDamage: %d\nLevel: %d",name,damage,level);
    }


    public String getName(){
        return name;
    }
}
