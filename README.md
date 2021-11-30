# Assignment--5-Design-Patterns

User: only select startups by the startup ID seen in parenthesis to the right of each startup name.
No exception handling has been implmented.
Many print lines are read out to the screen showing every action that is taken. You may need to scroll thru a lot of text.

Assignment 5b - Design Patterns
Nathanael Swecker nswecker@asu.edu
SER 316 Fall B 2021
GitHub
Repository
https://github.com/ndswecker/Assignment--5-Design-Patterns.git
Continuous Integration 
GitHub CI
https://github.com/ndswecker/Assignment--5-Design-Patterns/actions
CheckStyle
Initial Checksytle errors 200+ reduced to 103. Most errors include lack of javadoc (not enough time to fix all) and some naming conventions (purposely left so that variables would be easier to understand).


SpotBugs:
Spot bug errors are relatively low. Only 2 High priority. The rest are naming conventions, which I left because I felt they the Builder Pattern method resources showed that Construct() method should be capitalized. 
 

JUnit
JUnit 4
Coverage
Jacoco found in reports. Coverage 79%. 


Explanation of Design Patterns:
Three build patterns have been implemented intertwined.
Builder Pattern
Startups
Silicon Valley Simulator relies primarily on the builder pattern. The startups (StartupBE.java, StartupHW.java, StartupMP.java, StartupSE.java) have a startup builder (StartupBuilder.java), and startup director (StartupDirector.java) along with a startup class (Startup.java). Each of the Startups are instantiated using the builder pattern (Start.java). The startups each have attack methods implemented from an interface (StartupAttack.java). Startups are classified by four distinct types using an enum (TechType.java) Each tech type has advantages specific to their type and implemented in the director class within the Construct() method using a constant class (Consts.java).

Tech Giants
The tech giants have also been implemented with the builder pattern (TechGiantAS.java, TechGiantNA.java, TechGiantEU.java) that uses a tech giant builder (TechGiantBuilder.java) and a director (TechGiantDirector.java), along with a tech giant class (TechGiant.java). Each of the Tech Giants are instantiated using the builder pattern (Start.java). The tech giants each have action methods implemented from an interface (TechGiantAttack.java). Tech giants are classified as North American (TechGiantNA.java), Asian (TechGiantAS.java), and European (TechGiantEU.java).
Quarters
The financial quarters have been implemented with the builder pattern (QEven.java, QOdd.java) using the quarter builder (QuarterBuilder.java) and a Quarter director (QuarterDirector.java), along with a quarter class (Quarter.java). Each of the Quarters are instantiated using the builder pattern (Start.java). The quarters implement financial events and quarter events specific to odd quarters. During even quarters the events are focused on tech giants using their startups to wage battles. Each Quarter has one financial event (FinancialEvents.java) that is implemented in the market system (MarketSystem.java) in the marketLoop() method.
Reflections
This method was chosen without detailed consideration of the assignment. As such, I would not have recommended this pattern for this project now that I have implemented it. There is way too much overhead in this pattern for this problem. Nevertheless, The pattern has been executed. 

Iterator Pattern
Market System
The market system (MarketSystem.java) uses an iterator pattern (Iterator.java, Container.java) to display tech giants and startups to the user (methods: getIteratorSU, getIteratorTG) within MarketSysem.java using private classes (StartupIterator, TechGiantIterator).
Reflections
The iterator pattern could have been used more extensively, but was implemented later on in the development process. 

Singleton Pattern
Startup ID
The singleton pattern was used to generate an ID (GenerateID.java) for each of the startups. This ID needed to be generated and incremented after each startup instantiation to allow each startup to have a unique ID. The ID is used primarily by the user to select which startups would be manipulated. 
Reflections
The Singleton pattern was not used to meet a project requirement. Rather it was implemented out of necessity to ensure a reliable way of manipulating the data structure. I have encountered this pattern in my online research before, but it was not until this project that I understood why someone would use this pattern and how valuable it could be.

Simulator Action Flow
Start
The main method begins (Start.java) and sets up a market system (MarketSystem.java), quarters (Quarter.java, QEven.java, QOdd.java), startups (Startup.Java, StartupXX.java, StartupBuilder.java, StartupDirector.java), and tech giants (TechGiant.java, TechGiantXX.java, TechGiantBuilder.java, TechGiantDirector.java). After all the entities are instantiated they are listed out to the user. Net income and revenue are listed in millions of dollars. Public approval and market share are displayed and handled in percentages.
Market System
From the main method the market system is called (MarketSystem.maketLoop()). A while loop loops through the quarters using an incrementer and modulus to make a continuous cycle. Typing “exit” at any time would end the loop, but this was not yet fully implemented. No exception handling was done to deal with unexpected user input to date, but could be added with additional time. 
Each Quarter begins with a financial event (FinancialEvent.java) handled by that quarter. In odd Quarters a Tech giant can evolve or boost one of its startups. In The first quarter all tech giants attempt to capture wild startups. In the second and fourth quarters each tech company each tech giant may select one of its startups to attack one other startup up. Each startup implements its own attack method. Based on the startup’s tech type, they have modifiers that boost unique attack types. 
Attacks
Based on their tech type, each startup has modifications that boost their respective attacks. There are four attack types that rely on the 4 main attributes of a startup (netIncome, revenue, marketShare, publicApproval). A user must select one of these attack types. These mods are listed in parenthesis to the right of each of the attributes in the toString() method. Each attack is handled by a virtual 20 sided dice (D20.java) And the modifiers are added to the dice roll to boost the attack or defense roll. 




----- IGNORE BELOW HERE -----

Builder Pattern: A Builder class builds the final object step by step. This builder is independent of other objects. Each Tech Giant, Startup, and Quarter object is built by this pattern.
Resource to be used: https://www.tutorialspoint.com/design_pattern/builder_pattern.htm

Decorator Pattern: We are demonstrating the use of decorator pattern via following example in which we will decorate a Tech Giant, a Startup, and a Quarter without altering the class.
Resource to be used: https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm

Strategy Pattern: We create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.
Resource to be used: https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm


	
