1. xmlns -->  XML nameapace  XML 命名空间
2. XML namespace 是为了解决元素和属性命名上的冲突 
         类似于Java的全路径类名，解决类名中的冲突
3. XML的命名空间语法  xmlns: namespace-prefix="namespaceURI"
* xmlns: 声明   声明命名空间的保留字，其实就是XML中元素的一个属性
* namespace-prefix:  命名空间的前缀，这个前缀与某个命名空间相关联
* namespaceURI： 命名空间的唯一标识符，一般就是一个URI引用

4. Android中 常用的三种
* xmlns: android="http://schmeas.android.com/apk/res/android"
        android -- 用于Android系统定义的一些属性
* xmlns: tools="http://schemas.android.com/tools"
        tools -- 用于在 XML 文档记录一些，当应用打包的时候，会把这部分信息给过滤掉
                 说直白点，这些属性是为IDE提供相关信息   
* xmlns: app="http://schemas.android.com/apk/res-auto"
        app -- 应用自定义的一些属性