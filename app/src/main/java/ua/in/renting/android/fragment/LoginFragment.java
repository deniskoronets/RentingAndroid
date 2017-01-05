package ua.in.renting.android.fragment;

import ua.in.renting.android.R;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 05/01/17
 */
public class LoginFragment extends BaseFragment {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_login;
    }
}