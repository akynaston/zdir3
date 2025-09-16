# Untitled Note

Design Pattern reading

Week 1 - Factory Method

Reading: July 3-9
Meeting: July 12
Pages: 107-116
Opening Question: How does Factory Method promote loosely coupled code?
Java Examples: https://www.tutorialspoint.com/design\_pattern/factory\_pattern.htm
www.tutorialspoint.com
Design Pattern Factory Pattern
Factory Pattern - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

Pinned
\[11:36 AM\] 
Week 2 - Strategy

Reading: July 10-16
Meeting: July 19
Pages: 315-323
Opening Question: 
Part 1: What happens when a system has an explosion of Strategy objects? Is there some way to better manage these strategies?

Part 2: In the implementation section of this pattern, the authors describe two ways in which a strategy can get the information it needs to do its job. One way describes how a strategy object could get passed a reference to the context object, thereby giving it access to context data. But is it possible that the data required by the strategy will not be available from the context's interface? How could you remedy this potential problem?
Java Examples: https://www.tutorialspoint.com/design\_pattern/strategy\_pattern.htm
www.tutorialspoint.com
Design Patterns Strategy Pattern
Design Patterns Strategy Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:36 AM\] 
Week 3 - Decorator

Reading: July 17-23
Meeting: July 26
Pages: 175-184
Opening Question: 
In the Implementation section of the Decorator Pattern, the authors write: A decorator object's interface must conform to the interface of the component it decorates.

Now consider an object A, that is decorated with an object B. Since object B "decorates" object A, object B shares an interface with object A. If some client is then passed an instance of this decorated object, and that method attempts to call a method in B that is not part of A's interface, does this mean that the object is no longer a Decorator, in the strict sense of the pattern? Furthermore, why is it important that a decorator object's interface conforms to the interface of the component. it decorates?
Java Examples: https://www.tutorialspoint.com/design\_pattern/decorator\_pattern.htm
www.tutorialspoint.com
Design Patterns Decorator Pattern
Design Patterns Decorator Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:37 AM\] 
Week 4 - Composite

Reading: July 24-30
Meeting:  August 2
Pages: 163-173
Opening Question: 
Part 1: How does the Composite pattern help to consolidate system-wide conditional logic?

Part 2: Would you use the composite pattern if you did not have a part-whole hierarchy? In other words, if only a few objects have children and almost everything else in your collection is a leaf (a leaf can have no children), would you still use the composite pattern to model these objects?
Java Examples: https://www.tutorialspoint.com/design\_pattern/composite\_pattern.htm
www.tutorialspoint.com
Design Patterns Composite Pattern
Design Patterns Composite Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:37 AM\] 
Week 5 - Iterator

Reading: July 31-August 6
Meeting: August 9
Pages: 257-271
Opening Question: 
Consider a composite that contains loan objects. The loan object interface contains a method called "AmountOfLoan()", which returns the current market value of a loan. Given a requirement to extract all loans above, below or in between a certain amount, would you write or use an Iterator to do this?
Java Examples: https://www.tutorialspoint.com/design\_pattern/iterator\_pattern.htm
www.tutorialspoint.com
Design Patterns Iterator Pattern
Design Patterns Iterator Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:37 AM\] 
Week  6 - Template Method

Reading: August 7-13
Meeting: August 16
Pages: 325-330
Opening Question: 
The Template Method relies on inheritance. Would it be possible to get the same functionality of a Template Method, using object composition? What would some of the tradeoffs be?
Java Examples: https://www.tutorialspoint.com/design\_pattern/template\_pattern.htm
www.tutorialspoint.com
Design Patterns Template Pattern
Design Patterns Template Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:38 AM\] 
Week 7 - Abstract Factory

Reading: August 14-20
Meeting: August 23
Pages: 87-95
Opening Question: 
In the Implementation section of this pattern, the authors discuss the idea of defining extensible factories. Since an Abstract Factory is composed of Factory Methods, and each Factory Method has only one signature, does this mean that the Factory Method can only create an object in one way?

Consider the MazeFactory example. The MazeFactory contains a method called MakeRoom, which takes as a parameter one integer, representing a room number. What happens if you would also like to specify the room's color & size? Would this mean that you would need to create a new Factory Method for your MazeFactory, allowing you to pass in room number, color and size to a second MakeRoom method?

