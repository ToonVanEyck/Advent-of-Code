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
    read(fd,buf,STR_SIZE);          //read input file
    close(fd);

    int captcha = 0;                // result
    int match = 0;                  // matching index to check
    int str_len = strlen(buf)-1;    // -1 to remove '\n'
    int position = str_len>>1;               // location of matching index, set to 1 to get result of part 1

    for (int index = 0 ; index < str_len ; index++){
        if ((match = index + position) >= str_len) {
            match -= str_len;
        }
        if (buf[index]==buf[match]) {
            captcha += NUM(buf[index]);
        }
    }
    printf("the captcha is %d\n",captcha);
    return 0;
}