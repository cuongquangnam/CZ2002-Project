package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOController {
    public static void printTitle(String title) {
        int length = 71;
        int indent = (length - title.length()) / 2;
        for(int i = 0; i < length; i++)
            System.out.print("-");
        System.out.println();
        for(int i = 0; i < indent; i++)
            System.out.print(" ");
        System.out.print(title);
        for(int i = 0; i < indent; i++)
            System.out.print(" ");
        System.out.println();
        for(int i = 0; i < length; i++)
            System.out.print("-");
        System.out.println();
    }
    public static String breakLines(String string, int maxLineLength, int spaceLength) {
        StringTokenizer token = new StringTokenizer(string, " ");
        StringBuilder modifiedString = new StringBuilder(string.length());
        int lineLength = 0;
        while (token.hasMoreTokens()) {
            String word = token.nextToken();

            if (lineLength + word.length() > maxLineLength) {
                modifiedString.append("\n");
                for (int i = 0; i < spaceLength; i++)
                    modifiedString.append(" ");
                lineLength = 0;
            }
            modifiedString.append(word).append(" ");
            lineLength += word.length();
        }
        return modifiedString.toString();
    }
    public static int getChoice(int i, int j) {
        Scanner sc = new Scanner(System.in);
        int choice;

        try {
            choice = sc.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input, try again.");
            sc.nextLine();  // flush scanner
            return getChoice(i, j);
        }

        if (choice < i || choice > j) {
            System.out.println("Invalid input, try again.");
            return getChoice(i, j);
        }
        return choice;
    }


    public static String getString(String... message) {
        for (String m : message) System.out.println(m);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public static double getDouble(String... message) {
        for (String m : message) System.out.println(m);
        Scanner sc = new Scanner(System.in);
        double output;

        try {
            output = sc.nextDouble();
            return output;
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input, try again.");
            sc.nextLine();  // flush scanner
            return getDouble(message);
        }
    }


    public static int getInt(String... message) {
        for (String m : message) System.out.println(m);
        Scanner sc = new Scanner(System.in);
        int output;

        try {
            output = sc.nextInt();
            return output;
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input, try again.");
            sc.nextLine();  // flush scanner
            return getInt(message);
        }
    }


    public static boolean getBoolean(String... message) {
        for (String m : message) System.out.println(m);
        Scanner sc = new Scanner(System.in);
        boolean output;

        try {
            output = sc.nextBoolean();
            return output;
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input, try again.");
            sc.nextLine();  // flush scanner
            return getBoolean(message);
        }
    }


    public static String getEmail(String... message) {
        for (String m : message) System.out.println(m);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Pattern EMAIL_PATTERN = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = EMAIL_PATTERN.matcher(input);
        if (matcher.matches()) {
            return input;
        }
        else {
            System.out.println("Invalid Email address, try again.");
            return getEmail(message);
        }
    }

    public static String formatTimeMMddHHmm(Date time) {
        return new SimpleDateFormat("MM/dd HH:mm").format(time);
    }

    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}