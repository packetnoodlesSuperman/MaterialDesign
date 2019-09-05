```
//CoroutineScope内部包含了一个协程上下文（CoroutineContext） 对象
//CoroutineScope 协程的作用域 管理其域内的所有协程
//一个CoroutineScope可以有许多的子scope
public interface CoroutineScope {
     public val coroutineContext: CoroutineContext
}

//GlobalScope
public object GlobalScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = EmptyCoroutineContext
}


//CoroutineContext 协程上下文
public interface CoroutineContext {
    public operator fun <E : Element> get(key: Key<E>): E?
    
    public interface Key<E : Element>
    public interface Element : CoroutineContext {
    
    }
}


//EmptyCoroutineContext

//ContinuationInterceptor

```