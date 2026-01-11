#include<bits/stdc++.h>
using namespace std;

int threeSumClosest(vector<int>& nums, int target) {
	sort(nums.begin(), nums.end());
	int n = nums.size();
	int ans=INT_MAX;
	int diff=INT_MAX;

	for (int i=0;i<n;i++) {
		int j=i+1, k = n-1;
		while(j<k) {

			if(abs(nums[i]+nums[j]+nums[k]-target) < abs(ans-target)) {
				ans = nums[i]+nums[j]+nums[k];
			}

			if (nums[i]+nums[j]+nums[k] > target) {
				k--;
			} else if (nums[i]+nums[j]+nums[k] < target) {
				j++;
			} else {
				return ans;
			}
		}
	}
	return ans;
}

int main() {
	int n, target;
	cin >> n;
	vector<int> list(n);

	for (int i=0;i<n;i++) {
		cin >> list[i];
	}
	cin >> target;

	cout << threeSumClosest(list, target) << endl;
}

// https://leetcode.com/problems/3sum-closest/
