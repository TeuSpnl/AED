public class huffLeaf extends huffBTree {
    public final char value;

    public  huffLeaf(int freq, char value){
        super(freq);
        this.value = value;
    }
}
