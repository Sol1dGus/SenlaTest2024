package Task2;

import java.util.Scanner;

class ConverterUtilities{
    static void ConvertTab(int currency1, Double value)
    {
        switch (currency1) {
            // 1 - USD
            // 2 - EUR
            // 3 - CNY
            // 4 - RUB
            // 5 - GBR
            case 1:
                System.out.printf("%.2f USD\n", 1 * value);
                System.out.printf("%.2f EUR\n", 0.918 * value);
                System.out.printf("%.2f CNY\n", 7.1499 * value);
                System.out.printf("%.2f RUB\n", 97.0121 * value);
                System.out.printf("%.2f GBR\n", 0.7659 * value);
                break;
            case 2:
                System.out.printf("%.2f USD\n", 1.0893 * value);
                System.out.printf("%.2f EUR\n", 1 * value);
                System.out.printf("%.2f CNY\n", 7.7884 * value);
                System.out.printf("%.2f RUB\n", 105.6757 * value);
                System.out.printf("%.2f GBR\n", 0.8343 * value);
                break;
            case 3:
                System.out.printf("%.2f USD\n", 0.1399 * value);
                System.out.printf("%.2f EUR\n", 0.1284 * value);
                System.out.printf("%.2f CNY\n", 1 * value);
                System.out.printf("%.2f RUB\n", 13.5683 * value);
                System.out.printf("%.2f GBR\n", 0.1071 * value);
                break;
            case 4:
                System.out.printf("%.2f USD\n", 0.0103 * value);
                System.out.printf("%.2f EUR\n", 0.0095 * value);
                System.out.printf("%.2f CNY\n", 0.0737 * value);
                System.out.printf("%.2f RUB\n", 1 * value);
                System.out.printf("%.2f GBR\n", 0.0079 * value);
                break;
            case 5:
                System.out.printf("%.2f USD\n", 1.3057 * value);
                System.out.printf("%.2f EUR\n", 1.1987 * value);
                System.out.printf("%.2f CNY\n", 9.3356 * value);
                System.out.printf("%.2f RUB\n", 126.6687 * value);
                System.out.printf("%.2f GBR\n", 1 * value);
                break;
        };
    }
}
public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double valuein;
        String valueout;
        int x = 0;
        int y;

        while (x != -1)
        {
            System.out.println("\nВыберете валюту которую хотите конвертировать:");
            System.out.println("1 - USD\n" + "2 - EUR\n" + "3 - CNY\n" + "4 - RUB\n" + "5 - GBR");
            System.out.println("Чтобы завершить конвертирование введите -1");

            x = in.nextInt();
            while (x != -1 && (x < 1 || x > 5))
            {
                System.out.println("Введите число от 1 до 5 для выбора валюты:");
                System.out.println("Или же -1 для выхода из программы");
                x = in.nextInt();
            }

            if (x == -1) break;
            System.out.println("Выберете сумму, которую хотите конвертировать");

            valuein = in.nextDouble();

            while (valuein < 0)
            {
                System.out.println("Сумма должна быть неотрицательна");
                valuein = in.nextDouble();
            }
            System.out.println("Результат:");
            ConverterUtilities.ConvertTab(x, valuein);
        }
    }
}
