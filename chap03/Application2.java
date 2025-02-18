package joonseo.chap03;

public class Application2 {
    public static void main(String[] args) {
        RandomMaker randomMaker = new RandomMaker();
        System.out.println(randomMaker.randomNumber(10, 20));
        System.out.println(randomMaker.randomUpperAlphabet(10));
        System.out.println(randomMaker.rockPaperScissors());
        randomMaker.tossCoin();
    }
}
