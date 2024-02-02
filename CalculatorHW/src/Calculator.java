import java.util.Stack;

class Calculator {
    private double currentValue;
    private Stack<Double> undoHistory;
    private Stack<Double> redoHistory;

    public Calculator() {
        currentValue = 0;
        undoHistory = new Stack<>();
        redoHistory = new Stack<>();
    }

    public void performOperation(char operator, double operand) {
    	
        undoHistory.push(currentValue);

        switch (operator) {
            case '+':
                currentValue += operand;
                break;
            case '-':
                currentValue -= operand;
                break;
            case '*':
                currentValue *= operand;
                break;
            case '/':
                if (operand != 0) {
                    currentValue /= operand;
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
        }
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            redoHistory.push(currentValue);
            currentValue = undoHistory.pop();
        }else {
            System.out.println("Error: Nothing to undo");
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            undoHistory.push(currentValue);
            currentValue = redoHistory.pop();
        }else {
            System.out.println("Error: Nothing to redo");
        }
    }

    public double getResult() {
        return currentValue;
    }
}