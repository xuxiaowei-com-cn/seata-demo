# seata-demo

## nacos

- 版本
    - 2.0.3
- 启动（单机模式）
    - Windows
        ```
        startup.cmd -m standalone
        ```
    - Linux
        ```
        startup.sh -m standalone
        ```
- 说明
    - 为了方便操作、全部配置可追踪和下载后即可使用，nacos 配置中不进行任何配置
    - nacos 未做任何改动

## seata

- 版本
    - 1.4.2
- 说明
    - [配置修改](./seata)

## zipkin-server

- [GitHub](https://github.com/openzipkin/zipkin)
- [maven](https://repo1.maven.org/maven2/io/zipkin/zipkin-server/)
    - 下载：`zipkin-server-*.*.*-exec.jar`
    - 访问：[http://127.0.0.1:9411/zipkin/](http://127.0.0.1:9411/zipkin/)
    - [使用 MySQL 储存数据](https://github.com/openzipkin/zipkin/blob/master/zipkin-server/src/main/resources/zipkin-server-shared.yml#L168)
        - SQL
            - `zipkin-server-*.*.*-exec.jar` 中的 `zipkin-storage-mysql-v1-*.*.*.jar` 中的 `mysql.sql`
        - 执行
          ```
          java -jar zipkin-server-*.*.*-exec.jar --STORAGE_TYPE=mysql --MYSQL_HOST=127.0.0.1 --MYSQL_TCP_PORT=3306 --MYSQL_DB=zipkin --MYSQL_USER=root --MYSQL_PASS=root
          ```
