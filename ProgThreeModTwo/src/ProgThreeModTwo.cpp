//============================================================================
// Name        : ProgThreeModTwo.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

/*
 Program that takes in 2 strings from the user and concatenates them together.
 Outputs resulting concatenated string.
 Asks user for 3 sets of strings for variation.
 */
#include <iostream>
using namespace std;

string concat( string s1, string s2);

int main() {

	//variables to hold user inputs
	string first;
	string second;
	string output;

	//3 iterations for different length strings
	for ( int i = 0; i < 3; i++) {

		//ask for first string
		cout << "Enter String 1: ";
		getline(cin , first);

		//ask for second string
		cout << "Enter String 2: ";
		getline(cin , second);

		//combine strings
		output = concat(first, second);

		//output results
		cout << "Concatenated String: " << output << endl << endl;


	}

	return 0;
}

/*
 Combines two strings
 takes in two strings and returns single string
 */
string concat( string s1, string s2) {

	string s = s1 + s2;

	return s;
}
