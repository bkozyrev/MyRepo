package com.bkozyrev.superchat.chat.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import com.bkozyrev.superchat.R;
import com.bkozyrev.superchat.chat.di.scopes.ChatScope;
import com.bkozyrev.superchat.chat.presentation.presenter.ChatPresenter;
import com.bkozyrev.superchat.core.presentation.presenter.BasePresenter;
import com.bkozyrev.superchat.core.presentation.view.ToolbarActivity;
import com.bkozyrev.superchat.login.presentation.view.LoginActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                mChatPresenter.onSignOutClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public BasePresenter getPresenter() {
        return mChatPresenter;
    }

    @Override
    public void signOut() {
        startActivity(LoginActivity.newIntent(this)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}
