public class Worker extends Match {
    protected double managmentMargin;
    protected int managmentIdOfMatch;

    public void setMargin() {
        chooseMath(managmentIdOfMatch).margin = managmentMargin;
        RecalculationOfCoefficients(managmentIdOfMatch);
    }
    public void createMatch(Participant first, Participant second, int matchId) {
        matchList.add(new Match(first, second, matchId));
    }
    public void changeMargin(double margin, int matchID) {
        chooseMath(matchID).margin = margin;
        RecalculationOfCoefficients(matchID);
    }
    public void showCoefficients(int matchID) {
        System.out.println("Коэффициент для матча " + matchID + " на первого участника: " + chooseMath(2).firstParticipant.getCoefficient());
        System.out.println("Коэффициент для матча " + matchID + " на второго участника: " + chooseMath(2).secondParticipant.getCoefficient());
    }

    public void RegClient(Clients client) {
        ClientsList.add(client);
    }

}
