package Discord;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Config {
    public Config (){
        try{
            File tokenfile = new File("./src/Application/token.txt");
            System.out.println(tokenfile);
            String token = new Scanner(tokenfile).nextLine();
        }catch (FileNotFoundException k){
            k.printStackTrace();
            return;
        }
    }
}
