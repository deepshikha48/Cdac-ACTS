#include<iostream>
#include<string>
#include"player.h"

using namespace std;

//default constructor
player::player():age(0){}


//parameterized constructor
player::player(string n, string c,int a):name(n),country(c),age(a){}



istream& operator>>(istream& in, player& p)
{
    cout<<"enter the values for object of player class:\n";
     

    cout<<"enter name:"<<endl;
    in>>p.name;

    cout<<"enter country:"<<endl;
    in>>p.country;

    cout<<"enter age:"<<endl;
    in>>p.age;

    return in;

}    

ostream& operator<<(ostream& out, player& p)
{


    cout<<"name is :";
	out<<p.name<<"  ";

    cout<<"country is : ";
    out<<p.country<<"   ";
 
    cout<<"age is : ";
    out<<p.age<<endl;

    return out;

}



