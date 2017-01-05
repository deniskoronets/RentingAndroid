package ua.in.renting.android.interfaces;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 05/01/17
 */
public interface ObjectsReceiver {
    void onObjectsReceive(@IdRes int code, @NonNull Object... objects);
}