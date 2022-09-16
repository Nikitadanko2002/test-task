
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Calc calc = new Calc();
        calc.calc1(str);
    }

}
