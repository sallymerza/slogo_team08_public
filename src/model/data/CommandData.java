
package model.data;
//This entire file is part of my masterpiece.
//Sally Al
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.CommandInterface;
import controller.ParseTreeNode;

/**
 *
 * @author Sally Al
 *
 */
public class CommandData {
	private Map<String, Double> myVariableMap;
	private Map<String, List<ParseTreeNode<CommandInterface>>> myUserCommandMap;
	private double myCommandValue;
	private Map<String, List<String>> myCommandVariableMap;
	private Map<String, Double> myUserCommandInputMap;

	protected CommandData() {
		myVariableMap = new HashMap<String, Double>();
		setVariableMap(new HashMap<String, Double>());
		setUserCommandMap(new HashMap<String, List<ParseTreeNode<CommandInterface>>>());
		myUserCommandMap = new HashMap<String, List<ParseTreeNode<CommandInterface>>>();
		setMyCommandVariableMap(new HashMap<String, List<String>>());
		setMyUserCommandInputMap(new HashMap<String, Double>());

	}

	public void setVariableMap(Map<String, Double> variableMap) {
		myVariableMap = variableMap;
	}

	public void updateVariableMap(String varName, Double value) {
		myVariableMap.put(varName, value);
	}

	public void setUserCommandMap(Map<String, List<ParseTreeNode<CommandInterface>>> userCommandMap) {
		myUserCommandMap = userCommandMap;

	}

	public Map<String, Double> getVariableMap() {
		return myVariableMap;
	}

	public Map<String, List<ParseTreeNode<CommandInterface>>> getUserCommandMap() {
		return myUserCommandMap;
	}

	public double getCommandValue() {
		return myCommandValue;
	}

	public void setCommandValue(double commandValue) {
		myCommandValue = commandValue;
	}

	public Map<String, List<String>> getMyCommandVariableMap() {
		return myCommandVariableMap;
	}

	public void setMyCommandVariableMap(Map<String, List<String>> myCommandVariableMap) {
		this.myCommandVariableMap = myCommandVariableMap;
	}

	public Map<String, Double> getMyUserCommandInputMap() {
		return myUserCommandInputMap;
	}

	public void setMyUserCommandInputMap(Map<String, Double> myUserCommandInputMap) {
		this.myUserCommandInputMap = myUserCommandInputMap;
	}

}
