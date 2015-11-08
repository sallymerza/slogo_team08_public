
CompSci 308: Game Analysis
===================


Project Journal
=======

###Time Review

Date Started: 10/05

Date Ended: 10/27

Hours:  about 220

After the initial planning meeting, I spent most of my time coding new features or re-factoring code. I also spend a good portion of my time designing the hierarchy for the classes I was responsible for, and made sure there is minimal dependency among them. At the begging we worked individually, but later on we started to meet and work together as a team even though we were working on independent tasks. It proved to be more efficient, and effective.

Adding exceptions to the project was the hardest task for me to do. it was hard to accomodate for different types of errors based on different commands. 

Teamwork

I think that the team worked well together. We all attended planning meetings and later we met frequently to discuss extensions and any changes to the design. We also used facebook to communicate when we were not meeting. We were responsive there too. I think that that we did a good job communicating and keep everyone up to date and included. Even though there were times when some of us we not on campus, the rest of the team briefed that person.  We spent about 1-2 hours on the initial meeting of the project. After that we had frequent 4-6 hours meetings when we worked together. We had an extensive meeting after the extensions were posted, and after I met with my TA when we discussed important design change in command dependencies. 

At the beggning i was the only person in the team who had codePro installed on my eclipse. I used to run it on the code and tell members of the team about what sections of the code that they need to re-factor. I repeated that several times, and by the end we were able on the back-end side to eliminate a lot of code duplicates. I made the same request to the front end-team but i did not enfore it. in the future, as something that i would like to improve upon as a teammember is actually make it clear during the intial team meeting that code duplicates are not acceptable. Even though i know that the code that i wrote wa about 97% duplicate free, i would make sure in the future it becomes a priority.



Team Responsibilities:

Karen was responsible for designing the user interface, which involved implementing the history, available user commands, property settings, the turtle scene, and the console. In order to implement observer and observable, she also had to create the model objects in the back-end, and the configuration of the ModelController to add the observer to the observable objects. Alex worked with both the MenuPanel (saving current workspaces), the buttons, and various front-end functionalities including pen properties and multiple turtles.

Kevin and I worked on the back-bend. Kevin worked on the parser and the command factory he also added some of the commands. I worked on creating the majority of commands. I created the turtle class. I added manager classes that communicate between commands output and the classes in the front-end and the back-end classes affected by them. I also refactored commandfactory.java to be able to create different constructors for diferent commands depending on their type by using a refferance to their package. I made this change after meeting with my TA and discussing changes that resulting in me refactring command.java to have multiple constructors and refactor data.java to have several interfaces that can be passed to different commands. Before this change we used to pass data as a method paramater to every commands regardless if a command needed it or not.

In the initial planning meeting we decided on the groups. Then we had small groups meetings when we decided on individual tasks. In the planning team, we created the CRC cards and we came up with different scenarios to validate the design. In this meaning, we also defined the role of the controller to identify how the front-end and the back-end communicate. Later on for testing we had for the back end a tester class that checked the parser tree, and the commands. 

We adhered to our roles and the plan throughout the project duration. However, Kevin and I sometimes worked on each other sections. 

###Commits


####Commit #1: turtle and display observers moved from data to their own classes