Of course, nothing would prevent you from setting the color and size of the Room object after is has been instantiated, but this could also clutter your code, especially if you are creating and configuring many objects. How could you retain the MazeFactory and keep only one MakeRoom method but also accommodate different numbers of parameters used by MakeRoom to both create and configure Room objects?
Java Examples: https://www.tutorialspoint.com/design\_pattern/abstract\_factory\_pattern.htm
www.tutorialspoint.com
Abstract Factory Pattern
Abstract Factory Pattern - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:38 AM\] 
Week 8 - Builder

Reading: August 21-27
Meeting: August 30
Pages: 97-106
Opening Question: 
Like the Abstract Factory pattern, the Builder pattern requires that you define an interface, which will be used by clients to create complex objects in pieces. In the MazeBuilder example, there are BuildMaze(), BuildRoom() and BuildDoor() methods, along with a GetMaze() method. How does the Builder pattern allow one to add new methods to the Builder's interface, without having to change each and every sub-class of the Builder?
Java Examples: https://www.tutorialspoint.com/design\_pattern/builder\_pattern.htm
www.tutorialspoint.com
Design Patterns Builder Pattern
Design Patterns Builder Pattern - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:38 AM\] 
Week 9 - Singleton

Reading: August 28-September 3
Meeting: September 6
Pages: 127-134
Opening Question: 
The Singleton pattern is often paired with the Abstract Factory pattern. What other creational or non-creational patterns would you use with the Singleton pattern?
Java Examples: https://www.tutorialspoint.com/design\_pattern/singleton\_pattern.htm
www.tutorialspoint.com
Design Patterns Singleton Pattern
Design Patterns Singleton Pattern - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:38 AM\] 
Week 10 - Proxy

Reading: September 4-10
Meeting: September 13
Pages: 207-217
Opening Question: 
If a Proxy is used to instantiate an object only when it is absolutely needed, does the Proxy simplify code?
Java Examples: https://www.tutorialspoint.com/design\_pattern/proxy\_pattern.htm
www.tutorialspoint.com
Design Patterns Proxy Pattern
Design Patterns Proxy Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:38 AM\] 
Week 11 - Adapter

Reading: September 11-17
Meeting: September 20
Pages: 139-150
Opening Question: 
Would you ever create an Adapter that has the same interface as the object which it adapts? Would your Adapter then be a Proxy?
Java Examples: https://www.tutorialspoint.com/design\_pattern/adapter\_pattern.htm
www.tutorialspoint.com
Design Patterns Adapter Pattern
Design Patterns Adapter Pattern - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:39 AM\] 
Week 12 - Bridge

Reading: September 18-24
Meeting: September 27
Pages: 151-161
Opening Question: 
How does a Bridge differ from a Strategy and a Strategy's Context?
Java Examples: https://www.tutorialspoint.com/design\_pattern/bridge\_pattern.htm
www.tutorialspoint.com
Design Patterns Bridge Pattern
Design Patterns Bridge Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:39 AM\] 
Week 13 - Mediator

Reading: September 25-October 1
Meeting: October 4
Pages: 273-282
Opening Question: 
Since a Mediator becomes a repository for logic, can the code that implements this logic begin to get overly complex, possible resembling spaghetti code? How could this potential problem be solved?
Java Examples: https://www.tutorialspoint.com/design\_pattern/mediator\_pattern.htm
www.tutorialspoint.com
Design Patterns Mediator Pattern
Design Patterns Mediator Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:39 AM\] 
Week 14 - Observer

Reading: October 2-8
Meeting: October 11
Pages: 293-303
Opening Question: 
Part 1: The classic Model-View-Controller design is explained in Implementation note #8: Encapsulating complex update semantics. Would it ever make sense for an Observer (or View) to talk directly to the Subject (or Model)?

Part 2: What are the properties of a system that uses the Observer pattern extensively? How would you approach the task of debugging code in such a system?

Part 3: Is it clear to you how you would handle concurrency problems with is pattern? Consider an Unregister() message being sent to a subject, just before the subject sends a Notify() message to the ChangeManager (or Controller).
Java Examples: https://www.tutorialspoint.com/design\_pattern/observer\_pattern.htm
www.tutorialspoint.com
Design Patterns Observer Pattern
Design Patterns Observer Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:39 AM\] 
Week 15 - Chain of Responsibility

Reading: October 9-15
Meeting: October 18
Pages: 223-232
Opening Question: 
Part 1: How does the Chain of Responsibility pattern differ from the Decorator pattern or from a linked list?.

Part 2: Is it helpful to look at patterns from a structural perspective? In other words, if you see how a set of patterns are the same in terms of how they are programmed, does that help you to understand when to apply them to a design?
Java Examples: https://www.tutorialspoint.com/design\_pattern/chain\_of\_responsibility\_pattern.htm
www.tutorialspoint.com
Design Patterns Chain of Responsibility Pattern
Design Patterns Chain of Responsibility Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:40 AM\] 
Week 16 - Memento

