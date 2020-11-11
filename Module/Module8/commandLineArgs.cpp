#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv){
    if(argc < 2){
        printf("Error! You need to at least one argment which is your age\n");
        return 1;
    }
    int age = atoi(argv[1]); // atoi changes char to int 
    printf("Your age is %i\n", age); 
    
    /*
    for(int i = 0; i < argc; i++){
        printf("%s\n", argv[i]); // char*
    }
    */
    return 0;
}