package ua.in.renting.android.fragment.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import ua.in.renting.android.R;
import ua.in.renting.android.contract.LoginContract;
import ua.in.renting.android.fragment.BaseFragment;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 05/01/17
 */
public class LoginFragment extends BaseFragment
        implements LoginContract.View {

    // TODO: 06/01/17 change styles. Add animation

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    private EditText mEtUsername;
    private EditText mEtPassword;

    private LoginContract.Presenter mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEtUsername = (EditText) view.findViewById(R.id.et_username);
        mEtPassword = (EditText) view.findViewById(R.id.et_password);


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onFailed(@Nullable String... messages) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private final View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    final String username = mEtUsername.getText().toString().trim();
                    final String password = mEtPassword.getText().toString().trim();
                    if (mPresenter.validate(username, password)) {
                        mPresenter.login(username, password);
                    }
                    break;

                case R.id.btn_facebook:
                    break;

                case R.id.btn_google:
                    break;

                default:
                    break;
            }
        }
    };
}