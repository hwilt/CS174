#include "player.h"

int main(int argc, char** argv) {
    Map* m = new LinkedMap();
    loadPlayers(m);
    if(argc < 2){
        printf("You must invoke the program as ./playerlookup <first name> <last name>");
        return 1;
    }
    string first = (argv[1]);
    string last = (argv[2]);
    string name = first + " " + last;
    HashableString fullname(name);
    if(m->containsKey(&fullname)){
        Player* p = (Player*)m->get(&fullname);
        p->printPlayer();
    }
    else{
        cout << name << " not found" << endl;
    }


    delete m;
    return 0;
}


