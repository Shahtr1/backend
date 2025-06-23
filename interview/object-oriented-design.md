Object-Oriented Design (OOD)

❓ 100 OOD Interview Questions
🎓 OOP Basics & Principles (Q1–Q20)
What are the four pillars of OOP?

How does encapsulation improve code maintainability?

What is the difference between abstraction and encapsulation?

How do interfaces and abstract classes differ?

Give an example of inheritance and polymorphism in real code.

What is method overriding vs method overloading?

Why is composition often preferred over inheritance?

How does Liskov Substitution Principle impact class design?

What is tight coupling and how to avoid it?

What is cohesion and why is it important?

How do you achieve polymorphism in Java?

What are access modifiers in Java and how do they affect OOD?

What’s the role of constructors in OOP?

How to apply Open/Closed principle in a payment processor design?

How to identify responsibilities when designing a class?

What’s a use-case where inheritance led to problems?

Why is deep copying important in OOD?

What is a pure virtual function (in OOP terms)?

Give an example of applying the Interface Segregation Principle.

What is the Law of Demeter?

🛠 Design Patterns (Q21–Q60)
Implement Singleton in Java.

When would you use a Factory pattern?

What’s the difference between Strategy and State patterns?

Use case for Observer pattern (e.g., event-driven apps).

Difference between Decorator and Adapter patterns.

How to implement Chain of Responsibility pattern?

How does a Proxy pattern work?

Real-world example of Composite pattern.

What problem does the Builder pattern solve?

Difference between Template Method and Strategy.

Design an in-memory cache (use Decorator).

Design a logging system (Observer + Singleton).

Explain MVC vs MVVM.

Use the Command pattern for a text editor (undo/redo).

Implement a thread-safe Lazy Singleton.

How to extend Factory pattern using Open/Closed Principle?

How is Flyweight pattern memory efficient?

How would you implement an Iterator pattern?

Compare Bridge vs Adapter.

How do patterns promote reuse?

When to avoid Singleton?

What is a Mediator pattern used for?

How would you design a file system (Composite)?

Observer pattern in UI frameworks – example?

Strategy pattern for different shipping providers?

When is it better to use Abstract Factory over Factory?

Difference between Prototype and Builder pattern?

When would you use Dependency Injection?

Benefits and tradeoffs of using design patterns?

What are anti-patterns? Give examples.

Use-case for Service Locator pattern.

How would you test code that uses Factory pattern?

How to implement Retry logic using Template pattern?

How does the Visitor pattern work?

Implement Policy-based Authorization using Strategy.

What is the Singleton registry?

Explain micro-kernel pattern.

Implement facade over complex subsystem.

What is a Null Object pattern?

Difference between active object and proxy?

🏗️ System Design & Class Design (Q61–Q100)
Design an elevator system (OOP).

Design a parking lot system (OOP).

Design a library management system.

Design a movie ticket booking system.

Design a food delivery platform (Zomato, Uber Eats).

Design a deck of cards and card game.

Design a rate limiter system.

Design a notification service (Observer).

Design a social media platform (users, posts, likes).

Design a file upload system (Strategy for compression).

Design a vending machine.

Design a text editor (Command pattern).

Design a calendar/meeting scheduler.

Design a snake and ladder game.

Design an ATM.

Design a chatbot conversation handler.

Design a browser (tabs, bookmarks, history).

Design a music streaming service (Spotify-like).

Design a rideshare platform.

Design a content moderation system.

Design a banking transaction system.

Design a notification throttler.

How do you apply SOLID to a payment gateway?

How to design API client libraries (Strategy, Adapter)?

Design a workflow engine (Chain of Responsibility).

Design a plagiarism detection system.

Design a hotel booking platform.

Design a real-time chat application.

Design a news feed (Observer + Priority Queue).

Design a file system (recursive directory tree).

Design a video processing pipeline.

Design a content delivery system (CDN).

Design a distributed logger.

How would you scale your OOD to support plugins?

How do you design for extensibility and testing?

Design a multi-tenant SaaS system.

How to apply Dependency Inversion in service architecture?

Design a secure login system.

What’s the impact of OOD on testability?

How do you refactor tightly coupled classes?

💡 Java Code Example – Factory Pattern
java
Copy
Edit
interface Notification {
void send();
}

class EmailNotification implements Notification {
public void send() {
System.out.println("Sending Email");
}
}

class SMSNotification implements Notification {
public void send() {
System.out.println("Sending SMS");
}
}

class NotificationFactory {
public static Notification create(String type) {
return switch (type) {
case "EMAIL" -> new EmailNotification();
case "SMS" -> new SMSNotification();
default -> throw new IllegalArgumentException("Unknown type");
};
}
}
