<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">X-BUG</h1>
<h4 align="center">轻量化BUG管理平台</h4>
<div align="center">

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Contributors](https://img.shields.io/badge/contributors-5-brightgreen.svg)

</div>

## 平台简介

X-BUG从不只是缺陷累积的平台。字面意思上，X意味着如同将BUG擦除一般。

X-BUG是一套免费开源的缺陷管理平台，它的使用人群锁定个人或中小型软件开发团队，其理念是免去了项目管理中各种重度管理，减少运营投入及成本，让个人或团队可以快速上手，把控软件质量。

平台采用JAVA+VUE开发，支持在各系统平台部署使用。

## 功能介绍

- 团队管理：管理团队中的项目、成员，通常由团队管理员维护。
- 项目管理：管理项目中的缺陷、成员，通常由项目管理员维护。
- 模块管理：管理项目中的软件模块，通常由开发人员维护。
- 缺陷管理：管理需求、用例、BUG，通常由测试人员维护。


## 在线体验

- 默认账号：demo
- 默认密码：123456  

演示地址：[http://chat.teloivts.xyz:33332](http://chat.teloivts.xyz:33332)

## Docker部署

```
curl -o docker-compose.yml http://chat.teloivts.xyz:23333/docker/docker-compose.yml
docker-compose up -d
```

## 本地部署

1. **启动 MySQL**  
   - 默认端口：`3306`
   - 用户名：`root`
   - 密码：`123456`

2. **启动 Redis**  
   - 默认端口：`6379`

3. **启动 Spring Boot**  
   - 在 `xbug-admin` 子模块中执行：  
     ```bash
     mvn clean spring-boot:run
     ```

4. **启动 Vue**  
   - 在 `xbug-ui` 子模块中执行：  
     ```bash
     npm run build:prod
     ```


