//============================================================================
// Name        : Programming_3_CTA_5.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

// Part 2 reverse method
void reverseFile(const std::string& inFile, const std::string& outFile) {

	//check if file can be opened
    std::ifstream iFile(inFile);
    if (!iFile.is_open()) {
        std::cerr << "Could not open input file." << std::endl;
        return;
    }

    // Read entire file into a string
    std::string contents(
        (std::istreambuf_iterator<char>(iFile)),
        std::istreambuf_iterator<char>()
    );

    //close file
    iFile.close();

    // Reverse all characters
    std::reverse(contents.begin(), contents.end());

    // Write reversed contents to new file
    std::ofstream oFile(outFile);
    if (!oFile.is_open()) {
        std::cerr << "Could not open output file." << std::endl;
        return;
    }

    oFile << contents;
    //close file
    oFile.close();
}


int main() {
	//Part 1------------------------------------------------------------------------------

	//ofstream object
	std:: ofstream file;

	//open file
	file.open("CSC450_CT5_mod5.txt",std::ios::app);

	//check if file was opened correctly
	if (!file.is_open()){
		std::cerr << "File could not be opened." << std::endl;
		return 1; //exit program
	}

	//get message from user
	std::cout << "Write line you would like to append to CSC450_CT5_mod5.txt: ";

	//get line from user
	std::string userLine;
	std::getline(std::cin, userLine);

	//append line to file
	file << userLine << std::endl;

	std::cout << std::endl << "Appended successfully to CSC450_CT5_mod5.txt" << std::endl; //success message



	//Part 2--------------------------------------------------------------------------------------

	//reverse file
	reverseFile("CSC450_CT5_mod5.txt", "CSC450-mod5-reverse.txt");


	std::cout << "File reversed successfully." << std::endl;

	//close file
	file.close();

	return 0;
}
