The code in master branch is written in very crude way. The purpose is to make you understand the design principles, not just that, but to help you identify the code which doesn't comply to these principles and resolve them. For hands-on, just check out the master branch, identify improvements and resolve them one by one.

# SOLID Design Principles 
# 'S' : Single-responsibility:
A class should have one and only one reason to change, meaning that a class should have only one job.

Let's fist look at the code and identify what doesn't comply with Single-Responsibility.
```src/main/problem/AreaAggregator.java``` 
