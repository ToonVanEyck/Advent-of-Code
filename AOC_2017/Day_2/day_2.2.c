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

struct input_size{
    size_t x;
    size_t y;
    size_t elements;
};

struct input_size get_data_size(char *buf)
{
    struct input_size i_s = {0,0,0};
    for (int i = 0 ; i < strlen(buf) ; i++) {
        if ( buf[i] == '\t' || buf[i] == '\n' ) {
            i_s.elements ++;
            if ( buf[i] == '\n' ){
            i_s.y ++;
            }
        }
    }
    i_s.x = i_s.elements / i_s.y;
    return i_s;
}

int **structure_data(struct input_size i_s, char *buf)
{
    char numbuf[NUM_BUF_SIZE]={0};

    int** data = malloc(sizeof(int*)*i_s.y);
    for ( int y = 0 ; y < i_s.y ; y++ ) {
        data[y] = malloc(sizeof(int)*i_s.x);
    }
    int n_i = 0;
    int x=0, y=0;
    for (int i = 0 ; i < strlen(buf) ; i++){
        if ( buf[i] == '\t' || buf[i] == '\n' ) {
            data[y][x] = strtol(numbuf,NULL,10);
            memset(numbuf,0,NUM_BUF_SIZE);
            n_i = 0;
            x++;
            if ( buf[i] == '\n' ){
                y++;
                x=0;
            }
        } else {
            numbuf[n_i++] = buf[i];
        }
    }
    return data;
}

void free_data(struct input_size i_s, int ***data)
{
    for ( int y = 0 ; y < i_s.y ; y++ ) {
        free((*data)[y]);
    }  
    free(*data);
    *data = NULL;
}

void print_data(struct input_size i_s, int **data)
{
    for ( int y = 0 ; y < i_s.y ; y++ ) {
        for ( int x = 0 ; x < i_s.x ; x++ ) {
            printf("%d\t",data[y][x]);
        }
        printf("\n");
    }
}

int match(struct input_size i_s, int **data, int y)
{
    for ( int x_1 = 0 ; x_1 < i_s.x ; x_1++ ) {
        for ( int x_2 = x_1 + 1  ; x_2 < i_s.x ; x_2++ ) {
            if ( data[y][x_1] % data[y][x_2] == 0 ){
                //printf("%d / %d = %d \n",data[y][x_1],data[y][x_2],data[y][x_1] / data[y][x_2]);
                return data[y][x_1] / data[y][x_2];
            }
            if ( data[y][x_2] % data[y][x_1] == 0 ){
                //printf("%d / %d = %d \n",data[y][x_2],data[y][x_1],data[y][x_2] / data[y][x_1]);
                return data[y][x_2] / data[y][x_1];
            }
        }
    }
    return 0;
}

int main (int argc, char **argv)
{
    int fd = open(FILE,O_RDONLY);
    char buf[STR_SIZE];
    read(fd,buf,STR_SIZE);      //read input file
    close(fd);
    struct input_size i_s = get_data_size(buf);
    int **data = structure_data(i_s, buf);
    //print_data(i_s, data);

    int checksum = 0; 
    for ( int y = 0 ; y < i_s.y ; y++ ) {
        checksum += match(i_s, data, y);
    }

    printf("the checksum is %d\n",checksum);

    free_data(i_s,&data);

    return 0;
}