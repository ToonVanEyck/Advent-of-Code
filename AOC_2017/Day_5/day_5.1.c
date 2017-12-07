#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <limits.h>
#include <stdlib.h>


#define FILE "input"
#define STR_SIZE 64000
#define NUM(n) ((n)-48)


size_t get_data_size(char *buf)
{
    int phrases = 0;
    for (int i = 0 ; i < strlen(buf) ; i++) {
        if (buf[i] == '\n' ) {
            phrases ++;
        }
    }
    return phrases;
}

int *structure_data(size_t s, char *buf)
{
    int *data = malloc(sizeof(int)*s);
    int nr_s = 0;
    int data_len = strlen(buf);
    data[nr_s++] = strtol(buf,NULL,10);
    for (int i = 0 ; i < data_len; i++){
        if ( buf[i] == '\n' && i != data_len-1) {
            data[nr_s++] = strtol(&buf[i+1],NULL,10);
        }
    }
    return data;
}

void free_data(size_t s, int **data)
{
    free(*data);
    *data = NULL;
}

void print_data(size_t s, int *data)
{
    for ( int i = 0 ; i < s ; i++ ) {
        printf("%d\n",data[i]);
    }
}

int find_exit(size_t s, int *data)
{
    int i = 0;
    int cnt = 0;
    while ( i < s ) {
        /*
        for ( int p = 0 ; p < s ; p++ ) {
            printf("%s%2d  ",(p==i)?"\x1B[34m":"\x1B[37m",data[p]);
        }
        printf("\n");
        */
        cnt++;
        data[i]++;
        i += data[i]-1;
    }
    return cnt;
}

int main (int argc, char **argv)
{
    int fd = open(FILE,O_RDONLY);
    char buf[STR_SIZE];
    read(fd,buf,STR_SIZE);      //read input file
    close(fd);
    printf("Calculating exit ...\n");
    size_t s = get_data_size(buf);
    int *data = structure_data(s, buf);
    //print_data(s, data);
    int nr_steps = find_exit(s,data);
    printf("Exit reached in %d steps!\n",nr_steps);
    free_data(s,&data);
    return 0;
}