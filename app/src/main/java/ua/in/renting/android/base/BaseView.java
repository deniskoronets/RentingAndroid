package ua.in.renting.android.base;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 07/01/17
 */
public interface BaseView<P extends BasePresenter> {

    void setPresenter(P presenter);
}