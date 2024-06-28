import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //중앙값 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            System.out.println(m/2+1);
            //중간값보다 작은 수들을 넣어줄 MaxHeap
            PriorityQueue<Integer> lowerNum = new PriorityQueue<>((x, y) -> y - x);
            //중간값보다 큰 수들을 넣어줄 MinHeap
            PriorityQueue<Integer> higherNum = new PriorityQueue<>();
            int centerNum = 0;
            int cnt = 0;
            int printCnt = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < m/10+1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    if (cnt == 0) {
                        centerNum = num;
                    } else if (num < centerNum) {
                        lowerNum.offer(num);
                        if (lowerNum.size() > higherNum.size()) {
                            higherNum.offer(centerNum);
                            centerNum = lowerNum.poll();
                        }
                    } else {
                        higherNum.offer(num);
                        if (lowerNum.size() < higherNum.size()){
                            lowerNum.offer(centerNum);
                            centerNum = higherNum.poll();
                        }
                    }
                    cnt++;
                    if (cnt % 2 == 1) {
                        sb.append(centerNum+" ");
                        printCnt++;
                        if (printCnt % 10 == 0) {
                            System.out.println(sb);
                            sb.setLength(0);
                        }
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
