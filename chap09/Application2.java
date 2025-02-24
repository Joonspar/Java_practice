package joonseo.chap09;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ' ') {
                sb.append(Character.toLowerCase(ch));
            }

        }

        String[] words = sb.toString().split("\\s+");
        String[] wordsarr = new String[words.length];
        int[] counts = new int[words.length];
        int ucnt = 0;

        for (String word : words) {
            if (word.isEmpty()) continue;
            boolean check = false;
            for (int i = 0; i < ucnt; i++) {
                if (wordsarr[i].equals(word)) {
                    counts[i]++;
                    check = true;
                    break;
                }
            }

            if (!check) {
                wordsarr[ucnt] = word;
                counts[ucnt] = 1;
                ucnt++;
            }
        }

        System.out.println("------ 출력 예시 ------");
        System.out.println("------- 단어 빈도 -------");
        int cnt = 0;
        String result = "";

        for (int i = 0; i < ucnt; i++) {
            System.out.println(wordsarr[i] + ": " + counts[i]);

            if (counts[i] > cnt) {
                cnt = counts[i];
                result = wordsarr[i];
            }
        }
        System.out.println("가장 빈도 높은 단어 : " + result + " (" + cnt + " 번)");
    }
}

