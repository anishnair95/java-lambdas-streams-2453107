package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;
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
}
