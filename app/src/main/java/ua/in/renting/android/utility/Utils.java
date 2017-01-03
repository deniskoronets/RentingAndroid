package ua.in.renting.android.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public class Utils {

    public static String extractBetween(String start, String end, String value) {
        final Matcher matcher = Pattern.compile(String.format("%s(.+?)%s", start, end)).matcher(value);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return SharedStrings.EMPTY;
    }
}