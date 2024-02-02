package ru.localpractic.utils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
//        List list1 = new ArrayList();
//        list1.add(1);
//
//        List list2 = Collections.unmodifiableList(list1);
//        List list3 = Collections.unmodifiableList(new ArrayList<>(list1));
//
//        list1.add(2);
//        list1.add(3);
//
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list3);


            Stream<Integer> mainStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
            List<Integer> listEven = mainStream.filter(item -> item % 2 == 0).collect(toList());
            System.out.println(listEven);

            List<Integer> listOdd = mainStream.filter(item -> item % 2 != 0).collect(toList());
            System.out.println(listOdd);
//
//            List<String> friendsM =  List.of("Peter", "Paul");
//            friendsM.add("Jake");
//            List<String> friendsF =  new ArrayList<>(Arrays.asList("Anna", "Sofia"));
//            friendsF.add("Sarah");
//            Stream.concat(friendsM.stream(),friendsF.stream())
//                    .forEach(System.out::println);
    }




    public MseID checkAccess (Long  jobExecutionID, String userName, Long MSEProcessID, String nosologyID ) {
        MseID mseID = new MseID();
        return mseID;
    }



}