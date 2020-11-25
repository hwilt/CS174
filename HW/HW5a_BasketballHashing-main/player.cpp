#include "player.h"

Player::Player(string name, string school, int height, int weight, int year) {
    this->name = name;
    this->school = school;
    this->height = height;
    this->weight = weight;
    this->year = year;
}
Cloneable* Player::clone() {
    return new Player(name, school, height, weight, year);
}
void Player::printPlayer() {
    cout << name << endl;
    cout << "Birth Year: " << year << endl;
    cout << "School: " << school << endl;
    cout << "Height: " << height << " cm" << endl;
    cout << "Weight: " << weight << " kg" << endl;
}

/**
 * Populate a map with all of the basketball players in the file 
 * "players.txt"
 * @param map A map to fill
 */
void loadPlayers(Map* map) {
    // TODO: Fill this in.  Load in each player and put
    // them in the map with a HashableString with their name
    // as the key and a player as their value.  Look at Person.cpp
    // for an example of how to put things into a map
    ifstream file("players.txt");
    if (file.is_open()) {
        int i = 0;
        string line;
        string name;
        string school;
        int height;
        int weight;
        int year;
        while(getline(file, line)) {
            i = (i + 1)%5;
            switch(i){
                case 1:
                    name = line;
                    break;
                case 2:
                    weight = stoi(line);
                    break;
                case 3:
                    height = stoi(line);
                    break;
                case 4:
                    school = line;
                    break;
                case 0:
                    year = stoi(line);
                    Player* p = new Player(name, school, height, weight, year);
                    HashableString n(name);
                    map->put(&n, p);
                    break;
            }
        }
    }
}
