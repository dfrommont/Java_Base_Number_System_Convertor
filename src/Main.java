public class Main {

    public static void main(String[] args) {
        NumberConverter conv = new NumberConverter();
        conv.ConvertTo10("9999999", 10, 36);
        conv.ConvertTo10("110100010", 2, 10);
        conv.ConvertTo10("99", 6, 11);
        conv.displayRecords();
    }
}

