package com.bob.code.bundle;

import android.os.BaseBundle;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import androidx.annotation.RequiresApi;

/**
 * 它使用final修饰，所以不可以被继承
 * 它实现了两个接口，cloneable和Parcelable
 *
 * 为什么Intent数据限制是 1MB
 *
 * Parcel机制使用了一个共享内存，这个共享内存就叫Binder transaction buffer，
 * 这块内存有一个大小限制，目前是1MB，而且共用的，当超过了这个大小就会报错
 *
 * https://www.jianshu.com/p/ae1aa13a3f51
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public final class Bundle
// extends BaseBundle implements Cloneable, Parcelable
{

    //BaseBundle 的 成员变量
    /**
     * 使用的是ArrayMap，这个集合类存储的也是键值对，但是与HashMap不同的是，
     * HashMap采用的是“数组+链表”的方式存储，
     * 而ArrayMap中使用的是两个数组进行存储
     */
    ArrayMap<String, Object> mMap = null;

    public void putByte(String key, byte value) {
        mMap.put(key, value);
    }
}
