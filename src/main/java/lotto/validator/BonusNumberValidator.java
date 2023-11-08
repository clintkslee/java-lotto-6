package lotto.validator;

public class BonusNumberValidator {
    public static boolean validate(String bonusNum) {
        if(isNumber(bonusNum));
        if(isValidNumber(bonusNum));
        return true;
    }

    private static boolean isNumber(String bonusNum) {
        try {
            Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
    private static boolean isValidNumber(String bonusNum) {
        if(Integer.parseInt(bonusNum)<0 || 56<Integer.parseInt(bonusNum)) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}
