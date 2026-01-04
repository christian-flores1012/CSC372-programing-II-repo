//============================================================================
// Name        : Programming_3_Portfolio_Milestone.cpp
// Author      : Christian Flores
// Version     : ISO C++20
// Copyright   : Your copyright notice
// Description :  Creates 2 threads. Thread 1 counts up to 20. Thread 2 counts down from 20 once thread 1 finishes. Prints out values to console.
//============================================================================

#include <iostream>
#include <atomic>
#include <thread>

//creates atomic flag
std::atomic<bool> finished{false};

//counts up to 20 then updates flag
void countUp() {
    for (int i = 0; i <= 20; i++) { //count up to 20
        std::cout << "Thread 1: " << i << std::endl; //print value
    }
    finished.store(true, std::memory_order_release); //updates flag
    finished.notify_one(); // wake waiting thread
}

//counts down from 20 when countUp is finished
void countDown() {
    while (!finished.load(std::memory_order_acquire)) { //checks if finished is false
        finished.wait(false); // sleep until value changes from false
    }

    for (int i = 20; i >= 0; i--) { //count down from 20
        std::cout << "Thread 2: " << i << std::endl; //print value
    }
}

//calls countUp and countDown
int main() {
	finished = false;
	//start threads
    std::thread t1(countUp);
    std::thread t2(countDown);
    //wait for threads to finish
    t1.join();
    t2.join();

    std::cout << "Program Completed";
}
