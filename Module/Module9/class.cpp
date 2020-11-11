#include <stdio.h>

class Person {
    private:
        int age;
        char* name;
        void doPrivateStuff(){
            age = 0;
        }

    public:
        Person(int age, char* name){
            this->age = age;
            this->name = name;
        }

        ~Person(){
            printf("%s is being destructed\n", name);
        }
        
        void celebrateBirthday(){
            age++;
        }
        
        void printInfo(){
            printf("Person name is %s, age is %i\n", name, age);
        }
};

void celebrateNBirthdays(Person* p, int N) {
    // TODO: Fill this in
    for(int i = 0; i < N; i++){
        p->celebrateBirthday();
    }
}

Person* makeHenry(){
    const char* name = "Henry";
    //Person p(18, (char*) name); //static oject instantiation
    //p.printInfo();
    Person* p = new Person(18, (char*) name);
    p->printInfo();
    return p;
}

void testConDest() {
  Person* bill = new Person(40, (char*)"bill");
  // TODO: Finish this.  
  // Construct chris, then destruct chris, then destruct bill
  Person* chris = new Person(31, (char*) "chris");
  delete chris;
  delete bill;
}

int main(){
    printf("About to call makeHenry()\n");
    Person* p = makeHenry();
    printf("Finished calling makeHenry()\n");
    delete p;
    return 0;
}