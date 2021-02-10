#include<iostream>
#include<string>
#include"payslip.h"


using namespace std;


//default constructor
payslip::payslip()
{
   emp_no=0;
   emp_name="NONE";
   da=0;
   hra=0;
   basic_salary=0;
   
}


//paramertized constructor
payslip::payslip(int no, string name,float DA, float HRA, float BS)
{
   emp_no=no;
   emp_name=name;
   da=DA;
   hra=HRA;
   basic_salary=BS;

}

//calculating gross salary 
float payslip::calculator()
{
   float GS=(da*basic_salary)/100+(hra*basic_salary)/100+basic_salary;
   return GS;
   
}


//Display the input taken from user
ostream & operator<<(ostream &out,const payslip &t)
{
   out<<"----------------------------------------\n";
   out<<"emp_no: "<<t.emp_no<<"   emp_name: "<<t.emp_name<<"   DA: "<<t.da<<"   HRA: "<<t.hra<<"   Basic Salary: "<<t.basic_salary<<endl;
   out<<"----------------------------------------\n";

}










