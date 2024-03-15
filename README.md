The solution takes a lot of assumptions about current and future usecases.

Instead of using a dependency injection framework, the solution uses the MarsMissionRunner class to orchestrate concrete classes and run the mission

Additional polish that would be needed for this:

- Proper Dependency Injection
- Loading of robots from a database
- Logging
- Dedicated Validator services to allow for more flexible validation
- Improved Command pattern structure for the application layer

The structure of the solution is modeled with Domain-Driven Design. It has a domain layer 
which defines the MarsMap and Robot entities. A service called RobotMovementService enforces the invariants
of the mission (e.g. robots get lost, don't move if there's a scent, etc)

The application layer uses the Command pattern with a really basic command handler implementation.
Ideally a more robust one would be implemented with proper DI registration for each command to avoid
manually checking the instruction letter (in RobotInstructionService)