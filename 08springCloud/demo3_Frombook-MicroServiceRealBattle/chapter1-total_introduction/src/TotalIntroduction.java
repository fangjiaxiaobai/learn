/**
 * @author fangjiaxiaobai
 * @date 2017/12/5
 */
public class TotalIntroduction {
/**
    微服务就是系统架构上的一种设计风格，它的主旨是讲一个原本独立的系统拆分成多个小型
 服务，这些小型服务都在各自独立的进程中运行，服务之间通过基于Http的Restful API进行
 通信协作。
    被拆分的每个小型服务都围绕着系统中的某一项或一些耦合度较高的业务功能进行构建，
 并且每个服务都维护着自身的数据存储，业务开发，自动化测试案例以及独立部署机制。
    微服务的问题：
    运维挑战：
        需要维护的进程数会大大增加。运维过程需要更多的自动化，这就要求运维人员具备一定的开发
 能力来编排运维能力并让他们自动运行起来。
    接口一致性：需要完善的接口和版本管理或者严格的遵循开闭原则。
    分布式的复杂性：分布式的问题都是微服务架构系统设时需要考虑的因素，比如网络延迟，
 分布式事务，异步消息。

    微服务架构的九大特性：
        1.服务组件化。
        2.按业务组织团队。
        3.做产品的态度。
        4.智能断点和哑管道。
            在微服务架构中，使用以下两种服务调用方式：1,使用Http的Restful API或轻量级的消息发送协议
        实现信息传递和服务调用的触发。2.通过轻量级消息总线上传递消息，类似RabbitMQ等一些提供可靠异步交换的中间件。
        5.去中心化治理
            通过采用轻量级的契约定义接口，这样，整个微服务架构系统中的各个组件就能针对不同的业务特点选择不同的
        技术平台。
        6.去中心化管理数据。
            实施微服务架构时，都希望每一个服务来管理其自有的数据库，这就是数据管理的去中心化。但是，数据的
        一致性也称为微服务架构中亟待解决的问题。
        7.基础设施自动化。
            在微服务架构中，务必从一开始就构建“持续交付”凭条来支持整个实施过程。
            则必须1自动化测试：，2.自动化部署：解放繁琐枯燥的重复操作以及多环境的配置管理。
        8.容错设计：
            在微服务架构中，快速检测出故障源并尽可能的自动恢复是必须被设计和考虑的。
        9. 演进式设计：



 SpringCloud 简介：
   spring Cloud 是一个基于SpringBoot实现的微服务架构开发工具。它为微服务架构中涉及的配置管理，服务治理
 断路器，智能路由，微代理，控制总线，全局锁，决策竞选，分布式会话和集群状态管理等操作提供了一种简单的开发方式。
    Spring Cloud组件介绍：
        Spring Cloud config: 配置管理工具，支持使用git存储配置内容，可以使用它使用应用配置的外部化存储
    并支持客户端配置信息刷新，加密解密配置内容。
        Spring Cloud Netflix: 核心组件，
            Eureka：服务治理组件，包含服务注册中心，服务注册和发现机制的实现。
            Hystrix：容错管理组件，实现断路器模式，帮助服务依赖中出现的延迟和为故障提供强大的容错能力。
            Ribbon：客户端负载均衡的服务调用组件。
            Feign：基于Ribbon和Hystrix的声明式调用组件。
            Zuul: 网关组件，提供智能路由，访问过滤等功能。
            Archaius: 外部化配置组件。
        Spring Cloud Bus: 事件，消息总线，用于传播集群中的状态变化或事件，以触发后续的处理，比如用来动态刷新配置等。
        Spring Cloud Cluster: 针对ZooKeeper，Redis，Hazelcast,Consul的选举算法和通用模式的实现。
        Spring Cloud Cloudfoundry:与Pivotal Cloudfoundry的整合支持。
        Spring Cloud Consul: 服务发现与配置管理工具。
        Spring Cloud Stream： 通过Redis，Rabbit或者Kafka实现的消费微服务，可以通过简单的声明式模型来发送和接收消息。
        Spring Cloud AWS：用于简化整合Amazon web Service的组件。
        Spring Cloud Security：安全工具包，提供在Zuul代理中对OAuth2客户端器请求的中继器。
        Spring Cloud Sleuth: Spring Cloud应用的分布式跟踪实现，可以完美结核Zipkin。
        Spring Cloud ZooKeeper: 基于ZooKeeper的服务发现和配置管理组件。
        Spring Cloud Starters: Spring Cloud的基础组件，基于Spring Boot风格项目的基础依赖模块。
        Spring Cloud CLI：用于在Groovy快速创建SpringCloud应用的Spring Boot CLI插件。
            .........

    Spring Cloud 的版本说明：
        Spring CLoud 没有使用1.x.x的形式命名版本。而是根据字母表的顺序来对应版本的时间顺序。
        当一个版本的SpringCloud项目的发布内容积累到了临界点或者一个严重的bug解决可用后，就会发布一个“service releases"
    版本，简称SRX版本，其中X就是一个递增的数字，Brixton.SR5就是Brixton的第五个版本。
        使用Brixton版本时，SpringBoot要使用1.3.x，不能使用1.4.x
        如果要使用SpringBoot 1.4.x,那么Spring Boot要使用Camden版本。

*/










}
