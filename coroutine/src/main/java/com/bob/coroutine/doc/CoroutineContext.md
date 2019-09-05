```
协程上下文
协程上下文包含 当前协程的scope信息
public interface CoroutineContext {
    
    public operator fun <E : Element> get(key: Key<E>): E?
    
    public fun <R> fold(initial: R, operation: (R, Element) -> R): R
    
    public operator fun plus(context: CoroutineContext): CoroutineContext =
        if (context === EmptyCoroutineContext) this else
            context.fold(this) { acc, element ->
                val removed = acc.minusKey(element.key)
            }
}
```