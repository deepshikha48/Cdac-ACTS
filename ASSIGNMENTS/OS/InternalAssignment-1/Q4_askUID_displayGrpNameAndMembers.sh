#!/bin/bash

read -p "Enter user ID: " uid
username=`id -nu $uid`

if [ -z $username ]                   #check if uid exists or not
then
	echo "No such userID exists."
else

	grpNames=`id -nG $username`   #store all the group names with which given uid is associated
	for a in ${grpNames[@]}
	do                            #printing grp names and all its members
		echo "The group name associated with $uid UID is: $a"
		echo "All the group members of $ a group are: `members $a`"
	done
fi

