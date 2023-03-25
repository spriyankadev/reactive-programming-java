package com.geekypod.reactiveprog.lab;

import com.geekypod.reactiveprog.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnableLab08 {

    public static void main(String[] args) {
//        Runnable runnable = () -> System.out.println("");

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        ()->{
                            System.out.println("process is done. Sending emails..");
                        });

//        Util.sleepSeconds(4);
    }

    private static Runnable timeConsumingProcess(){
        return () ->{
            Util.sleepSeconds(3);
            System.out.println("Operation Completed");
        };
    }
}
