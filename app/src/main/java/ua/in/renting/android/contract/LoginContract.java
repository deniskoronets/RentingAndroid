package ua.in.renting.android.contract;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ua.in.renting.android.base.BasePresenter;
import ua.in.renting.android.base.BaseView;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 23/01/17
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void onFailed(@Nullable String... messages);
        void onSuccess();
    }

    interface Presenter extends BasePresenter {
        boolean validate(@Nullable String username, @Nullable String password);
        void login(@NonNull String username, @NonNull String password);
    }
}