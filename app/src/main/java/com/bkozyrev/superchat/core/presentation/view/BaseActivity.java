package com.bkozyrev.superchat.core.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import dagger.android.AndroidInjection;

/**
 * Реализация базовой {@code Activity} приложения.
 * Обязательный родитель для всех {@code Activity} в приложении.
 *
 * @param <V> {@link MvpView}
 * @param <P> {@link BasePresenter}
 *
 * @author Козырев Борис
 */
public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        getPresenter().attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }

    /**
     * Получение {@link BasePresenter}
     */
    @NonNull
    public abstract P getPresenter();
}
