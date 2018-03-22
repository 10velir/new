public class Participant {
    private String nameOfTheTeam;
    private int participantId;
    private double coefficient;
    private boolean WinFlag = false;

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isWinFlag() {
        return WinFlag;
    }

    public void setWinFlag(boolean winFlag) {
        WinFlag = winFlag;
    }

    public Participant(String nameOfTheTeam, int participantId) {
        this.nameOfTheTeam = nameOfTheTeam;
        this.participantId = participantId;
    }
}
