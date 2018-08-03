import Logic.Enums.ATTACKS;
import Logic.Enums.LYOKOCLASS;
import Logic.Lyokowarrior;

/**
 * Created by jack on 8/3/18.
 */
public class Main {
    public static void main(String[] args) {
        Lyokowarrior lyokowarrior = new Lyokowarrior("Jack", LYOKOCLASS.SAMURAI);
        System.out.println("At creation:");
        System.out.println("Level: "+lyokowarrior.getLevel());
        System.out.println("XP: "+lyokowarrior.getXp());
        System.out.println("Attacks: ");
        for (ATTACKS attack:lyokowarrior.getAttacks()){
            System.out.println(attack.toString());
        }
        System.out.println("------------------------");
        System.out.println("added 1500xp");
        lyokowarrior.addXP(1500);
        System.out.println("------------------------");

        System.out.println("Level: "+lyokowarrior.getLevel());
        System.out.println("XP: "+lyokowarrior.getXp());
        System.out.println("Attacks: ");
        for (ATTACKS attack:lyokowarrior.getAttacks()){
            System.out.println(attack.toString());
        }

        System.out.println("------------------------");
        System.out.println("added 1500xp");
        lyokowarrior.addXP(1500);
        System.out.println("------------------------");

        System.out.println("Level: "+lyokowarrior.getLevel());
        System.out.println("XP: "+lyokowarrior.getXp());
        System.out.println("Attacks: ");
        for (ATTACKS attack:lyokowarrior.getAttacks()){
            System.out.println(attack.toString());
        }

    }
}