(https://github.com/duke-compsci308-fall2015/slogo_team08/commit/e16a95a8973d7aa60907156a0efc9d5cce792dab)

The main purpose of this command was to move turtle and display commands observer from the Data class to their own classes. The turtle and display "observer" classes that I added became like managers between commands and the classes that they affect. Before that, some commands modified the turtle directly. I realized from talking to my TA that this was a poor design decision. This was the main motivation of this commit. The other reason was that I realized that the Data class had became too big, and not all the other classes that access it need all the information stored there. However, in this commit I also added more commands that even though used the new manager classes, they were not directly related to the commit. I realize now that I should have split this commit into two or may be three commits to emphasize its real purpose. 

This commit did not create a merge conflict because it was a new feature. 

This feature became very useful later in making communication easier and clearer between the back-end and the front-end teams when I added the display commands. It was also the only way that ensured the commands send their output to front end without directly accessing any classes or objects.

###Commit #2: 
this is not one commit; it is a series a commits that i made to implement and improve a new feature. 
The new feature is adding the observer classes between the commadns and the turtle class and the front end. this feature was a response to the extensions. i did not want to modify the existing design so i decided to implement the observer pattren to facilitate communication. i prefer this pattren to using an mvc from model to view becuase it allows more flexibility.

in this initial commit (https://github.com/duke-compsci308-fall2015/slogo_team08/commit/e53bddf0d4d32519a50add29e7b487df4eae0182) i created the class and set a map that returns a double representing the command output. as the command message  and the comments inside the class suggest, All I needed from the front end team was the name of objects or variables that will need the output. 
I received feedback from one of my teammates telling me that they need more than one double value for some of the output, hence i decided to modify the map to return a list instead of one number. this is why i made the second commit: https://github.com/duke-compsci308-fall2015/slogo_team08/commit/d1c642f943e201f237c1638a919867cd05c3eebd.

I used enums to represent the commands to make communication clear witht he front-end and to avoid using strings

I made the third commit on my analysis branch ( https://github.com/duke-compsci308-fall2015/slogo_team08/commit/957e4a6e9ee1063e6fa9082f1a97efbc35ed7301 ). even though it does not appear on the master branch, I would like to elaberate on it. ). First I created an abstract class for observers and then i made two subclasses: one for display commands that affect the turtle (change pen color , size, shape etc) and one that changes the gui in general ( background, and palette).i refactored the update method into two methods one for assigning the values and one for actually updating the turtle. i did that mainly becuase i think that there is still a dependency in the trail.java class and hence the many dots to get a vaule. i did not create that class, but i still had to use it, so i had to do inline refactoring in my classes.

###Coomit #3: 

https://github.com/duke-compsci308-fall2015/slogo_team08/commit/c075c3e26598625c30f17357becf763188674884

I made this commit in analysis_sma45 branch. it is not found on the master class becuase it made it during the analysis period.

I know that i did not break anything in the commit. it is more of re-factoring. In this commit I created an enum class to populate the map in the observer class between turtle commands ( not turtle display commands) and its observer. 




###Conclusions
I did not underestimate this project. I knew from the beginning it was complex and required attention mostly to how the components communicated with each other. I believe that I contributed significantly to the project from adding new features, re-factoring, participating in creating the design, and helping my teammates when they needed me. 

Data.java required most editing because it was shared by front-end and back-end. I also had to change some of the parameters in commands as my teammate in the back-end sub-team modified some of his code.


To be a better designer, I will continue to make sure that classes have methods and fields that are directly related to their functionality, and avoid creating classes that do too much. I will in the future incorporate new patterns that I have never used before to learn about them and be able to compare and contrast and ultimately make better choices.

To be a better teammate, I will continue offering help to my teammates. I will also continue to inform them about my work progress.

•	If you could work on one part right now to improve any aspect of your project, what would it be: 

SlogoScenee, even though that I did not create that class. I think that it requires re-design. First of all I would consolidate it with controller because I think that it is basically is a poorly named controller. I would also re-factor it so that the front end does not have an instance of it. Kevin and I already designed the back-end so that it does not have an instance of slogo-scene of the controller. I proposed these changes in one of the meetings but my teammate on the front end group but my teammate on the front-end side preferred to keep it as is at that point of the project. 


Design Review
=======

###Status


From looking at the entire code I realize now that we followed coding conventions but we did not have a unified method. For example, I used this.variable name in constructors but other members of the team use myVariable instead. On the other hand we used descriptive names for variables and methods to avoid confusion.  We also incorporated global
The code in general is easy to read and classes do what's expected of them. As mentioned before I would change slogo-scene.java's name to a more representative one ( manager.java for example). I also named a couple of classes observers, but i think I should have named them differently . for example turtleCommandManager.java instead of turtlecommandobserver. 

Dependinces are easy to find because we made sure that Data.java is the class that has reference to other classes like turtle, trail, history, error etc. this proved to be helpful later when we added multiple scenes and multiple turtles because we only had to reference data.java instead of each one of these classes. We did not use any public variables. We encapsulated them within classes and used public or protected methods to get and set them. In other cases we used interface to provide access to a portion of the class. 

Are there implemented features that are particularly easy or hard to extend?
Commands are easy to extend on several levels. We used the factory pattern to create the commands since we do not know their types before running the application. This made it easy to create many commands, and user defined commands. We also used abstraction to create categories of commands based on the classes or objects with which they interact. 

###Classes:

####Parser.java

This class interests me because it is capable of parsing input for a variety of command types effectively. It delegates code when necessary to commandRegister and commandFactory but its main functionality is still clear and easy to follow. It does not give away to other classes that it creates a nested list but it passes then an encapsulated object.
I would suggest to break a couple of long methods into several smaller ones. These createNewNode(), and createParseTree() have many if-statements I would suggest considering several check methods especially since there is some overlap between the two methods and other methods in the class.

To incorporate this class into another project it would be useful to remove hardcoded strings in many places throughout the code. The current design requires the input to be between brackets and is parsed by space. It will be useful to generalize these requirements to make it possible to parse based on other conditions.

####Class #2: Abstract Button.java and its subclasses (clearhistory, run).java

What interested me the most about this class is the high level of dependency RunButton() and ClearHistory() methods require. They require many parameters and these parameters in my opinion should not be accessed by a button.  Because these methods have so many dependencies, it will not be possible to incorporate this class in a different project that for example jut needs a simple button. I would suggest refactoring the abstract class in away that helps it delegate responsibilties to classes it currently take as paramaters instead of grabbing entire classes. 


###Design

My Code:

I worked mainly on implementing commands. I implemtned most of them except repeat, dotimes, if, makeuserinstructions.  I created a hierarchy that begins with an abstract command class with multiple constructors. Then I created a number of sub-classes that are also abstract classes. Each of these classes became the root for the hierarchy for a group of commands. With this abstraction I was able to categorize different commands based on their functionality and dependency. I added a third layer of abstraction to some of these command classes to further group them. At the leaf level, I had classes that carry the command name the user will input for convention. In the current design I have the data class divided into interfaces that correspond to the commands categories. I added in the factory class checks that assign a command constructor different interface of the data class depending on the command type. This meant that the commands will receive portions of the data class that they need. I resolved to this design after discussing dependencies with my TA. 

In the original design the traverser class used to pass the entire data class to every command during execution. I was aware that this was a poor design. I did not want to pass such an important and big class as data to every command. It also meant that commands became tied to this project. It was not possible before to generalize the command hierarchy in different design. 

In the current design, I make each command returns a value that will activate an observer or a manager class tied to the type of this class. Then the manager is linked to the corresponding component. I did not create in this design one controller from model to view, but I decided to use the idea of observer pattern to give the design more flexibility. It took some planning to group the commands based on what classes or objects they affect, but in the end I had three main observer classes the commands had to notify.

In the original design, I made the mistake of changing the turtle properties directly from the commands. I realized later from my discussion with my TA that this would have limited my design overall. 

I think that the current commands hierarchy design is close in the sense that adding new commands does not require modifying any of the currently existing commands. It does not depend of what type of object needs the output of a command. A new command can be added either by extending one of the existing abstract classes or by creating a new category with its own abstracts class and a leaf command class. Then the factory assigns the correct component of data it requires if any. Each command inherits an execute method from the Command.java abstract class. It must return a double number. If it affects another component then it should be added to respective observer in command factory. 

In the code the I designed for arithmetic and boolean commands. I passed default constructor to them with no parameters because they do not interact with any data components. My teammate added unlimited input component extension, and he made these commands extend a class called unlimitedInputDoubleComman. This class takes the entire data.java class as a constructor parameter. He did not discuss that change with me, and I did not realize that he made that change until after the due date. I still do not believe that these commands should have any access to the whole data class. 

#### note regarding ask and tell:

to make distinction to the two commands, and to make them as varstile as possilble we decided to make the tell [ n ] command return the range of turtles from 1 to n. 1example: tell [ 100 ] will create 99 turtles and return 100 active turtles.Hence fd 100 will move 100 turtles. tell is also capable of taking a list of input and return the range. example tell [ 1 2 5 ] will return 5 turtles

Ask on the other hand creates the range like tell but returns the turtle specified in the input. example: ask [ 100 ] [fd 50 ] will create 100 turtles if not already created but only turtle with id = 100 will move forward. 

Overall design of the complete program:

Front end:

* The front end contains the scene where the objects are displayed. It is composed of two methods that retain the active object(s) at any moments and the properties of the background, and the pen if it is used.  

* A drop down menu. One of its options is creating a new tab with its own id. We used multiple instances of Data.java for each tab to ensure that the states are preserved on any given tab. A user can also choose to save commands from the drop down menu. For saving the commands, and the sates we had make our classes realizable. 

* A console that takes the user's input and, sends it to the controller which in turn will send it to the parser. 

* A prompt class that displays command output. It is notified by the command via a number of observer classes.

* A history panel that saves the user input. We save history of commands before processing them. An instance of the history  class is saved in data to ensure that history applies to different tabs

* A user defined panel that shows any user defined variables or function.

* In addition to providing the user with the ability to change the GUI properties by commands, we added a feature that lets the user make these changes directly via the UI. These classes are completely saved in the back end, and they never communicate with the back end

Back-End: 

* Data class that stores an instance of the turtle class and all the turtle objects created throughout the life time of the program for each tab. The controller saves instances of the class. Any class in the front end that wishes to communicate with this class needs access through the controller.

* A parser that parse the user input into a tree. This class relies on a property file that  maps commands to the number of parameters they take, unless they are user defined commands. 

* A command factory that takes input from the parser and create the commands based on their type. This class has access to different data interfaces to assign relative data components to each command's constructor. Observers/Observable mapping is done in this class too.

* A traverser class that loops through user defined commands or regular and their parameters and send them to their perspective commands.

* Command hierarchy- discussed above.

* Observer classes that act as controllers between the back-end and the front end.  

* Error class that saves different error messages, and notifies the front-end 


Adding components:

* a new command - see above

* a new component to the front end : A new button: button extends buttonAbstract class. It inherits a run method. The location of the button should be provided in AllButtons class where an instance of the button should reside. Its constructor requires the following attributes: ConsoleUI console, ModelController controller, GUIManager guimanager, ResourceBundle resource, String buttonName. I think that passing all of these parameters limits the flexibility of the button. Adding this component is extensible in the sense that  I can add infinite number of buttons but it not truly is because I will need to pass all these parameters. 

* A feature not implemented: I would like to add an undo button. This button would undo the last command and its effect on the screen. To implement it I would modify history to have a stack. Or I would dedicate a class with three stacks to save the commands passed so far and the shapes dawn on the screen. The third one saves the third one will have the id of the last turtle affect and its previous location. This class would require access to data and history in particular. It would also require access to the list of turtles in a tab and their locations which is an inherited attribute of a turtle.




###Alternate Designs

The main design challenge from the back-end perspective was creating the commands and passing them just the right number and type of parameters. From discussions with my TA, we considered the decorator pattern as a way to allow a user to add new commands. The advantage of using this pattern would be to create a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact. If we had had implemented this pattern, we would have made the command an interface that wraps around command subclasses so that we can extend their functionality. My TA and I also discussed modifying the factory pattern that we had originally to be able to assign different constructors to different commands based on their requirements. After further discussion with my teammate we decided to modify the original factory pattern design. This design has the advantage of hiding how different commands are created. The current design means that we can assign different capabilities to commands during creation. Alternatively, we would have had to create commands and then decorate them with extra features later if we had used the decorator pattern. 

The second major design challenge that we faced was protecting data.java from being passed as a simple parameter, and only use it by commands that actually need it. This relates back to the first design decision we made. Modifying the design with command factory enabled us to assign data components as needed. It also enabled us to assign observer/observable binding between commands and the classes with which they need to send output.  

The program's ability to create any type of commands is its strongest feature on the back-end side for the reasons mentioned above. Having multiple tabs on the front end side is another strong feature. The back-end team did not make any modifications to accomodate this extended feature. which proves that the data class was closed. 

However, the main issue that reamians in the program is it inability to check for all errors. i was able to add some exceptions to the program for input validation, but i was not convinced that the design for this feature was optimal. We did not account for exceptions at an early phase of the design, so it became very difficualt to centerlize exception handling. i had to add exceptions inline in many cases and i am aware that this added dependencies to the program, it did not account for all types of errors that the program may encounter, and it made the design open not closed. This is something that will make sure takes proper planning in the next project. 


Code Masterpiece
================

Even after the major design modification in the factory and data, I still think that the data class is big and has too much functionality. It is true that the class was not pass around as a whole to all the commands anymore because I used interfaces to control what components I can pass, but this made me realize that all of these components should not be in one class in the first place. For my masterpiece, I decided to refactor data.java into 6 models: turtles, all turtles (this has the list of all turtles created and active ones), history, error, background, and command. I refactored all of these classes but I think command and turtle/all turtle are good representatives of this work. You will in the commit that I modified a 100 files but that was just to change method calling the new classes. I wanted to make sure that the project remains functional after I made these changes. You can pull analysis_sma45 and it will work as before. I did that also to make sure that other classes in the back and front end will remain close to this change.

I decided to instantiate all of them in the data class and use interfaces to link them because I wanted the new data class to still be able to support multiple tabs feature we had as an extension. If we did not have multiple tabs then I would remove data.java altogether and use the new classes as needed. 

