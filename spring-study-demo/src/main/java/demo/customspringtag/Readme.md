### Spring XML 组成部分
- XML schema 用于描述标签
- BeanDefinitionParser implementations 用于解析xml标签
- NamespaceHandler implementation 用于装配解析标签需要的Beans

### 自定义标签流程
```aidl
- Authoring an XML schema to describe your custom element(s).
- Coding a custom NamespaceHandler implementation (this is an easy step, don’t worry).
- Coding one or more BeanDefinitionParser implementations (this is where the real work is done).
- Registering the above artifacts with Spring (this too is an easy step).
```

### Code
- 见源码

### 原理解析
- [Spring自定义标签和spring.handlers的加载过程](https://blog.csdn.net/wabiaozia/article/details/78631259)

### 参考
- [spring自定义标签](https://www.cnblogs.com/huhx/p/baseusespringtag1.html)
