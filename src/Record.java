public class Record {

    private String num_before;
    private int old_base;
    private int new_base;
    private String num_after;

    public Record() {}

    public int getNew_base() {
        return new_base;
    }
    public int getOld_base() {
        return old_base;
    }
    public String getNum_after() {
        return num_after;
    }
    public String getNum_before() {
        return num_before;
    }

    public void setNew_base(int new_base) {
        this.new_base = new_base;
    }
    public void setNum_after(String num_after) {
        this.num_after = num_after;
    }
    public void setNum_before(String num_before) {
        this.num_before = num_before;
    }
    public void setOld_base(int old_base) {
        this.old_base = old_base;
    }
}
