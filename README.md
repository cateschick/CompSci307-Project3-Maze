maze
====

This project implements a maze solver.

Name: CATE SCHICK

### Timeline

Start Date: September 11th, 2021

Finish Date: September 14th, 2021

Hours Spent: 26 hours


### Tutorial and other Resources Used
I referenced attached article on Inheritance and another
attached article on VBox background settings

### Resource Attributions
https://www.mygreatlearning.com/blog/inheritance-in-java/#:~:text=Inheritance%20in%20Java%20is%20a,class%20or%20the%20child%20class.
https://www.programcreek.com/java-api-examples/?class=javafx.scene.layout.VBox&method=setBackground

### Running the Program

Main class: Main.java

Data files needed: N/A

Key/Mouse inputs: 

*Mouse inputs*:
This project recognizes mouse input when users select which algorithm they want their maze solver
to implement. They can select BFS, DFS, Greedy, Magic, or RandomWalk algorithms.

This project also recognizes mouse input when a user selects the "New Maze" button.

*Key inputs*:
* N: A new maze is created
* S: The maze takes a step()
* SPACE: Pauses the maze
* D: Creates a new DFS Maze
* B: Creates a new BFS Maze
* G: Creates a new Greedy Maze
* R: Creates a new RandomWalk Maze
* M: Creates a new Magic Maze

Known Bugs:

*Display*
I was unable to get my displays to dynamically update to reflect the current values. 
The backend works as expected and keeps track of the number of steps that the maze takes, 
the max size of the data structure, and the number of times the algorithm backtracked. While my frontend
has a bug, you can see the System prints out the values for each step.

UPDATES: I also attempted to add the dynamic button for pausing the maze. 

### Notes/Assumptions

I had done a similar project in my AI class last spring utilizing these algorithms, but 
the project was more focused on understanding the search algorithms themselves and implementing them. Approaching this project
from a design perspective was actually much more difficult, which I found surprising.

### Impressions

I struggled with this project more than the others, likely because I feel that my weaknesses in OOP and Java in general
tend to lie mostly in my understanding of inheritance. I struggle to implement these abstract classes and override methods,
and hope that my MazeSolver project will lead to some insights for myself. 
