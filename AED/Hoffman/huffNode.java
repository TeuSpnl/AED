class huffNode extends huffBTree{
    public final huffBTree lChild, rChild;

    public huffNode(huffBTree lChild, huffBTree rChild){
        super(lChild.freq + rChild.freq);

        this.lChild = lChild;
        this.rChild = rChild;
    }
}