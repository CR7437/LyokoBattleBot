package Logic.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jack on 8/3/18.
 * Adapted to XANA's Monsters by Chris on 8/3/18
 */
public enum MONSTERCLASS {
    Manta(Arrays.asList(MATTACKS.TACKLE, MATTACKS.TOSS, MATTACKS.mantaLASER, MATTACKS.mantaCRAZY)),
    Creeper(Arrays.asList(MATTACKS.TOSS, MATTACKS.cLASER)),
    Tarantula(Arrays.asList(MATTACKS.TACKLE, MATTACKS.TOSS, MATTACKS.tLASER, MATTACKS.tCHARGE, MATTACKS.tSLAM)),
    Megatank(Arrays.asList(MATTACKS.TACKLE, MATTACKS.mLASER, MATTACKS.mROLL)),
    Krabe(Arrays.asList(MATTACKS.TACKLE, MATTACKS.TOSS, MATTACKS.krabLASER, MATTACKS.krabVENTRAL)),
    Blok(Arrays.asList(MATTACKS.TACKLE, MATTACKS.TOSS, MATTACKS.bLASER, MATTACKS.bFIRE, MATTACKS.bICE)),
    Frelion(Arrays.asList(MATTACKS.TACKLE, MATTACKS.fLASER, MATTACKS.fTOXIC)),
    Kankrelat(Arrays.asList(MATTACKS.TACKLE, MATTACKS.kankLASER)),
    Kongre(Arrays.asList(MATTACKS.TACKLE, MATTACKS.kongLASER)),
    Shark(Arrays.asList(MATTACKS.TACKLE, MATTACKS.sTORPEDO)),
    Kalamar(Arrays.asList(MATTACKS.TACKLE, MATTACKS.kalaDRILL));


    private final List<MATTACKS> mattacks;

    MONSTERCLASS(List<MATTACKS> mattacks) {
        this.mattacks = mattacks;
    }

    public List<MATTACKS> getMattacks() {
        return mattacks;
    }

    public List<MATTACKS> getLevelMAttacks(int level) {
        List<MATTACKS> mattacks = new ArrayList<>();
        for (MATTACKS mattack : getMattacks()) {
            if (mattack.getLevel() == level) {
                mattacks.add(mattack);
            }
        }
        return mattacks;
    }
}



