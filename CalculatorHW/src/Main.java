import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (operator, undo, redo, or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            char command = input.charAt(0);

            switch (command) {
                case '+':
                case '-':
                case '*':
                case '/':
                    System.out.print("Enter operand: ");
                    double operand = scanner.nextDouble();
                    scanner.nextLine();  // Consumă newline lăsat în urmă de nextDouble()
                    calculator.performOperation(command, operand);
                    System.out.println("Current Result: " + calculator.getResult());
                    break;
                case 'u':
                    calculator.undo();
                    System.out.println("Undo. Current Result: " + calculator.getResult());
                    break;
                case 'r':
                    calculator.redo();
                    System.out.println("Redo. Current Result: " + calculator.getResult());
                    break;
                default:
                    System.out.println("Error: Invalid command");
            }
        }

        scanner.close();
    }
}


