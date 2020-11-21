#include "player.h"

int main(int argc, char** argv) {
    Map* m = new LinkedMap();
    loadPlayers(m);
    // TODO: Fill this in.  Query m for a player corresponding
    // to the passed in arguments, and print out their information
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
        delete p;
    }
    else{
        cout << name << " not found" << endl;
    }


    delete m;
    return 0;
}


