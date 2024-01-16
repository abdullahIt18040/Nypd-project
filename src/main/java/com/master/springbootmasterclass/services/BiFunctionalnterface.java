package com.master.springbootmasterclass.services;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionalnterface implements BiFunction<List<Integer>,List<Integer>,List<Integer>>{
    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {

        return Stream.of(list1,list2).flatMap(List::stream).distinct().collect(Collectors.toList());
    }
}
