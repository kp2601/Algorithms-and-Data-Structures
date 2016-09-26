/*A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line. */

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include<stdlib.h>
#include<stack>
#include<string>
using namespace std;

bool CheckForBalancedParenthesis(string s);
bool Match(char char_1, char char_2);

bool CheckForBalancedParenthesis(string s)
{
	/* Declare an character Stack using STL */
	stack<char> Stack;
	int i=0;
	
	/* Traverse the given string or expresstion to check matching parenthesis */
	while(s[i])
	{
		if( s[i]=='(' || s[i]=='{' || s[i]=='[' )
		{
		/*If the exp[i] is a starting parenthesis then push it to Stack*/		
            Stack.push(s[i]);
		
        }
		/* If exp[i] is a ending parenthesis then check for empty stack or 
		paranthesis matching then pop it from Stack*/
		if( s[i]==')' || s[i]=='}' || s[i]==']' )
		{
			if( Stack.empty() || !Match(Stack.top(),s[i]) )
			{
				return false;
			}
			else
			{
				Stack.pop();
			}
		}
		i++;
	}
	
	/*If Stack is empty then paranthesis are balanced otherwise NOT */
	return Stack.empty();
}
 
/* Match for relevent paranthesis */
bool Match(char char_1, char char_2)
{
	if( char_1=='(' && char_2==')' )
		return true;
	else if(char_1=='{' && char_2=='}')
		return true;
	else if(char_1=='[' && char_2==']')
		return true;
	else
		return false;
}



int main() {
    string giv = "";
    vector<string> V;    
    while (cin >> giv) {
        V.push_back(giv);
        
    }
    int count = 0;    
    for(auto e:V){        
        if(count > 0) {
        if(CheckForBalancedParenthesis(e)) {
		  cout<<"YES"<<endl;
        }
	   else{
		  cout<<"NO"<<endl;
         }
        }
    ++count;     
   }
    return 0;
 }
