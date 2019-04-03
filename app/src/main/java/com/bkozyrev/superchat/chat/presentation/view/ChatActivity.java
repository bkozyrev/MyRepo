package com.bkozyrev.superchat.chat.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.bkozyrev.superchat.R;
import com.bkozyrev.superchat.chat.di.scopes.ChatScope;
import com.bkozyrev.superchat.chat.presentation.presenter.ChatPresenter;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.core.presentation.view.BaseActivity;
import com.bkozyrev.superchat.core.presentation.view.ToolbarActivity;

import javax.inject.Inject;

/**
 * Активити чата
 *
 * @author Kozyrev Boris
 */
public class ChatActivity extends ToolbarActivity implements ChatMvpView {

    @Inject
    @ChatScope
    public ChatPresenter mChatPresenter;

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, ChatActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        setUpToolbar(R.string.chat_screen_title, false, false);
    }

    @NonNull
    @Override
    public BasePresenter getPresenter() {
        return mChatPresenter;
    }
}
