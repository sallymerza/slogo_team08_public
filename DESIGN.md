#SLogo Team 8 Design

###Introduction:

In this project, we are creating a simplified computer programming language that lets the users interact with an object on the screen through a command line on a per expression basis. The users will have the ability to use predefined commands as part of the program library, or create their own commands by combining different program commands and variables. The program will aid the users by giving them the option to resue commands from a history panel instead of having to define them agin through out the program life.


To make the program flexible, we use the Model-Controller-Interface. We separate the GUI from the backend logic where all the computation is done. The controller accepts the input from the user and parses it into the attributes and rules that are going to be used by the model or the interface. The model manages the data, logic and rules of the program. The Interface component contains the user interface, the grid, and the output. It is also where the user specifies the rules and attributes to the program either by uploading fillies or by selecting them from options on the GUI.

We also ensure flexibility of the program by making classes express behavior to the user but in reality they delegate the implementation of methods to other classes.

###Overview

####Description of the four APIs are 

External frontend API:  this interface is used to make the program easy to extend in the future. The main purpose of this API is to make the GUI modifiable without affecting the internal states of the program. The methods stored in this API have the ability to display, and render changes to the user. The methods stored in this interface have this following general functionality: creating the GUI the first time the user opens the program, showing all the buttons and text boxes to the user, showing the menu to the user, showing the history of different commands used, showing error messages to the user, displaying the console to the user, and sending string typed by the user to the controller.  The methods in this API are also responsible for showing the result of different commands applied to the turtle object(s), and whether or not a trail is shown.  Background rendering is also set in this interface. There will also be methods in API that send notifications to the model to create and reset the different object shown on the screen at any time.  Similarly there will be methods that notify the controller to reset the console. 

Classes:

-background.java

-menu.java

-rightSidePanel.java

-console.java

-buttons.java

External backend API: This interface provides the ability to extend the model in the future without having to change, or inadvertently break the view. The methods in this API specialize in changing states of different data structures. The methods in this interface will be responsible for getting the error messages but not doing input validation themselves. There will also be methods to get commands. Those methods do not return all possible commands; instead commands are packaged into Math, Boolean, Turtle, and User Defined commands. There will also be methods in this API for the turtle object. Instead of returning every possible method pertaining to the turtle object, this API will have the ability to get a copy of the turtle object definition to increase flexibility, and eliminate the need to pass different parameters for different methods that all depend on the turtle object. 

Furthermore, the methods in this interface will be responsible for sending back results of commands, strings parsed, errors, and turtle states back to the controller to be sent to the view. This API includes methods responsible for parsing user input, and validating it. Exception handling is processed in this API. Exceptions are processed in the controller, but the error messages are saved in the model to separate date from the program logic. 

Classes:

- Object.java- superclass for turtle and turtle like objects

- Turtle.java- holds all turtle information and turtle modification commands

- Command.java- super class responsible for abstract commands

- TurtleQuery.java: class that holds all methods responsible for setting and getting the turtle object and its attributes.

- MathOperations.java: super class for all math command and results

- BooleanCommand.java: super class for all Boolean command and results

- ParserException.java- takes care of parser errors and modifies the model to add an error message

- Command Exception.java- errors in the command, modifies the model to add an error message

Internal frontend API: This interface is not going to be used by future programmer; it functions mainly to facilitate communication from the view to the model. This interface ensures communication from the view to the model without jeopardizing the security of the view.  Methods in this API will request updated through the controller to the model about any changes to display on the UI. The methods in this API will not show how different buttons, menus, or the console work though. The methods in this interface will be responsible for setting the asking the model for a list of methods previously called by the user to display in the history section of the GUI. This API is also responsible for checking with the model if any of the turtle object attributes has changed. 

Classes:

-view/model.java

Internal backend API: this interface is responsible for facilitating the communication from the model to the view. The methods in this API do not directly modify any methods or attributes in the GUI; they send notifications that something has changed in the model.   Methods in this interface notify the GUI when specific turtle's attribute has changed, when a command returns a value, and when an error has occurred due to invalid input. This API will not reveal to GUI the turtle object, how the commands do their calculations, or how the parser and the controller detect input error though. 

Classes:

-controller.java


