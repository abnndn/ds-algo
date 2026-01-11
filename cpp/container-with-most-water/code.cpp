#include <bits/stdc++.h>
using namespace std;

int maxArea(vector<int>& height) {
	int start=0;
	int end = height.size()-1;

	long ans = 0L;
	while(start < end) {
		ans = max(ans, (long)(end-start)*min(height[start], height[end]));

		cout << start << " " << end << ": " << ans << endl;

		if (height[start] <= height[end]) {
			start++;
		} else {
			end--;
		}
	}
	return ans;
}

int main() {
	int n;

	cin >> n;
	vector<int> height(n);
	for(int i=0;i<n;i++) {
		cin >> height[i];
	}

	cout << maxArea(height) << endl;
}

// https://leetcode.com/problems/container-with-most-water/