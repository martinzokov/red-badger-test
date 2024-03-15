# Design
The structure of the solution is modeled with Domain-Driven Design. It has a domain layer
which defines the MarsMap and Robot entities. A service called 

# Key concepts

## 1. Domain 

- `MissionMap` interface to allow for missions to different planets. MarsMap is the only implementation at the moment 
- `Robot` entity for basic robot functionality like turning and calculating next position
- `Orientation`, `Position`, `RobotReport`, `RobotStatus`, `Scent` - helper classes that don't need an ID
- `RobotMovementService` enforces the invariants of the mission (e.g. robots get lost, don't move if there's a scent, etc)

## 2. Application

The application layer uses the Command pattern with a really basic command handler implementation.
Ideally a more robust one would be implemented with proper DI registration for each command to avoid
manually checking the instruction letter (in RobotInstructionService)

-  `CommandInvoker` and `RobotCommand` - generic interfaces to provide an extensible framework for other commands
- `RobotInstructionService` - processes a command
- `MarsMissionRunner` deploys a robot instance and sends instructions to it. This orchestrates concrete classes but should really use dependency injection. Maintains state of the mission  

The solution makes some assumptions about current and future use cases. 
One such assumption is next position is not automatically set in the `Robot` class but rather calculated and then set on the object by the `MarsRobotMovementService` so that domain rules can be easily enforced from the service

Instead of using a dependency injection framework, the solution uses the MarsMissionRunner class to orchestrate concrete classes and run the mission

## Future improvement suggestions:

- Proper Dependency Injection
- Loading of robots from a database
- Logging
- Dedicated Validator services to allow for more flexible validation
- Improved Command pattern structure for the application layer

# How to run
For a basic CLI interface, run `main()` from `Main.kt`

Alternatively - run all tests. Tests for MarsMissionRunner are essentially integration tests that use concrete implementations instead of mocking dependencies on other layers like the unit tests for other classes