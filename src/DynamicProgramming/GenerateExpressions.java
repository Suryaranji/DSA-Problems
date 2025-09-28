package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GenerateExpressions {
    public List<Integer> ways(int index, String expression) {
        if (index >= expression.length()) {
            return Collections.emptyList();
        }
        List<Integer> answer = new ArrayList<>();
        int operatorIndex = extractOperatorIndex(index, expression);
        List<Integer> withoutPicking = ways(operatorIndex + 1, expression);
        int left = extractNumber(expression, index);
        for (int i : withoutPicking) {
            answer.add(calculateSum(left, i, expression.charAt(operatorIndex)));
        }
        if (withoutPicking.isEmpty()) {
            answer.add(left);
        }

        if (operatorIndex != expression.length()) {
            int right = extractNumber(expression, operatorIndex + 1);
            int ans = calculateSum(left, right, expression.charAt(operatorIndex));
            int secondOperator = extractOperatorIndex(operatorIndex + 1, expression);
            List<Integer> pickGroupAnswers = ways(secondOperator + 1, expression);
            for (int i : pickGroupAnswers) {
                answer.add(calculateSum(ans, i, expression.charAt(secondOperator)));
            }
            if(pickGroupAnswers.isEmpty()) {
                answer.add(ans);
            }
        }
        return answer;
    }

    public int calculateSum(int sum, int number, char operator) {
        return switch (operator) {
            case '+' -> sum + number;
            case '-' -> sum - number;
            case '*' -> sum * number;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public int extractNumber(String expression, int index) {
        int i = index;
        Set<Character> operators = Set.of('*', '+', '-');
        while (i < expression.length() && !operators.contains(expression.charAt(i))) {
            i++;
        }
        return Integer.parseInt(expression.substring(index, i));
    }

    public int extractOperatorIndex(int index, String expression) {
        Set<Character> operators = Set.of('*', '+', '-');
        int i = index;
        while (i < expression.length() && !operators.contains(expression.charAt(i))) {
            i++;
        }
        return i;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return ways(0, expression);
    }

    public static void main(String[] args) {
        GenerateExpressions ge = new GenerateExpressions();
        System.out.println(ge.diffWaysToCompute("2*3-4*5"));
    }
}
