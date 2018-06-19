import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        Deque<String> stackProblems = new ArrayDeque<>();
        Deque<String> queCandidates = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            String problem = reader.readLine();
            stackProblems.push(problem);
        }

        Pattern pattern = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");

        for (int i = 0; i < candidatesCount; i++) {
            String candidate = reader.readLine();

            Matcher matcher = pattern.matcher(candidate);

            if (matcher.find()) {
                queCandidates.add(candidate);
            }
        }

        while (queCandidates.size() != 0) {
            if (stackProblems.size() == 0) {
                break;
            }
            String problem = stackProblems.peek();
            String candidate = queCandidates.peek();

            int sumProblem = 0;
            int sumName = 0;
            for (int i = 0; i < problem.length(); i++) {
                char ch = problem.charAt(i);
                sumProblem += ch;
            }

            for (int i = 0; i < candidate.length(); i++) {
                char ch = candidate.charAt(i);
                sumName += ch;
            }

            if (sumName > sumProblem) {
                stackProblems.pop();
                queCandidates.remove();
                queCandidates.add(candidate);
                System.out.printf("%s solved %s.%n", candidate, problem);
            } else {
                queCandidates.remove();
                stackProblems.pop();
                stackProblems.addLast(problem);
                System.out.printf("%s failed %s.%n", candidate, problem);
            }
            if(queCandidates.size()==1){
                break;
            }

        }
        if (queCandidates.size() == 1) {
            System.out.println(queCandidates.remove() + " gets the job!");
        } else {
            List<String> names = new ArrayList<>();
            for (String queCandidate : queCandidates) {
                names.add(queCandidate);
            }
            System.out.println(String.join(", ", names));
        }

    }
}