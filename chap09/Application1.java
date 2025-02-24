package joonseo.chap09;

import java.util.Scanner;
public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력: ");
        String s1 = sc.nextLine();
        String[] arr = s1.split(" ");
        int l = arr.length;
        System.out.print("변환된 문자열 : ");

        for(int i = 0; i< l; i++){
            if(i != l-1){
                System.out.print(Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1) + " ");
            }else{
                System.out.println(Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1));
            }
        }
        System.out.println("총 단어 개수 : " + arr.length);
    }
}
