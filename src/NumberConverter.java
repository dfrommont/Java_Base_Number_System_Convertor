public class NumberConverter {

    public NumberConverter() {}

    public void ConvertTo10(String num, int base) {
        if (num.matches("[0-9]+|.+")) {
            long count = num.chars().filter(ch -> ch == '.').count();
            float total = 0;
            if (count == 0) { ///no decimal component
                for (int i = 0; i < num.length(); i++) {
                    total += Integer.parseInt(num.substring(num.length()-i-1,num.length()-i)) * Math.pow(base, i);
                }
                System.out.println(total);
            } else if (count == 1) {
                String number = num.substring(0, num.indexOf("."));
                String decimal = num.substring(num.indexOf(".")+1);
                int total1 = 0;
                for (int i = 0; i < number.length(); i++) {
                    total1 += Integer.parseInt(number.substring(number.length()-i-1,number.length()-i)) * Math.pow(base, i);
                }
                float total2 = 0;
                for (int i = 0; i < decimal.length(); i++) {
                    total2 += Integer.parseInt(decimal.substring(i, i+1)) * Math.pow(base, -i-1);
                }
                total = total1 + total2;
                System.out.println(total);
            } else { ///Illegal expression
                System.out.println("Expression: "+num+" contains more than one full stop.");
            }
        } else {
            System.out.println("String "+num+" contains non-numbers");
        }
    }
}

