import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //N번째 큰수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //PriorityQueue를 이용해 내림차순으로 N개의 수를 저장함
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);

        //N*N 행렬을 읽어들임
        for (int i = 0; i < n; i++) {
            //i번째 행을 읽어옴
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                //매번 pq에 수를 넣어본 후
                pq.offer(num);
                //배열내에 큰 순서대로 N개의 수가 pq내에 위치하도록 유지함
                if (pq.size() > n) {
                    pq.poll();
                }
            }
        }
        //N번째 큰수가 나오게 됨
        System.out.println(pq.poll());
    }
}
