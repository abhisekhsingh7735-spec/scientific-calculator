import java.util.Stack;

/**
 * Core calculator engine with scientific functions
 * Handles mathematical operations and expression evaluation
 */
public class Calculator {
    
    private double memory = 0;
    private Stack<String> history;
    
    public Calculator() {
        this.history = new Stack<>();
    }
    
    /**
     * Basic arithmetic operations
     */
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot calculate modulus with zero");
        }
        return a % b;
    }
    
    /**
     * Trigonometric functions (angle in degrees)
     */
    public double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }
    
    public double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
    
    public double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
    
    /**
     * Inverse trigonometric functions (returns degrees)
     */
    public double arcSine(double value) {
        if (value < -1 || value > 1) {
            throw new IllegalArgumentException("asin input must be between -1 and 1");
        }
        return Math.toDegrees(Math.asin(value));
    }
    
    public double arcCosine(double value) {
        if (value < -1 || value > 1) {
            throw new IllegalArgumentException("acos input must be between -1 and 1");
        }
        return Math.toDegrees(Math.acos(value));
    }
    
    public double arcTangent(double value) {
        return Math.toDegrees(Math.atan(value));
    }
    
    /**
     * Logarithmic and exponential functions
     */
    public double logarithm(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Logarithm input must be positive");
        }
        return Math.log10(value);
    }
    
    public double naturalLog(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Natural log input must be positive");
        }
        return Math.log(value);
    }
    
    public double exponential(double value) {
        return Math.exp(value);
    }
    
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * Square root and other roots
     */
    public double squareRoot(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(value);
    }
    
    public double nthRoot(double value, double n) {
        if (value < 0 && n % 2 == 0) {
            throw new IllegalArgumentException("Cannot calculate even root of negative number");
        }
        return Math.pow(value, 1.0 / n);
    }
    
    /**
     * Factorial calculation
     */
    public double factorial(double value) {
        if (value < 0 || value != Math.floor(value)) {
            throw new IllegalArgumentException("Factorial requires non-negative integer");
        }
        
        int n = (int) value;
        if (n > 170) {
            throw new IllegalArgumentException("Factorial too large to calculate");
        }
        
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Absolute value
     */
    public double absoluteValue(double value) {
        return Math.abs(value);
    }
    
    /**
     * Reciprocal (1/x)
     */
    public double reciprocal(double value) {
        if (value == 0) {
            throw new ArithmeticException("Cannot calculate reciprocal of zero");
        }
        return 1.0 / value;
    }
    
    /**
     * Percentage calculation
     */
    public double percentage(double value) {
        return value / 100.0;
    }
    
    /**
     * Memory operations
     */
    public void memoryAdd(double value) {
        memory += value;
    }
    
    public void memorySubtract(double value) {
        memory -= value;
    }
    
    public void memoryClear() {
        memory = 0;
    }
    
    public double memoryRecall() {
        return memory;
    }
    
    /**
     * History management
     */
    public void addToHistory(String operation, double result) {
        history.push(operation + " = " + result);
    }
    
    public Stack<String> getHistory() {
        return history;
    }
    
    public void clearHistory() {
        history.clear();
    }
    
    /**
     * Evaluate mathematical expression with basic operator support
     * Supports: +, -, *, /, %
     */
    public double evaluate(String expression) {
        // Remove spaces
        expression = expression.replaceAll("\\s+", "");
        
        try {
            // Simple evaluation using stack-based approach
            return evaluateExpression(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression: " + e.getMessage());
        }
    }
    
    private double evaluateExpression(String expr) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            
            // Parse number
            if (Character.isDigit(c) || c == '.') {
                StringBuilder numStr = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    numStr.append(expr.charAt(i));
                    i++;
                }
                numbers.push(Double.parseDouble(numStr.toString()));
            }
            // Handle operators
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                while (!operators.isEmpty() && hasPrecedence(operators.peek(), c)) {
                    applyOperator(numbers, operators);
                }
                operators.push(c);
                i++;
            }
            else if (c == '(' || c == ')') {
                i++;
            }
            else {
                i++;
            }
        }
        
        while (!operators.isEmpty()) {
            applyOperator(numbers, operators);
        }
        
        return numbers.pop();
    }
    
    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        return false;
    }
    
    private void applyOperator(Stack<Double> numbers, Stack<Character> operators) {
        if (numbers.size() < 2) return;
        
        double b = numbers.pop();
        double a = numbers.pop();
        char op = operators.pop();
        
        double result = 0;
        switch (op) {
            case '+': result = add(a, b); break;
            case '-': result = subtract(a, b); break;
            case '*': result = multiply(a, b); break;
            case '/': result = divide(a, b); break;
            case '%': result = modulus(a, b); break;
        }
        numbers.push(result);
    }
}
