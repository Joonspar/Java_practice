package joonseo.chap06.student;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] students = new StudentDTO[10];
        int count = 0;

        while (count < 10) {
            System.out.print("학년: ");
            int grade = sc.nextInt();

            System.out.print("반: ");
            int classroom = sc.nextInt();

            sc.nextLine();

            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("국어점수: ");
            int kor = sc.nextInt();

            System.out.print("영어점수: ");
            int eng = sc.nextInt();

            System.out.print("수학점수: ");
            int math = sc.nextInt();

            students[count] = new StudentDTO(grade, classroom, name, kor, eng, math);
            count++;

            System.out.print("계속 추가할 겁니까 ? (y/n) : ");
            sc.nextLine();
            String answer = sc.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("\n=== 학생 정보 출력 ===");
        for (int i = 0; i < count; i++) {
            StudentDTO student = students[i];
            int avg = (student.getKor() + student.getEng() + student.getMath()) / 3;
            System.out.println("학년=" + student.getGrade() + ", 반=" + student.getClassroom() + ", 이름=" + student.getName()
                    + ", 국어=" + student.getKor() + ", 영어=" + student.getEng() + ", 수학=" + student.getMath()
                    + ", 평균=" + avg);
        }

    }
}
