package com.geekypod.reactiveprog.lab;

import com.geekypod.reactiveprog.util.Util;
import reactor.core.publisher.Mono;

public class MonoSubscribeLab03 {
    public static void main(String[] args) {
        //publisher
        Mono<Integer> stringMono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);

        //1
        stringMono.subscribe(
                // To reuse lambda expression added these method in Util class
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
//                i -> {
//                    System.out.println(i);
//                }, err -> {
//                    System.out.println(err.getMessage());
//                },
//                () -> {
//                    System.out.println("Completed");
//                }
                );
    }
}
