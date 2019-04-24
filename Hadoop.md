### Hadoop 核心模块:
 - Hadoop Common：工具类、支撑 Hadoop 的其他模块
 - HDFS
 - Hadoop YARN：管理框架和集群资源
 - Hadoop MapReduce：计算框架
 
### Hadoop 生态环境：
 - Hive
 - HBase
 - Spark
 - MapReduce
 - ZooKeeper
 
### HDFS:
 - 文件线性切割成块(Block)：偏移量 offset(byte)
 - Block 分散存储在集群节点中
 - 单一文件的 Block 大小一致，文件与文件可以不一致
 - Block 可以设置副本数，副本无序分散在不同节点中，副本数不要超过节点数量
 - 文件上传可以设置 Block 大小（默认128M）和副本数量（默认3个）
 - 已上传的文件 Block 副本数可以调整，大小不变
 - 只支持一次写入多次读取，同一时刻只有一个写入者
 - 可以 append 追加数据

### Block 副本的放置策略：
 - 第一个副本：放置在上传文件的DN；如果是集群外提交，则随机挑选一台磁盘不太满，CPU不太忙的节点。
 - 第二个副本：放置在与第一个副本不同的机架的节点上。
 - 第三个副本：与第二个副本相同机架的不同节点
 - 更多副本：随机节点
 
### Hadoop 架构模型：
  - 文件元数据 MetaData,文件数据
     - 元数据
     - 数据本身
  - （主）NameNode 节点保存文件元数据：单节点 posix
  - （从）DataNode 节点保存文件 Block 数据：多节点
  - DataNode 与 NameNode 保持心跳，提交 Block 列表
  - HdfsClient 与 NameNode 交互元数据信息
  - HdfsCleint 与 DataNode 交互文件 Block 数据
  - DataNode 利用服务器本地文件系统存储数据块

