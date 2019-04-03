package com.bkozyrev.superchat.login.presentation.presenter;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.login.domain.AuthInteractor;
import com.bkozyrev.superchat.login.presentation.view.LoginView;

/**
 * Презентер экрана регитрации пользователя
 *
 * @author Kozyrev Boris
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private AuthInteractor mAuthInteractor;

    public LoginPresenter(@NonNull AuthInteractor authInteractor) {
        mAuthInteractor = authInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        observeAuthState();
    }

    private void observeAuthState() {
        getCompositeDisposable().add(
                mAuthInteractor
                        .observeAuthState()
                        .subscribe(
                                authState -> getView().authStateChanged(authState),
                                Throwable::printStackTrace
                        )
        );
    }
}
