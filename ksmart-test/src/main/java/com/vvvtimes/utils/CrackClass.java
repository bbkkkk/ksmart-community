package com.vvvtimes.utils;


import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class CrackClass {

    public static void crack(String oldJarPath, String outClassPath) throws NotFoundException, CannotCompileException, IOException {
        // 这个是得到反编译的池
        ClassPool pool = ClassPool.getDefault();

        // 取得需要反编译的jar文件，设定路径
        pool.insertClassPath(oldJarPath);

        // 取得需要反编译修改的文件，注意是完整路径
        CtClass cc1 = pool.get("com.ibm.websphere.jdbc.base.BaseConnection");

        try {
           /* // 取得需要修改的方法
            CtMethod method = cc1.getDeclaredMethod("check");
            // 修改方法体直接return true;
            method.setBody("{return true;}");*/
            CtMethod m = cc1.getDeclaredMethod("open");
            m.instrument(new ExprEditor() {

                @Override
                public void edit(MethodCall m) throws CannotCompileException {
                    if (m.getClassName().equals("com.ibm.websphere.jdbc.base.BaseLicenseUtility")
                            && m.getMethodName().equals("isLocked")) {
                        m.replace("$_=false;");
                        System.out.println("find");
                    }
                }

            });
            cc1.writeFile(outClassPath);
            System.out.println("反编译class修改成功");
        } catch (NotFoundException e) {
            System.out.println("反编译class异常:" + e);
        }
    }

}
