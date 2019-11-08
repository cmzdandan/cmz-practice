package com.cmz.proxy;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/10/30
 * @description 代理的处理类
 */
public class ProxyHandler {

    static Path path = Paths.get("com/cmz/proxy/AutoExecProxy.java");

    public  void proxy() throws Exception {
        this.createJavaFile();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int run = compiler.run(null, null, null, path.toString());
        if (run == 0) { // 0为编译成功，1为报错
            this.loadProxy();
        }
    }

    /**
     * 反射调用
     * @throws Exception
     */
    private  void loadProxy() throws Exception {
        URL url = Paths.get(System.getProperty("user.dir")).toUri().toURL();
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        Class<?> autoProxy = loader.loadClass("com.cmz.proxy.AutoExecProxy") ;
        Object o = autoProxy.newInstance();
        Method method = autoProxy.getDeclaredMethod("proxy");
        method.invoke(o) ;
    }

    /**
     * 创建java文件
     * @throws IOException
     */
    private  void createJavaFile() throws IOException {
        String src = "package com.cmz.proxy;\n" +
                "\n" +
                "public class AutoExecProxy {\n" +
                "    public static void proxy(){\n" +
                "        AutoExecProxy.before();\n" +
                "        Exec.exec();\n" +
                "        AutoExecProxy.after();\n" +
                "    }\n" +
                "\n" +
                "    private static void before(){\n" +
                "        System.out.println(\"before.....\");\n" +
                "    }\n" +
                "\n" +
                "    private static void after(){\n" +
                "        System.out.println(\"after.....\");\n" +
                "    }\n" +
                "}" ;
        Files.write(path,src.getBytes(), StandardOpenOption.CREATE) ;
    }
}
