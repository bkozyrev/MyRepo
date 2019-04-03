package com.bkozyrev.superchat.chat.presentation.presenter;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.chat.presentation.view.ChatMvpView;
import com.bkozyrev.superchat.core.data.AuthState;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.login.domain.AuthInteractor;

/**
 * Презентер чата
 *
 * @author Kozyrev Boris
 */
public class ChatPresenter extends BasePresenter<ChatMvpView> {

    private AuthInteractor mAuthInteractor;

    public ChatPresenter(@NonNull AuthInteractor authInteractor) {
        mAuthInteractor = authInteractor;
    }

    public void onSignOutClick() {
        observeAuthState();
        mAuthInteractor.signOut();
    }

    private void observeAuthState() {
        getCompositeDisposable().add(
                mAuthInteractor
                        .observeAuthState()
                        .subscribe(
                            authState -> {
                                if (authState.equals(AuthState.SIGNED_OUT)) {
                                    getView().signOut();
                                }
                            }, Throwable::printStackTrace)
        );
    }
}
