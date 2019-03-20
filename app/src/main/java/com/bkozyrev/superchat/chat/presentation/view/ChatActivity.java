package com.bkozyrev.superchat.chat.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.bkozyrev.superchat.R;
import com.bkozyrev.superchat.chat.di.scopes.ChatScope;
import com.bkozyrev.superchat.chat.presentation.presenter.ChatPresenter;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.core.presentation.view.BaseActivity;

import javax.inject.Inject;

/**
 * Активити чата
 *
 * @author Kozyrev Boris
 */
public class ChatActivity extends BaseActivity implements ChatMvpView {

    @Inject
    @ChatScope
    public ChatPresenter mChatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
    }

    @NonNull
    @Override
    public BasePresenter getPresenter() {
        return mChatPresenter;
    }
}
