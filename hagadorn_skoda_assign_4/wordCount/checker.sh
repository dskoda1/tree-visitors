#!/bin/bash

if [ $# -lt 1 ]; then
	echo "Counts the number of characters and most frequently occuring word in"
	echo "a given input file. Optionally searches for an input string."
	echo "Usage: <input-file> <optional-search-string>"
	exit 1
fi

numChars=$(tr -d '[:space:]' < "$1" | wc -c)
line=$(tr -c '[:alpha:]' '[\n*]' < "$1" | sort | uniq -c | sort -nr | head -10 | grep '[a-zA-Z]' | head -1)
lineArray=($line)
line=$(wc -w "$1")
lineArray2=($line)

echo "Input file: $1"
echo "Number of words: ${lineArray2[0]}"
echo "The most frequent word is '${lineArray[1]}', it occurs ${lineArray[0]} times"
echo "Number of characters: $numChars"

if [ $# -ge 2 ]; then
	num=`grep -o -w "$2" $1 | wc -l`
	echo "'$2' occured $num times"
fi
