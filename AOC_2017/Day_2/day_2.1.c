#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <limits.h>
#include <stdlib.h>


#define FILE "input"
#define STR_SIZE 4096
#define NUM_BUF_SIZE 16
#define NUM(n) ((n)-48)

int main (int argc, char **argv)
{
    int fd = open(FILE,O_RDONLY);
    char buf[STR_SIZE];
    read(fd,buf,STR_SIZE);      //read input file
    printf("%s\n",buf);
    close(fd);

    int largest = 0;
    int smallest = INT_MAX;
    int checksum = 0;
    char numbuf[NUM_BUF_SIZE]={0};
    int n_i = 0;
    
    for (int i = 0 ; i < strlen(buf) ; i++){
        if ( buf[i] == '\t' || buf[i] == '\n' ) {
            int number = strtol(numbuf,NULL,10);
            smallest = (number<smallest) ? number : smallest;
            largest  = (number>largest)  ? number : largest;
            memset(numbuf,0,NUM_BUF_SIZE);
            n_i = 0;
            if ( buf[i] == '\n' ){
                checksum += (largest - smallest);
                largest = 0;
                smallest = INT_MAX;
            }
        } else {
            numbuf[n_i++] = buf[i];
        }
    }
    printf("the checksum is %d\n",checksum);
    return 0;
}