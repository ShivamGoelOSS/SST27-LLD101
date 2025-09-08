package com.example.notifications;

import java.util.Objects;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier next;

    protected NotifierDecorator(Notifier next) {
        this.next = Objects.requireNonNull(next, "next");
    }
}


