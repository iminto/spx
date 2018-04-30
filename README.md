#### 启动
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