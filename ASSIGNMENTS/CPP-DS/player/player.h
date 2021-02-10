#include<iostream>
#include<string>

using namespace std;

class player
{
   public:

   int age;
   string name;
   string country;

   player();
   player(string,string,int);
   friend istream & operator>>(istream &, player &);
   friend ostream & operator<<(ostream & , player &);


};
