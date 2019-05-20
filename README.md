[![build](https://www.travis-ci.org/iminto/spx.svg?branch=master)](https://www.travis-ci.org/iminto/spx)


#### 说明
本项目是基于springboot2+beetl+dubbo的脚手架,nacos分支使用了nacos做服务发现和配置管理
先导入spx-web项目下面的SQL脚本，默认使用了MySQL 8.0数据库，然后启动zookeeper即可
spx-admin项目演示了消费者使用dubbo的场景

### docker运行
``` shell
cd /spx-web/
mvn package dockerfile:build
docker images
docker run -p 8080:8080 /tmp/springx:/tmp -t springboot/spx-web:0.1
# 由于依赖了mysql ,没在一个网络里，所以运行会报错，这里自己百度解决
```

### Nacos分支运行
``` shell
#启动nacos（自行安装）
cd /soft/nacos/bin/ && sh startup.sh -m standalone
#启动sentinel（自行安装）
java -Dserver.port=8858 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=sentinel-dashboard -Dcsp.sentinel.api.port=8719 -jar sentinel-dashboard-1.6.0.jar
#启动项目
java -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8719 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=spx -jar spx-web-0.1.jar
```

