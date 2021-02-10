#include<iostream>
#include<string>
#include<map>
#include"payslip.h"


using namespace std;

int main()
{
   payslip *ps;
   int size,emp_no;
   float da,basic_salary,hra;
   string emp_name;
   map<int,int> m;
  

   //size should be greater than 0
   do
   {
   	cout<<"enter the number of employees\n";
   	cin>>size;
   	cout<<"\n";
   }while(size<=0);

   //allocate memory using new
   ps=new payslip[size];


   cout<<"enter the details for each employee\n";

   //validating employee no. 
   //should be unique for each employee 
   for(int i=0;i<size;i++)
   {	   
     	do
      	{
      		cout<<"emp_no:   ";
      		cin>>emp_no;
      		cout<<"\n";
      	}
	while((emp_no<=0) || (m.find(emp_no) != m.end()));

	m.insert(pair<int,int>(emp_no,1));

 
    
     
   
      	cout<<"emp_name:   ";
      	cin>>emp_name;
      	cout<<"\n";
   
	cout<<"Dearness Allowance can be of greater than 0 and less than 50% of salary\n";
   	do
	{
		cout<<"DA:   ";
   		cin>>da;
   		cout<<"\n";
	}while(da<=0 || da>50);
   
	cout<<"House Rent Allowance can be of range 5-50% of the salary\n";
   	do
	{
		cout<<"HRA:   ";
   		cin>>hra;
        	cout<<"\n";
	}while(hra<5||hra>50);
   
	cout<<"Basic salary should greater than 1000\n";
   	do
	{
		cout<<"Basic Salary:   ";
   		cin>>basic_salary;
   		cout<<"\n";
	}while(basic_salary<=1000);

        //copy the entered details into array of object using parameterized constructor
	payslip p(emp_no,emp_name,da,hra,basic_salary);

	ps[i]=p;

   	cout<<"---------------------------------------\n";

   
   
   }

   cout<<"details of each employee that u have entered\n";
   for(int i=0;i<size;i++)
	   cout<<ps[i];


   for(int i=0;i<size;i++)
           cout<<"gross salary of "<<i<<" employee: "<<ps[i].calculator()<<endl;
   




delete[] ps;


return 0;
}
