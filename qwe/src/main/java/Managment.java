import Exeptions.WrongMarginExp;

public class Managment {

    public void chooseMargin(double marginM, int matchID, Worker worker) throws WrongMarginExp {
        if (marginM <= 0 & marginM > 20) {
            throw new WrongMarginExp("Margin must be <=0 & > 20");
        } else {
            worker.managmentMargin = marginM;       //Менеджер выбирает маржу для матча и передаёт её рабочему
            worker.managmentIdOfMatch = matchID;
        }
    }
}
