package menus;

public enum UpdateMenuEnum {
    UPDATE_BY_ID(31, "정보 갱신 (by id)"),
    UPDATE_CANCEL(39,"돌아가기");

    int code;
    String message;

    UpdateMenuEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
