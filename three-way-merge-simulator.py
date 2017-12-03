#!/usr/bin/python
# Author: Daniel Ferreira Maida
# email : dfm2 {at} cin.ufpe.br

import sys
import subprocess

conflict_count = 0
no_conflict_count = 0
target_file = "package.json" #the file that you used to create the commit-hashes.txt

with open("commit-hashes.txt", "r") as cmt: #this is the txt file with the commit SHAs
    commit_line = cmt.read().splitlines()
for i in range(0,len(commit_line)):    #here the simulation begins
    if (i + 3) > len(commit_line) - 1:
        break
    base = commit_line[i]
    left = commit_line[i+1]
    right = commit_line[i+2]   

    print(base)
    print(left)
    print(right)
    print('creating branches...')

    subprocess.call(['git','checkout', '-b', 'base', base]) 
    subprocess.call(['git','checkout', '-b', 'left', left])
    subprocess.call(['git','checkout', '-b', 'right', right])
    
    print('checking out to base...')
    
    subprocess.call(['git','checkout','base'])

    try:
        print(' merging left')
        subprocess.check_call(['git','merge', '-m', 'merge left' ,left])
    
        print('merging right')
        subprocess.check_call(['git','merge', '-m', 'merge right' ,right])

        no_conflict_count +=1 
    
    except: #if the return code is 1, a conflict happened and a SubprocessException is thrown
        with open("merge_results.txt", "a") as mr: 
            #this is the output file of the program that consists of the combination of SHAs that resulted in conflict
            #the number of conflicts and the number of non-conflicts
            conflict_count += 1
            mr.write("------------------------------\n")
            mr.write("base: " + base + '\n')
            mr.write("left: " + left+ '\n')
            mr.write("right: " + right + '\n')
            subprocess.call(['git', 'rm', target_file])
    
    print('checking out to master')
    subprocess.call(['git','checkout', '-f', 'master'])
    print('deleting branches')
    subprocess.call(['git','branch', '-D', 'base'])
    subprocess.call(['git','branch', '-D', 'left'])
    subprocess.call(['git','branch', '-D', 'right'])
    print('iteration end')
with open("merge_results.txt", "a") as mr:
    mr.write('\n')
    mr.write("Total of conflicts: " + str(conflict_count) + '\n')
    mr.write("Total of non-conflicts: " + str(no_conflict_count))
print("Merge process finished")