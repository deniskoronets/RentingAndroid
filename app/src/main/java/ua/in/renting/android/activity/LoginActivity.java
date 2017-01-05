package ua.in.renting.android.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import ua.in.renting.android.R;
import ua.in.renting.android.fragment.LoginFragment;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 05/01/17
 */
public class LoginActivity extends BaseActivity {

    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        super.setContentView(R.layout.activity_login);

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);

        startFragment(LoginFragment.newInstance(), false);
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public void setBlock(boolean block) {
        mRefreshLayout.setRefreshing(block);
    }
}