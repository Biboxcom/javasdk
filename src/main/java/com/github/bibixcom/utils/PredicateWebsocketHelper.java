package com.github.bibixcom.utils;

import java.util.function.Predicate;

public class PredicateWebsocketHelper
{
    public static Predicate<String> isPing(String message)
    {
        return s -> message.contains("ping");
    }

    public static Predicate<String> isPong(String message)
    {
        return s -> message.contains("pong");
    }

    public static Predicate<String> isPingPong(String message)
    {
        return isPing(message).and(isPong(message));
    }

    public static Predicate<String> isError(String message)
    {
        return s -> message.contains("error");
    }
}
