import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < countCase; i++) {
            int length = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            sb.append(length / 2 + 1).append("\n");
            int count = 0;

            for (int k = 0; k < length / 10 + 1; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    list.add(x);
                    Collections.sort(list, Comparator.naturalOrder());

                    if (list.size() % 2 == 1) {
                        sb.append(list.get(list.size() / 2)).append(" ");
                        count++;
                    }
                }
                if (count % 10 == 0) sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
