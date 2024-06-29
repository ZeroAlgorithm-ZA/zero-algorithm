import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
                if (pq.size() > number) pq.poll();
            }
        }

        System.out.println(pq.poll());
    }
}
