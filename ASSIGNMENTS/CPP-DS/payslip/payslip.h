#include<iostream>
#include<string>

using namespace std;


class payslip
{
   int emp_no;
   string emp_name;
   float da;
   float hra;
   float basic_salary;


	public:

   payslip();
   payslip(int,string, float, float, float);
   float calculator();
   friend ostream & operator<<(ostream & , const payslip &);
   //friend istream & operator>>(istream &, payslip &);




};


