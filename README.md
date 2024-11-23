<p align="center">
    <img src="https://img.shields.io/static/v1?label=%E5%BC%80%E5%8F%91%E6%97%B6%E9%97%B4&message=22/07/04-22/08/02&color=007bff"/>
    <img src="https://img.shields.io/static/v1?label=Spring&message=5.0.5&color=dc3545"/>
    <img src="https://img.shields.io/static/v1?label=Dubbo&message=1.1.24&color=ffc107"/>
    <img src="https://img.shields.io/static/v1?label=Vue&message=2.5.16&color=17a2b8"/> 
    <a href="https://github.com/springbear2020/chinasofti-health" target="_blank">
        <img src="https://img.shields.io/static/v1?label=%E5%BC%80%E6%BA%90%E9%A1%B9%E7%9B%AE&message=chinasofti-health&color=18a745"/>
    </a>
</p>

# 一、快速开始

1. 克隆仓库：使用 Git 克隆仓库或直接下载仓库压缩包到您的计算机来获取源代码。

2. 打开工程：使用 IntelliJ IDEA 开发工具打开克隆的仓库或解压的工程文件，而后使用 Maven 项目构建工具更新工程模块依赖。

3. 创建数据库并导入数据：登录 MySQL 控制台，创建一个名为 chinasofti_health 的数据库，并将 document/sql/chinasofti_health.sql 脚本中的建表语句和数据导入到 health 数据库中。

4. 修改配置：

   - 修改 health-provider/src/main/resources/jdbc.properties 中的数据库连接信息，设置你自己的数据库用户名和密码。

   - 修改 health-provider/src/main/resources/qiniu.properties 中的七牛云配置信息，设置你自己的七牛云令牌信息。
   - 修改 health-provider/src/main/resources/redis.properties 中的 Redis 连接信息，设置你自己的 Redis 服务器地址和端口。

5. 启动后台服务：
   - 启动  ZooKeeper 服务器：双击 ZooKeeper 安装目录下的 bin/ZKserver.cmd 启动注册中心服务。
   - 启动 Redis 服务器：双击 Redis 安装目录下的  redis-server.exe 启动 Redis 服务器。

6. 部署访问：按照下表信息依次为每个模块配置 Tomcat 服务器并启动，从而进入美年健康系统。

   |     工程名      | HTTP 端口 | JMX 端口 | 上下文路径 |     备注     |
   | :-------------: | :-------: | :------: | :--------: | :----------: |
   | health-provider |   8081    |   1099   |     /      | 后端服务系统 |
   | health-backend  |   8082    |  10990   |     /      | 后台管理系统 |
   |  health-mobile  |   8083    |  10991   |     /      | 移动前台系统 |

   ![](document/img/1.1%20工程模块部署.png)

# 二、项目介绍

美年健康管理系统是一款应用于健康管理机构的业务系统，实现健康管理机构工作内容可视化、会员管理专业化、健康评估数字化、健康干预流程化、知识库集成化，从而提高健康管理师的工作效率，加强与会员间的互动，增强管理者对健康管理机构运营情况的了解。系统分为美年健康后台管理系统和移动端应用两部分，其中后台系统提供给健康管理机构内部人员（包括系统管理员、健康管理师等）使用，移动端应用提供给健康管理机构的用户（体检用户）使用。

# 三、系统流程

![](document/img/2.1%20系统流程.png)

# 四、技术架构

![](document/img/2.2%20技术架构.png)

# 五、系统架构

![](document/img/2.3%20系统架构.png)

# 六、系统功能

![](document/img/2.4%20系统功能.png)

