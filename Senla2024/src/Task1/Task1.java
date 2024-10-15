package Task1;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

class Visual{
    static void PrintGallows(int mistakes)
    {
        switch (mistakes) {
            case 0:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            case 1:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("               0    |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            case 2:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("               0    |");
                System.out.println("               []   |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            case 3:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("               0    |");
                System.out.println("              /[]   |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            case 4:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("               0    |");
                System.out.println("              /[]\\  |");
                System.out.println("                    |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            case 5:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("               0    |");
                System.out.println("              /[]\\  |");
                System.out.println("               /    |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            case 6:
                System.out.println();
                System.out.println("               ------");
                System.out.println("               |    |");
                System.out.println("               0    |");
                System.out.println("              /[]\\  |");
                System.out.println("               /\\   |");
                System.out.println("                    |");
                System.out.println("      [----------------]");
                break;
            default:
                System.out.println();
                System.out.println("  ☆  ☆    ☆   ☆  ☆ ☆    ☆   ☆  ☆   ");
                System.out.println("     ☆  ☆    ☆   ☆  ☆ ☆    ☆   ☆  ☆   ");
                System.out.println("  ☆    ☆   ☆ \\ 0 /  ☆    ☆   ☆  ");
                System.out.println("   ☆  ☆  ☆    []   ☆  ☆  ☆");
                System.out.println("               /\\   ");
                System.out.println("      [----------------]");
                break;
        }
    }
}

class Word{
    static String Generate(String fileName)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            Random rnd = new Random();
            String line = br.readLine();
            int number = rnd.nextInt(Integer.parseInt(line)) + 1;
            for (int i = 0; i < number; i++) {
                line = br.readLine();
            }
            br.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

public class Task1 {
    public static void main(String[] args) throws IOException {
        int mistakes = 0;
        Scanner in = new Scanner(System.in);
        char c;
        String word = Word.Generate("src\\Task1\\Words.txt");
        StringBuilder inputedchars = new StringBuilder();
        StringBuilder playerword = new StringBuilder("*".repeat(word.length()));
        Visual.PrintGallows(mistakes);
        while (mistakes != 6 && playerword.indexOf("*") != -1)
        {
            System.out.println("Слово: " + playerword);
            System.out.println("Количество допустимых ошибок: " + (6 - mistakes));
            System.out.println("Введите букву: ");
            c = in.next().charAt(0);
            if (inputedchars.indexOf("" + c) != -1)
            {
                System.out.println("Буква уже введена");
            }
            else
            {
                inputedchars.append(c);
                if (word.indexOf(c) == -1)
                {
                    mistakes++;
                    System.out.println("Буквы " + c + " в слове нет!");
                }
                else
                {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == c)
                        {
                            playerword.setCharAt(i, c);
                        }
                    }
                    System.out.println("Буква " + c + " в слове есть!");
                }
            }
            if (playerword.indexOf("*") != -1) Visual.PrintGallows(mistakes);
            else Visual.PrintGallows(7);
        }
        System.out.println(word);
        if (mistakes == 6)
        {
            System.out.println("К СОЖАЛЕНИЮ, ВЫ ПРОИГРАЛИ!");
        }
        else
        {
            System.out.println("ПОЗДРАВЛЯЮ, ВЫ ВЫИГРАЛИ!");
        }
    }
}
