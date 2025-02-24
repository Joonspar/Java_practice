package joonseo.chap08;

public class Triangle extends Shape implements Resizable {

    private int base;
    private int height;
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int base, int height, int side1, int side2, int side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea(){
        return (base*height) / 2;
    }

    @Override
    public double calculatePerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public void resize(double factor){
        this.base *= factor;
        this.height *= factor;
        this.side1 *= factor;
        this.side2 *= factor;
        this.side3 *= factor;
    }
}
