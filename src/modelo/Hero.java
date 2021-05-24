
package modelo;


public class Hero {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String alias;
    private String group;
    private String state;

    public Hero() {
    }

    public Hero(int id, String name, String lastName, int age, String alias, String group, String state) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.alias = alias;
        this.group = group;
        this.state = state;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
