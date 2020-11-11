#include "stdio.h"
#include "audio.h"
#include <stdlib.h>
#include <iostream>
#include <string>
#include <fstream>
#include <cstdint>

float* reverseArray(float* arr, int N) {
    float* rev = new float[N];
    for (int i = 0; i < N; i++) {
        rev[N-i-1] = arr[i];
    }
    return rev;
}

float* makeEcho(float* x, int N, int delay) {
    float* y = new float[N+delay];
    // Copy over original audio
    for (int i = 0; i < N+delay; i++) {
        if (i < N) {
            y[i] = x[i];
        }
        else {
            y[i] = 0;
        }
    }
    // Add echo
    for (int i = 0; i < N; i++) {
        y[i+delay] += x[i];
    }
    return y;
}

int main(int argc, char* argv[]) {
    if(argc < 4){
        printf("You must invoke the program as ./driver <input file> <output file> <lag/echo>");
        return 1;
    }
    
    wav_hdr wavHeader = getAudioHeader(argv[1]);
    size_t N;
    float* audio = getAudio(argv[1], &N);
    int echoValue = atoi(argv[3]); //#include <stdlib.h>
    float* lag = lagAudio(audio, N, echoValue);
    writeAudio(argv[2], lag, N, wavHeader);
    delete[] audio;
    delete[] lag;
    return 0;
}
