import java.util.Collections;
import java.util.Locale;
import java.util.ArrayList;

public class NumberConverter {

    private final ArrayList<String> num_bank;

    public NumberConverter() {
        num_bank = new ArrayList<>();
        String[] bank = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Collections.addAll(num_bank, bank);
    }

    public void ConvertTo10(String num, int base) {
        if (num.matches("[0-9]+|.+")) {
            int max = 0;
            for (int i = 0; i < num.length(); i++) if (num_bank.indexOf(""+num.charAt(i)) > max) max = num_bank.indexOf(""+num.charAt(i));
            if (max > base-1) {
                System.out.println("The base you provided is too high for the number provided, use base "+(max+1)+" or greater.");
            } else {
                long count = num.chars().filter(ch -> ch == '.').count();
                num = num.toUpperCase(Locale.ROOT);
                float total = 0;
                if (count == 0) { ///no decimal component
                    for (int i = 0; i < num.length(); i++) total += (num_bank.indexOf(num.substring(num.length()-i-1,num.length()-i)) * Math.pow(base, i));
                    System.out.println(total);
                } else if (count == 1) {
                    String number = num.substring(0, num.indexOf("."));
                    String decimal = num.substring(num.indexOf(".")+1);
                    int total1 = 0;
                    for (int i = 0; i < number.length(); i++) total1 += (num_bank.indexOf(number.substring(number.length()-i-1, number.length()-i)) * Math.pow(base, i));
                    float total2 = 0;
                    for (int i = 0; i < decimal.length(); i++) total2 += (num_bank.indexOf(decimal.substring(decimal.length()-i-1, decimal.length()-i)) * Math.pow(base, i-1));
                    total = total1 + total2;
                    System.out.println(total);
                } else { ///Illegal expression
                    System.out.println("Expression: "+num+" contains more than one full stop.");
                }
            }
        } else {
            System.out.println("String "+num+" contains non-numbers");
        }
    }
}