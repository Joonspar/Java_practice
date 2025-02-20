package joonseo.chap05;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Level05 {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            set.add(random.nextInt(10));
        }
        int[] target = new int[4];
        int index = 0;
        for (int num : set) {
            target[index++] = num;
        }
        Scanner scanner = new Scanner(System.in);
        int attempts = 10;

        System.out.println("숫자 야구 게임을 시작합니다!");

        while (attempts > 0) {
            System.out.println(attempts + "회 남으셨습니다.");
            System.out.print("4자리 숫자를 입력하세요: ");
            String input = scanner.nextLine();
            if (!input.matches("\\d{4}")) {
                System.out.println("4자리의 정수를 입력해야 합니다.");
                continue;
            }

            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = Character.getNumericValue(input.charAt(i));
            }
            int strike = 0, ball = 0;
            for (int i = 0; i < 4; i++) {
                if (guess[i] == target[i]) {
                    strike++;
                } else {
                    for (int j = 0; j < 4; j++) {
                        if (i != j && guess[i] == target[j]) {
                            ball++;
                        }
                    }
                }
            }
            if (strike == 4) {
                System.out.println("정답입니다!");
                break;
            } else {
                System.out.println("아쉽네요 " + strike + "S " + ball + "B 입니다.");
                attempts--;
            }
        }
        if (attempts == 0) {
            System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
            System.out.println("정답은: " + target[0] + target[1] + target[2] + target[3] + " 였습니다.");
        }

        scanner.close();
    }
}
