import java.util.Collections;
import java.util.Locale;
import java.util.ArrayList;

public class NumberConverter {

    private final ArrayList<String> num_bank;
    private static ArrayList<Record> records;

    public NumberConverter() {
        num_bank = new ArrayList<>();
        String[] bank = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Collections.addAll(num_bank, bank);
        records = new ArrayList<>();
    }

    public void ConvertTo10(String num, int base, int new_base) {
        Record new_record = new Record();
        new_record.setNum_before(num);
        new_record.setOld_base(base);
        new_record.setNew_base(new_base);
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
                    new_record.setNum_after(convertToNewBase(total, new_base));
                    records.add(new_record);
                } else if (count == 1) {
                    String number = num.substring(0, num.indexOf("."));
                    String decimal = num.substring(num.indexOf(".")+1);
                    int total1 = 0;
                    for (int i = 0; i < number.length(); i++) total1 += (num_bank.indexOf(number.substring(number.length()-i-1, number.length()-i)) * Math.pow(base, i));
                    float total2 = 0;
                    for (int i = 0; i < decimal.length(); i++) total2 += (num_bank.indexOf(decimal.substring(decimal.length()-i-1, decimal.length()-i)) * Math.pow(base, i-1));
                    total = total1 + total2;
                    new_record.setNum_after(convertToNewBase(total, new_base));
                    records.add(new_record);
                } else { ///Illegal expression
                    System.out.println("Expression: "+num+" contains more than one full stop.");
                }
            }
        } else {
            System.out.println("String "+num+" contains non-numbers");
        }
    }

    public String convertToNewBase(float total, int new_base) {
        ArrayList<Double> powers = new ArrayList<>();
        int count = 0;
        while (Math.pow(new_base, count) < total) {
            powers.add(Math.pow(new_base, count));
            ++count;
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < powers.size(); i++) {
            int current_total = 0;
            int val = 0;
            do {
                current_total += powers.get(powers.size()-i-1);
                ++val;
            } while (current_total <= total);
            --val;
            total -= powers.get(powers.size()-i-1)*val;
            ret.append(num_bank.get(val));
        }
        System.out.println(ret);
        return String.valueOf(ret);
    }

    public void displayRecords() {
        for (Record rec : records) {
            System.out.println("Num before: "+rec.getNum_before()+" (Base: "+rec.getOld_base()+"), Num after: "+rec.getNum_after()+" (Base: "+rec.getNew_base()+").");
        }
    }
}