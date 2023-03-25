package com.geekypod.reactiveprog.lab;

import java.util.stream.Stream;

public class StreamLab01 {
// Lazy behaviour of stream
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });

//		System.out.println(integerStream); //prints tostring method of integerStream
//Terminal Operator
        integerStream.forEach(System.out::println);

    }
}
