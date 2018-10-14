package Application;

public class Checker {

    public static int checkNumber(String number) throws NumberFormatException {
        int retNumber;
        try { retNumber = Integer.parseInt(number);}
        catch (NumberFormatException e){ throw e; }
        return retNumber;
    }
}
