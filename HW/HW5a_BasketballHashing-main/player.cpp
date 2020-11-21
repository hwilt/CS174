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
            if(i == 0){
                name = line;
            }
            else if(i == 1){
                weight = stoi(line);
            }
            else if(i == 2){
                height = stoi(line);
            }
            else if(i == 3){
                school = line;
            }
            else if(i == 4){
                year = stoi(line);
                Player* p = new Player(name, school, height, weight, year);
                HashableString HS(name);
                map->put(&HS, p);
            }
            i = (i+1)%5;
        }
    }
}
