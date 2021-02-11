#!/bin/bash

read -p "Enter the interface name: " interface
ifconfig $interface | grep 'inet ' | awk '{print $2}'

#ifconfig display interface detail 
#then send the output to grep and search for inet word
#then send the output to awk to print the second word after inet word ie. IP address
