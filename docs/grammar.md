# 语法

### 变量定义

    var a = 1, b = "123"; // 定义两个变量
    var f = x -> x + 1; // 定义lamdba函数
    var f1 = function f2() { return 1; } // 定义函数f2, 通知赋值给变量f1

### 运算符

    var a = 1 + 1 - 3 * 4 % 5; // 支持四则混合运算
    ++a;
    --a;
    a += 1; 
    a /= 2;  // 支持自加自减
    var flag = a < b; // 支持 <, <=, >, >=, !=, ==等比较运算
    var b = a < b && b > c || !a; // 支持&&, ||, !等关系运算
    // 不支持位运算, 在脚本里意义比较小

### 语句

    if (a % 2 == 0) { // 支持if-else语句
      a %= 2;
    } else {
      a += 1;
    }
    for (var i = 0; i < 100; ++i) { // 支持for循环
      // do something
    }
    for (var x : list) { // 支持for-in循环
      if (x < 5) {
        continue; // 支持continue
      }
      if (x > 10) {
        break; // 支持break
      }
    }
    function f(n) { // 支持函数定义
      if (n < 2) {
        return 1; // 支持函数return
      }
      return f(n - 1) + f(n - 2); // 支持递归
    }
    f(3); // 支持函数调用
    // 不支持while循环, 目前for就够了
    // 暂时不支持new对象

### 语言特性

脚本语言有两个局限.
 一是动态类型, 可以任何对象之间比较常会出现很多麻烦.
 二是不适合写try-catch这种复杂分支逻辑.
 因此, 下面语言特性是是目的是尽量减少麻烦, 尽量少写代码.
 
 1. 在比较大小的时候null最小, bool中的false=0, true=1, 数值类型就按数值大小, String等复合类型都最大.
 2. 基本类型bool, byte, short, int, long, float, double之间可以相互转换.
 3. null可以转换成基本类型, false或者0. 这对于 if条件判断很有用.
 4. 基本类型是有级别的, bool最低, double最高.
 5. 四则运算的时候, 先确定最高级别, 都转化成最高级别再运算. 比如false + 1.0结果是double, 1.0.
 6. 对于加法, 如果有一个是字符串String类型, 那么都是先转化成字符串, 再串联.
 7. 每个语句表达式都是有返回值的. 如果没有return, 那么最后一个计算得到的值就是返回值.