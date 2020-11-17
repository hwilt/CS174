CC=g++
CFLAGS=-std=c++11 -g -Wall


Linkedlist.o: LinkedList.h LinkedList.cpp
	$(CC) $(CFLAGS) -c LinkedList.cpp 

all: LinkedList.o driver.cpp
	$(CC) $(CFLAGS) -o driver driver.cpp LinkedList.o

clean:
	rm *.o