#include<bits/stdc++.h>
using namespace std;

string longestCommonPrefix(vector<string>& strs) {

	for (int i=0;i<strs[0].length();i++) {
		for (int j=1;j<strs.size();j++) {
			if (i == strs[j].length() || strs[0][i] != strs[j][i]) {
				return strs[0].substr(0,i);
			}
		}
	}
	return strs[0];
}

int main() {
	int n;
	cin >> n;
	vector<string> input(n);
	for (int i=0;i<n;i++) {
		cin >> input[i];
	}

	cout << longestCommonPrefix(input) << endl;
}