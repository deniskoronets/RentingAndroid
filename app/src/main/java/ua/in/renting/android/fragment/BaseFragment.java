package ua.in.renting.android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.in.renting.android.activity.BaseActivity;
import ua.in.renting.android.interfaces.ObjectsReceiver;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public abstract class BaseFragment extends Fragment
        implements ObjectsReceiver {

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle b) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            final ActionBar bar = ((AppCompatActivity) activity).getSupportActionBar();
            if (bar != null) {
                onActionBarReady(bar);
            }
        }
    }

    protected void onActionBarReady(@NonNull ActionBar bar) {
        final CharSequence title = getToolbarTitle();
        if (title != null) {
            bar.setTitle(title);
        }
    }

    @Nullable
    protected CharSequence getToolbarTitle() {
        @StringRes final int stringRes = getToolbarTitleRes();
        if (stringRes > 0) {
            return getString(stringRes);
        }
        return null;
    }

    @StringRes
    protected int getToolbarTitleRes() {
        return 0;
    }

    protected final boolean startFragment(@NonNull BaseFragment fragment, boolean addToBackStack) {
        final Activity activity = getActivity();
        return activity instanceof BaseActivity
                && ((BaseActivity) activity).startFragment(fragment, addToBackStack);

    }

    public void popBackStack() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onObjectsReceive(int id, @NonNull Object... objects) {
        final Activity activity = getActivity();
        if (activity != null && activity instanceof BaseActivity) {
            ((BaseActivity) activity).onObjectsReceive(id, objects);
        }
    }

    protected void setBlock(boolean block) {
        ((BaseActivity) getActivity()).setBlock(block);
    }

    @LayoutRes
    protected abstract int getLayoutResId();
}