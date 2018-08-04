package Logic;

import Logic.Enums.MATTACKS;
import Logic.Enums.MONSTERS;
import Logic.Enums.lyokowarrior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 8/4/18
 *
 * This class sets up the Monsters the player will face
 */
 
 public class XANAmonster
 {
	 private String name;
	 private int health;
     private int level;
     private MONSTERS monster;
     private int xp;
	 
	 public XANAmonster(String name, MONSTERS monster)
	 {
		 this.name = name;
		 int health = getMonsterHealth(name);
		 int level = getMonsterLevel(name);
		 this.monster = monster;
	 }
	 
	 public int getMonsterHealth(String name)
	 {
		 //yes, I know most of the monsters are 50hp, but that's how it is... strangely.
		 switch(name)
		 case "Manta": health = 50; break;
		 case "Creeper": health = 20; break;
		 case "Tarantula": health = 80; break;
		 case "Megatank": health = 50; break;
		 case "Krabe": health = 50; break;
		 case "Blok": health = 50; break;
		 case "FrelionLead": health = 50; break;
		 case "FrelionSide": health = 20; break;
		 case "Kankrelat": health = 50; break;
		 case "Kongre": health = 50; break;
		 case "Shark": health = 50; break;
		 case "Kalamar": health = 50; break;
		 default: system.out.println("Error: Unknown Monster"); health = 200; break;
		 
		 return health;
	 }
	 
	 public int getMonsterLevel(String name)
	 {
		 switch(name)
		 case "Manta": level = 6; break;
		 case "Creeper": level = 6; break;
		 case "Tarantula": level = 6; break;
		 case "Megatank": level = 5; break;
		 case "Krabe": level = 4; break;
		 case "Blok": level = 3; break;
		 case "FrelionLead": level = 2; break;
		 case "FrelionSide": level = 2; break;
		 case "Kankrelat": level = 1; break;
		 case "Kongre": level = 1; break;
		 case "Shark": level = 2; break;
		 case "Kalamar": level = 5; break;
		 default: system.out.println("Error: Unknown Monster"); level = 40; break;
		 
		 return level;
	 }
	 
	 public string getName()
	 {
		 return name;
	 }
	 
	 public boolean isDead()
	 {
		 if (health<=0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public void kill()
	 {
		 health = 0;
	 }
	 
	 public void hurt(int damage)
	 {
		 if(isDead())
		 {
			 System.out.println("The %s missed because nothing was there!",name);
		 }
		 else if(damage>=health)
		 {
			 kill();
		 }
		 else
		 {
			 health =- damage;
		 }
	 }
	 
	 public List<MATTACKS> getMAttacks()
	 {
        
        List<MATTACKS> mattacks = new ArrayList<>();
        for (int i = 1; i <= level; i++) 
		{
            attacks.addAll(MONSTERS.getLevelMAttacks(i));
        }
        return mattacks;
    }
	
	
 }