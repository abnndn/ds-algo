#include <bits/stdc++.h>
using namespace std;

map<char, int> roman;

void romanIntMapping() {
	roman['I'] = 1;
	roman['V'] = 5;
	roman['X'] = 10;
	roman['L'] = 50;
	roman['C'] = 100;
	roman['D'] = 500;
	roman['M'] = 1000;
}

int romanToInt(string s) {
	romanIntMapping();
	int answer = 0;

	for (int i=0;i<s.size();i++) {
		cout << i << ": " << s[i] << " :: " << roman[s[i]] << endl;
		if (i < s.size()-1 && roman[s[i]] < roman[s[i+1]]) {
			answer -= roman[s[i]];
		} else {
			answer += roman[s[i]];
		}
		cout << answer << endl;
	}	

	return answer;
}

int main() {
	string romanNum;
	cin >> romanNum;
	cout << romanToInt(romanNum) << endl;
}


// https://leetcode.com/problems/roman-to-integer/

// Input
// LVIII, III
// "MCMXCIV"
