package Domain.Enums;

/**
 * Created by jack on 8/3/18.
 * Adapted for monsters by Chris on 8/3/18
 */
public enum MATTACKS {
	//Manta Attacks
	mantaLASER("MantaLaser",6,40,false),
	mantaCRAZY("MantaCrazyLaser",6,999,false),
	//Creeper Attacks
	cLASER("CreeperLaser",6,40,false),
	//Tarantula Attacks
	tLASER("TarantulaLaser",6,30,false),
	tCHARGE("TarantulaChargedLaser",6,60,false),
	tSLAM("TarantulaCannonSlam",6,50,false),
	//Megatank Attacks
    mLASER("CircularLaser",5,50,true),
	mROLL("Bump",5,999,false),
	//Kalamar Attacks
	kalaDRILL("KalamarDrill",4,50,true),
	//Krabe Attacks
    krabLASER("KrabeLaser",4,40,false),
	krabVENTRAL("KrabeStomachLaser",4,999,false),
	//Blok Attacks
    bLASER("BlokLaser",3,20,false),
	bFIRE("BlokFlameWheel",3,30,false),
	bICE("BlokFreezeRay",3,10,false),
	//Frelion (Hornet) Attacks
    fLASER("FrelionShot",2,20,false),
	fTOXIC("FreloinToxin",2,10,true),
	//Kankrelat Attacks
    kankLASER("KankrelatShot",1,10,false),
	//Kongre
	kongLASER("KongreLaser",1,20,false),
	//Shark Attacks
	sTORPEDO("SharkTorpedo",1,20,false),
	
	//General Attacks
	//These attacks can be used by any monster aside from Kankrelats.
	TACKLE("Tackle",2,25,true),
	TOSS("RagdollToss",2,2,true);


    private final int damage;
    private final int level;
    private final String name;
	private final boolean tMULT;
    MATTACKS(String name,int level, int damage, boolean tMULT){
        this.level = level;
        this.damage = damage;
        this.name = name;
		this.tMULT = tMULT;
		//tMULT is boolean because certain attacks have the ability to gain damage over time (Blame v=d/t, not me)
		//Megatank Laser damage multiplication would be handled by the shield/dodge option, and damage multiplies by 0.5.
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("--%s--\nDamage: %d\nLevel: %d",name,damage,level,tMULT);
    }


    public String getName(){
        return name;
    }
	
	public boolean getTMULT(){
		return tMULT;
	}
}
