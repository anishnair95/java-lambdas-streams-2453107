package com.example;

import com.example.function.TriFunction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

class EmployeeTest {

  private EmployeeUtils employeeUtils = new EmployeeUtils();

  @Test
  void employeeFullName() {
    Employee employee = new Employee();
    employee.setFirstName("Jerome");
    employee.setLastName("Donaldson");

    String actual = employeeUtils.getFullName(employee);

    assertThat(actual).isEqualTo("Jerome Donaldson");
  }

  @Test
  void employeeManagersLastName() {
    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
    employee2.setLastName("Westbay");
    employee1.setManager(employee2);

    String actual = employeeUtils.getManagersLastName(employee1);

    assertThat(actual).isEqualTo("Westbay");
  }

  @Test
  void employeeInEmploymentLongerThanFiveYears() {
    Employee employee = new Employee();
    employee.setYearsOfService(20);

    Boolean actual = employeeUtils.hasBeenEmployedLongerThanFiveYears(employee);

    assertThat(actual).isTrue();
  }

  @Test
  void employeeHasMoreThanThreeDirectReports() {
    Employee employee = new Employee();
    employee.setNumberOfDirectReports(5);

    Boolean actual = employeeUtils.hasMoreThanThreeDirectReports(employee);

    assertThat(actual).isTrue();
  }

  @Test
  void employeeHasMoreThanThreeYearsOfServiceAndLessThanTwoDirectReports() {
    Employee employee = new Employee();
    employee.setYearsOfService(5);
    employee.setNumberOfDirectReports(1);

    Boolean actual = employeeUtils.hasMoreThanThreeYearsOfServiceAndLessThanTwoDirectReports(employee);

    assertThat(actual).isTrue();
  }

  class CustomerCode {
    private String id;
    private String name;
    private String secretcode;

    public CustomerCode(String id, String name, String secretcode) {
      this.id = id;
      this.name = name;
      this.secretcode = secretcode;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getSecretcode() {
      return secretcode;
    }

    public void setSecretcode(String secretcode) {
      this.secretcode = secretcode;
    }

    @Override
    public String toString() {
      return "CustomerCode{" +
              "id='" + id + '\'' +
              ", name='" + name + '\'' +
              ", secretcode='" + secretcode + '\'' +
              '}';
    }
  }
  @Test
  void execute() {
    Function<String, CustomerCode> getCustomerCode = (String id) -> {
      String[] customerDetails = id.split(":");

      if (customerDetails[0].length() != 9) {
        throw new IllegalArgumentException("Invalid customer code");
      }
      return new CustomerCode(customerDetails[0], customerDetails[1], customerDetails[2]);
    };

    String testString = "123123123:Jordan:,mlaku2308jq30901";
    String testString2 = "890222023:Billy:,202auxaslk2308jq30901";
    String testString3 = "89222023:Billy:,202auxaslk2308jq30901";



    CustomerCode customerCode = getCustomerCode.apply(testString);
    CustomerCode customerCode2 = getCustomerCode.apply(testString2);
    CustomerCode customerCode3 = getCustomerCode.apply(testString3);

    System.out.println(customerCode);
    System.out.println(customerCode2);
    System.out.println(customerCode3);

  }

  @Test
  public void test() {
    IntStream.range(0,100).forEach(i -> {
      System.out.println(i);
    });
  }

  @Test
  public void testBiFunction() {
    Item item = new Item(10,5.5);
    Item item2 = new Item(100,9.5);
    BiFunction<Integer, Double, Double> discountedPriceCal = (totalPrice, discountPercent) ->
            (totalPrice * (100 - discountPercent)) / 100;
    System.out.println(discountedPriceCal.apply((int) (item.getQuantity() * item.getPrice()), 5D));
    System.out.println(discountedPriceCal.apply((int) (item2.getQuantity() * item2.getPrice()), 10D));
  }

  // trifunction
  @Test
  public void testTriFunction() {
    TriFunction<Double, Double, Double, Double> triFunction = (length, width, height) -> {
      double volume = (length * width * height) / 100;
      return volume;
    };
    System.out.println(triFunction.apply(10D, 20D, 30D));
  }

  // supplier
  @Test
  public void testSupplier() {
    Supplier<Developer> dev = () -> new Developer();
    Supplier<Developer> defaultDev= () -> new Developer("Roshan");
    // passing supplier - which could have any type of instance of developer
    Developer developer = factory(dev);
    Developer developer1 = factory(defaultDev);
    System.out.println(developer);
    System.out.println(developer1);
  }

  public Developer factory(Supplier<Developer> supplier) {

    Developer developer = supplier.get();

    if (developer.getName() == null || developer.getName().isEmpty()) {
      developer.setName("default");
    }

    developer.setSalary(new BigDecimal(0.0));
    developer.setStart(LocalDate.now());
    return developer;
  }
}