| 模块         | 子模块                       | 任务描述                 | 说明                     |
| :----------- | :--------------------------- | :----------------------- | :----------------------- |
| 会员管理     | 会员档案                     | 新增会员                 | 新增会员信息             |
| 会员查询     | 根据条件搜索会员             |                          |                          |
| 编辑会员信息 | 修改会员信息                 |                          |                          |
| 删除会员     | 删除会员                     |                          |                          |
| 会员统计     | 本月预约量                   | 查看本月会员预约的数量   |                          |
| 会员总量     | 查看总共会员的数量           |                          |                          |
| 体检上传     | 上传体检报告                 | 体检报告上传             |                          |
| 删除报告     | 删除体检报告                 |                          |                          |
| 健康评估     | 体质测评                     | 新增评估                 | 根据患者情况填写评估问卷 |
| 查看结果     | 查看评估报告                 |                          |                          |
| 查询评估     | 通过条件查询评估信息         |                          |                          |
| 心理测评     | 新增评估                     | 根据患者情况填写评估问卷 |                          |
| 查看结果     | 查看评估报告                 |                          |                          |
| 查询评估     | 通过条件查询评估信息         |                          |                          |
| 风险测评     | 新增评估                     | 根据患者情况填写评估问卷 |                          |
| 查看结果     | 查看评估报告                 |                          |                          |
| 查询评估     | 通过条件查询评估信息         |                          |                          |
| 知知识库识库 | 评估建议                     | 增删改查                 | 评估建议的增删改查       |
| 健康方案     | 增删改查                     | 健康方案的增删改查       |                          |
| 运动项目库   | 增删改查                     | 运动库的增删改查         |                          |
| 膳食库       | 增删改查                     | 膳食库的增删改查         |                          |
| 疾病库       | 增删改查                     | 疾病库的增删改查         |                          |
| 体检预约     | 预约列表                     | 预约查询                 | 根据条件查询预约信息     |
| 新增预约     | 新增预约信息                 |                          |                          |
| 预约设置     | 日历预约                     | 根据日历排开诊时间       |                          |
| 批量导入     | 导入开诊时间                 |                          |                          |
| 取消预约     | 取消预约时间                 |                          |                          |
| 检测项管理   | 增删改查                     | 检测项的增删改查         |                          |
| 套餐管理     | 新增套餐                     | 新增套餐内容             |                          |
| 修改套餐     | 修改套餐内容                 |                          |                          |
| 查询套餐     | 查询套餐内容                 |                          |                          |
| 健康干预     | 人群分类                     | 系统预分类               | 系统对人群进行预分类     |
| 确认分类     | 健康管理师对人群进行分类确认 |                          |                          |
| 干预方案     | 查询患者                     | 根据条件查询患者         |                          |
| 制定干预方案 | 选择患者制定干预计划         |                          |                          |
| 干预工作台   | 执行干预计划                 | 执行干预计划             |                          |
| 查看干预计划 | 查看干预计划                 |                          |                          |
| 修改干预计划 | 修改干预计划                 |                          |                          |
| 方案模板     | 新增模板                     | 新增方案模板             |                          |
| 查询方案     | 查询方案模板                 |                          |                          |
| 系统设置     | 菜单管理                     | 增删改查                 | 菜单的增删改查           |
| 权限设置     | 增删改查                     | 权限的增删改查           |                          |
| 用户管理     | 增删改查                     | 用户的增删改查           |                          |
| 题库管理     | 增删改查                     | 题库的增删改查           |                          |
| 问卷管理     | 增删改查                     | 问卷的增删改查           |                          |

# 七、工程结构

```lua
chinasofti-health		-- 父工程，统一管理项目依赖
├── document			-- 项目资源目录
├── health-backend		-- 后台管理系统，打包方式为 war，作为服务消费方，需单独启动服务
├── health-common		-- 通用模块，打包方式为 jar，存放通用工具类和实体类等
├── health-interface            -- 接口模块，打包方式为 jar，存放服务层接口类
├── health-mobile		-- 前台应用系统，打包方式为 war，作为服务消费方，通过 Dubbo 暴露服务，需单独启动服务
└── health-provider		-- 后端服务模块，打包方式为 war，作为服务提供方，需单独启动服务
```

# 八、效果展示

## 8.1 后台管理系统

### 8.1.1 检查项

1. 新增检查项

   ![](document/img/8.1%20检查项新增.png)

2. 删除检查项

   ![](document/img/8.2%20检查项删除.png)

3. 编辑检查项

   ![](document/img/8.3%20检查项编辑.png)

4. 查询检查项

   ![](document/img/8.4%20检查项分页.png)

### 8.1.2 检查组

1. 新增检查组：新增时可选择当前检查组对应的检查项信息，一个检查组包含多个检查项。

   ![](document/img/8.5%20检查组新增.png)

2. 删除检查组

   ![](document/img/8.6%20检查组删除.png)

3. 编辑检查组：编辑时可更改当前检查组包含的一系列检查项信息。

   ![](document/img/8.7%20检查组编辑.png)

4. 查询检查组

   ![](document/img/8.8%20检查组分页.png)

### 8.1.3 套餐管理

1. 新增套餐：新增时可选择当前套餐对应的检查组信息，一个套餐包含多个检查组。

   ![](document/img/8.9%20套餐新增.png)

2. 删除套餐

   ![](document/img/8.10%20套餐删除.png)

3. 编辑套餐：编辑时可更改当前套餐包含的一系列检查组信息。

   ![](document/img/8.11%20套餐编辑.png)

4. 查询套餐

   ![](document/img/8.12%20套餐分页.png)

### 8.1.4 预约设置

1. 模板下载：点击 模板下载 按钮将下载预约设置信息 Excel 数据模板文件，包含日期、可预约人数和已预约人数信息。
2. 上传文件：可根据已填写的 Excel 模板文件设置对应日期的可预约和已预约人数信息。
3. 预约设置：可点击某个日期从而设置该日的可预约人数信息。

![](document/img/8.13%20预约设置.png)

## 8.2 前台应用系统 

### 8.2.1 首页

![](document/img/8.14%20首页.png)

### 8.2.2 套餐查询

![](document/img/8.15%20套餐查询.png)

### 8.2.3 体检预约

1. 预约详情

   ![](document/img/8.16%20预约详情.png)

2. 提交预约

   ![](document/img/8.17%20提交预约.png)

### 8.2.4 报告查看

![](document/img/8.18%20报告查看.png)

# 九、许可证

```
MIT License

Copyright (c) 2023 Spring-_-Bear

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

