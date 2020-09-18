# 用法

## 引入依赖

以maven为例, 应当引入的依赖如下
      <dependency>
          <groupId>com.xiaoming</groupId>
          <artifactId>ma-script</artifactId>
          <version>0.0.44</version>
      </dependency>
      
## 用法示例

花一分钟看下面的java用法示例, 可以说是非常简单了. 

    package com.xiaoming.script;
    
    import com.xiaoming.script.compile.*;
    
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
    
运行结果.

    name = xiaoming, gender = male, age = 30
    name = xiaodan, gender = female, age = 20

## 一般步骤

* 定义上下文.
    * 首先我们定义了一个上下文context. 整个脚本中引用的对象, 都在context保存.
    * 脚本在执行过程中, 会生成新的对象, 也会放到context中.
    * 我们通过context.define可以添加对象进去, 复用java原生的数据和方法.
* 编写脚本
    * 编写脚本语法与java和javascript类似, 但更接近java.
    * 脚本内容可以从配置文件或者数据库中动态加载, 不必固定在代码中.
* 编译运行
    * 调用MaScript.compile方法把代码编译. 其返回值会告知是否有语法错误.(示例未展示)
    * 调用MaScript.run(context)运行脚本.
* 错误处理
    * 因为动态脚本语言, 没有那么多编译期和运行时检查, 运行时遇到错误会抛出exption给宿主, 并停止.
    * 因此编写脚本的时候, 要确认编写的逻辑正确性.
    
## 关键概念

结合上面简单的示例, 我给出这个脚本使用方法的关键概念.

1. 上下文MaContext并不依赖脚本MaScript编译运行. 这意味着, MaScript.run可以传入任何的context.
2. MaScript编译的时候并不需要上下文MaContext, 这意味着, MaScript是无状态的, 编译一次, 到处复用.
3. MaScript.run(context)是有可能改动context中的对值的, 这种context就不纯粹了, 不能复用了. 后面会讲如何复用context.    