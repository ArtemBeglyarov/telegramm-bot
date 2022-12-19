package ru.localpractic.utils;

import java.time.LocalDateTime;
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

    public static void main(String[] args) {
        String str = "2009-12-02T11:25:25";

// parse string to `LocalDateTime`
        LocalDateTime dateTime = LocalDateTime.parse(str);
        System.out.println(dateTime);
//
//        List<String> l = new ArrayList<>();
//        String a = "fwfwfwfwfwfwfwfwf";
//        String b = "cvcvcvcvcvcvcvcvcv";
//        String c = "dcvcvcv";
//        String d = "dsdfdfd";
//
//        l.add(a);
//        l.add(b);
//        l.add(c);
//        l.add(d);
//
//        System.out.println(l.toString());
    }




    public MseID checkAccess (Long  jobExecutionID, String userName, Long MSEProcessID, String nosologyID ) {
        MseID mseID = new MseID();


        return mseID;
    }



}