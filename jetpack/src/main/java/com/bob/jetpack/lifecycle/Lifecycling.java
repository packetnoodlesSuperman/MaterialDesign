package com.bob.jetpack.lifecycle;

import androidx.lifecycle.GeneratedAdapter;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Lifecycling {

    //reflective callback
//    private static final int REFLECTIVE_CALLBACK = 1;
//
//    private static Map<Class, Integer> sCallbackCache = new HashMap<>();
//
//    static GenericLifecycleObserver getCallback(Object object) {
//        if (object instanceof FullLifecycleObserver) {
//
//        }
//        if (object instanceof GenericLifecycleObserver) {
//
//        }
//
//        final Class<?> Klass = object.getClass();
//        int type = getObserverConstructorType(Klass);
//    }
//
//    private static int getObserverConstructorType(Class<?> Klass) {
//        if (sCallbackCache.containsKey(Klass)) {
//            return sCallbackCache.get(Klass);
//        }
//        int type = resolveObserverCallbackType(Klass);
//    }
//
//    private static int resolveObserverCallbackType(Class<?> Klass) {
//        //getCanonicalName() 是获取所传类从java语言规范定义的格式输出
//        //
//        if (Klass.getCanonicalName() == null) {
//            return REFLECTIVE_CALLBACK;
//        }
//
//        Constructor<? extends GeneratedAdapter> constructor =
//                generatedConstructor(Klass);
//    }
//
//    private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> Klass) {
//        Package aPackage = Klass.getPackage();
//        String name = Klass.getCanonicalName();
//
//        final String fullPackage = aPackage != null ? aPackage.getName() : "";
//        final String adapterName =
//    }
//
//    public static String getAdapterName(String className) {
//        return className.replace(".", "_")+"_LifecycleAdapter";
//    }
}
