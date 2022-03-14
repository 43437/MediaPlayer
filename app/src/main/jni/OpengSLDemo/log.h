#include <android/log.h>

#ifndef __LOG_H__
#define __LOG_H__

#define LOGD(X, R) __android_log_print(ANDROID_LOG_DEBUG, "DEBUG", "%s %d ", X, R)
#define LOGE(X) __android_log_print(ANDROID_LOG_ERROR, "ERROR", "%s %d ", X)

#endif