 #include "com_xm_study_ndk_JniText.h"
  /*
   * Class:     io_github_yanbober_ndkapplication_NdkJniUtils
   * Method:    getCLanguageString
   * Signature: ()Ljava/lang/String;
   */
  JNIEXPORT jstring JNICALL Java_com_xm_study_ndk_JniText_getCLangString(JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env,"系统默认 normal 一般情况下，我们更希望使用的是标准的 android:textStyle 而不是用一个自定义的属性 customfont:textStyle 。但是像上面这样的属性直接放上去肯定是不能生效的，还需要再加一些代码才行。");
 }

 JNIEXPORT jstring JNICALL Java_com_xm_study_ndk_JniText_getCLangString2(JNIEnv *env, jobject obj){
     return (*env)->NewStringUTF(env,"系统默认 bold 一般情况下，我们更希望使用的是标准的 android:textStyle 而不是用一个自定义的属性 customfont:textStyle 。但是像上面这样的属性直接放上去肯定是不能生效的，还需要再加一些代码才行。!");
  }
