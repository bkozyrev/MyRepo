package com.bkozyrev.superchat.chat.di.scopes;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ChatScope {
}