import java.util.Scanner;

public class DepositCalculate {
    double calculateComplexPercent(double a, double y, int d) {
        double pay;
        pay = a * Math.pow((1 + y / 12), 12 * d);
        return finalPay(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return finalPay(amount + amount * yearRate * depositPeriod, 2);
    }

    double finalPay(double value, int places) {
        double scale;
        scale = Math.pow(10, places);
        return Math.round(value * scale) / scale; 
    }

    void calculationDeposit() {
        int period;
        int action;
        int amount;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double outVar = 0;
        if (action == 1) {
            outVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outVar = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }

    public static void main(String[] args) {
        new DepositCalculate().calculationDeposit();
    }
}
