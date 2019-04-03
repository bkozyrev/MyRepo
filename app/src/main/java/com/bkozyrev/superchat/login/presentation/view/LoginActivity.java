package com.bkozyrev.superchat.login.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import com.bkozyrev.superchat.R;
import com.bkozyrev.superchat.chat.presentation.view.ChatActivity;
import com.bkozyrev.superchat.core.data.AuthState;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.core.presentation.view.ToolbarActivity;
import com.bkozyrev.superchat.login.presentation.presenter.LoginPresenter;
import com.firebase.ui.auth.AuthUI;

import javax.inject.Inject;
import java.util.Collections;

/**
 * Активити авторизации пользователя
 *
 * @author Kozyrev Boris
 */
public class LoginActivity extends ToolbarActivity implements LoginView {

    private static final int SIGN_IN_REQUEST_CODE = 3;

    @Inject
    LoginPresenter mLoginPresenter;

    private Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpToolbar(R.string.login_screen_title, false, false);
        initView();
    }

    @NonNull
    @Override
    public BasePresenter getPresenter() {
        return mLoginPresenter;
    }

    @Override
    public void authStateChanged(@NonNull AuthState authState) {
        switch (authState) {
            case SIGNED_OUT:
                break;
            case SIGNED_WITH_GOOGLE:
                Intent intent = ChatActivity.newIntent(this)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
        }
    }

    private void initView() {
        mSignInButton = findViewById(R.id.sign_in_button);

        mSignInButton.setOnClickListener(v -> {
            startActivityForResult(AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Collections.singletonList(
                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    SIGN_IN_REQUEST_CODE);
        });
    }
}
