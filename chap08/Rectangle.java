package joonseo.chap08;

public class Rectangle extends Shape implements Resizable {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2*width + 2*height;
    }

    @Override
    public void resize(double factor){
        this.width *= factor;
        this.height *= factor;
    }
}
