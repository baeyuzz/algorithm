import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기_배유진 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for(int i = 0; i < t; i ++) {
            int arr[] = new int[1000];
            int score[] = new int[101];
            int num = sc.nextInt(); // #testcase 
             
            for(int j = 0; j < 1000; j ++) 
                arr[j] = sc.nextInt(); // 점수 입력 받음
             
            for(int j = 0 ; j < 1000; j ++)
                score[arr[j]] ++ ;
             
            int max = 0;
            int tmp = 0;
             
            for(int j = 0; j < 101; j ++) {
                if(max <= score[j]) {
                    max = score[j];
                    tmp = j;
                    //System.out.println(score[j]);
                }
            }
            System.out.println("#" + (i+1) + " " + tmp);
         
        }
        sc.close();
    }
}