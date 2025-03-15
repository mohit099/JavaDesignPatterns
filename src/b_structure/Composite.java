package b_structure;


import java.util.ArrayList;
import java.util.List;

// Component - Common interface for both individual and composite elements
interface Employee {
    void showDetails();
}

// Leaf - Represents individual objects
class Developer implements Employee {

    String name;
    String designation;

    Developer(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + designation);
    }
}

// Composite - Represents a group of Employees (Manager with subordinates)
class Manager implements Employee {
    String name;
    String designation;
    List<Employee> team = new ArrayList<>();

    Manager(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    void addTeamMember(Employee emp) {
        team.add(emp);
    }

    void removeMember(Employee employee) {
        team.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + designation);
        for (Employee e : team) {
            System.out.print("     ");
            e.showDetails();
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        // Leaf objects
        Employee d1 = new Developer("Alice", "Consultatnt Developer");
        Employee d2 = new Developer("Bob", "Senior Consultatnt Developer");

        // Composite object
        Manager m1 = new Manager("Mantis", "Aisstant Manager");
        m1.addTeamMember(d1);
        m1.addTeamMember(d2);
        m1.showDetails();

        System.out.println();

        // Higher-level Composite
        Manager departmentHead = new Manager("David", "Tech Head");
        departmentHead.addTeamMember(m1);
        departmentHead.showDetails();

    }
}
