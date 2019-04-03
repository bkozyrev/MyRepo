package com.bkozyrev.superchat.login.presentation.view;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.data.AuthState;
import com.bkozyrev.superchat.core.presentation.view.MvpView;

/**
 * @author Kozyrev Boris
 */
public interface LoginView extends MvpView {

    void authStateChanged(@NonNull AuthState authState);
}
