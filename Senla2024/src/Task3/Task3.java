package Task3;

import java.util.Scanner;
import java.util.Random;

class PasswordUtilities{
    static StringBuilder shuffle(StringBuilder password)
    {
        int j;
        char tmp;
        StringBuilder result = new StringBuilder(password);
        Random rnd = new Random();
        for (int i = result.length() - 1; i > 0; i--) {
            j = rnd.nextInt(i + 1);
            tmp = result.charAt(i);
            result.setCharAt(i, result.charAt(j));
            result.setCharAt(j, tmp);
        }
        return result;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        String UpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LowerCase = "abcdefghijklmnopqrstuvwxyz";
        String Special = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        String Figures = "0123456789";

        int len;
        int Cspecial;
        int Cfigures;
        int Cuppercase;
        int Clowercase;
        int x;

        StringBuilder password = new StringBuilder();

        System.out.println("Введите длину пароля от 8 до 12: ");
        len = in.nextInt();

        while (len < 8 || len > 12)
        {
            System.out.println("Введите длину пароля от 8 до 12: ");
            len = in.nextInt();
        }

        Cspecial = rnd.nextInt(len / 4) + 1;
        Cfigures = rnd.nextInt(len / 4) + 1;
        Cuppercase = rnd.nextInt(len /4) + 1;
        Clowercase = len - Cspecial - Cfigures - Cuppercase;

        for (int i = 0; i < Cuppercase; i++) {
            x = rnd.nextInt(UpperCase.length());
            password.append(UpperCase.charAt(x));
        }

        for (int i = 0; i < Clowercase; i++) {
            x = rnd.nextInt(LowerCase.length());
            password.append(LowerCase.charAt(x));
        }

        for (int i = 0; i < Cspecial; i++) {
            x = rnd.nextInt(Special.length());
            password.append(Special.charAt(x));
        }

        for (int i = 0; i < Cfigures; i++) {
            x = rnd.nextInt(Figures.length());
            password.append(Figures.charAt(x));
        }

        password = PasswordUtilities.shuffle(password);

        System.out.println(password);
    }
}
