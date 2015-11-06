package command;

import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import model.data.BackgroundData;
import model.data.Data;
import model.data.TurtleData;

public class CommandFactory {
	private TurtleData turtleData;
	private BackgroundData bgData;
	private Data allData;
	private Map<String, Class<?>> reflectionMap = new HashMap<String, Class<?>>();
	private Map<String, String> reflectionMapString = new HashMap<String, String>();
	private final String CLASS_PROPERTIES = "resources/class";
	private final String ERROR_RESOURCES = "resources/error";
	private ResourceBundle resource;
	private ResourceBundle errorResources;

	public CommandFactory(Data data) {
		turtleData = data.getturtleData();
		allData = data;
		bgData = data.getBackgroundData();

		resource = ResourceBundle.getBundle(CLASS_PROPERTIES);
		errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);
		Enumeration<String> tempList = resource.getKeys();
		while (tempList.hasMoreElements()) {
			String tempString = tempList.nextElement();
			this.registerCommand(tempString, resource.getString(tempString));
		}
	}

	public void registerCommand(String commandName, Class<?> commandClass) {
		reflectionMap.put(commandName, commandClass);
	}

	public void registerCommand(String commandName, String commandClass) {
		reflectionMapString.put(commandName, commandClass);
	}

	public Command createCommand(String commandName) {
		Class<?> commandClass = createClass(commandName);

		Constructor<?> commandConstructor = createConstructor(commandClass);

		return createClassInstance(commandClass, commandConstructor);
	}

	private Class<?> createClass(String commandName) {
		Class<?> commandClass = null;
		try {

			commandClass = Class.forName(reflectionMapString.get(commandName));
		} catch (ClassNotFoundException e1) {
			// turtleData.setErrorMessage("notFound");
		}
		return commandClass;
	}

	private Constructor<?> createConstructor(Class<?> commandClass) {
		Constructor<?> commandConstructor = null;
		try {// based on name grab constructor

			commandConstructor = commandClass.getDeclaredConstructors()[0];

		} catch (Exception e) {
			allData.getErrorData().setErrorMessage("notFound");
		}
		return commandConstructor;
	}

	private Command createClassInstance(Class<?> commandClass, Constructor<?> commandConstructor) {
		Command command = null;
		try {// creating the instance

			if (commandClass.getPackage().getName().contains("turtle")) {
				Object[] o = new Object[1];
				o[0] = turtleData;
				command = (Command) commandConstructor.newInstance(o);
			}

			else if (checkCommandType(commandClass, "display")) {
				Object[] o = new Object[1];
				o[0] = bgData;

				command = (Command) commandConstructor.newInstance(o);

			} else if (checkCommandType(commandClass, "otherCommands")) {
				Object[] o = new Object[1];
				o[0] = allData.getCommandData();
				command = (Command) commandConstructor.newInstance(o);
			} else {
				command = (Command) commandConstructor.newInstance(new Object[] {});
			}
			addObservers(command);
		}

		catch (Exception e) {
			allData.getErrorData().setErrorMessage("notFound");

		}
		return command;
	}

	private boolean checkCommandType(Class<?> commandClass, String name) {
		return (commandClass.getPackage().getName().contains(name))
				|| (commandClass.getSuperclass().getPackage().getName().contains(name));
	}

	private void addObservers(Command command) {
		if (command.getClass().getPackage().getName().contains("display")) {
			if (command.getClass().getPackage().getName().contains("turtleDisplay")) {
				command.addObserver(allData.getturtleData().getTurtleDisplayObserver());
			} else {
				command.addObserver(allData.getBackgroundData().getDisplayCommandsObserver());
			}
		} else if (command.getClass().getPackage().getName().contains("turtle")) {
			command.addObserver(allData.getturtleData().getTurtleCommandsObserver());
		}

	}
}
