import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Calc {
    public static int ind1, ind2;
    static String[] numbs = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static int calc1(String str) throws InputException {
        String[] strings = str.split(" ");
        if (strings.length == 1 || strings.length == 2) {
            throw new InputException("a string is not a mathematical operation");
        }
        if (isRom(strings[0]) && integerOrNot(strings[2]) || (isRom(strings[2]) && integerOrNot(strings[0]))) {
            throw new InputException("enter only Arabic or only Roman values");
        }

        if (isRom(strings[0]) && isRom(strings[2])) {
            List<String> arr = Arrays.asList(numbs);
            for (String str1 :
                    arr) {
                if (strings[0].equals(str1)) {
                    ind1 = arr.indexOf(str1);
                }
            }
            for (String str2 :
                    arr) {
                if (strings[2].equals(str2)) {
                    ind2 = arr.indexOf(str2);
                }
            }
            switch (strings[1]) {
                case "+":
                    System.out.println(numbs[ind1 + ind2 + 1]);
                    break;
                case "-":
                    if (ind1 <= ind2) {
                        throw new InputException("the result is less than one");
                    }
                    System.out.println(numbs[ind1 - ind2 - 1]);
                    break;
                case "*":
                    System.out.println(numbs[(ind1 + 1) * (ind2 + 1) - 1]);
                    break;
                case "/":
                    if (ind1 < ind2) {
                        throw new InputException("the result is less than one");
                    }
                    System.out.println(numbs[(ind1 + 1) / (ind2 + 1) - 1]);
                    break;
                default:
                    throw new InputException("uncorrected operation");
            }
            return 0;
        }
        if (strings.length > 3) {
            throw new InputException("the format of the mathematical operation does not satisfy the task - two operands and one operator (+, -, /, *)");
        }
        int x = 2;
        if (!integerOrNot(strings[0]) || !integerOrNot(strings[2])) {
            throw new InputException("the values are uncorrected");

        }
        if ((!strings[1].equals("+")) && (!strings[1].equals("-")) && (!strings[1].equals("/")) && (!strings[1].equals("*"))) {
            throw new InputException("uncorrected operation");
        }
        int res = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
        int a = Integer.parseInt(strings[0]);

        if ((Integer.parseInt(strings[0]) < 1) || (Integer.parseInt(strings[0]) > 10) || (Integer.parseInt(strings[2]) > 10) || (Integer.parseInt(strings[2]) < 1)) {
            throw new InputException("the numbers are uncorrected");
        }
        switch (strings[1]) {
            case "+":
                System.out.println(Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]));
                break;
            case "-":
                System.out.println(Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]));
                break;
            case "*":
                System.out.println(Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]));
                break;
            case "/":
                System.out.println(Integer.parseInt(strings[0]) / Integer.parseInt(strings[2]));
                break;
        }
        return 0;
    }

    private static boolean integerOrNot(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int commaCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((!Character.isDigit(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRom(String a) {
        if (Objects.equals(a, "I") || Objects.equals(a, "II") || Objects.equals(a, "III") || Objects.equals(a, "IV") || Objects.equals(a, "V") ||
                Objects.equals(a, "VI") || Objects.equals(a, "VII") || Objects.equals(a, "VIII") || Objects.equals(a, "IX") || Objects.equals(a, "X")) {
            return true;
        }
        return false;
    }
}
