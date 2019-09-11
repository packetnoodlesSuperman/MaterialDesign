1. Activity间传递数据问题 为什么不能超过1M
* 了解Activity的启动流程
* 了解aidl
* 了解binder
* 了解Parcel
* 了解序列化 java和Android两种序列化
* 了解ArrayMap数据结构
```
在ActivityManagerProxy的startActivity方法中

public int startActivity(IApplicationThread caller, String callingPackage, Intent intent,
                           ...) throws RemoteException {
    //池中创建两个Parcel对象
    Parcel data = Parcel.obtain();
    Parcel reply = Parcel.obtain();
    ...
    data.writeString(callingPackage);
    //用于写入自己传递的数据
    intent.writeToParcel(data, 0);
    data.writeStrongBinder(resultTo);
    ....//写入数据到data后，远程通信
    mRemote.transact(START_ACTIVITY_TRANSACTION, data, reply, 0);
    int result = reply.readInt();
    reply.recycle();
    data.recycle();
    return result;
}
```
