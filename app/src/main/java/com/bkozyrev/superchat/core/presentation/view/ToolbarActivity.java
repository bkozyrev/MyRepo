package com.bkozyrev.superchat.core.presentation.view;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.bkozyrev.superchat.R;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;

/**
 * Базовая активити для работы с {@code Toolbar}
 *
 * @author Козырев Борис
 */
public abstract class ToolbarActivity<V extends MvpView, P extends BasePresenter<V>> extends BaseActivity<V, P> {

    private static final String TAG = "ToolbarActivity";

    protected Toolbar mToolbar;

    /**
     * Первая настройка тулбара. Рекомендуется вызывать сразу после {@link android.app.Activity#setContentView(int)}
     * @param titleResId              идентификатор строки для заголовка тулбара.
     * @param homeButtonEnabled       флаг отображения кнопки назад
     * @param displayHomeAsUpEnabled  флаг возврата на уровень назад
     */
    protected void setUpToolbar(@StringRes @Nullable Integer titleResId,
                                boolean homeButtonEnabled,
                                boolean displayHomeAsUpEnabled) {
        mToolbar = findViewById(R.id.toolbar);

        if (mToolbar != null) {
            mToolbar.setVisibility(View.VISIBLE);
            setSupportActionBar(mToolbar);
        } else {
            Log.e(TAG, "Toolbar not found!");
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (titleResId != null) {
                actionBar.setTitle(titleResId);
            }
            actionBar.setHomeButtonEnabled(homeButtonEnabled);
            actionBar.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
        }
    }

    protected void hideToolbar() {
        mToolbar = findViewById(R.id.toolbar);

        if (mToolbar != null) {
            mToolbar.setVisibility(View.GONE);
        } else {
            Log.e(TAG, "Toolbar not found!");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
