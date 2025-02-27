package joonseo.chap13;
import java.util.*;

public class Application4 {
    public static void main(String[] args) {
        Queue<String> ans = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("학생 ID 입력('exit' 입력시 종료) : ");
            String id = sc.nextLine();
            if(id.equals("exit")){
                break;
            }
            if(!ans.contains(id)){
                ans.offer(id);
                System.out.println("ID가 추가 되었습니다.");
            }else{
                System.out.println("이미 등록된 ID입니다.");
            }
        }
        System.out.println(ans);
    }
}
