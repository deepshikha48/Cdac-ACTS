#pragma once
#include<iostream>
#include<string>

using namespace std;

class QueueUsingLinkList;

class Node
{
	private:
		//variable to store string data
		string data;
		//pointer to next node
		Node* next;

	public:
		//constructor
		Node();

		//destructor
		~Node();

		//making QueueUsingLinkList as friend to use its private data members
		friend QueueUsingLinkList;


};

class QueueUsingLinkList
{
private:
	//front to hold front most element
	Node *front;
	//rear to Hold last element
	Node *rear;
	//fixed size queue
	int size;

public:
	//default constructor
	QueueUsingLinkList();

	//parameterized constructor to set size for queue
	QueueUsingLinkList(int);

	//destructor
	~QueueUsingLinkList();

	//Add data to queue
	void push(string);

	//delete data from queue
	void pop();

	// get the front most data
	string getFrontElement();

	// get the last data
	string getRearElement();

	//check is queue is empty
	bool isEmpty();

	//check is queue is full
	bool isFull();

	//to print queue
	void print();

};

