#include "FFmpegAudioPlay.h"
#include <jni.h>
#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>


#ifndef __AUDIO_DEVICE__
#define __AUDIO_DEVICE__

// this callback handler is called every time a buffer finishes playing
void bqPlayerCallback(SLAndroidSimpleBufferQueueItf bq, void *context);

void createEngine();

// create buffer queue audio player
void createBufferQueueAudioPlayer(int rate, int channel, int bitsPerSample);

void play();

// shut down the native audio system
void shutdown();

#endif