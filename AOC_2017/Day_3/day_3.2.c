#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <limits.h>
#include <stdlib.h>

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

int get_index(struct coordinate co)
{
    int i = 1;
    struct coordinate co_comp = {0,0};
    int count_i = 1;
    int counter = 0;
    enum direction direction = left_right;

    while(co.x != co_comp.x || co.y != co_comp.y){
        i++;
        if (counter < count_i){
            if(direction == left_right){
                co_comp.x += ((count_i % 2)? 1 : -1);
            } else {
                co_comp.y += ((count_i % 2)? 1 : -1);
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
    return i;
}

int calc_value(int index)
{
    int value = 1;
    if (index > 1){
        value = 0;
        struct coordinate co = get_coordinate(index);
        struct coordinate co_n;
        int surround[8];
        co_n = co; co_n.x += -1 ; co_n.y += 1  ;surround[0] = get_index(co_n);
        co_n = co; co_n.x += 0  ; co_n.y += 1  ;surround[1] = get_index(co_n);
        co_n = co; co_n.x += 1  ; co_n.y += 1  ;surround[2] = get_index(co_n);
        co_n = co; co_n.x += -1 ; co_n.y += 0  ;surround[3] = get_index(co_n);
        co_n = co; co_n.x += 1  ; co_n.y += 0  ;surround[4] = get_index(co_n);
        co_n = co; co_n.x += -1 ; co_n.y += -1 ;surround[5] = get_index(co_n);
        co_n = co; co_n.x += 0  ; co_n.y += -1 ;surround[6] = get_index(co_n);
        co_n = co; co_n.x += 1  ; co_n.y += -1 ;surround[7] = get_index(co_n);
        for( int i = 0 ; i < 8 ; i++)
        {
            if (surround[i] < index){
                value += calc_value(surround[i]);
            }
        }
    }
    return value;
}

int main (int argc, char **argv)
{
    int input = 312051;
    if ( argc == 2 ){
        input = strtol(argv[1],NULL,10);
    }
    printf("Finding value after %d ...\n",input);
    int value;
    for( int i = 1 ; ( value = calc_value(i)) <= input ; i++);
    printf("The value is %d\n",value);
    return 0;
}