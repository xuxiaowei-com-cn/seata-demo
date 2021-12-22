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

## 测试

- 正常
    - http://localhost:801/b/save
      ``` json
      {
          "a": "A",
          "anum": 1,
          "b": "B",
          "bnum": 1,
          "c": "C",
          "cnum": 1
      }
      ```

- 分布式事务
    - http://localhost:801/b/save

        ```
        {
            "a": "A",
            "anum": 1,
            "b": "B",
            "bnum": 1,
            "c": "C",
            "cnum": 0
        }
        ```
