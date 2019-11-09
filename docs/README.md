## 不求甚解


本系列将会以一个 WordCount 程序为敲门砖，希望能够追踪一个 Spark 任务提交 YARN 运行的完整轨迹，探明关于 YARN 任务的运行机制以及 YARN 集群的设计思想等入门级理论。目的就是想以最简单的方式来了解顶尖系统的设计。

本系列只是作者的学习笔记，意求能够大略源码，然后简单总结，备忘再温故。

篇中描述的探明过程会借鉴 [Hadoop 官方文档](http://hadoop.apache.org/docs/r2.7.4/hadoop-yarn/hadoop-yarn-site/index.html) 以及 [官方源代码(2.7.4)](https://github.com/apache/hadoop/tree/release-2.7.4-RC0/hadoop-yarn-project/hadoop-yarn) ，入门学习阶段，均是自己粗浅理解，如有偏差之处欢迎各位指点迷津。

---

### YARN 任务跟踪探明

* [「主线」准备一块敲门砖: Word Count Demo](./1.&#32;Demo.md)
* [「主线」向 YARN 提交 Spark 应用](./2.&#32;Client.md)
    * [「支线」Client 参数的版本变更](./2.1&#32;ClientArguments.md)
* [「主线」ResourceManager 出场](./3.&#32;ResourceManager.md)
    * [「支线」ResourceManager 之 RMContext](./3.1&#32;RMContext.md)
    * [「支线」ResourceManager 之事件机制](./3.2&#32;EventDispatcher.md)
    * [「支线」ResourceManager 之高可用](./3.3&#32;RMHignAvaliable.md) (TODO)
* [「主线」ApplicationMaster 出场](./4.&#32;ApplicationMaster.md)
    * [「支线」从 NEW 到 SUBMITTED](./4.1&#32;AM-1.md) (TODO)
    * [「支线」从 SUBMITTED 到 ACCEPTED]() (TODO)
    * [「支线」从 ACCEPTED 到 RUNNING]() (TODO)
* [「主线」NodeManager 出场]() (TODO)
    * ...


