# YARN 任务跟踪探明

<br>

### 不求甚解

本系列以 WordCount 任务作为敲门砖，追踪一个 Spark 应用提交到 YARN 运行的完整轨迹，探明 YARN 任务的运行机制和 YARN 集群的设计思想等入门级理论。目的就是希望能够以最简单的方式来了解顶尖系统的设计。

本系列只是作者的学习笔记，意求能够大略源码，简单总结，备忘再温故。

篇中描述的探明过程主要借鉴于官方源码以及文档。入门学习阶段，均是自己粗浅理解，如有偏差之处欢迎各位指点迷津。

<br>

### 章节目录

* [「主线」准备一块敲门砖: Word Count Demo](./1.&#32;Demo.md)
* [「主线」向 YARN 提交 Spark 应用](./2.&#32;Client.md)
    * [「支线」ClientArguments 在 Spark 1.x 与 2.x 中的使用变更](./2.1&#32;ClientArguments.md)
* [「主线」ResourceManager 出场](./3.&#32;ResourceManager.md)
    * [「支线」ResourceManager 之 RMContext](./3.1&#32;RMContext.md)
    * [「支线」ResourceManager 之事件机制](./3.2&#32;EventDispatcher.md)
    * [「支线」ResourceManager 之 NodeManager (TODO)](./3.3&#32;RMHignAvaliable.md)
    * [「支线」ResourceManager 之高可用 (TODO)](./3.3&#32;RMHignAvaliable.md)
    * [「支线」ResourceManager 之资源调度器 (TODO)](./3.4&#32;ResourceScheduler.md)
* [「主线」ApplicationMaster 出场](./4.&#32;ApplicationMaster.md)
* [「主线」从 NEW 到 SUBMITTED](./5&#32;LaunchAM-1.md) (TODO)
* [「主线」从 SUBMITTED 到 ACCEPTED](./5&#32;LaunchAM-2.md) (TODO)
* [「主线」从 ACCEPTED 到 RUNNING](./5&#32;LaunchAM-2.md) (TODO)
* ***未完待续***

<br>

### 相关链接

* [Hadoop 官方文档](http://hadoop.apache.org/docs/r2.7.4/hadoop-yarn/hadoop-yarn-site/index.html)

* [Hadoop-Yarn 源码(2.7.4)](https://github.com/apache/hadoop/tree/release-2.7.4-RC0/hadoop-yarn-project/hadoop-yarn)

* [Spark 官方文档](http://spark.apache.org/docs/2.3.0/)

* [Spark 源码(2.3.0)](https://github.com/apache/spark/tree/v2.3.0)