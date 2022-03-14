#include "log.h"
#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>

#ifndef __FFMPEG_ADUIO__
#define __FFMPEG_ADUIO__

int createFFmpegAudioPlay(int *rate, int *channel);

// 获取PCM数据, 自动回调获取
int getPCM(void **pcm, size_t *pcmSize);

// 释放相关资源
int releaseFFmpegAudioPlay();

void setDataSource(char *filepath);
#endif