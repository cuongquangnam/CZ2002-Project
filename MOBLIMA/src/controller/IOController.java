package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles some input from standard input as well as formatting methods.
 */
public class IOController {
    /**
     * This method prints specified {@code String} to standard output.
     * @param title The header message to be written to standard output
     */
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

    /**
     * This method breaks line for a {@code String} whose length exceeds a certain value
     * as well as adding spaces to the second line onwards.
     * @param string The String to be formatted
     * @param maxLineLength The maximum length a line can be
     * @param spaceLength The number of spaces to be added to the second line onwards
     * @return The formatted String
     */
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

    /**
     * This method reads an integer from standard input whose value should be in a
     * certain range.
     * @param i The lower bound (inclusive) of the input
     * @param j The upper bound (inclusive) of the input
     * @return The input from standard input with specified range
     */
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

    /**
     * The method reads a {@code String} from standard input.
     * @param message The message to be shown to the user
     * @return The input from standard input
     */
    public static String getString(String... message) {
        for (String m : message) System.out.println(m);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * This method reads a {@code double} from standard input.
     * @param message The message to be shown to the user
     * @return The input from standard input
     */
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


    /**
     * This method reads a {@code int} from standard input.
     * @param message The message to be shown to the user
     * @return The input from standard input
     */
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


    /**
     * This method reads a {@code boolean} from standard input.
     * @param message The message to be shown to the user
     * @return The input from standard input
     */
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


    /**
     * This method reads an Email address from standard input.
     * @param message The message to be shown to the user
     * @return The input from standard input with Email format
     */
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

    /**
     * This method reads a {@code String} with format MM-dd HH:mm from standard input and transform it to be a {@code Date}.
     * @param message The message to be shown to the user
     * @return The {@code Date} after formatting
     */
    public static Date readTimeMMddHHmm(String... message) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            String input = getString(message);
            input = new SimpleDateFormat("yyyy").format(new Date()) + "-" + input;  // set year as current year
            Date date = simpleDateFormat.parse(input);
            return date;
        } catch (ParseException ex) {
            System.out.println("Wrong format. Try again.");
            return readTimeMMddHHmm(message);
        }
    }

    /**
     * This method formats a {@code Date} to a {@code String} with format YYYYMMddHHmm.
     * @param time The {@code Date} to be formatted
     * @return The {@code String} formatted
     */
    public static String formatTimeYYYYMMddHHmm(Date time) {
        return new SimpleDateFormat("YYYYMMddHHmm").format(time);
    }

    /**
     * This method formats a {@code Date} to a {@code String} with format MM/dd HH:mm.
     * @param time The {@code Date} to be formatted
     * @return The {@code String} formatted
     */
    public static String formatTimeMMddHHmm(Date time) {
        return new SimpleDateFormat("MM/dd HH:mm").format(time);
    }

    /**
     * This method formats a {@code Date} to a {@code String} with format MM/dd.
     * @param time The {@code Date} to be formatted
     * @return The {@code String} formatted
     */
    public static String formatTimeMMdd(Date time) {
        return new SimpleDateFormat("MM/dd").format(time);
    }

    /**
     * This method tests whether two {@code Date} equals in month and date
     * @param d1 The first {@code Date} to be compared
     * @param d2 The second {@code Date} to be compared
     * @return true if they equals in month and date, false otherwise
     */
    public static boolean dateEquals(Date d1, Date d2) {
        return formatTimeMMdd(d1).equals(formatTimeMMdd(d2));
    }

    /**
     * This method rounds a double value to a specified decimal place.
     * @param value The value to be rounded
     * @param precision The number of decimal places of the result
     * @return The result after rounding
     */
    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}