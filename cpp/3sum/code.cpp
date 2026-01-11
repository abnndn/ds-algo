#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> threeSum(vector<int>& nums) {
	vector<vector<int>> list = {};

	if(nums.size()<3) {
        return list;
    }

	sort(nums.begin(), nums.end());

	for (int i=0;i<nums.size()-2;i++) {
		if (i>0 && nums[i] == nums[i-1]) {
			continue;
		}
		int j=i+1; int k=nums.size()-1;

		while(j<k) {
			if (nums[i]+nums[j]+nums[k] > 0) {
				k--;
				continue;
			} else if(nums[i]+nums[j]+nums[k] < 0) {
				j++;
				continue;
			}

			if (j>i+1 && k<nums.size()-1 &&
			 nums[j] == nums[j-1] && nums[k] == nums[k+1]) {
				// Already covered triplet
			} else {
				vector<int> found{
					nums[i], nums[j], nums[k]
				};
				list.push_back(found);
			}

			j++; k--;
		}
	}

	return list;
}

int main() {
	int n;
	cin >> n;
	vector<int> list(n);
	vector<vector<int>> output = threeSum(list);

	cout << "Output:" << endl;
	for (int i=0;i<output.size();i++) {
		for (int j=0;j<3;j++) {
			cout << output[i][j] << " ";
		}
		cout << ";" << endl;
	}
}

// https://leetcode.com/problems/3sum/
