package com.bkozyrev.superchat.login.presentation.presenter;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.login.domain.LoginInteractor;
import com.bkozyrev.superchat.login.presentation.view.LoginView;

/**
 * Презентер экрана регитрации пользователя
 *
 * @author Kozyrev Boris
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginInteractor mLoginInteractor;

    public LoginPresenter(@NonNull LoginInteractor loginInteractor) {
        mLoginInteractor = loginInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        observeAuthState();
    }

    private void observeAuthState() {
        getCompositeDisposable().add(
                mLoginInteractor
                        .observeAuthState()
                        .subscribe(
                                authState -> getView().authStateChanged(authState),
                                Throwable::printStackTrace
                        )
        );
    }
}
