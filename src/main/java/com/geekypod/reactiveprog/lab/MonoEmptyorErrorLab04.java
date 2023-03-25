package com.geekypod.reactiveprog.lab;

import com.geekypod.reactiveprog.util.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyorErrorLab04 {

    public static void main(String[] args) {
        //subscriber
        userRepository(20)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    //publisher
    public static final Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // better way of saying null
        } else {
            return Mono.error(new RuntimeException("Not Allowed in the range"));
        }
    }
}
