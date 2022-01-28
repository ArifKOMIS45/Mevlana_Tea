Feature: Product Payment Functionality

  Scenario: TC_0811
    Given Click on the Produkte button
    And Click on one of the products randomly which is in the stocks
    When Click on the PayPal button
    Then The user should be able to see PayPal login page

  Scenario: TC_0812
    Given Click on the Produkte button
    And Click on one of the products randomly which is in the stocks
    When Click on the In den Warenkorb button
    When Click on the PayPal button
    Then The user should be able to see PayPal login page

  Scenario Outline: TC_0813 --TC_0826
    Given Click on the Produkte button
    And Click on one of the products randomly which is in the stocks
    When Click on the In den Warenkorb button
    Then Click on the Weiter zur Kasse button
    And Fill the name "<Vorname>"
    And Fill the nachname "<Nachname>"
    And Fill the straße "<Street>"
    And Fill the postleitzahl "<Postleitzahl>"
    And Fill the Ort "<Ort>"
    And Fill the telefon  "<Telefon>"
    And Fill the email "<Email>"
    When Select <Transfer> as payment option
    When Select <Payment with> as payment "<Option>"
    And Select the <Terms and conditions>
    When Click on the "<the Kostenpflichtig Bestellen>"
    Then The user shoul be able to see the appropriate "<Message>"

    Examples:
      | Vorname | Nachname | Street        | Postleitzahl | Ort    | Telefon     | Email            | Transfer | Payment with | Option      | Terms and conditions | the Kostenpflichtig Bestellen | Message                                                                                                       |
      |         | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | true     | false        | false       | true                 | true                          | Vorname ist ein Pflichtfeld                                                                                   |
      | Arif    |          | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | true     | false        | false       | true                 | true                          | Nachname ist ein Pflichtfeld                                                                                  |
      | Arif    | Tester   |               | 34119        | Kassel | 05617397718 | tester@gmail.com | true     | false        | false       | true                 | true                          | Straße ist ein Pflichtfeld                                                                                    |
      | Arif    | Tester   | Thyssenstrabe |              | Kassel | 05617397718 | tester@gmail.com | true     | false        | false       | true                 | true                          | Postleitzahl ist ein Pflichtfeld                                                                              |
      | Arif    | Tester   | Thyssenstrabe | 34119        |        | 05617397718 | tester@gmail.com | true     | false        | false       | true                 | true                          | Ort / Stadt ist ein Pflichtfeld                                                                               |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel |             | tester@gmail.com | true     | false        | false       | true                 | true                          | Telefon ist ein Pflichtfeld                                                                                   |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 |                  | true     | false        | false       | true                 | true                          | E-Mail-Adresse ist ein Pflichtfeld                                                                            |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | true     | false        | false       | true                 | false                         |                                                                                                               |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | false    | true         | Paypal      | true                 | false                         |                                                                                                               |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | false    | true         | Lastschrift | true                 | false                         |                                                                                                               |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | false    | true         | Kreditkarte | true                 | false                         |                                                                                                               |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@gmail.com | true     | false        | false       | false                | true                          | Bitte lies und akzeptiere die Allgemeinen Geschäftsbedingungen, um mit deiner Bestellung fortfahren zu können |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | ab123       | tester@gmail.com | true     | false        | false       | true                 | true                          | Telefon ist keine gültige Telefonnummer                                                                       |
      | Arif    | Tester   | Thyssenstrabe | 34119        | Kassel | 05617397718 | tester@          | true     | false        | false       | true                 | true                          | Ungültige Rechnungs E-Mail-Adresse                                                                       |

    Scenario: TC_0827
      Given Click on the Produkte button
      And Click on one of the products randomly which is in the stocks
      When Click on the In den Warenkorb button
      Then Click on the Weiter zur Kasse button
      And Click on the Gutschein message
      And Fill the Gutschein code field randomly "123ert"
      When click on the Gutschein anwenden button
      Then The user should be able to see Der Gutschein  message
