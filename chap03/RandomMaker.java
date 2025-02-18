package joonseo.chap03;

import java.util.Random;

public class RandomMaker {
    public static void main(String[] args) {
    }
    public int randomNumber(int min, int max){
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    public String randomUpperAlphabet(int l){
        Random random = new Random();
        String result = "";
        for (int i = 0; i < l; i++) {
            result += (char) ('A' + random.nextInt(26));
        }
        return result;
    }
    public String rockPaperScissors(){
        int res = randomNumber(1,3);
        if(res == 1){
            return "주먹";
        }else if(res == 2){
            return "보자기";
        }else{
            return "가위";
        }
    }
    public void tossCoin(){
        int res = randomNumber(1,2);
        if (res == 1){
            System.out.println("앞면");
        }else{
            System.out.println("뒷면");
        }
    }
}
