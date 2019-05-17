[![build](https://www.travis-ci.org/iminto/spx.svg?branch=master)](https://www.travis-ci.org/iminto/spx)

### 启动
cd /soft/nacos/bin/ && sh startup.sh -m standalone
java -Dserver.port=8858 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=sentinel-dashboard  -Dcsp.sentinel.api.port=8719  -jar sentinel-dashboard-1.6.0.jar
java -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.api.port=8719 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=spx  -jar spx-web-0.1.jar

#### Docker
```shell
docker run -p 8080:8080 -t springboot/spx
docker run -v  /tmp/springx:/tmp -p 8080:8080 -d  springboot/spx
```

#### 进入容器
```
docker exec -it 28620b sh
```

#### 删除过期的容器
```text
删除none镜像：docker rmi $(docker images -f "dangling=true" -q)
找出引用：docker ps -a
```
