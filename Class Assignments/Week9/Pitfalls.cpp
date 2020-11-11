#include <stdio.h>


class MyClass{
    private:
        int x1, x2;
    public:
        MyClass(int x1, int x2){
            this->x1 = x1;
            this->x2 = x2;
        }
        int getx1(){
            return x1;
        }
        int getx2(){
            return x2;
        }

};

void pitFall1(){
    MyClass obj1(174, 476);
    MyClass* obj1ref = &obj1;
    //Do some stuff...


    // Delete a local variable in the method
    // But this variable is on the stack for
    // the methods and will automically be deleted
    // for you. You cannot yourself touch this region
    // of memory
    delete obj1ref; 
}

MyClass* getObj(){
    MyClass* obj1 = new MyClass(174, 476);

    return obj1;
}


void pitFall2(){
    MyClass* obj1ref = getObj();
    printf("obj1ref->getx1() = %i\n", obj1ref->getx1());
    delete obj1ref;
}


int main(){
    pitFall2();
    return 0;
}