package BaekJoon.silver;

/*
  TODO:
    N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오
    첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
    둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
    다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
    표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
    총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_11660 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int sizeN = Integer.parseInt(stringTokenizer.nextToken()); // 정방 행렬 크기
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // 질문 개수

        int[][] squareMatrix = new int[sizeN + 1][sizeN + 1];
        for (int i = 1; i <= sizeN; i++) { // 행
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= sizeN; j++) { // 열
                squareMatrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] sumMatrix = new int[sizeN + 1][sizeN + 1];
        for (int i = 1; i < sizeN; i++) { // 구간 합 배열
            for (int j = 1; j <= sizeN; j++) {
                sumMatrix[i][j] = sumMatrix[i][j - 1]
                                + sumMatrix[i - 1][j]
                                - sumMatrix[i - 1][j - 1]
                                + squareMatrix[i][j];
            }
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            // FIXME 오류
            int result = sumMatrix[x2][y2]
                    - sumMatrix[x2][y1 - 1]
                    - sumMatrix[x1 - 1][y2]
                    + sumMatrix[x1 - 1][y1 - 1];

            System.out.println(result);
        }

    }
}
