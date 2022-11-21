import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class DataInput {

    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";    public static Long getLong() throws IOException{
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static Integer getInt(){
        String s = "";
        try {
            while(true){
                s = getString();
                if(isNumeric(s)){
                    break;
                }else{
                    System.out.print("Non-int input, try again: ");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer value = Integer.valueOf(s);
        return value;

    }

    public static double getDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static Integer getIntInRange(int low, int high){
        String s = "";
        try {
            while(true){
                s = getString();
                if(isNumeric(s)){
                    if(Integer.valueOf(s) >= low && Integer.valueOf(s) <= high){
                        break;
                    }else{
                        System.out.print(ANSI_RED + "Incorrect input" + RESET + "\nRetry: ");
                    }
                }else{
                    System.out.print(ANSI_RED + "Incorrect input" + RESET + "\nRetry: ");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer value = Integer.valueOf(s);

        return value;
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String getAlphabeticString(){
        String s;
        try {
            while(true){
                s = getString();
                if(isAlphabetic(s)) {
                    return s;
                }else{
                    System.out.print("You can only input characters from english alphabet, try again: ");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isAlphabetic(String input){
        input = input.toLowerCase();
        for(int i = 0;i<input.length();i++){
            if(!(input.charAt(i) >= 97 && input.charAt(i) <= 122) && input.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }

}