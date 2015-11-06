package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import command.CommandFactory;
import command.CommandInterface;
import command.CommandRegister;
import model.data.Data;
import model.data.ErrorData;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
	private CommandFactory cf;
	private ResourceBundle errorResources;
	private final String INPUT_RESOURCES = "resources/input";
	private final String ERROR_RESOURCES = "resources/error";
	private List<ParseTreeNode<CommandInterface>> nodeList;
	private Boolean error = false;

	private CommandRegister cr;

	private String myErrorMessage;
	private ResourceBundle resources;
	private Map<String, Integer> commandTimesMap;
	private Map<String, Double> commandInputMap;

	public Parser() {
		errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);
		pattern = new Patterner();

		numInputs();
	}

	private void commandRegistration(Data allData) {
		cf = new CommandFactory(allData);
		cr = new CommandRegister(cf);

		cr.register();

	}

	public List<ParseTreeNode<CommandInterface>> parse(String input, Data allData) {
		commandRegistration(allData);
		createCommandList(removeComments(input));
		nodeList = new ArrayList<ParseTreeNode<CommandInterface>>();
		commandInputMap = allData.getCommandData().getMyUserCommandInputMap();

		if (checkInput()) {
			this.createParseTree(allData.getErrorData());
		}

		for (ParseTreeNode<CommandInterface> p : nodeList) {
			 this.printTreeInOrder(p);
			 System.out.println("");

		}

		return nodeList;
	}

	private int createParseTree(ErrorData allData) {
		int index = 0;
		commandTimesMap = new HashMap<String, Integer>();
		while (index < commandList.size()) {
			ParseTreeNode<CommandInterface> newNode = createNewNode(index, null);
			index = createParseTree(index + 1, newNode, allData);
			nodeList.add(newNode);
		}

		return index;

	}

	private int createParseTree(int index, ParseTreeNode<CommandInterface> head, ErrorData allData) {
		if (head == null) {
			error = true;
			return index;

		}
		Double numInputs = getNumInputs(head, allData);

		if (numInputs == 0) {
			return index;
		}
		if (numInputs == -1) {
			error = true;
			return index;
		}
		for (int i = 0; i < numInputs; i++) {
			List<ParseTreeNode<CommandInterface>> tempNodeList = new ArrayList<ParseTreeNode<CommandInterface>>();
			if (index >= commandList.size()) {
				allData.setErrorMessage(head.getCommand().getClass().getSimpleName()+": " + errorResources.getString("noArgument"));
				error = true;
				return index;
			}
			if (commandList.get(index)[1].equals("ListStart")) {
				index = bracket(index, head, tempNodeList);
				while (true && index < commandList.size()) {
					if (!commandList.get(index)[1].equals("ListEnd")) {
						ParseTreeNode<CommandInterface> newNode = createNewNode(index, head);

						index = createParseTree(index + 1, newNode, allData);
						tempNodeList.add(newNode);
					} else {
						index = bracket(index, head, tempNodeList);

						break;
					}
				}
			} else {
				ParseTreeNode<CommandInterface> newNode = createNewNode(index, head);
				index = createParseTree(index + 1, newNode, allData);
				tempNodeList.add(newNode);
			}

			head.addChild(tempNodeList);
		}

		return index;
	}

	private int bracket(int index, ParseTreeNode<CommandInterface> head,
			List<ParseTreeNode<CommandInterface>> tempNodeList) {
		ParseTreeNode<CommandInterface> listStart = createNewNode(index, head);
		tempNodeList.add(listStart);
		index++;
		return index;
	}

	private ParseTreeNode<CommandInterface> createNewNode(int index, ParseTreeNode<CommandInterface> parent) {
		ParseTreeNode<CommandInterface> node = new ParseTreeNode<CommandInterface>(
				cf.createCommand(commandList.get(index)[1]));
		if (node.getCommand() == null) {

			return null;
		}

		if (checkMatch("Constant", node)) {
			setNodeValue(index, node);
		} else {
			// for debug
			node.getCommand().setValue(index);
			// node.getCommand().setValue(0);
		}

		if (checkMatch("Variable", node) || checkMatch("UserCommand", node)) {
			setNodeName(index, node);
		}
		if (checkMatch("UserCommand", node)) {
			for (int i = index; i < commandList.size(); i++) {
				if (commandList.get(i)[1].equals("ListEnd")
						&& commandList.get(index - 1)[1].equals("MakeUserInstruction")) {

					Double tempInputs = (double) ((i - index) - 2);
					commandInputMap.put(commandList.get(index)[0], tempInputs);
					commandTimesMap.put(commandList.get(index)[0], 1);
					break;
				}
			}
		}
		if (parent != null) {
			node.setParent(parent);
		}
		return node;

	}

	private void setNodeValue(int index, ParseTreeNode<CommandInterface> node) {
		node.getCommand().setValue(Double.parseDouble(commandList.get(index)[0]));
	}

	private void setNodeName(int index, ParseTreeNode<CommandInterface> node) {
		node.getCommand().setName(commandList.get(index)[0]);
	}

	private boolean checkMatch(String s, ParseTreeNode<CommandInterface> node) {

		return node.getCommand().getClass().getSimpleName().equals(s);

	}

	private Double getNumInputs(ParseTreeNode<CommandInterface> node, ErrorData allData) {
		Double numInputs = (double) Integer.parseInt(resources.getString(node.getCommand().getClass().getSimpleName()));
		if (node.getCommand() != null) {
			if (checkMatch("UserCommand", node)) {
				if (!commandTimesMap.containsKey(node.getCommand().getName())
						&& commandInputMap.containsKey(node.getCommand().getName())) {
					try {
						numInputs = commandInputMap.get(node.getCommand().getName());
					} catch (Exception e) {
						allData.setErrorMessage(node.getCommandName()+" " +errorResources.getString("notFound"));
					}
				} else {

					commandTimesMap.remove(node.getCommand().getName());
				}

			}
			return numInputs;
		} else {
			return -1.0;
		}
	}

	public void printCommandList() {
		for (String[] s : commandList) {
			System.out.println(s[0] + ", " + s[1]);
		}
	}

	public void printTreeInOrder(ParseTreeNode<CommandInterface> head) {
		if (head == null) {
			return;
		}

		for (List<ParseTreeNode<CommandInterface>> nodeList : head.getChildren().getNodeList()) {
			for (ParseTreeNode<CommandInterface> node : nodeList) {
				printTreeInOrder(node);
			}
		}

		System.out.println(head.getCommand().getClass().getSimpleName() + " " + head.getCommand().getValue() + "->"
				+ head.getParent().getCommand().getClass().getSimpleName() + " "
				+ head.getParent().getCommand().getValue());

	}

	private void numInputs() {
		resources = ResourceBundle.getBundle(INPUT_RESOURCES);
	}

	private void createCommandList(String input) {
		String[] example = splitInput(input);
		commandList = pattern.matchSplitCommand(example, pattern.getPatterns());
	}

	private String removeComments(String input) {

		String[] lines = input.split(System.getProperty("line.separator"));
		StringBuilder modifiedString = new StringBuilder();
		for (String s : lines) {
			if (!s.contains("#")) {
				modifiedString.append(s);
				modifiedString.append(System.getProperty("line.separator"));
			}
		}
		return modifiedString.toString();
	}

	public String[] splitInput(String input) {
		inputArray = input.split("\\p{Space}");
		return inputArray;
	}

	public List<String[]> getCommandList() {
		return commandList;
	}

	public Patterner getPattern() {
		return pattern;
	}

	public CommandFactory getCommandFactory() {
		return cf;
	}

	public boolean checkInput() {
		return !commandList.isEmpty();
	}

}
