#include "log.h"
#include "AudioDevice.h"
#include <cstdio>
#include "FFmpegAudioPlay.h"

#define NELEM(X) ((int)(sizeof((X))/sizeof((X)[0])))
const char* JNIREG_CLASS = "cn/maxkot/mediaplayer/OpenSLDemoActivity";

char input_str[50];

void _setPlayFile(JNIEnv *env, jclass clazz, jstring filepath){

    sprintf(input_str, "%s", env->GetStringUTFChars(filepath, NULL));
    setDataSource(input_str);
}

JNIEXPORT void JNICALL _play(JNIEnv * env, jclass clazz)
{
    LOGD("play", 0);
    play();
}

JNIEXPORT void JNICALL _stop(JNIEnv * env, jclass clazz)
{
    LOGD("stop", 0);
    shutdown();
}



static JNINativeMethod g_methods[] = {
        { "play",                "()V",                        (void *) _play },
        { "setPlayFile",         "(Ljava/lang/String;)V",      (void *) _setPlayFile },
        { "stop",                "()V",                        (void *) _stop }
};


JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved)
{
    JNIEnv* env = NULL;

    if (vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
        return -1;
    }
    jclass clazz = env->FindClass(JNIREG_CLASS);

    env->RegisterNatives(clazz, g_methods, NELEM(g_methods) );

    return JNI_VERSION_1_4;
}

JNIEXPORT void JNI_OnUnload(JavaVM *jvm, void *reserved)
{

}



