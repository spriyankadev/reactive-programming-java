package com.geekypod.reactiveprog.lab;

import com.geekypod.reactiveprog.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MonoFromSupplierLab05 {

    public static void main(String[] args) {
        // use just only when you already have data, else any calculation required on data then use fromSupplier
        //   Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        // getName() method will be called only if we've subscribe it
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext(), Util.onError(), Util.onComplete()
        );

        Callable<String> stringCallable = () -> getName();
        // getName() method will be called only if we've subscribe it
        Mono<String> monoFromCallable = Mono.fromCallable(stringCallable);
        monoFromCallable.subscribe(
                Util.onNext()
        );
    }

    public static String getName() {
        System.out.println("Generating Name...");
        return Util.faker().name().firstName();
    }
}
