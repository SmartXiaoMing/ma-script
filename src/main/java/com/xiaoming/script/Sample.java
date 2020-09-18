package com.xiaoming.script;

import com.xiaoming.script.compile.*;
import com.xiaoming.script.compile.MaContext;
import com.xiaoming.script.compile.MaScript;

public class Sample {
    static class Console {
        public void log(Object object) {
            System.out.println(String.valueOf(object));
        }
    }
    static class Person {
        private String name = "xiaoming";
        public int age = 30;
        public String gender = "male";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        MaContext context = new MaContext(); // 初始化上下文
        context.define("Console", new Console()); // 添加内置的对象, 将java对象导入到脚本当中
        context.define("person", new Person());

        String src =
                "Console.log('name = ' + person.getName() + ', gender = ' + person.gender + ', age = ' + person.age);" +
                "person.setName('xiaodan');" + // 调用person的公有函数
                "person.age -= 10;" + // 操作person的公共成员变量
                "person.gender = 'female';" +
                "Console.log('name = ' + person.getName() + ', gender = ' + person.gender + ', age = ' + person.age);";

        MaScript maScript = new MaScript(); // 初始化脚本
        maScript.compile(src); // 使用源码src, 编译脚本
        maScript.run(context); // 在上下文context中, 运行脚本
    }
}
