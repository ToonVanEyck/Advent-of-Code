#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define FILE "input"
#define STR_SIZE 4096
#define NUM(n) ((n)-48)
int main (int argc, char **argv)
{
    int fd = open(FILE,O_RDONLY);
    char buf[STR_SIZE];
    read(fd,buf,STR_SIZE);      //read input file
    buf[strlen(buf)-1]=buf[0];  //append first number to end of string so the circular calciulation can be made in one go
    close(fd);
    int captcha = 0;
    for (int i = 1 ; i < strlen(buf) ; i++){
        if (buf[i-1]==buf[i]) {
            captcha += NUM(buf[i]);
        }
    }
    printf("the captcha is %d\n",captcha);
    return 0;
}