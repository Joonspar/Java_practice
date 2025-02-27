package joonseo.chap13;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> ans = new LinkedList<>();

        while (true) {
            System.out.print("방문 URL을 입력하세요 (단, exit를 입력하면 종료) : ");
            String url = sc.nextLine();

            if (url.equals("exit")) {
                break;
            }

            ans.add(url);
            if (ans.size() > 5) {
                ans.removeFirst();
            }
            System.out.println("최근 방문 url : " + ans);
        }
    }
}
