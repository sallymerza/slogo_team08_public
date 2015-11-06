package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import command.CommandInterface;
import controller.ParseTreeNode;
import controller.Parser;
import controller.Traverser;
import model.data.BackgroundData;
import model.data.CommandData;
import model.data.Data;
import model.data.ErrorData;
import model.data.TurtleData;
import model.data.interfaces.iError;

public class SlogoScene extends Observable {

	private List<Data> myDataList = new ArrayList<Data>();
	private Traverser myTraverser;
	private List<ParseTreeNode<CommandInterface>> myTree;
	private Parser myParser;
	private Data myAllData;

	public SlogoScene() {
		myAllData = new Data();
		myDataList.add(myAllData);
		myParser = new Parser();
		myTraverser = new Traverser();
	}

	/**
	 * Sets the Data object, passing information to Data from the front-end to
	 * the back-end.
	 */
	public void setData(int id, Data data) {
		myDataList.set(id, data);
		setChanged();
		notifyObservers();
	}



	public TurtleData getTurtleData(int id) {
		return myDataList.get(id).getturtleData();
	}
	public CommandData getCommandData(int id) {
		return myDataList.get(id).getCommandData();
	}

	public BackgroundData ColorData(int id) {
		return myDataList.get(id).getBackgroundData();
	}

	public ErrorData getErrorData(int id){
		return myDataList.get(id).getErrorData();
	}


	public List<Data> getAllData() {
		return myDataList;
	}

	public iError traverse(int id) {
		Data myCurrData = myDataList.get(id);

		if (!myTree.isEmpty()) {
			myTraverser.traverse(myTree, myCurrData.getCommandData());

		}

		setData(id, myCurrData);
		return myCurrData;
	}

	public void parse(String s, int id) {
		Data myCurrData = myDataList.get(id);
		myTree = myParser.parse(s, myCurrData);
	}

	public Parser getParser() {
		return myParser;
	}

	public Traverser getTraverser() {
		return myTraverser;
	}

}
