package controller;

import error.ErrorResources;


public abstract class ControlFunctions {
    protected ErrorResources error;

    public ControlFunctions () {
        error = new ErrorResources();
    }

}
