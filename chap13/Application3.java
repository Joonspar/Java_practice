package joonseo.chap13;
import java.util.*;
public class Application3 {
    public static void main(String[] args) {
        Queue<String> ans = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("대기 고객 이름 입력(다음 고객으로 넘어가려면 'next', 종료하려면 'exit') : ");
            String name = sc.nextLine();
            if(!name.equals("exit") && !name.equals("next")){
                ans.offer(name);
                System.out.println(name + " 고객님 대기 등록 되었습니다.");
            }
            if(name.equals("next")){
                if(ans.isEmpty()){
                    System.out.println("대기 고객이 없습니다.");
                }else{
                    System.out.println(ans.poll() + "님 차례입니다.");
                }
            }
            if(name.equals("exit")){
                break;
            }

        }

    }
}
