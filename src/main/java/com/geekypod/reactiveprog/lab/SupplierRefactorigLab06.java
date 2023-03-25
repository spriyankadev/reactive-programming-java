package com.geekypod.reactiveprog.lab;

import com.geekypod.reactiveprog.util.Util;
import reactor.core.publisher.Mono;

public class SupplierRefactorigLab06 {
    public static void main(String[] args) {
    getName(); //this will not print inside Mono.fromSupplier

        getName().subscribe(
                Util.onNext()
        );

        getName();
//        Util.sleepSeconds(4); //block the main thread
    }


    public static Mono<String> getName() {
        System.out.println("Enter getName Method");
// only by calling getName() method it will not execute below code, to print this we've to subscribe it
        //Below code will only execute if we subscribe it
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name...");
            Util.sleepSeconds(3);
            return Util.faker().name().firstName();
        }).map(String::toUpperCase);
    }
}
