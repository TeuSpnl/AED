public class Ponto {
    public int x, y;

    public Ponto() {
        setPonto(0, 0);
    }

    public Ponto(int x, int y) {
        setPonto(x, y);
    }

    public void setPonto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "[" + getX() + "," + getY() + "]";
    }
}
