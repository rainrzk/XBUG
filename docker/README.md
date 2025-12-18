
## 构建分离镜像

```
docker buildx build --platform linux/amd64,linux/arm64 \
  -t sterralice/xbug-mysql:latest \
  -f docker/mysql/mysql-dockerfile \
  .\
  --push
```

```
docker buildx build --platform linux/amd64,linux/arm64 \
  -t sterralice/xbug-after:latest \
  -f docker/after/after-dockerfile \
  . \
  --push
```

```
docker buildx build --platform linux/amd64,linux/arm64 \
  -t sterralice/xbug-front:latest \
  -f docker/front/front-dockerfile \
  . \
  --push
```

## 启动容器

```
curl -o docker-compose.yml http://chat.teloivts.xyz:23333/docker/docker-compose.yml
docker-compose up -d
```
