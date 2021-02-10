#include "QueueUsingLinkList.h"

int main()
{
	//Get the size for queue
	int size;
	do
	{
		cout << "Enter size for queue (>0)" << endl;
		cin >> size;

	} while (size <= 0);

	//initialize queue to size given by user
	QueueUsingLinkList queue(size);
	//take string data to store value
	string data;

	int choice = 0;
	bool exit = false;
	while (!exit)
	{
		cout << "--------------------------------------------" << endl;
		cout << "1. Push" << endl;
		cout << "2. Pop" << endl;
		cout << "3. Print" << endl;
		cout << "4. Is Empty ?" << endl;
		cout << "5. Is Full ?" << endl;
		cout << "6. Get Rear ?" << endl;
		cout << "7. Get Front ?" << endl;
		cout << "8. Exit" << endl;
		cout << "--------------------------------------------" << endl;
		cout << "Enter Choice: ";
		cin >> choice;
		cout << endl;

		switch (choice)
		{
			case 1:

				cout << "Enter String value  to push into queue" << endl;
				cin >> data;
				queue.push(data);
				break;

			case 2:

				queue.pop();
				break;

			case 3:

				queue.print();
				break;

			case 4:

				if (queue.isEmpty())
					cout << "Yes , Queue is Empty" << endl;
				else
					cout << "No, Queue is Not Empty" << endl;
				break;

			case 5:

				if (queue.isFull())
					cout << "Yes ,There is no Space To push further" << endl;
				else
					cout << "No, Space is Available" << endl;
				break;
			
			case 6:

				cout << queue.getRearElement() << endl;
				break;

			case 7:

				cout << queue.getFrontElement() << endl;
				break;

			case 8:

				exit = true;
				cout << "Thankyou!!" << endl;
				break;

			default:

				cout << "Enter Valid choice!!"<<endl;
				break;
			}

	}

	return 0;
}