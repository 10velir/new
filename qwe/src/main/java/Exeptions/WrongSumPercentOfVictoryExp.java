package Exeptions;

public class WrongSumPercentOfVictoryExp extends Exception {
    public WrongSumPercentOfVictoryExp(String message) {
        super(message);
    }

    public WrongSumPercentOfVictoryExp(String message, Exception e) {
        super(message, e);
    }

    public WrongSumPercentOfVictoryExp(Exception e) {
        super(e);
    }

}
