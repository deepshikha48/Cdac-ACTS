#!/bin/bash

read -p "Enter directory name: " dir

if [ -d $dir ]                           # Check if dir is present or not
then
	count=0
	res=`ls $dir | grep "^a"`        #Store all files and dir in array that starts with 'a'
	for i in ${res[@]}
	do 
		if [ -f ${dir}/${i} ]    #Check for each array element if its a file or not
		then
			echo "$i"           
			((++count))
		fi
	done
else
	echo "No such directory exists"
fi


if [ $count -eq 0 ]                     #If no file starts with 'a' then count will be 0
then
	echo "No such file that starts with letter 'a'"
fi
