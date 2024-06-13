package employee;

public enum PositionEnum {
	// 코드 작성
    DIRECTER(21, "이사"),
    GENERAL_MANAGER(22, "부장"),
    MANAGER(23, "과장"),
    ASSISTANT_MANAGER(24, "대리"),
    STAFF(25, "사원");

    int code;
    String message;

    PositionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
