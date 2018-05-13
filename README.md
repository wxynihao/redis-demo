# 1	NoSQL
## 1.1	需求
高并发读写
海量数据的高效率存储与访问
高可扩展性和高可用性
## 1.2	产品分类
|分类|代表产品|典型应用场景|数据模型|优点|缺点|
|---|---|---|---|---|---|
|键值（key-value）|Tokyo Cabinet/Tyrant, Redis, Voldemort, Oracle BDB|内容缓存，主要用于处理大量数据的高访问负载，也用于一些日志系统等等|Key 指向 Value 的键值对，通常用HashTable来实现|查找速度快|数据无结构化，通常只被当作字符串或者二进制数据|
|列存储数据库|	Cassandra, HBase, Riak|分布式的文件系统|以列簇式存储，将同一列数据存在一起|查找速度快，可扩展性强，更容易进行分布式扩展|功能相对局限|
|文档型数据库|	CouchDB, MongoDb|Web应用（与Key-Value类似，Value是结构化的，不同的是数据库能够了解Value的内容）|Key-Value对应的键值对，Value为结构化数据|数据结构要求不严格，表结构可变，不需要像关系型数据库一样需要预先定义表结构|查询性能不高，而且缺乏统一的查询语法。|
|图形(Graph)数据库|Neo4J, InfoGrid, Infinite Graph|社交网络，推荐系统等。专注于构建关系图谱|图结构|利用图结构相关算法。比如最短路径寻址，N度关系查找等|很多时候需要对整个图做计算才能得出需要的信息，而且这种结构不太好做分布式的集群方案。|

# 2	概述
## 2.1	Redis简介
Remote Dictionary Server(Redis) 是使用ANSI C语言编写的key-value存储系统，支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。

它通常被称为数据结构服务器，因为值（value）可以是 字符串(String)， 哈希(Map)，列表(list)，集合(sets) 和 有序集合(sorted sets)等类型。

应用场景：缓存、任务队列、排行榜、网站访问统计、数据过期处理、分布式集群架构中的session分离

## 2.2	安装
### 2.2.1	下载

https://github.com/MSOpenTech/redis/releases

### 2.2.2	运行

1. 服务端

```
redis-server.exe redis.windows.conf
```

1. 客户端

```
redis-cli.exe -h 127.0.0.1 -p 6379
```

### 2.2.3	基本操作
* 添加：set name value
* 获取：get name
* 删除：del name
* 查询：keys *

# 3	Jedis

Redis的Java客户端开发包。

https://github.com/xetorthio/jedis

## 3.1	基本使用

``` java
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "rain");
        String val = jedis.get("name");
        System.out.println(val);
        jedis.close();
```

## 3.2	连接池使用

``` java
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("date", "5/18");
        String val = jedis.get("name");
        System.out.println(val);
        jedis.close();
        jedisPool.close();
```

# 4	数据结构
## 4.1	String

## 4.2	Hash

## 4.3	List
## 4.4	Set
## 4.5	SortedSet



# 5	参考资料
1.	《Redis教程》 菜鸟教材 http://www.runoob.com/redis/redis-tutorial.html
2.	《Redis入门教程》 慕课网 https://www.imooc.com/view/839

