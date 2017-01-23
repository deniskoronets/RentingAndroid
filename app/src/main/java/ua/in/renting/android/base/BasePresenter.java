package ua.in.renting.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 07/01/17
 */
public interface BasePresenter {

    void onCreate(@Nullable Bundle b);
    void onSaveInstanceState(Bundle outState);
}