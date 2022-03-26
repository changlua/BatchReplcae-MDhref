# 使用方式

> 说明：本项目仅仅使用的是JDK提供的类库，无需引入第三方类库。

1、填写四个配置项

![image-20220326141257398](https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/2022/3/202203261412443.png)

源目录：指的是就是你要替换的目录文件夹路径。

目标目录：就是所有文件替换好之后输出的路径。

我的需求是将我的笔记目录中所有md里内容替换如下：

+ https://gitee.com/changluJava/picture-bed/raw/master/替换为https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/beifen-gitee/

所以我的完整配置是：

```java
//源目录
private static String COPY_ORIGN = "C:\\Users\\93997\\Desktop\\test";

//目标目录（可以填写自己本身源路径，达到覆盖效果。建议是输出到其他路径，防止有问题）
private static String COPY_TO = "C:\\Users\\93997\\Desktop\\test";

//被替换内容
private static String tihuan = "https://gitee.com/changluJava/picture-bed/raw/master/";

//替换内容
private static String tihuanTO = "https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/beifen-gitee/";
```

2、运行代码即可：

![image-20220326141750712](https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/2022/3/202203261417759.png)

OK，此时打开文件可以看到里面的原来图床地址已经替换如下：

![image-20220326141925838](https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/2022/3/202203261419953.png)