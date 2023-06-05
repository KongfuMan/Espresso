import espresso.syntax.EspressoCompiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        //String script = "45+10*2;";
        //String script = "int age = 44; { int i = 10; age+i;}";
        //String script = "int age = 44; for(int i = 0;i<10;i++) { age = age + 2;} int i = 8;";
        //String script = "int b= 10; int myfunc(int a) {return a+b+3;} myfunc(2);";
//        String script = "class myclass{int a=2; int b; myclass(){ b = 3;} } ";
        //String script = "class class1{int a=2; int b; void method1(){println(\"in class1\");}} class class2 extends class1{int b = 5; void method1(){println(\"in class2\");} } class1 c = class2(); println(c.a); println(c.b); c.method1();";
        //String script = "class myclass{int a; int b; myclass(){a=1; b=2;} int calc(){return a + b;} } myclass c = myclass(); c.calc();";
        //String script = "println(2);";
        //String script = "int fun1(int a){return a+1;} println(fun1(2)); function int(int) fun2=fun1; fun2(3);";
        //String script = "int a=0; function int() fun1(){int b=0; int inner(){a=a+1; b=b+1; return b;} return inner;} function int() fun2 = fun1(); println(fun2()); println(fun2());";
        //String script = "println(2+3.5); println(\"Hello \" + 45); ";
        String scriptFile = "/Users/charles/Documents/projects/Espresso/src/main/java/espresso/syntax/MyClass.esp";
        String script = readTextFile(scriptFile);
        EspressoCompiler compiler = new EspressoCompiler();
        compiler.compile(script);
    }

    /**
     * 读文本文件
     * @param pathName
     * @return
     * @throws IOException
     */
    private static String readTextFile(String pathName) throws IOException {
        StringBuffer buffer = new StringBuffer();
        try (FileReader reader = new FileReader(pathName);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append('\n');
            }
        }
        return buffer.toString();
    }
}
