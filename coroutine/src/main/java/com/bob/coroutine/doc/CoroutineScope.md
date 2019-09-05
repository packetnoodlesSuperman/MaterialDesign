```
定义一个作用域在一个新的协程里面
每一个协程构建器是 在这个作用域的 扩展
并且继承该作用域内的协程上下文
自动开启和取消上下文

协程作用域 可以管理其域内的所有协程
一个CoroutineScope可以有许多的子scope
创建scope的方式有很多种方法
    使用launch、async等
public interface CoroutineScope {
    public val coroutineContext: CoroutineContext
}

public operator fun CoroutineScope.plus(context: CoroutineContext): CoroutineScope =
    ContextScope(coroutineContext + context)
    
    
    
public fun MainScope(): CoroutineScope = 
    ContextScope(SupervisorJob() + Dispatcher.Main)    
    
    
    
 public object GlobalScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = EmptyCoroutineContext
 }   
```