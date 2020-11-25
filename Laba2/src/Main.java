
 
import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    static double operation(double a, double b, char sign) {
        return switch (sign) {
            case '+' -> a + b;
            case '-' -> b - a;
            case '*' -> a * b;
            case '/' -> b / a;
            default -> -1;
        };
    }
 
    static int priority(char symbol) {
        return switch (symbol) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
 
    public static Double Calculate(String expression) {
        Stack<Character> signs = new Stack<>();
        Stack<Double> numbers = new Stack<>();
        char symbol;
        for (int i = 0; i < expression.length(); i++) {
            symbol = expression.charAt(i);
            if (symbol != ' ') {
                switch (symbol) {
                    case '(' -> signs.add(symbol);
                    case ')' -> {
                        while (signs.peek() != '(') {
                            double number1 = numbers.peek();
                            numbers.pop();
                            double number2 = numbers.peek();
                            numbers.pop();
                            numbers.add(operation(number1, number2, signs.peek()));
                            signs.pop();
                        }
                        signs.pop();
                    }
                    case '+', '-', '*', '/' -> {
                        while (!signs.empty() && priority(signs.peek()) >= priority(symbol)) {
                            double number1 = numbers.peek();
                            numbers.pop();
                            double number2 = numbers.peek();
                            numbers.pop();
                            numbers.add(operation(number1, number2, signs.peek()));
                            signs.pop();
                        }
                        signs.add(symbol);
                    }
                    default -> {
                        StringBuilder operand = new StringBuilder();
                        while (i < expression.length() && Character.isDigit(expression.charAt(i)))
                            operand.append(expression.charAt(i++));
                        --i;
                        if (Character.isDigit(operand.charAt(0)))
                            numbers.add((double) Integer.parseInt(operand.toString()));
                    }
                }
            }
        }
        while (!signs.empty()) {
            double number1 = numbers.peek(); numbers.pop();
            double number2 = numbers.peek(); numbers.pop();
            numbers.add(operation(number1, number2, signs.peek()));
            signs.pop();
        }
        return numbers.peek();
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Calculate(sc.nextLine()));
    }
}