package parameter;

import java.util.ArrayList;


/**
 * java应用最终被打成可执行的jar包，此时向应用传入参数的唯一方法是命令行
 * 命令行的参数
 * 命令行方式有5种，idea方式有6种
 * 1 -X             VM Options区域
 * 2 -XX            VM Options区域
 * 3 -Dkey=value    VM Options区域
 * 4 --key=value    Program argument区域
 * 5 key=value      Program argument区域
 * 6                Environment variables区域
 *
 * VM参数：1，2, 特指JVM虚拟机专用参数，如 -Xmx, -Xms, -XX:MaxMetaspaceSize=size等等。
 * 命令行参数：4, 5 在spring boot中特指，commandLineArgs
 * 系统参数：3 存在System.getProperties和Spring的sysProp属性里
 * 环境变量参数：6 命令行里启动jar包，无法为应用传入特定的环境变量参数，只能改全局的环境变量，所有应用共用。但在开发场景下，使用IDEA可为应用专门定制。
 * main方法参数：-jar xxx.jar 后面键入的所有参数都会被作为main方法参数传入进来，由应用程序自己解析。
 */
public class ParameterDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        for (String arg : args) {
            list.add(arg);
        }
        // 在 xxx.jar 后面输入的参数，会被解析到args中
        System.out.println("main方法参数：" + list);
        System.out.println("properties参数: " + System.getProperties());
        System.out.println("env参数:" + System.getenv());
    }
}
