#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;


class Hashable {
    public:
        size_t doStuff(){
            return 0;
        }
        virtual size_t getHash() = 0;
};

class HashableInt: public Hashable {
    private:
        int x;
    public:
        HashableInt(int x){
            this->x = x;
        }
        size_t getHash(){
            return (size_t)x;
        }
};

class Person{
    protected:
        string name;
        int age;
    public:
        Person(string name, int age){
            this->name = name;
            this->age = age;
        }
        virtual void celebrateBirthday(){
            age++;
        }
        int getAge(){
            return age;
        }
        virtual void printInfo(){
            cout << name << " is " << age << " years old\n";
        }
};

// public class Student extends Person
class Student: public Person, public Hashable{
    private:
        string classYear;
    public:
        Student(string name, int age, string classYear): Person(name, age) {
            this->classYear = classYear;
        }
        size_t getHash(){
            return (size_t)age;
        }

        void printInfo(){
            //cout << name << " (" << classYear << ") is " << age << " years old\n";
            // super.printInfo()
            Person::printInfo();
            cout << "Class Year: " << classYear << endl;
        }
};

class Button: public Person {
    public:
        Button(string name, int age):Person(name, age){};
        void celebrateBirthday(){
            age--;
        }
};

void deepCopySlicing(){
    Student chris("Chris", 31, "Sophomore");
    Person pchris = chris; // object slicing!!
    //printf("&chris = %p\n", &chris);
    //printf("&pchris = %p\n", &pchris);
    Person* p = &pchris;
    Student* s = (Student*)p;
    s->printInfo();
}

void shallowCopyPolymorphism(){
    Person* person = new Student("Chris", 31, "Sophomore");
    person->printInfo();


    delete person;
}


int main(){
    HashableInt h(31);
    cout << h.getHash();
    return 0;
}