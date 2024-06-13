package employee;

public class FullTimeEmp extends Employee {
	// 필드 선언
	private PositionEnum position;
	private int grade;
	
	public FullTimeEmp() {
		// 코드 작성
		super(-1, (String)null, (DepartmentEnum)null);
		this.position = PositionEnum.valueOf(null);
		this.grade = 0;
	}

	public FullTimeEmp(int id, String name, DepartmentEnum department, PositionEnum position, int grade) {
		// 코드 작성
		super(id, name, department);
		this.position = position;
		this.grade = grade;
	}

	public void print(){
		super.print();
	}

	@Override
	public void print(StringBuilder builder) {
		super.print(builder);
		builder.append("position: ").append(this.position.getMessage()).append("\n")
				.append("grade: ").append(this.grade).append("\n");
	}

	@Override
	public String toFileString() {
		return super.toFileString() + "," + position.name() + "," + grade;
	}

	// setters 및 getters 정의

	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
