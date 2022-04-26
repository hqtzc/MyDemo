# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-------------------------------------------定制化区域----------------------------------------------

#---------------------------------1.实体类---------------------------------

#-------------------------------------------------------------------------

#---------------------------------2.第三方包-------------------------------

#-------------------------------------------------------------------------

#---------------------------------3.与js互相调用的类------------------------

#-------------------------------------------------------------------------

#---------------------------------4.反射相关的类和方法-----------------------

#----------------------------------------------------------------------------

#-------------------------------------------基本不用动区域--------------------------------------------

#---------------------------------基本指令区----------------------------------

# 代码混淆压缩比，在0~7之间
-optimizationpasses 5

# 混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

# 指定不忽略包可见的库类成员(字段和方法)。默认地，当解析库类的时候ProGuard会跳过这些类成员，项目类一般不会去引用它们。然而有的时候，程序里的类相当于库类存在于相同包。此时它们会引用他们的包可见的类成员。在这种情况下为了保持程序代码保持一致性去读取这些类的成员是有用的。
-dontskipnonpubliclibraryclassmembers

# 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify

#指定处理期间打印更多相关信息
-verbose

-printmapping proguardMapping.txt

#指定要启用和禁用的优化，在更精细的水平。只有当优化适用。 混淆时采用的算法(google推荐，一般不改变)
-optimizations !code/simplification/cast,!field/*,!class/merging/*

# 避免混淆Annotation、内部类
-keepattributes *Annotation*,InnerClasses

# 避免混淆泛型
-keepattributes Signature

# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

#----------------------------------------------------------------------------

#---------------------------------默认保留区---------------------------------

-keep public class * extends android.app.Activity

-keep public class * extends android.app.Application

-keep public class * extends android.app.Service

-keep public class * extends android.content.BroadcastReceiver

-keep public class * extends android.content.ContentProvider

-keep public class * extends android.app.backup.BackupAgentHelper

-keep public class * extends android.preference.Preference

-keep public class * extends android.view.View

-keep public class com.android.vending.licensing.ILicensingService

-keep class android.support.** {*;}

-keepclasseswithmembernames class * {

    native <methods>;

}

-keepclassmembers class * extends android.app.Activity{

    public void *(android.view.View);

}

-keepclassmembers enum * {

    public static **[] values();

    public static ** valueOf(java.lang.String);

}

-keep public class * extends android.view.View{

    *** get*();

    void set*(***);

    public <init>(android.content.Context);

    public <init>(android.content.Context, android.util.AttributeSet);

    public <init>(android.content.Context, android.util.AttributeSet, int);

}

-keepclasseswithmembers class * {

    public <init>(android.content.Context, android.util.AttributeSet);

    public <init>(android.content.Context, android.util.AttributeSet, int);

}

-keep class * implements android.os.Parcelable {

  public static final android.os.Parcelable$Creator *;

}

-keepclassmembers class * implements java.io.Serializable {

    static final long serialVersionUID;

    private static final java.io.ObjectStreamField[] serialPersistentFields;

    private void writeObject(java.io.ObjectOutputStream);

    private void readObject(java.io.ObjectInputStream);

    java.lang.Object writeReplace();

    java.lang.Object readResolve();

}

-keep class **.R$* {

*;

}

-keepclassmembers class * {

    void *(**On*Event);

}

#----------------------------------------------------------------------------

#---------------------------------webview------------------------------------

-keepclassmembers class fqcn.of.javascript.interface.for.Webview {

   public *;

}

-keepclassmembers class * extends android.webkit.WebViewClient {

    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);

    public boolean *(android.webkit.WebView, java.lang.String);

}

-keepclassmembers class * extends android.webkit.WebViewClient {

    public void *(android.webkit.WebView, jav.lang.String);

}

#----------------------------------------------------------------------------
