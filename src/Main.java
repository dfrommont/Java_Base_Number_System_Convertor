public class Main {

    public static void main(String[] args) {
        NumberConverter conv = new NumberConverter();
        conv.ConvertTo10("9999999", 10, 36);
        conv.displayRecords();
    }
}
