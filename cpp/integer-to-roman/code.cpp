#include <bits/stdc++.h>
using namespace std;

vector<int> num;
vector<string> roman;

void romanIntMapping() {
	num.push_back(1000);	roman.push_back("M");
	num.push_back(900);		roman.push_back("CM");
	num.push_back(500);		roman.push_back("D");
	num.push_back(400);		roman.push_back("CD");
	num.push_back(100);		roman.push_back("C");
	num.push_back(90);		roman.push_back("XC");
	num.push_back(50);		roman.push_back("L");
	num.push_back(40);		roman.push_back("XL");
	num.push_back(10);		roman.push_back("X");
	num.push_back(9);		roman.push_back("IX");
	num.push_back(5);		roman.push_back("V");
	num.push_back(4);		roman.push_back("IV");
	num.push_back(1);		roman.push_back("I");
}

int getRomanForCurrNumUsingBS(int currNum) {
	int start=0;
	int end = 12;
	int mid;
	int retIndex = -1;
	while(start <= end) {
		mid = (start+end)/2;

		if(num[mid] <= currNum) {
			retIndex = mid;
			end = mid-1;
		} else {
			start = mid+1;
		}

	}
	return retIndex;
}

string intToRoman(int number) {
	romanIntMapping();
	int index;

	string ans = "";
	while(number>0) {
		index = getRomanForCurrNumUsingBS(number);
		ans += roman[index];
		// cout << number << ": " << index << ":: " << ans << endl;

		number -= num[index];
	}

	return ans;
}

int main() {
	int num;
	cin >> num;

	cout << intToRoman(num) << endl;
}

// https://leetcode.com/problems/integer-to-roman/
