package com.geekypod.reactiveprog.lab;

import com.geekypod.reactiveprog.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFutureLab07 {

    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());
        Util.sleepSeconds(1);
    }

    public static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(()-> Util.faker().name().fullName());
    }
}
