> 开发时间：2022-07.04 - 至今

# 一、快速开始

1.  克隆仓库：使用 Git 克隆仓库或直接下载仓库压缩包到您的计算机

2. 打开工程：使用 `IntelliJ IDEA`  打开克隆的仓库或解压的工程文件，而后使用 Maven 工具更新父工程依赖

3. 创建数据库和表：登录 MySQL  创建 `health` 数据库，将 `health-provider/src/main/resources/sql/health.sql` 文件中的数据库表导入 health 数据库中

4. 修改配置信息：

   > 1. 修改 `health-provider/src/main/resources/jdbc.properties` 中的数据库用户名和密码信息 

5. 启动 `ZooKeeper` 服务器：双击 zookeeper 安装目录下的 `ZKserver.cmd` 启动服务（默认监听 2181 端口）

6. 部署访问：部署 Tomcat 启动 `health-provider`，而后再启动 `health-backend`

# 二、项目概述

## 2.1、项目介绍

美年健康管理系统是一款应用于健康管理机构的业务系统，实现健康管理机构工作内容可视化、会员管理专业化、健康评估数字化、健康干预流程化、知识库集成化，从而提高健康管理师的工作效率，加强与会员间的互动，增强管理者对健康管理机构运营情况的了解。系统分为美年健康后台管理系统和移动端应用两部分。其中后台系统提供给健康管理机构内部人员（包括系统管理员、健康管理师等）使用，移动端应用提供给健康管理机构的用户（体检用户）使用。

## 2.2、总体流程

