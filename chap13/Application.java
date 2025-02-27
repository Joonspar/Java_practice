package joonseo.chap13;

import java.util.ArrayList;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int p = 0;
        double res = 0;
        while(true){
            p += 1;
            System.out.print("학생 성적 : ");
            int score = sc.nextInt();
            students.add(score);
            System.out.print("추가 입력하려면 y : ");
            char check = sc.next().charAt(0);
            if(check != 'Y' && check != 'y'){
                break;
            }

        }
        for(int i = 0; i<p; i++){
            res += students.get(i);
        }
        System.out.println("학생 인원 : " + p);
        System.out.println("평균 점수 : " + res/p);
    }
}
