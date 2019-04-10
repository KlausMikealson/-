### 数据淘汰策略：
 1. volatile-lru:淘汰设置过期时间的数据集中最近最少使用的数据
 2. volatile-ttl:淘汰设置过期时间的数据集中快过期的数据
 3. volatile-random:淘汰设置过期时间的数据集中的任意数据
 4. allkeys-lru:淘汰数据集中最近最少使用的数据
 5. allkeys-ttl:淘汰数据集中任意数据
 6. no-enviction:不淘汰，新数据插入报错