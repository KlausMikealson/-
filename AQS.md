JUC中很多同步组件的构建基础
基于 FIFO 队列，可以用于构建锁或其他相关同步装置的基础框架
同步队列的头节点是当前获取到同步状态的节点
获取同步状态失败的节点，会被构造成一个节点（共享式/独占式）加入到同步队列尾部，采用CAS

Node{
    int waitStatus;
    Node prev;
    Node next;
    Node nextWaiter;
    Thread thread;
}

### waitStatus:
 - CANCELLED 当前线程被取消
 - SIGNAL 当前节点的后继节点包含的线程需要运行
 - CONDITION 当前节点在 condition 队列中
 - PROPAGATE 当前场景下后续的acquireShared能够得以执行
 - 0 当前节点在sync队列中，等待着获取锁






