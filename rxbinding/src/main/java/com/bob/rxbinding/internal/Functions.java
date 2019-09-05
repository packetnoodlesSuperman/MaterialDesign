package com.bob.rxbinding.internal;

import io.reactivex.functions.Predicate;

import java.util.concurrent.Callable;

public final class Functions {
    private static final Always ALWAYS_TRUE = new Always(true);
    public static final Predicate<Object> PREDICATE_ALWAYS_TRUE = ALWAYS_TRUE;

    private static final class Always implements Callable<Boolean>, Predicate<Object> {
        private final Boolean value;

        private Always(Boolean value) {
            this.value = value;
        }

        @Override
        public boolean test(Object o) throws Exception {
            return value;
        }

        @Override
        public Boolean call() throws Exception {
            return value;
        }
    }
}
