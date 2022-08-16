package ru.telegram.bot.utils;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Utils {

    public static <V, T> T safeGet(V v, Function<V, T> f) {
        return Optional.ofNullable(v).map(f).orElse(null);
    }

    public static <E> E safeGet(Supplier<E> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return null;

        }
    }
}