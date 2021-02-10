#include<iostream>
#include<stdlib.h>
#include"player.h"

using namespace std;

//function to comapre by country
int cmpr_country(const void* a, const void* b)
{
	
    const player *x=(const player *)a;	
    const player *y=(const player *)b;	
    return ((x->country).compare(y->country));

}    

//function to comapre by name
int cmpr_name(const void* a, const void* b)
{
    const player *x=(const player *)a;	
    const player *y=(const player *)b;    
    return ((x->name).compare(y->name));

}

//function to comapre by age
int cmpr_age(const void* a, const void * b)
{
    const player *x=(const player *)a;	
    const player *y=(const player *)b;	
    return ((x->age)-(y->age));

}




int main()
{
  
  player* p1;
  int n,choice;

  cout<<"enter number of players\n";
  cin>>n;

  //allocate memory for array of objects using free
  p1=new player[n];

  //enter the values for data members
  for(int i=0;i<n;i++)
	  cin>>p1[i];


  cout<<"press 1- To sort by name\n";
  cout<<"press 2- To sort by country\n";
  cout<<"press 3- To sort by age\n";
  cout<<"press 4- To sort by exit\n";
  cin>>choice;

  switch(choice)
  {
	  case 1:
 		//sorting by name
  		cout<<"------------------------------------------------------\n";
  		cout<<"sorting by name\n";
  		qsort(p1,n,sizeof(p1[0]),cmpr_name);

  		for(int i=0;i<n;i++)
	  		cout<<p1[i];
		break;
	case 2:

  		//sorting by country
  		cout<<"-----------------------------------------------------\n";
  		cout<<"sorting by country\n";
  		qsort(p1,n,sizeof(p1[0]),cmpr_country);

  		for(int i=0;i<n;i++)
	  		cout<<p1[i];
		break;
	case 3:


 		 //sorting by age
  		 cout<<"-----------------------------------------------------\n";
  		 cout<<"sorting by age\n";
  		 qsort(p1,n,sizeof(p1[0]),cmpr_age);

 		 for(int i=0;i<n;i++)
	  		cout<<p1[i];
		 break;
	case 4:

		 exit(0);
	default:
		 cout<<"invalid input\n";
		 break;
  }




//deallocating the memory 
delete[] p1;

return 0;
}
	
