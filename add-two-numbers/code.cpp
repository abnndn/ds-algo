#include <bits/stdc++.h>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
	
	int sum=0;
    ListNode* l3 = nullptr;
    ListNode* curr;

    while(l1 != nullptr || l2 != nullptr || sum > 0) {
        if (l1 != nullptr) {
            sum += l1->val;
            l1 = l1->next;
        }
        if (l2 != nullptr) {
            sum += l2->val;
            l2 = l2->next;
        }
        // cout << sum << endl;
        if (l3 == nullptr) {
            l3 = new ListNode(sum%10);
            curr = l3;
        } else {
            curr->next = new ListNode(sum%10);
            curr = curr->next;
        }
        
        sum /= 10;
    }
    return l3;

int main() {

}

// https://leetcode.com/problems/add-two-numbers/