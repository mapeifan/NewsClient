# NewsClient
Retrofit+Rxjava+Gson 写的新闻端小项目Demo

内容持续更新中~~ 基本功能不断完善中

#简单的实现了 Retrofit+Rxjava+Gson 效果 ，下拉可刷新列表 采用 pull-to-refresh 框架

==========================================================================================================================================

#20180823

1、新增极光推送（目前仅做了提示）

2、系统原生webview添加 （TBS 和原生切换使用）

3、第三方库 EventBus 的使用

目前主要存在（webview 加载空白的问题，目前还在查找原因）

![效果图](https://github.com/mapeifan/NewsClient/blob/master/app/src/main/res/Jpush_1.png)

![效果图](https://github.com/mapeifan/NewsClient/blob/master/app/src/main/res/Jpush_2.png)


==========================================================================================================================================

#20180822 修改

优化使用体验，主要有以下优化：

1、优化使用规则，不再随机更新类型（viewpage）

2、应用名称更改（FLY 快讯）

3、主体颜色刚改 （紫-》红）

4、部分bug修正（图片不加载的bug(粗心导致)）

5、采用腾讯TBS浏览器内核（替代webview)（PS: 个人感觉使用了 反而加载慢了。。。再找找原因）

6、标题栏修改 （不再显示 页面）


![效果图](https://github.com/mapeifan/NewsClient/blob/master/app/src/main/res/效果图2.png)

==========================================================================================================================================



#20180815 修改

1、新增预览图片功能（Glide实现）

2、修改功能（下拉切换新闻模式，上拉加载下一页内容） 

3、标题栏部分修改 

![效果图](https://github.com/mapeifan/NewsClient/blob/master/app/src/main/res/效果图.png)
