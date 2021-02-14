package nikos.terminal.calculator.ui.main;

import androidx.lifecycle.ViewModel;

import static java.lang.Double.parseDouble;

public class MainViewModel extends ViewModel {
    private double result = 0;
    private String userInputTop;
    private String userInputBottom;

    public void setUserInputTop(String inputTop){
        this.userInputTop = inputTop;
    }

    public void setUserInputBottom(String inputBottom){
        this.userInputBottom = inputBottom;
    }

    public double addition() {
       result =  parseDouble(userInputTop) + parseDouble(userInputBottom);
       return result;
    }

    public double subtraction() {
        result =  parseDouble(userInputTop) - parseDouble(userInputBottom);
        return result;
    }

    public double multiply() {
        result =  parseDouble(userInputTop) * parseDouble(userInputBottom);
        return result;
    }

    public double division() {
        result = parseDouble(userInputTop)/ parseDouble(userInputBottom);
        return result;
    }

    public double percent() {
        result = parseDouble(userInputTop)/ parseDouble(userInputBottom);
        result = result * 100;
        return result;
    }

    public double squareRoot() {
        result = Math.sqrt(parseDouble(userInputTop));
        return result;
    }

}