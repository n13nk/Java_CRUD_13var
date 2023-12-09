package domain;

public class Program {
    private int id;
    private String department_name;
    private String product_name;
    private int price;
    private String hours_of_operation;

    public Program() {
    }

    public Program(String department_name, String product_name,String hours_of_operation ,int price ) {
        this.department_name = department_name;
        this.product_name = product_name;
        this.price = price;
        this.hours_of_operation = hours_of_operation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepatment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getHours_of_operation() {
        return hours_of_operation;
    }

    public void setHours_of_operation(String hours_of_operation) {
        this.hours_of_operation = hours_of_operation;
    }

    @Override
    public String toString() {
        return "\nПрограмма{" +
                "id=" + id +
                ",Название отдела='" + department_name + '\'' +
                ",Название товара='" + product_name + '\'' +
                ",Часы работы='" + hours_of_operation + '\'' +
                ",Цена='" + price + '\'' +
                "}";
    }
}

