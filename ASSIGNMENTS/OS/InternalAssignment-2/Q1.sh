#!/bin/bash


echo "1. Find process ID of given process name"
echo "2. Kill the process using -9 signal"
echo "3. Execute date command , find where bash is creating child process"
echo "4. Exit"
echo "-------------------------------------------------------------------"
read -p "Enter your choice of operation: "  choice


case $choice in

	1)
		read -p "Enter name of a process: " name
		echo "PID of $name is: `ps -e | grep $name | awk '{print $1}'`";;
	2)
		read -p "Enter process name to kill: " name
		PID=`ps -e | grep $name | awk '{print $1}'`
		echo "Killing $name with PID $PID...`kill -9 $PID`";;
	3)
		#strace -f date
		strace -e trace=execve date;;
	4)
		echo "Thank-you !!"
		exit 0;;
	*)
		echo "Invalid input !!"
		exit 0;;
esac




