#!/bin/bash

path=`pwd`                          #store path of current dir in path
echo "The path of current working directory is: $path"

read -p "Enter a path(name) of another folder to move in: " folder
cd $folder                          #enter into new directory
echo "Listing the contents of current directory ie. $folder: `ls`"

echo "Moving back to previous working directory ..."
cd                                  #exit from directory
cd $path                            #back to old one using path variable
echo "Listing the contents of current directory ie. $path: `ls`"
                                    #listing its content for conforming where we are
