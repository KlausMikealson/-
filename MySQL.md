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

EXPLAIN：
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
 
