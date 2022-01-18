### Topological Sorting

[https://www.geeksforgeeks.org/topological-sorting/](https://www.geeksforgeeks.org/topological-sorting/)
#### DFS

> We can modify DFS to find Topological Sorting of a graph. In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of the stack. Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack. 

#### Kahn's algorithm
1. Compute the in-degree (number of incoming edges) for each vertex present in the DAG and initialize the count of visited nodes as 0.
2. Pick all vertices with in-degree as 0 and add them to the queue (enqueue).
3. Remove a vertex from the queue (dequeue) and then
    - increase `visitedNodes` by 1
    - decrease in-degree for all of its neighbors by 1
    - in in-degree of neighbor decrease to 0, add it to that node to the queue
4. Repeat step 3 while the queue is not empty
5. If the `visitedNodes` is not equal to the number of nodes, so topological sort is not avaiable for the graph.

