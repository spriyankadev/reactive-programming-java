package com.geekypod.reactiveprog.assignment;

import com.geekypod.reactiveprog.util.Util;

import java.io.File;

public class AssignmentDemoLab01 {
    public static void main(String[] args) {

        FileService.read("file01.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.write("file02.txt", "This is File2")
        .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.read("file02.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());


        FileService.write("file03.txt", "This is File3")
                .subscribe(Util.onNext(), Util.onError(), ()-> System.out.println("File 3 created!"));

        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), ()-> System.out.println("File 3 deleted!"));
    }
}
