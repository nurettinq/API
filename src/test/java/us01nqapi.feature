Feature: US_002 Kayit olmak icin email and username bilgileri girilebilmelidir.


 @ApiUs01
  Scenario: T_012 Swagger dökümanı kullanarak tüm kayıt bilgileri doğrulanmalı.
    Given nq Medunna
    When  nq send Get request
    Then  nq Status code is 200
    And   nq Verifies that valid username is also api
    And   nq Verifies that valid firstname is also api
    And   nq Verifies that valid lastname is also api
    And   nq Verifies that valid email is also api
  @ApiUs01P
   Scenario: TC_013 API kullanarak kayıtlı kişiler oluşturulup ve doğrulayabilmeli
     Given nq Medunna
     When nq send post request by entering "firstname" ,"lastname", "email", "login", "ssn"
     Then  nq Status code is 200
     And   nq Verifies the entered "firstame" ,"lastname", "email", "login", "ssn"
