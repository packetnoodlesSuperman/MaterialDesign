```
定义 协程构建器的 开始选线
它是使用在  CoroutineScope.launch 的 start 参数中 
            CoroutineScope.async 的 start 参数中， 
            以及 其他协程构建器的函数中
            
协程启动的选项以下几种
    DEFAULT
    LAZY
    ATOMIC
    UNDISPATCHED            
public enum class CoroutineStart {


    public operator fun <T> invoke(block: suspend () -> T, completion: Continuation<T>) =
        when(this) {
            CoroutineStart.DEFAULT -> block.startCoroutineCancellable(completion)
            CoroutineStart.ATOMIC -> block.startCoroutine(completion)
            CoroutineStart.UNDISPATCHED -> block.startCoroutineUndipatched(completion)
            CoroutineStart.LAZY -> Unit
        }

}
```