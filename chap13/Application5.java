package joonseo.chap13;
import java.util.*;

public class Application5 {
    public static void main(String[] args) {
        TreeSet<String> ans = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("단어 입력 ('exit' 입력 시 종료) : ");
            String word = sc.nextLine();
            if(word.equals("exit")){
                break;
            }else{
                ans.add(word);
            }
        }
        System.out.println("정렬 된 단어 : " + ans);
    }
}
