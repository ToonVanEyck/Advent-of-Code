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

char **structure_data(size_t s, char *buf)
{
    char **data = malloc(sizeof(char*)*s);
    int nr_s = 0;
    int data_len = strlen(buf);
    data[nr_s++] = &buf[0];
    for (int i = 0 ; i < data_len; i++){
        if ( buf[i] == '\n' && i != data_len-1) {
            data[nr_s++] = &buf[i+1];
            buf[i]='\0';
        }
    }
    return data;
}

void free_data(size_t s, char ***data)
{
    free(*data);
    *data = NULL;
}

void print_data(size_t s, char **data)
{
    for ( int i = 0 ; i < s ; i++ ) {
        printf("%s\n",data[i]);
    }
}

int test_passphrase(char *p)
{
    int location[32]={0,-1};
    location[0]=1;
    for ( int i = 0 ; i < strlen(p) ; i++ ) {
        if ( p[i] == ' ' ) {
            location[0]++;
            location[location[0]]=i;
        }
    }
    location[location[0]+1]=strlen(p);  
    for ( int i = 1 ; i <= location[0] ; i++ ) {
        int length_1 = location[i+1] - location[i] - 1;
        for ( int j = i + 1 ; j <= location[0] ; j++ ) {
            int length_2 = location[j+1] - location[j] - 1;
            if ( length_1 == length_2 )
            {
                int match_cnt = 0;
                for( int k = 1 ; k <= length_1 ; k++)
                {
                    if (p[location[i]+k] == p[location[j]+k]) {
                        match_cnt++;
                    }
                }
                if ( match_cnt == length_1 ){
                    return 0;
                }
            }
            
        }  
    }
    return 1;
}

int main (int argc, char **argv)
{
    int fd = open(FILE,O_RDONLY);
    char buf[STR_SIZE];
    read(fd,buf,STR_SIZE);      //read input file
    close(fd);
    printf("Calculating correct phrases ...\n");
    size_t s = get_data_size(buf);
    char **data = structure_data(s, buf);
    int passed_phrases = 0;
    for ( int i = 0 ; i < s ; i++) {
        if (test_passphrase(data[i])) {
            passed_phrases++;
            //printf("\x1B[32m%s\n",data[i]);
        } else {
            //printf("\x1B[31m%s\n",data[i]);
        }
    }
    printf("\x1B[37m%d pass phrases are good!\n",passed_phrases);
    free_data(s,&data);
    return 0;
}