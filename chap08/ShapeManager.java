package joonseo.chap08;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index = 0;

    public void addShape(Shape shape) {
        if (index >= shapes.length) {
            Shape[] sh = new Shape[shapes.length * 2];
            System.arraycopy(shapes, 0, sh, 0, shapes.length);
            shapes = sh;
        }
        shapes[index++] = shape;
    }

    public void removeShape(Shape shape) {
        /* 배열에서 전달된 Shape를 찾아 제거. 단, 제거된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
        for (int i = 0; i < index; i++) {
            if (shapes[i] == shape) {
                for (int j = i; j < index - 1; j++) {
                    shapes[j] = shapes[j + 1];
                }
                shapes[index - 1] = null;
                index--;
            }
        }
    }

    public void printAllShapes() {
        /* 배열에 저장된 모든 도형의 이름, 넓이, 둘레를 출력 */
        for (int i = 0; i < index; i++) {
            System.out.println("Shape: " + shapes[i].getClass().getSimpleName());
            System.out.println("Area: " + shapes[i].calculateArea());
            System.out.println("Perimeter: " + shapes[i].calculatePerimeter());
            System.out.println("===========================");
        }
    }

    public double getTotalArea() {
        /* 배열에 저장된 모든 도형의 넓이를 더해서 반환 */
        double area = 0;
        for (int i = 0; i < index; i++) {
            area += shapes[i].calculateArea();
        }
        return area;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장된 모든 도형의 둘레를 더해서 반환 */
        double meter = 0;
        for (int i = 0; i < index; i++) {
            meter += shapes[i].calculatePerimeter();
        }
        return meter;
    }
}


