package com.geekypod.reactiveprog.lab;

import reactor.core.publisher.Mono;

public class MonoJustLab02 {

    public static void main(String[] args) {
        // publisher
        Mono<Integer> integerMono = Mono.just(1);

        System.out.println(integerMono);
//in reactive programming nothing happen until you subscribe
        integerMono.subscribe(i -> {
            System.out.println("Received : " + i);
        });
    }
}
