package employee;

public class PartTimeEmp extends Employee {
    // 필드 선언
    private int hours;

    public PartTimeEmp() {
        // 코드 작성
        super(0, (String)null, (DepartmentEnum)null);
        this.hours = 0;
    }

    public PartTimeEmp(int id, String name, DepartmentEnum department, int hours) {
        // 코드 작성
        super(id, name, department);
        this.hours = hours;
    }

    public void print(){
        super.print();
    }

    @Override
    public void print(StringBuilder builder) {
        super.print(builder);
        builder.append("hours: ").append(this.hours).append("\n");
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + hours;
    }

    // setters 및 getters 정의

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
