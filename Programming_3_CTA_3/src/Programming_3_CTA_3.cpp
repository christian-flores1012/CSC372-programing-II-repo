//============================================================================
// Name        : Programming_3_CTA_3.cpp
// Author      : Christian Flores
//
// Program: Takes 3 integer values from the user, saves each input in an integer variable
//          and creates a pointer for each variable. Prints Results.
//============================================================================

#include <iostream>
using namespace std;

// function to validate input to make suer it is integer, returns valid user input
int getValidInt() {
	//declares value variable
    int value;
    while (true) {
    		//gets user input
        cin >> value;

        //checks if user inputs something other than an integer
        if (!cin.fail()) {
        		// if valid integer it returns
            return value;
        }

        	//lets user know to enter a valid input
        cout << "Invalid input. Please enter a valid integer value. ";
        cin.clear();
        cin.ignore(100, '\n');
    }
}

int main() {
	//declare int variables
	int first;
	int second;
	int third;

	// get 3 values from the user
	cout << "Enter first integer value: ";
	first = getValidInt();

	cout << "Enter second integer value: ";
	second = getValidInt();

	cout << "Enter third integer value: ";
	third = getValidInt();

	//create 3 pointers
	int* ptrFirst = new int;
	int* ptrSecond = new int;
	int* ptrThird = new int;

	//store values inside pointers
	*ptrFirst = first;
	*ptrSecond = second;
	*ptrThird = third;


	cout << endl << "-----------Values-----------" << endl << endl;

	//print variable,pointer value, and dereferenced pointer value for all three values
	cout << "Variable: " << first << endl << "Pointer: " << ptrFirst << endl << "Pointer(Dereferenced): " << *ptrFirst;
	cout << endl << endl;

	cout << "Variable: " << second << endl << "Pointer: " << ptrSecond << endl << "Pointer(Dereferenced): " << *ptrSecond;
	cout << endl << endl;

	cout << "Variable: " << third << endl << "Pointer: " << ptrThird << endl << "Pointer(Dereferenced): " << *ptrThird ;
	cout << endl << endl;


	//free pointers
	delete ptrFirst;
	delete ptrSecond;
	delete ptrThird;


	return 0;
}
