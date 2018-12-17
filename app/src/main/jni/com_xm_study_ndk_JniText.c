 #include "com_xm_study_ndk_JniText.h"
  /*
   * Class:     io_github_yanbober_ndkapplication_NdkJniUtils
   * Method:    getCLanguageString
   * Signature: ()Ljava/lang/String;
   */
  JNIEXPORT jstring JNICALL Java_com_xm_study_ndk_JniText_getCLangString(JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env,"77777777777777777777777!");
 }