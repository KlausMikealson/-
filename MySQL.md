### SQL 语句手写语法：
```mysql
SELECT DISTINCT
    <select_list>
FROM
    <left_table> <join_type>
RIGHT
    <right_table> ON <join_condition>
WHERE
    <where_condition>
GROUP BY
    <group_by_list>
HAVING
    <having_condition>
ORDER_BY
    <order_by_condition>
LIMIT
    <limit_num>
```

### join condition:
 - inner join
 - left join
 - right join
 - fullouter join

### 索引的建立：
 - 主键自动建立唯一索引
 - 频繁作为查询条件的字段应该建立索引
 - 外键应该建立索引
 - 频繁更新的字段不应该建立索引
 - where 条件里用不到的字段不建立索引
 - 在高并发条件下倾向于创建组合索引
 - 分组字段应该建立索引

### EXPLAIN：
> 使用 EXPLAIN 关键字可以模拟优化器执行 SQL 查询语句，从而知道 MySQL 如何处理 SQL 语句，来分析查询语句或表结构的性能瓶颈。

使用方法：EXPLAIN + SQL 语句

作用：
 - 表的读取顺序
 - 数据读取操作的操作类型
 - 哪些索引可以使用
 - 哪些索引被实际使用
 - 表之间的引用
 - 每张表有多少行被优化器查询

参数：
 - id
 - select_type
 - table
 - type
    - ALL
    - index
    - range
    - ref
    - eq_ref
    - const, system
    - NULL
 - possible_keys
 - key
 - key_len
 - ref
 - rows
 - Extra
    - Using filesort
    - Using where
    - Using index
    - Using temporary
    - Using join buffer
    - impossible where
    - distinct
 
 ### 存储引擎：
 - InnoDB
 - MyISAM

### InnoDB compare with MyISAM:
 - count 运算的区别：MyISAM 缓存了表 meta-data(行数等)，所在执行 count(*) 时，MyISAM 更高效
 - 是否支持事务和崩溃后的安全恢复：InnoDB支持事务、回滚、崩溃修复能力，MyISAM 强调性能
 - 是否支持外键：InnoDB 支持，MyISAM 不支持
 - 适用表：InnoDB 适用于 写密集型表，MyISAM 适用于读密集型表
 - MyISAM 锁粒度大，不适合高并发，支持数据压缩，适合存储海量数据

### 索引使用的数据结构：
 - BTree 索引
 - 哈希索引

### 大表优化方法：
 - 限定数据范围
 - 读写分离
 - 缓存
 - 垂直拆分
    - 优点：减少IO，简化表结构，易于维护
    - 缺点：主键冗余，引入 join 操作，加大事务难度
 - 水平分区
    - 优点：支持很大的数据量，应用端改动少
    - 缺点：分片事务，分片join很复杂

### 数据分片的两种方案：
 - 客户端代理：分片逻辑在应用端，封装在jar包，通过修改封装 jdbc 实现
 - 中间件代理

### 支持事务的数据库的特性：
 - 原子性
 - 一致性
 - 隔离性
 - 永久性

### 事务的隔离级别：
 - 读未提交
 - 读已提交
 - 重复读取
 - 串行化