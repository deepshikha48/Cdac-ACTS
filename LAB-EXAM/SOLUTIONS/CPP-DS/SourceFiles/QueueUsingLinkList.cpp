#include "QueueUsingLinkList.h"

//initialize data and next pointer using default constructor
Node::Node() :data(""), next(NULL) {}

//destructor
Node::~Node() {}

//default constructor: size=0
QueueUsingLinkList::QueueUsingLinkList() : front(NULL), rear(NULL), size(0) {}

//Parameterized constructor: size=0
QueueUsingLinkList::QueueUsingLinkList(int s) : front(NULL), rear(NULL), size(s) {}

//free up resources using destructor
QueueUsingLinkList::~QueueUsingLinkList()
{
	delete(front);
	delete(rear);
}

//Function to Add data to queue: At rear position
void QueueUsingLinkList::push(string value)
{
    //check if queue is full or not to insert a new node
    if (isFull())
    {
        cout << "The queue is Full !!" << endl;
        return;
    }

    //initializing a new node to add into queue
    Node* t = new Node;
    t->data = value;
    t->next = NULL;

    //adding the Ist element
    if (rear == NULL)
    {
        rear = t;
        front = t;
    }
    else
    {
        //incrementing rear pointer then adding new node
        rear->next = t;
        rear = t;
    }
    cout << "Pushed successfully!" << endl;
    return;
}

//Function to delete data from queue: from Front position
void QueueUsingLinkList::pop()
{
    //if queue is empty then return
    if (isEmpty())
    {
        cout << "The queue is Empty !!" << endl;
        return;
    }
    else
    {
        //take temporary node initialize it to front pointer 
        Node* temp = front;
        //if only one node is there the set front and rear to null
        if (front == rear)
        {
            rear = NULL;
            front = NULL;
        }
        //if there are more than one node then increment front to next position
        else
        {
            front = front->next;
        }
        cout << "Data poped: "<<temp->data<< endl;
        //delete the node
        delete (temp);
    }
}

//Function to get front most element
string QueueUsingLinkList::getFrontElement() 
{
    //if queue is empty : front is null then no data
    if (isEmpty()) return "The queue is Empty !!";
    else
    {
        //return the front most data
       return "Front data: "+front->data;
    }
}

//Function to get the last element
string QueueUsingLinkList::getRearElement() 
{
    //if queue is empty: then rear is null so no data
    if (isEmpty()) return "The queue is Empty !!";
    else 
    {
        //return last element
        return "Rear data: " +rear->data;
    }
}

//Function to check if queue is empty
bool QueueUsingLinkList::isEmpty() 
{
    //if front is null then empty
    if (front == NULL)
    {
        return true;
    }
    else
        return false;
}

//Function to check if queue is full
bool QueueUsingLinkList::isFull() 
{
    //counter variable
    int count = 0;
    //initialize a temp variable to front
    Node* temp = front;

    //logic to count all the nodes
    while (temp != NULL)
    {
        count++;
        temp = temp->next;
    }
    //if size of queue is equal to  no. of nodes then full
    if (count == size)
    {
        return true;
    }
    else
    {
        return false;
    }
}

//Funtion to print all the data in a queue
void QueueUsingLinkList::print()
{
    //if queue is empty then nothing to print
    if (isEmpty())
    {
        cout << "The queue is Empty !!" << endl;
        return;
    }

    //initialize a temp var to front 
    Node* temp = front;
    //keep incrementing till temp becomes null then print all data one by one
    while (temp != NULL)
    {
        cout << temp->data << endl;
        temp = temp->next;
    }
}

