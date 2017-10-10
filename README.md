The code in master branch is written in very crude way. The purpose is to make you understand the design principles, not just that, but to help you identify the code which doesn't comply to these principles and resolve them. For hands-on, just check out the master branch, identify improvements and resolve them one by one.

# SOLID Design Principles 
# 'S' : Single-responsibility:
A class should have one and only one reason to change, meaning that a class should have only one job.

Let's fist look at the code and identify what doesn't comply with Single-Responsibility. Other things looks fine in terms of single responsibility except the code in :  ```src/main/problem/AreaAggregator.java```

```AreaAggregator``` class has two methods ```Sum``` (aggregates area of different shapes) and ```Output``` (outputs aggregated area). Having two methods is not the problem. The problem is this class does two things : summing areas and print output. Basically, this violates the single-responsibility priciple.

Okay, lets re-verify this. Let's do some modification: add a new shape ```Rectangle```. What do you think, how would your ```AreaAggregator``` change? Well you would accomodate changes to add Rectangle's area in method Sum. So far, all good.

What if client needs output in PDF format (or in any other format)? How would it impact ```AreaAggregator```? Yes, you would again need to accomodate this change in the method ```Output```. Basically, two reasons to change this class. Do you really think, output in different format is AreaAggregator's concern.

Now, that we know, what the problem is, can we try to resolve this?
