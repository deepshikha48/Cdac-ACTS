#!/bin/bash

read -p "Enter a file name: " file

if [ -f $file ]               #check if file exists or not
then                          #check if all the x bits are set in file or not and store in result
	result=`ls -l $file | egrep '^[^d]..x..x..x.*$'`
	if [ -z "$result" ]
	then
		echo "Not a world executable file"
	else
		echo "World executable file"
	fi
else
	echo "File does not exists or its a directory"
fi
