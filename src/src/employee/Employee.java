package employee;

public class Employee {
	// 필드 선언
	protected int id;
	protected String name;
	protected DepartmentEnum department;

	public Employee(int id, String name, DepartmentEnum department) {
	// 코드 작성
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public void print(){

	}

	public void print(StringBuilder builder) {
		builder.append("================\n")
				.append("id: ").append(this.id).append("\n")
				.append("name: ").append(this.name).append("\n")
				.append("department: ").append(this.department.getMessage()).append("\n");
	}

	public String toFileString() {
		return id + "," + name + "," + department.name();
	}

	public static Employee fromFileString(String fileString) {
		String[] parts = fileString.split(",");
		if (parts.length >= 3) {
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			DepartmentEnum department = DepartmentEnum.valueOf(parts[2]);
			if (parts.length == 5) {
				PositionEnum position = PositionEnum.valueOf(parts[3]);
				int grade = Integer.parseInt(parts[4]);
				return new FullTimeEmp(id, name, department, position, grade);
			} else if (parts.length == 4) {
				int hours = Integer.parseInt(parts[3]);
				return new PartTimeEmp(id, name, department, hours);
			}
		}
		return null;
	}

	// setters 및 getters 정의

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentEnum getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}
}
