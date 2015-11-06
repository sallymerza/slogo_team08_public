
package model.data;

/**
 *
 * @author Sally Al
 *
 */
public class ErrorData {

	private boolean myError;
	private String myErrorMessage;

	public boolean isError() {
		return myError;
	}

	public void setError(boolean error) {
		myError = error;
	}

	public String getErrorMessage() {
		String temp = myErrorMessage;
		myErrorMessage = null;
		return temp;
	}

	public void setErrorMessage(String errorMessage) {
		myErrorMessage = errorMessage;

	}
}
