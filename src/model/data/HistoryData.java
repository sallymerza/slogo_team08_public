
package model.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sally Al
 *
 */
public class HistoryData {
	private List<String> myUserHistory;

	public HistoryData(){
		myUserHistory = new ArrayList<String>();

	}

	public List<String> getUserHistory() {
		return myUserHistory;
	}

	public void setUserHistory(List<String> userHistory) {
		myUserHistory = userHistory;
	}

	public void addCommandToHistory(String s) {
		myUserHistory.add(s);
	}
}
