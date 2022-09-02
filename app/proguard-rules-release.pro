-obfuscationdictionary proguard_dic.txt
-classobfuscationdictionary proguard_dic.txt
-packageobfuscationdictionary proguard_dic.txt
#-keepattributes SourceFile,LineNumberTable
#-keepattributes *Annotation*,SourceFile,LineNumberTable
-keep class androidx.annotation.Keep
-keep class com.github.megatronking.stringfog.annotation.StringFogIgnore
#-keep @androidx.annotation.Keep class * {*;}
#保持使用了Keep注解的方法以及类不被混淆
-keepclassmembers class * {
    @androidx.annotation.Keep <methods>;
}
#保持使用了Keep注解的成员域以及类不被混淆
-keepclassmembers class * {
    @androidx.annotation.Keep <fields>;
}
-keepclassmembers class * {
    @androidx.annotation.Keep <init>(...);
}

-dontwarn *.**
-keep class com.setqq.plugin.sdk.IPlugin {*;}
-keep class com.setqq.plugin.sdk.API {*;}
-keep class com.saki.aidl.PluginMsg {*;}
-keep class com.mcsqnxa.** {<init>(...);}
