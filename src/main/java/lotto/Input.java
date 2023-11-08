package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.lottoMaker.Lotto;
import lotto.lottoMaker.LottoGenerator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurcahseAmountValidator;
import lotto.validator.WinningNumberValidator;

public class Input {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;

    public Input(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }

    public int startInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = inputPurchaseAmount();

        genLottos(purchaseAmount);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = inputWinningNum();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = inputBonusNum();
        int bonusNumber = Integer.parseInt(bonusNum);
        return bonusNumber;
    }

    private String inputPurchaseAmount() {
        String purchaseAmount;
        while (true) {
            try {
                purchaseAmount = Console.readLine();
                PurcahseAmountValidator.validate(purchaseAmount);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private void genLottos(String purchaseAmount) {
        int numOfTicket = Integer.parseInt(purchaseAmount) / 1000;
        System.out.println(numOfTicket + "개를 구매했습니다.");
        LottoGenerator.generate(lottoTicket, numOfTicket);
        LottoGenerator.printLottoTicket(lottoTicket);
        System.out.println();
    }

    private String inputWinningNum() {
        String winningNum;
        while (true) {
            try {
                winningNum = Console.readLine();
                WinningNumberValidator.validate(winningNum);
                splitWinningNumber(winningNum);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNum;
    }

    void splitWinningNumber(String winningNum) {
        String[] splitWinningNumber = winningNum.split(",");
        for (String num : splitWinningNumber) {
            winningNumber.add(Integer.parseInt(num));
        }
    }

    private String inputBonusNum() {
        String bonusNum;
        while (true) {
            try {
                bonusNum = Console.readLine();
                BonusNumberValidator.validate(bonusNum);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }
}
