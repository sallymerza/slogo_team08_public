package error;

import java.util.ResourceBundle;


public class ErrorResources {
    private final String ERROR_RESOURCES = "resources/error";
    private ResourceBundle errorResources;

    public ErrorResources () {
        setErrorResources(ResourceBundle.getBundle(ERROR_RESOURCES));
    }

    public ResourceBundle getErrorResources () {
        return errorResources;
    }

    public void setErrorResources (ResourceBundle errorResources) {
        this.errorResources = errorResources;
    }
}
