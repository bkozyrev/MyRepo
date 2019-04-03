package com.bkozyrev.superchat.login.presentation.view;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.data.AuthState;
import com.bkozyrev.superchat.core.presentation.view.MvpView;

/**
 * Вью логин экрана
 *
 * @author Kozyrev Boris
 */
public interface LoginView extends MvpView {

    /**
     * Поменялось состояние авторизации
     *
     * @param authState состояние авторизации
     */
    void authStateChanged(@NonNull AuthState authState);
}
