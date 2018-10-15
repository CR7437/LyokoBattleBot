package Discord;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Config {
    private String TOKEN;
    private String PREFIX = "-"; //TODO move to config file later

    public String getPREFIX() {
        return PREFIX;
    }

    public Config() {
        try{
            File tokenfile = new File("token.txt"); //TODO move to YAML config file
            System.out.println(tokenfile);
            TOKEN = new Scanner(tokenfile).nextLine();
        }catch (FileNotFoundException k){
            k.printStackTrace();
        }
    }

    public String getTOKEN() {
        return TOKEN;
    }
}
