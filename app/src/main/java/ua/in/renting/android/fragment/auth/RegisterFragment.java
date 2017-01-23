package ua.in.renting.android.fragment.auth;

import ua.in.renting.android.R;
import ua.in.renting.android.fragment.BaseFragment;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 23/01/17
 */
public class RegisterFragment extends BaseFragment {

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_register;
    }
}