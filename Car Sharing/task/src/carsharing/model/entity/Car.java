package carsharing.model.entity;public class Car {    private final int companyId;    private int id;    private String name;    public Car(int id, String name, int companyId) {        this.id = id;        this.name = name;        this.companyId = companyId;    }    public Car(String name, int companyId) {        this.name = name;        this.companyId = companyId;    }    public int getId() {        return id;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public int getCompanyId() {        return companyId;    }}