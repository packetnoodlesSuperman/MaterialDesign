* Continuation 是一种描述程序的控制状态的抽象



```
public interface Continuation<in T> {

    public val context: CoroutineContext;
    
    public fun resumeWith(result: Result<T>)
    
}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetension.BINARY)
public annotation class RestrictsSuspension

public inline fun <T> Continuation<T>.resume(value: T): Unit = 
    resumeWith(Result.success(value))
    
    
``` 