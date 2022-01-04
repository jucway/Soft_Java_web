# Soft_Java_web
软件方向实践项目—Java Web



@[toc]
## 软件方向实践

### Java Web 开发

| 时间       | 实践                    | 备注                                |
| ---------- | ----------------------- | ----------------------------------- |
| 2021.12.27 | 数据库相关操作          | 数据库相关指令熟悉                  |
| 2021.12.28 | web项目创建，首页的显示 | web+tomcat idea的使用，使用servelet |
| 2022.01.04           | 首页分页功能，显示详情页面  ， 增加评论功能                       |     熟悉网页标签和请求封装                              |


[servelet 理论知识](https://blog.csdn.net/qq_19782019/article/details/80292110?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164129575516780261978417%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=164129575516780261978417&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-80292110.pc_search_em_sort&utm_term=servlet&spm=1018.2226.3001.4187)

#### 环境：

+ 编译器：IDEA2021.3 专业版（教育邮箱申请）
+ 数据库：Mysql + Navicat 15

#### 项目文件
<font color=LightGreen>笔记文件传输门：</font>
[实训课笔记记录](https://blog.csdn.net/zcw1234515/article/details/122195999?spm=1001.2014.3001.5501)

+ 实践步骤：
    1. 连接数据库--建表等等
    2. 封装DAO
    3. 创建web项目使用tomcat连接本地8080端口
    4. 导入样式文件，显示首页，同时显示数据库news 信息在首页；





#### 结果展示
+ 首页分页，总共7条数据，分成两页；![在这里插入图片描述](https://img-blog.csdnimg.cn/9375df4f3375412cad21d2950370ca37.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_20,color_FFFFFF,t_70,g_se,x_16)


------------------
+ 第二页：
![在这里插入图片描述](https://img-blog.csdnimg.cn/1ac907942f474e12b1e4cca7b879a73c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_20,color_FFFFFF,t_70,g_se,x_16)

----------------
+ 详情页面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/0909a9e512e84f9ba1d278fa41ddc233.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_20,color_FFFFFF,t_70,g_se,x_16)

---------------

+ 评论页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/c68a26af61e34039b391b3119262019c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_5,color_FFFFFF,t_70,g_se,x_16)


--------------------
> 解决中文乱码：

> 方法1：
>         String str = new String(req.getParameter("cauthor").getBytes("ISO-8859-1"),"utf-8");
        comment.setCauthor(str);


---------------------
![在这里插入图片描述](https://img-blog.csdnimg.cn/50197d18d69d4245b92f53af9349c941.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_20,color_FFFFFF,t_70,g_se,x_16)

-----------
+ 设置首页显示
![在这里插入图片描述](https://img-blog.csdnimg.cn/1c98548c35924ce8bec36da33b771fdb.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_20,color_FFFFFF,t_70,g_se,x_16)




## 文件分析



![在这里插入图片描述](https://img-blog.csdnimg.cn/fa1e9ba5e164483abf37c6ca84552c06.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_5,color_FFFFFF,t_70,g_se,x_16)![在这里插入图片描述](https://img-blog.csdnimg.cn/efc4be00edb64843a01a1586fadea48d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,size_5,color_FFFFFF,t_70,g_se,x_16)


![在这里插入图片描述](https://img-blog.csdnimg.cn/297011044c5444c5af08829d69a23788.png)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2805261d90b7447086b437358c59e6fd.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASnVjd2F5,5,color_FFFFFF,t_70,g_se,x_16)

## 效果展示



--------------
<font color=LightPink>文件资源代码传输门：</font>
[项目文件代码和资料](https://github.com/jucway/Soft_Java_web)




#### 总结:
<font size=4 color=LightSeaGreen>成功不会自动送上门来，幸福也不会自动降临到一个人身上。这个世界上所有美好的东西都需要主动争取，加油！！！</font>



+ 为期4天的java实践课，跟着老师从头开始一步一步搭建网页，大部分显示的东西都是课程资料，但是还是比较考验思维和遇到问题的解决能力。这个实践基本上都能有效的利用好课堂的时间完成大部分功能；



实践的难点：
基本上是工具的使用；由于没有前端开发的基础，不过对于javascript有些基本的了解，上手比较快；
其次整个实践老师教学过程使用的是eclipse ，然而我还是比较习惯使用IDEA进行编程；这两个工具操作上基本是一致，刚开始会遇到一点点问题，不过基本都是能够找到解决方法的；
其次是数据库的安装，数据库之前做java实验课仿真QQ程序的时候已经安装好了数据库，所有在这个方面没有遇到问题，不过之前装数据库也是遇到了不少问题：
> 这里又知道了一个更块安装数据库的方法；
> 直接使用解压包进行安装，只需要修改配置文件的信息，就可以安装好数据库，之后安装mysql服务就能够使用数据库；
其次是使用DAO（数据访问对象模式）访问数据库，能够更好的管理连接信息；
再者是对于 tomacat 搭建 servelet 的熟悉使用；


[CSND 链接](https://blog.csdn.net/zcw1234515/article/details/122202702?spm=1001.2014.3001.5501)