![在这里插入图片描述](https://img-blog.csdnimg.cn/7a46aedc49094e5687f1f0be0e632d2a.png#pic_center)




## 2.3、技术结构

![在这里插入图片描述](https://img-blog.csdnimg.cn/9f81eb944cb1485b944e11ad5aa468d0.png#pic_center)


## 2.4、功能架构

![在这里插入图片描述](https://img-blog.csdnimg.cn/8f0322443763497c8c06fb5559752234.png#pic_center)


## 2.5、功能列表

| 模块         | 子模块                       | 任务描述                 |                          |
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

## 2.6、产品结构

1. 结构

![在这里插入图片描述](https://img-blog.csdnimg.cn/af3c3aa52b1740efbe89024d0f0167bc.png#pic_center)


2. 首页

![在这里插入图片描述](https://img-blog.csdnimg.cn/3663aed8dd1e4d64abbbfe9c3532733a.png#pic_center)



3. 会员管理

![在这里插入图片描述](https://img-blog.csdnimg.cn/b00bd52e50524843b8c9d86d132d1feb.png#pic_center)


4. 预约管理

![在这里插入图片描述](https://img-blog.csdnimg.cn/745bc756dd75446097f4e3c521c3a178.png#pic_center)


5. 健康评估

![在这里插入图片描述](https://img-blog.csdnimg.cn/418e6afa3d604bd786c64d93c78868c8.png#pic_center)


6. 健康干预

![在这里插入图片描述](https://img-blog.csdnimg.cn/5842c1b232034de788f1c063d8752156.png#pic_center)





# 三、系统设计

## 3.1、项目结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/0ff09393d27d45bc8895ad4c74dcc5d3.png#pic_center)


## 3.2、功能设计

### 1. 会员管理

会员管理主要是健康管理师管理患者的界面，患者来源包括直接到诊注册，预约用户，其中到诊注册用户为健康管理师直接添加患者信息；预约到诊用户为健康管理师完善信息。体检上传功能为患者上传体检报告，可以删除报告信息。会员统计用于统计本月预约量及全部预约量。

1. 会员档案：显示所有患者信息，可以对患者进行增删改查

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/9ed75abd65c4449a8d223f630b515ecd.png#pic_center)


2. 报告上传：显示已经预约的列表，可以上传患者的体检报告，到检的患者可以直接新增信息

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/065b5974ebd4484ea3f45e5c347af6ce.png#pic_center)


### 2. 预约管理

预约功能包含患者预约体检项目以及体检时间，健康管理师查看已预约患者并确认患者是否到诊。以及后台管理员维护预约项目、预约套餐数据。

1. 预约列表：查看患者预约情况，对预约信息进行操作的页面

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/408c614e55ce48b49fc14d5f813fd9ff.png#pic_center)


2. 检查项管理

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/bdc69db597e2422cb7ea816ecb2c8ef4.png#pic_center)


### 3. 健康评估

健康评估主要是帮助健康管理师对患者进行健康评估的方式，如果患者未做过评估，则健康管理师对患者进行现场评估；如果患者做过健康评估，则健康管理师查询患者信息查看患者评估结果。

1. 风险评估：健康管理师对患者进行评估使用的列表，可以新增评估或查看患者评估结果

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/1b14b7c6baf5437ea2ab689030a165d8.png#pic_center)


2. 指标管理：健康管理师给到诊患者进行健康评估，新建评估，完成问卷，查看评估结果。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/45f12146ea3545cdb6031959f928f8fb.png#pic_center)


### 4. 健康干预

健康管理师根据评估结果以及患者信息对患者进行健康干预，制定健康干预计划。

1. 人群分类：患者通过评估进行预分类，健康管理师对患者信息查看，确认分类。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/1f1e889696894cafbcdcd892ac8fa5e7.png#pic_center)


2. 干预模板：健康管理师提前维护干预模板，便于制定干预计划时使用。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/bdf0863f8bd546ccad46e95c386818ae.png#pic_center)


3. 健康干预：健康管理师通过患者信息，制定健康干预计划。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/bfd1e74c0a9c4b8394270c924d62df08.png#pic_center)


### 5. 知识库

知识库为支持系统正常运行的必要部分，主要包含评估建议维护，健康方案维护，运动项目库维护，膳食库维护，疾病库维护，宣教内容维护。

1. 评估建议：评估建议库为评估结果反馈，根据指标关联内容，显示健康建议。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/34c7bffda00c4288ba2f0b4c76d41a75.png#pic_center)


2. 运动项目库：运动项目库为健康干预运动建议内容，健康管理师制定运动建议时，选择运动项。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/ad3165352f51439b857c83c2463a5c9b.png#pic_center)


### 6. 统计分析

统计分析主要是健康机构管理者对健康管理机构运营情况的查看。

1. 工作量统计：工作量统计为显示健康管理师干预方案总量，干预回访量以及干预结束量。

   ![在这里插入图片描述](https://img-blog.csdnimg.cn/7f5f9bdaad384659b293267340d81925.png#pic_center)



## 3.3、UI 设计

### 1. 首页

![在这里插入图片描述](https://img-blog.csdnimg.cn/7599efa4a418461ea99a90fbb2fb7a9b.png#pic_center)




### 2. 预约页面

![在这里插入图片描述](https://img-blog.csdnimg.cn/9eda871b3b524ef686bd1cdff80f3659.png#pic_center)


### 3. 预约详情

![在这里插入图片描述](https://img-blog.csdnimg.cn/c45b01c4ca44457bbc0c9e67879f4c19.png#pic_center)


### 4. 编辑信息

![在这里插入图片描述](https://img-blog.csdnimg.cn/9981a7eb1dfc45b8814a4b1040c60a96.png#pic_center)


### 5. 预约须知

![在这里插入图片描述](https://img-blog.csdnimg.cn/d0d4fdbf94cc4cce968bbe749b13660a.png#pic_center)


### 6. 报告查询

![在这里插入图片描述](https://img-blog.csdnimg.cn/e3812c21d1e84849bddd12d306b5aa5c.png#pic_center)


### 7. 登录页面

![在这里插入图片描述](https://img-blog.csdnimg.cn/72cfbb88bd6d4bf499c71fff1044d026.png#pic_center)


### 8. 体检报告

![在这里插入图片描述](https://img-blog.csdnimg.cn/cbeefd33ea084711bb677e8325e7da8b.png#pic_center)


### 9. 风险评估

![在这里插入图片描述](https://img-blog.csdnimg.cn/791d4f9aab10416cbf28d929ecebf2c2.png#pic_center)


### 10. 评估问卷

![在这里插入图片描述](https://img-blog.csdnimg.cn/b109a8aec92049d2b2164abcd3af6990.png#pic_center)


### 11. 干预方案

![在这里插入图片描述](https://img-blog.csdnimg.cn/614b955b9c5140fd90333f062f4fb561.png#pic_center)


### 12. 健康档案

![在这里插入图片描述](https://img-blog.csdnimg.cn/05db108f44ee4b7aa45086bdbdb51ce5.png#pic_center)


### 13. 档案详情

![在这里插入图片描述](https://img-blog.csdnimg.cn/52fdb12439ff483f83b0e662364b456a.png#pic_center)


### 14. 健康资讯

![在这里插入图片描述](https://img-blog.csdnimg.cn/7ceaf72e4d934490907b50e06495ea49.png#pic_center)


### 15. 资讯详情

![在这里插入图片描述](https://img-blog.csdnimg.cn/d9bc0680cded49c7a2dc89d20ace4672.png#pic_center)
