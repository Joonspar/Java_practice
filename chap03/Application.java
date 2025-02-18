package joonseo.chap03;
import joonseo.chap03.Calculator;
public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.checkMethod();
        int res1 = calculator.sum1to10();
        System.out.println("1부터 10까지의 합 : " + res1);
        calculator.checkMaxNumber(10,20);
        int res2 = calculator.sumTwoNumber(10,20);
        System.out.println("10과 20의 합은 : " + res2);
        int res3 = calculator.minusTwoNumber(10,5);
        System.out.println("10과 5의 차는 : " + res3);
    }

}
