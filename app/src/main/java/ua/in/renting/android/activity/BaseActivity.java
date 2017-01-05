package ua.in.renting.android.activity;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ua.in.renting.android.fragment.BaseFragment;
import ua.in.renting.android.interfaces.ObjectsReceiver;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public abstract class BaseActivity extends AppCompatActivity
        implements ObjectsReceiver {

    @Nullable
    public final Fragment getFragmentFromContainer() {
        return getFragmentFromContainer(getFragmentContainerId());
    }

    @Nullable
    public final Fragment getFragmentFromContainer(@IdRes int containerId) {
        return getSupportFragmentManager().findFragmentById(containerId);
    }

    public boolean startFragment(@NonNull BaseFragment fragment, boolean addToBackStack) {
        final String tag = fragment.getClass().getSimpleName();
        final FragmentManager manager = getSupportFragmentManager();
        final int containerId = getFragmentContainerId();

        if (!addToBackStack && containerId == getFragmentContainerId()
                && manager.getBackStackEntryCount() > 0) {
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerId, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();

        return true;
    }

    @Override
    public void onObjectsReceive(int code, @NonNull Object... objects) {
    }

    @IdRes
    public abstract int getFragmentContainerId();

    public abstract void setBlock(boolean block);
}