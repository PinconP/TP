#! /bin/sh
echo "Il y a `ls -la | grep '^-.*\.txt$'| wc -l` fichiers dont le nom se termine par .txt"
echo "Il y a `ls -la | grep '^-.*\.sh$'| wc -l` fichiers dont le nom se termine par .sh"
echo "Il y a `ls -la | grep '^-.* \.' | wc -l` fichiers cachés"
echo "Il y a `ls -l | grep '^-.*' | grep -v '\.txt$' | grep -v '\.sh$' | wc -l` autres fichiers"