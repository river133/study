总结：
1：对于map/set的选择使用
hashmap，treemap，linkedhashmap

加锁采用：hashtable
Collections.sychronizedXXX

并发高采用：Collections.sychronizedXXX
并发高并要求排序采用：concurrrentsKiplistmap


2、list
ArraysList
LinkedList
Collections.synchronizedXXX

Queue一下2种队列
    CocurrentLinkedQueue
    BlockingQueue
    LinkedBlockingQueue
    ArrayBlockingQueue
    TransferQueue
    SynchronousQueue
    DelayQueue//执行定时任务