![This is cool, too bad you can't see it](slogo-crc.jpg "Main Screen")


###User Interface
Our user interface will be composed of several parts: a console for the user to enter commands, a prompt that displays error messages when the user inputs bad data, a Turtle Scene that displays the movements of the turtle, an area to set turtle properties, a menu panel to save and open SLogo files and create new SLogo files, an area displaying history of commands executed, and an area for displaying available variables and commands. The latter two components will be interactive, clickable text areas to easily input into the console. Below is a model of how we will design our user interface:

![This is cool, too bad you can't see it](SlogoUI.JPG "Main Screen")


## Design Details##

**Backend Overview**

We plan to have four main APIs for the back end, A model external API, model internal API, command internal API and a command external API. These APIs represent the two major sections of the back end: the controller and the model. The hub will call the Command API external and use that information to call the valid model API command. The event handler in the GUI will track when modifications have been made via the Model API and update the GUI when that occurs. 

 - Model API: The main purpose of the model APIs is to allow the view and the controller to access and modify the simulation data respectively. We’re unsure what internal commands the model API will need at this point but will leave its existence intact due to future extensions. 
 - External Command API: allow the other classes to access the parsed command and return the updated model object. 
 - Internal Command API: Conducts parsing and internal logic of the Slogo language. 

There are a few major design points necessary for this portion of the project to be successful. 

1.	There needs to be a good way to add new commands, turtle functions and data modifications. We want to use a strategy design pattern or a reflection design pattern to map strings to commands and map commands to functionalities 

2.	There needs to be a flexible way of accounting for extensions in the number of objects being modified. In the data object, instead of having one instance of turtle we will have an array list of objects that can hold the ids of many things. 

3.	There needs to be a good way of storing variables and referencing variables via commands. There will probably be an arraylist of variables inside the controller class as well as necessary inputs for each of the command classes. 


**Classes**

 - Controller.java: responsible for holding the instance of the parser class and conducting logic
	 - controller.parse()- modifies all the info
	 - getModel() - passes the model class to hub
 - Parser.java: responsible for parsing commands. Will return, lines of slogo code
	 - parseSpaces()- parses using regex and puts it into an array
	 - getNextLine()- returns the next line of the array
	 - getLine(int)- returns the index in the array
 - Command.java- super class responsible for abstract commands
	 - doCommand()- does the actual modification of the model class
	 - sub methods- called by changeModel()
 - Turtle Commands- return a turtle modification
	 - doCommand()- changes the turtle and returns it
 - Turtle Query Command- return an integer about turtle status
	 - changeModel()- returns a turtle status
 - Math Operation Command- return the result
 - Boolean Command- returns a Boolean
 - Display command- returns a display modification
 - Object.java- superclass for turtle and turtle like objects 
 - Turtle.java- holds all turtle information and turtle modification commands
	 - setX()
	 - setY()
	 - getX()
	 - getY()
	 - setOrientation()
	 - getOrientation()
	 - showTurtle()
	 - hideTurtle()
	 - setPenColor()
	 - getShape()
	 - stamp()
 - Model.java- holds turtle information, movement points etc… At this point we believe that the model.java will hold an arraylist of objects, a path data point set and an error Boolean and message. This should give us enough flexibility to modify all future extensions and objects. All classes inside model will have setters and getters like the turtle example above 
	 - setPenSize()
	 - setPen()
	 - getPen()
 - ParserException.java- takes care of parser errors and modifies the model to add an error message
 - Command Exception.java- errors in the command, modifies the model to add an error message

**Front End Overview**
We plan to have two APIs for the front end: internal front end and external front end APIs. Obviously, these follow the norms of referring to API for interaction among classes within the GUI package (internal) and for interaction between the GUI package and the controller and model segments of our program (external). The external API for the GUI is mostly concerned with retrieving, saving, or resetting the information held in model. The one exception to this is the interaction between the GUI and the controller when the "Run" button is hit, sending code from the console to be parsed (this connection is also needed for exception catching). The internal API for the GUI is concerned with displaying updated information in a manner that is readable and accessible. To discuss more concretely the APIs and their association with assignment specifications, look at the list of front-end classes with descriptions below:

**Classes**
- background.java - The canvas upon which the turtle and its drawings lie. This class will be responsible for communicating with the backend by obtaining the turtle object saved in the model (getTurtle() method), drawing the trail which is stored in model (.drawTrail()), and setting the background for a new or saved turtle (setBackgroundForTurtle()). This class does not need to communicate with the rest of the classes in the front end
- menu.java - The toolbar containing useful functions like New Slogo, Save Slogo, Open Slogo, and Quit. Save Slogo, Open Slogo, and New Slogo will all need to communicate with the backend to a degree by setting, resetting, or retrieving the state of the model for their respective purpose. Corresponding functions would be newSlogo(), openSlogo(), and saveSlogo(). Once again, this class has no real internal API, since it relays all information to the model, which the front end will subsequently retrieve. 
- rightSidePanel.java - The section of the GUI where history, saved user-defined functions, and variables are displayed to the user. External API is not needed for this class, since it is directly connected to the console and the run button. It does not need to go to the model to retrieve its data since it can contain merely the text of whatever is required. This class does need internal API since it communicates so much with the Console. Functions like setHistory(), setConsole(), setVariable(), getVariable(), setFunction(), getFunction() would be good to use in conjunction with the console. 
- console.java - The section of the GUI wherein the user types commands, functions, variables, and mathematicals to affect the turtle. This class would have an external API based on the fact that it needs to relay text to the controller. A function getConsoleText() should work when the run button is pressed to return the input text to the controller. As well, console.java should have an internal API to interact with the run and clear buttons, as well as the rightSideMenuPanel.java class. Functions like setConsoleFromHistory(), clearConsole(), and an event handling function should deal with these relationships accordingly. 
- buttons.java - A superclass or interface that deals with creating and adding functionality to the run and clear buttons. These buttons do not need an external API, but do require an internal API to deal mainly with the console, functions for which have mostly been named above. 

## Example Code ##

THIS EXAMPLE STARTS RIGHT AFTER THE HUB HAS PASSED THE INFORMATION TO THE CONTROLLER.

The Hub holds an instance of the model class as well as the controller class. The controller class has initialized an instance of the parser class. The hub runs controller.setInput() to set the input. The hub runs controller.parse(). The Controller.parse() will then run the following sequence of code:

1.	calls the internal parse class parse command, which returns the necessary information in this case fd 50 via a list. 
2.	The controller then runs some internal mapping method to map the string to a command
3.	The controller will initialize the command with the necessary input variables, in this case new moveCommand(50). 
4.	The command object will then call “make changes”. Which will modify the model.java instance in controller. 
5.	The model.java in this situation would access its internal turtle list and make the new coordinate change of the turtle.
6.	Because the pen Boolean is false, no points will be added to the path variable in model.java
7.	The command object will then return the model instance. 
8.	The controller will then return the model instance to hub.
9.	The event caller in the GUI sensing a change will grab the new instance of the model inside hub 
10.	If there is an error at any point a modification will be made to the error Boolean inside the model to true as well as an error message string. This will prompt the GUI to open up a dialog box with the error message. 

In this example you can see that the only two commands that the HUB will ever call is controller.setInput and controller.Parse. This should represent the external API. All the internal API commands are what the Contorller.parse() command are calling. As for information passing, there will be an instance of the model.java class that will be passed from the controller to the HUB to be used by the GUI.

###Design Considerations
One of our main design considerations includes communication between the front-end view and the back-end model. Ultimately, we decided that our Parser would act as part of our controller, since this is what we would need to parse commands in the console and translate into information for the Turtle movement and positions in the back-end. Then, we also considered how we would pass back information back from the model to the controller and then to update the view/GUI. We will have a separate class as part of the Controller package to handle this. Thus, when a user enters a command into the console, the controller package containing the Parser will parse the command, and instantiate a Command object. The Command instantiates a specific Model which will contain information of either Turtle commands or Math commands. The Model will return a value that will either modify the TurtleScene object in the GUI or the Prompt object in the GUI.

We will also need to consider how we will design the back-end to execute user-inputted commands. We decided to include the abstract Commands class inside our controller package which will then be passed on to the turtle in the model. For user-created commands, we will have a separate object for this that will store a map of the user-created commacnd to the Command object. 

For the front end, a perplexing design consideration is that of making the turtle just "jump" from point to point just leaving a trail if required to, or to make it actually move/slide across the screen leaving a trail. This consideration could not only change the structure of a few of our front end classes, but also of our main class. 

###Team Responsibilities
Karen and Alex will work on the user interface and view APIs, while Sally and Kevin will work with the model APIs and parser classes.
