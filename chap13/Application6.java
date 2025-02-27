package joonseo.chap13;
import java.util.*;
public class Application6 {
    public static void main(String[] args) {
        HashMap<String,String> ans = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search',종료하려면 'exit') : ");
            String name = sc.nextLine();
            String number = sc.nextLine();
            if(!name.equals("search") && !name.equals("exit")){
                ans.put(name,number);
                System.out.println("추가 완료 :" + name + " " + number);
            }
            else if (number.length() == 0){
                System.out.println("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
            }
            else if(name.equals("search")){
                System.out.print("검색 할 이름 : ");
                String temp = sc.nextLine();
                if(!ans.containsKey(temp)){
                    System.out.println(temp + "씨의 번호는 등록되어 있지않습니다.");
                }else{
                    System.out.println(temp + "씨의 전화번호 : " + ans.get(temp));
                }
            }
            else if(name.equals("exit")){
                break;
            }
        }
    }
}
