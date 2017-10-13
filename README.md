> The code in master branch is written in very crude way. The purpose is to make you understand the design principles, not just that, but to help you identify the code which doesn't comply to these principles and resolve them. For hands-on, just check out the master branch, identify improvements and resolve them one by one.

# SOLID Design Principles 
# 'S' : Single-responsibility:
> A class should have one and only one reason to change, meaning that a class should have only one job.

### Working Branch : ```master```

Let's fist look at the code and identify what doesn't comply with Single-Responsibility. Other things looks fine in terms of single responsibility except the code in :  ```src/main/problem/AreaAggregator.java```

```AreaAggregator``` class has two methods ```Sum``` (aggregates area of different shapes) and ```Output``` (outputs aggregated area). Having two methods is not the problem. The problem is this class does two things : summing areas and print output. Basically, this violates the single-responsibility priciple.

Okay, lets re-verify this. Let's do some modification: add a new shape ```Rectangle```. What do you think, how would your ```AreaAggregator``` change? Well you would accomodate changes to add Rectangle's area in method Sum. So far, all good.

What if client needs output in PDF format (or in any other format)? How would it impact ```AreaAggregator```? Yes, you would again need to accomodate this change in the method ```Output```. Basically, two reasons to change this class. Do you really think, output in different format is AreaAggregator's concern.

Now, that we know, what the problem is, can we try to resolve this?

How?

By relieving, AreaAggregator from its extra responsibility. Since Output in current implementation is in String format, we will assign this responsibility to a new class ```StringOutputter```. Cool ? 

Not cool. Well, ```AreaAggregator``` is fine, because it has only one job and only one reason to change.
```StringOutputter```is also fine, because it has only one job and only one reason to change. 

Coming back to original question, what if client needs output in PDF format? No problem, we will write new class ```PdfOutputtter```. And, this is the best time to introduce an interface ```Outputter```. Both ```StringOutputter``` and ```PdfOutputter``` will implement this interface. No existing code change and no violation of single responsibility.

Now cool, right? Yeah.

Switch to branch, ```single_responsibility_resolved``` for implementation.

# 'O' : Open/Closed Principle
> Objects or entities should be open for extension, but closed for modification.
> This simply means that a class should be easily extendable without modifying the class itself.

### Working Branch : ```single_responsibility_resolved```

Let's discuss same question : add a new shape ```Rectangle```. And, answer is still same: code changes required in method ```Sum``` of the class ```AreaAggregator``` to accomodate this change. That means, we are modifying the class itself - that's the problem. It is breaking open-closed principle. 

```
public int Sum() {
        int sum = 0;
        for (Shape shape: Shapes) {
            if(shape.getClass().equals(Circle.class)) {
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            } else if (shape.getClass().equals(Square.class)) {
                sum += Math.pow(((Square) shape).getSide(), 2);
            }
        }
        return sum;
} 
```
In simple words, what is smelling is, we calculate area of each shapes in ```Sum```. Somehow, if we get rid of this, it will help.

Let each class calculates it's own area, and we will simply use here for summation. Then, it will be fine, right?

Let's see how would this look like:

```
public int Sum() {
        int sum = 0;
        for (Shape shape: Shapes) {
            sum += shape.Area();
        }
        return sum;
}
```
Introducing method ```Area``` in interface ```Shape``` will help. Then all shapes who are implementing interface will take care of it's own area calculation.

```
public interface Shape {
    public int Area();
}
```
Still, question is same : add a new shape ```Rectangle```. But, this time the answer is different. Write ```Rectangle``` class, implements ```Shape``` interface and ```Area``` method. All new code, no existing code changes or class modification needed.

Much cleaner code. 

For implementation switch to branch ```open_closed_resolved```

# 'L' : Liskov substitution principle
> All this is stating is that every subclass/derived class should be substitutable for their base/parent class. Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

### Working Branch : ```open_closed_resolved```

We have shapes like Circle, Cube, Line and Square in code. Re-look at the code, carefully. Can you spot the problem? All shapes has some Area except Line. It has 0 area. 

As of now, Area method of Shape Line intentionally returning 0. But, ideally, we should throw an exception ```IDontActuallyHaveArea```. This is a violation of the Liskov Substitution Principle.

```
1     Shape shape = new Square(10);
2     shape.Area();
```
So far, so good. But if we replace line 1 by 
```
Shape shape = new Line(10);
```
The program will throw an exception : ```IDontActuallyHaveArea```

How to resolve this? By not implementing interface Shape. Let shape ```Line``` implement another interface ```BasicShape```.

Sounds good.

Switch to the branch : ```liskov_substitution_resolved``` for implementation

# 'I' : Interface Segregation Principle
> A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.

we know that we also have solid shapes like Cube, so since we would also want to calculate the volume of the shape, we can add another contract to the Shape Interface.

```
public interface Shape {
    public int Area();
    public int Volume();
}
```
Any shape we create must implement the ```Volume``` method, but we know that Square and Circle are flat shapes and that they do not have volumes, so this interface would force the ```Square``` and ```Circle``` class to implement a method that it has no use of.

ISP says no to this, instead you could create another interface called ```SolidShape``` that has the Volume contract and solid shapes like cubes e.t.c can implement this interface.

```
public interface SolidShape {
    public int Volume();
}
```
class ```Cube``` would now implement Shape for Area and SolidShape for Volume.

```
public class Cube implements Shape, SolidShape {
    private int side;
    public Cube(int side) {
        this.side = side;
    }
    @Override
    public int Volume() {
        return side * side * side;
    }
    @Override
    public int Area() {
        return 6 * side * side;
    }
}
```
