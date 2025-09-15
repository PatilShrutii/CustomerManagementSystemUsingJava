Project Overview
The Customer Management System (CMS) is a Java-based console application that manages customer data such as registration details, email, password, date of birth, and subscription plans.
It demonstrates concepts of:
-OOPs in Java (Encapsulation, Inheritance, Polymorphism)
-Custom Exception Handling
-Collections Framework (ArrayList, Comparator, etc.)
-Input Validation Rules
-Enums for Service Plans
This project was developed as a case study to strengthen Java programming, object-oriented design, and problem-solving skills.

Tech Stack
Language: Java (JDK 8+)
IDE: Eclipse / IntelliJ / VS Code
Core Concepts Used:
Classes & Objects
Enums (ServicePlan)
Custom Exceptions (CMSExecptionHandling)
Collections (ArrayList, Comparator)
Validation logic (ValidationRulesCMS)

Project Structure 
|── Customer.java                 # Customer entity class
├── ServicePlan.java              # Enum for subscription plans (SILVER, GOLD, DIAMOND, PLATINUM)
├── ValidationRulesCMS.java       # Business validation logic (email, DOB, plan, etc.)
├── CMSExecptionHandling.java     # Custom exception handling class
├── compareByRegAmountComparator.java # Comparator to sort customers by registration amount
├── UI.java                       # Main class with menu-driven UI

Features
1.Customer Registration with validation (email uniqueness, DOB check, plan validation)
2. Login Functionality with email & password check
3. Sorting Customers (by registration amount, email, etc.)
4. Custom Exception Handling for invalid inputs
5. Menu-driven Console UI for interaction
