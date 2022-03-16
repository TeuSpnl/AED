public class Cilindro extends Circulo {
    public double altura, area, volume;


    public Cilindro() {}

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        setArea();
    }

    public void setArea() {
        this.area = 2 * super.getArea() + 2 * Math.PI * super.getRaio() * altura;
        setVolume();
    }

    public double getArea() {
        return this.area;
    }

    public void setVolume() {
        this.volume = getArea() * altura;
    }

    public double getVolume() {
        return this.volume;
    }

    public String toString(){
        return super.toString() + 
                "\nVolume: " + getVolume();
    }
}
