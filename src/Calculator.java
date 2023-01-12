
public class Calculator {

    public Operation calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                return operation;
            case "sub":
                operation.setResult(sub(operation.getNum1(), operation.getNum2()));
                return operation;
            case "mul":
                operation.setResult(mul(operation.getNum1(),operation.getNum2()));
                return operation;
            case "div":
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
        }
        return null;
    }

    private static double sum(double a, double b) {
        return a + b;
    }

    private static double sub(double a, double b) {
        return a - b;
    }
    private static double mul(double a, double b){ return a*b;}
    private static double div(double a, double b){ return a/b;}
}