Reading: October 16-22
Meeting: October 25
Pages: 283-291
Opening Question: 
The authors write that the "Caretaker" participant never operates on or examines the contents of a memento. Can you consider a case where a Caretaker would in fact need to know the identity of a memento and thus need the ability to examine or query the contents of that memento? Would this break something in the pattern?
Java Examples: https://www.tutorialspoint.com/design\_pattern/memento\_pattern.htm
www.tutorialspoint.com
Design Patterns Memento Pattern
Design Patterns Memento Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:40 AM\] 
Week 17 - Command

Reading: October 23-29
Meeting: November 1
Pages: 233-242
Opening Question: 
In the Motivation section of the Command pattern, an application's menu system is described. An application has a Menu, which in turn has MenuItems, which in turn execute commands when they are clicked. What happens if the command needs some information about the application in order to do its job? How would the command have access to such information such that new commands could easily be written that would also have access to the information they need?
Java Examples: https://www.tutorialspoint.com/design\_pattern/command\_pattern.htm
www.tutorialspoint.com
Design Patterns Command Pattern
Design Patterns Command Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:40 AM\] 
Week 18 - Prototype

Reading: October 30-November 5
Meeting: November 8
Pages: 117-126
Opening Question: 
Part 1: When should this creational pattern be used over the other creational patterns?

Part 2: Explain the difference between deep vs. shallow copy.
Java Examples: https://www.tutorialspoint.com/design\_pattern/prototype\_pattern.htm
www.tutorialspoint.com
Design Patterns Prototype Pattern
Design Patterns Prototype Pattern - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:40 AM\] 
Week 19 - State

Reading: November 6-12
Meeting: November 15
Pages: 305-313
Opening Question: 
If something has only two to three states, is it overkill to use the State pattern?
Java Examples: https://www.tutorialspoint.com/design\_pattern/state\_pattern.htm
www.tutorialspoint.com
Design Patterns State Pattern
Design Patterns State Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:40 AM\] 
Week 20 - Visitor

Reading: November 13-26 (Two weeks because of Thanksgiving)
Meeting: November 29
Pages: 331-344
Opening Question: 
One issue with the Visitor pattern involves cyclicality. When you add a new Visitor, you must make changes to existing code. How would you work around this possible problem?
Java Examples: https://www.tutorialspoint.com/design\_pattern/visitor\_pattern.htm
www.tutorialspoint.com
Design Patterns Visitor Pattern
Design Patterns Visitor Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:40 AM\] 
Week 21 - Flyweight

Reading: November 27-December 3
Meeting: December 6
Pages: 195-206
Opening Question: 
Part 1: What is a non-GUI example of a flyweight?

Part 2: What is the minimum configuration for using flyweight? Do you need to be working with thousands of objects, hundreds, tens?
Java Examples: https://www.tutorialspoint.com/design\_pattern/flyweight\_pattern.htm
www.tutorialspoint.com
Design Patterns Flyweight Pattern
Design Patterns Flyweight Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:41 AM\] 
Week 22 - Interpreter

Reading: December 4-10
Meeting: December 13
Pages: 243-255
Opening Question: 
As the note says in Known Uses, Interpreter is most often used "in compilers implemented in object-oriented languages...". What are other uses of Interpreter and how do they differ from simply reading in a stream of data and creating some structure to represent that data?
Java Examples: https://www.tutorialspoint.com/design\_pattern/interpreter\_pattern.htm
www.tutorialspoint.com
Design Patterns Interpreter Pattern
Design Patterns Interpreter Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.

\[11:41 AM\] 
Week 23 - Façade

Reading: December 11-17
Meeting: December 20
Pages: 185-193
Opening Question: 
Part 1: How complex must a sub-system be in order to justify using a façade?

Part 2: What are the additional uses of a façade with respect to an organization of designers and developers with varying abilities? What are the political ramifications?
Java Examples: https://www.tutorialspoint.com/design\_pattern/facade\_pattern.htm
www.tutorialspoint.com
Design Patterns Facade Pattern
Design Patterns Facade Patterns - Learning java design patterns in simple and easy steps : A beginner's tutorial containing complete knowledge about an java design patterns starting from its Factory Pattern, Abstract Factory, Singleton, Builder, Prototype, Adapter, Bridge, Filter, Composite, Decorator, Facade, Flyweight, Proxy, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Null Object,Strategy, Template, Visitor, MVC, Front Controller etc.
