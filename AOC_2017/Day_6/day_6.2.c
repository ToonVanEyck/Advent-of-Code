#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <limits.h>
#include <stdlib.h>


#define FILE "input"

void print_data(size_t s, int *data)
{
    for ( int i = 0 ; i < s ; i++ ) {
        printf("%2d  ",data[i]);
    }
    printf("\n");
}

int get_index_largest(size_t s, int *data)
{
    int l = 0;
    for (int i = 0 ; i<s ; i++){
        l = (data[i]>l)?data[i]:l;
    }
    for (int i = 0 ; i<s ; i++){
        if ( data[i] == l ) {
            return i;
        }
    }
    return -1;
}

void calculate_memory(size_t s, int index, int *data)
{
    int l_i = get_index_largest(s,&data[s*(index-1)]);
    int l_v = data[s*(index-1) + l_i];
    for ( int i = 0 ; i < s ; i++) {
        data[s*(index) + i] = data[s*(index-1) + i];
    }
    data[s*(index) + l_i] = 0;
    while (l_v > 0){
        if (++l_i >= s){
            l_i = 0;
        }
        data[s*(index) + l_i]++;
        l_v--;
    }
}

int memory_exists(size_t s, int index, int *data)
{
    int match = 0;
    for (int i = 0 ; i < index ; i++) {
        match = 0;
        for (int j = 0 ; j < s ; j++){
            if ( data[s*(i) + j]  == data[s*(index) + j]){
                match ++;
            }
        }
        if (match == s) {
            return i+1;
        }
    }
    return 0;
}

int main (int argc, char **argv)
{
    int data[1600000] = {14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4};
    size_t s = 16;
    printf("Calculating memory ...\n");
    int index = 1;
    int diff = 0;
    for (; diff == 0 ; index++){
        calculate_memory(s,index,data);
        diff = memory_exists(s,index,data);
    }
    index-=diff;
    printf("loop diff = %d steps !\n",index);
    return 0;
}