package command.otherCommands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import command.Command;
import command.CommandInterface;
import controller.ParseTreeChildren;
import controller.ParseTreeNode;
import controller.Traverser;
import model.data.CommandData;


public class UserCommand extends Command {

  private static final long serialVersionUID = -8672243465517450294L;
  private ResourceBundle errorResources;
  private final String ERROR_RESOURCES = "resources/error";
  private CommandData allData;
  Traverser traverser = new Traverser();
  Map<String, Double> localMap;
  Map<String, Double> tempMap;

  public UserCommand(CommandData allData) {
    super(allData);
    this.allData = allData;
    errorResources = ResourceBundle.getBundle(ERROR_RESOURCES);
  }

  @Override
  public double execute(ParseTreeChildren distance) {
    double ans = 0;
    if (allData.getUserCommandMap().containsKey(getName()) && !distance.getParent().getParent()
        .getCommand().getClass().getSimpleName().equals("MakeUserInstruction")) {
      List<ParseTreeNode<CommandInterface>> temp =
          allData.getUserCommandMap().get(getName());
      List<String> tempString = allData.getMyCommandVariableMap().get(getName());
      localMap = new HashMap<String, Double>(allData.getVariableMap());
      tempMap = allData.getVariableMap();
      for (int i = 0; i < distance.getNodeList().size(); i++) {

        localMap.put(tempString.get(i), distance.getCommandValue(i, 0));
      }
      allData.setVariableMap(localMap);
      ans = traverser.traverse(temp, allData);
      allData.setVariableMap(tempMap);
    } else if (!distance.getParent().getParent()
        .getCommand().getClass().getSimpleName().equals("MakeUserInstruction")) {
   //   allData.setErrorMessage(getName()+": " +errorResources.getString("notFound"));
    }

    return ans;
  }

}
