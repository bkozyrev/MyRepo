package com.bkozyrev.superchat.core.presentation.presenter;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.presentation.view.MvpView;

/**
 * Реализация базовой сущности Presenter
 *
 * @param <V> Сущность {@link MvpView}
 *
 * @author Козырев Борис
 */
public class BasePresenter<V extends MvpView> {

    // флаг, определяющий первое присоединение View к Presenter
    private boolean mIsFirstLaunch = true;

    // ссылка на View
    private V mView;

    /**
     * Присоединение View к Presenter
     *
     * @param view Сущность {@link MvpView}
     */
    public void attachView(@NonNull V view) {
        mView = view;

        if (mIsFirstLaunch) {
            mIsFirstLaunch = false;
            onFirstViewAttach();
        }
    }

    /**
     * Отсоединение View от Presenter
     */
    public void detachView() {
        mView = null;
    }

    /**
     * Получение ссылки на {@link MvpView}
     */
    @NonNull
    protected V getView() {
        return mView;
    }

    /**
     * Метод обратного вызова.
     * Вызывается при первом присоединении {@link MvpView} к {@link BasePresenter}
     */
    protected void onFirstViewAttach() {
    }
}
