#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <limits.h>
#include <stdlib.h>

#define abs(v) (((int)(v)<0)?(v)*-1:(v))

struct coordinate{
    int x;
    int y;
};

enum direction{up_down,left_right};

struct coordinate get_coordinate(int input)
{
    struct coordinate co = {0,0};
    int count_i = 1;
    int counter = 0;
    enum direction direction = left_right;
    for ( int i = 2 ; i <= input ;i++) {
        if (counter < count_i){
            if(direction == left_right){
                co.x += ((count_i % 2)? 1 : -1);
            } else {
                co.y += ((count_i % 2)? 1 : -1);
            } 
            counter++;  
        } 
        if (counter == count_i){
            if(direction == left_right){
                direction = up_down;
            } else {
                direction = left_right;
                count_i++;
            } 
            counter = 0;
        }
    }
    return co;
}

int get_manhattan_distance(struct coordinate co)
{
    return abs(co.x) + abs(co.y);
}

int main (int argc, char **argv)
{
    int input = 312051;
    if ( argc == 2 ){
        input = strtol(argv[1],NULL,10);
    }
    printf("Finding distance to %d ...\n",input);
    struct coordinate co = get_coordinate(input);
    int distance = get_manhattan_distance(co);
    printf("The distance is to (%d,%d) is %d\n",co.x,co.y,distance);
    return 0;
}