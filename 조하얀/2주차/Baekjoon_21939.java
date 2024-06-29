import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countProblem = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeSet<Problem> problems = new TreeSet<>((o1, o2) -> {
            if (o1.level == o2.level) return o1.number - o2.number;
            return o1.level - o2.level;
        });
        Map<Integer, Integer> problemsMap = new HashMap<>();

        for (int i = 0; i < countProblem; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            problems.add(new Problem(number, level));
            problemsMap.put(number, level);
        }

        StringBuilder answer = new StringBuilder();
        int countCommend = Integer.parseInt(br.readLine());
        for (int i = 0; i < countCommend; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int number, level;
            switch (commend) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) answer.append(problems.last().number);
                    else answer.append(problems.first().number);
                    answer.append("\n");
                    break;
                case "add":
                    number = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    problems.add(new Problem(number, level));
                    problemsMap.put(number, level);
                    break;
                case "solved":
                    number = Integer.parseInt(st.nextToken());
                    level = problemsMap.get(number);
                    problemsMap.remove(number, level);
                    problems.remove(new Problem(number, level));
            }
        }

        System.out.println(answer.toString());
    }
}

class Problem {
    int number;
    int level;

    public Problem(int number, int level) {
        this.number = number;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return number == problem.number && level == problem.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, level);
    }
}
