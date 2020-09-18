package com.xiaoming.script;

import com.xiaoming.script.compile.MaCompileResult;
import com.xiaoming.script.compile.MaContext;
import com.xiaoming.script.compile.MaScript;

import java.util.Scanner;

public class Application {
    static class Person {
        public long age = 10;
        public String gender = "male";
        public int updateGender(double n) {
            gender = "female";
            age += n;
            return (int) age;
        }
    }

    public static void main(String[] args) {
        MaContext context = new MaContext();
        Person a = new Person();
        Person b = new Person();
        context.set("a", a);
        context.set("b", b);
        MaScript script = new MaScript();

        MaContext compileContext = context.getSandbox();
        MaContext runContext = context.getSandbox();

        System.out.println("please input script:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                String text = scanner.nextLine();
                long t1 = System.currentTimeMillis();
                MaCompileResult result = script.compile(compileContext, text);
                long t2 = System.currentTimeMillis();
                System.out.println("[compile] cost " + (t2 - t1) + " ms, result: " + result);
                if (!result.message.isEmpty()) {
                    System.out.println(result.message);
                }
                if (result.error == 0) {
                    long t3 = System.currentTimeMillis();
                    Object value = script.run(runContext);
                    long t4 = System.currentTimeMillis();
                    System.out.println("[run] cost " + (t4 - t3) + " ms, result: " + java.lang.String.valueOf(value));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
