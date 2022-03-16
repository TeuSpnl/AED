public class Circulo extends Ponto {

    public double raio, area;

    public Circulo() {}

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
        setArea();
    }

    public void setArea() {
        this.area = Math.PI * (raio * raio);
    }
    
    public double getArea(){
        return this.area;        
    }

    public String toString() {
        String strArea = String.format("%.2f", getArea());

        return "Centro: " + super.toString() +
                "\nRaio: " + getRaio() +
                "\nÁrea: " + strArea;
    }

}
