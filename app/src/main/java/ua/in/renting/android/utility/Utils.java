package ua.in.renting.android.utility;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;

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

    public static void setOnClickListener(@Nullable OnClickListener listener, @NonNull View parent, int... ids) {
        for (int id : ids) {
            parent.findViewById(id).setOnClickListener(listener);
        }
    }

    public static void setOnClickListener(@Nullable OnClickListener listener, @NonNull View... views) {
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }
}