package top.xgoding.dubbo.samples.spi.javassist;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 * @see org.apache.dubbo.common.compiler.support.JavassistCompiler
 * </p>
 *
 * @package: top.xgoding.dubbo.samples.spi.javassist
 * @description:
 * @author: yxguang
 * @date: 2020/11/22
 * @version: V1.0
 * @modified: yxguang
 */
public class JavassistDemo {
    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //初始化Javassist类池
        ClassPool classPool = ClassPool.getDefault();
        //创建HelloWorld类
        CtClass hello_world = classPool.makeClass("Hello World");
        //为HelloWorld类添加一个test方法
        CtMethod testMethod = CtNewMethod.make("public static void test(){ System.out.println(\"Hello World\"); }", hello_world);
        hello_world.addMethod(testMethod);
        //生成类
        Class aClass = hello_world.toClass();
        //通过反射调用实例类
        Object object = aClass.newInstance();
        Method test = aClass.getDeclaredMethod("test", null);
        //调用方法
        test.invoke(object, null);
    }
}
