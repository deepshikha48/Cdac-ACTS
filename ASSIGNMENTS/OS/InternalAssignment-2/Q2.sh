#!/bin/bash

#1 method
echo "List of all sleeping processes: `ps o stat,cmd | grep "^[SD]"`"

#2 method
#echo "`ps -eo s,pid,cmd | awk '{ if ($1 == "S" || $1 == "D") print $1,$2,$3; }'`"



