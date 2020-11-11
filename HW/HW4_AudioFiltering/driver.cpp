#include "stdio.h"
#include "audio.h"
#include <stdlib.h>
#include <iostream>
#include <string>
#include <fstream>
#include <cstdint>


/*
* Returns a summed array of where the array crossing the middle point
* in an audio stream
*
* @param aud     the incoming audio
* @param N       the size of the audio array
* @param window  the length of the window on eitehr side of each sample
*                   in which to count the crossings
* @return        the summed array of corring
*/
float* summed(float* aud, size_t N, int window){
    float* sumArr = new float[N];
    
    for(int i = 0; i < N; i++){
        int sum = 0;
        int start;
        int end;
        if(i-window >= 0){
            start = i-window;
        }
        else{
            start = 0;
        }
        if(i+window <= N-1){
            end = i+window;
        } 
        else{
            end = N-1;
        }
        for(int j = start; j <= end; j++){
            if (aud[j+1] > 32768 && aud[j] < 32768) {
                sum++;
            }
            else if (aud[j+1] < 32768 && aud[j] > 32768) {
                sum++;
            }
        }
        sumArr[i] = sum;
    }


    return sumArr;
}

/*
* Returns a float array that holds the audio that takes out either
* the vowels or consonants. 
*
* @param aud     the incoming audio
* @param N       the size of the audio array
* @param window  the length of the window on eitehr side of each sample
*                   in which to count the crossings
* @param thres   the threshold for inclusion of a sample
* @oaram VC      either a 1 or 0, 1 for vowels and 0 for consoants
* @return        the filtered audio
*/
float* filter(float* aud, size_t* N, int window, int thres, int VC){
    float* summedArr = summed(aud, *N, window);
    float* filtered = new float[*N];
    size_t size = 0;
    if(VC == 1){ //filtering out the vowels
        int j = 0;
        for(int i = 0; i < *N-1; i++){
            if(summedArr[i] > thres){
                filtered[j] = aud[i];
                j++;
                size++;
            }
        }
    }
    else{ //filtering out the consoants
        int j = 0;
        for(int i = 0; i < *N-1; i++){
            if(summedArr[i] < thres){
                filtered[j] = aud[i];
                j++;
                size++;
            }
        }
    }
    *N = size;
    return filtered;
}



int main(int argc, char* argv[]) {
    if(argc < 6){
        printf("You must invoke the program as ./filter <input file> <output file> <window size> <threshold> <vowel(0) or consoant(1)>");
        return 1;
    }
    
    wav_hdr wavHeader = getAudioHeader(argv[1]);
    size_t N;
    float* audio = getAudio(argv[1], &N);
    int window_size = atoi(argv[3]); //#include <stdlib.h>
    int threshold = atoi(argv[4]);
    int vowel = atoi(argv[5]);
    float* filtered = filter(audio, &N, window_size, threshold, vowel);
    writeAudio(argv[2], filtered, N, wavHeader);
    delete[] audio;
    delete[] filtered;
    return 0;
}

