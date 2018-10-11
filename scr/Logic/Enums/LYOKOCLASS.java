package Logic.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 */
public enum  LYOKOCLASS {
    SAMURAI(Arrays.asList(ATTACKS.IMPACT,ATTACKS.KATANASTRIKE)),
    FELINE(Arrays.asList(ATTACKS.LASERARROW)),
    GEISHA(Arrays.asList(ATTACKS.FANSTRIKE)),
    ANGEL(Arrays.asList(ATTACKS.ENERGYSHIELD));



    private final List<ATTACKS> attacks;
    LYOKOCLASS(List<ATTACKS> attacks){
        this.attacks = attacks;
    }
    public List<ATTACKS> getAttacks(){
        return attacks;
    }

    public List<ATTACKS> getLevelAttacks(int level){
        List<ATTACKS> attacks = new ArrayList<>();
        for (ATTACKS attack:getAttacks()) {
            if (attack.getLevel() == level){
                attacks.add(attack);
            }
        }
        return attacks;
    }





}
