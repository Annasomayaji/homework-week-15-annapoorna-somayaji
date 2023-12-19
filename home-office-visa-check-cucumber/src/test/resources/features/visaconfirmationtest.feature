Feature: Visa Confirmation functionality
  As a user, I like to verify if the visa is required for my travel

  Background: User is on Home page
    Given User has navigate to homepage

  @author_Annapoorna-Somayaji
  Scenario Outline: Verify visa requirement for an Australian coming to UK
    When User clicks on start button
    And User selects "<nationality>", "<reason>"
    Then User can view visa requirement in "<result>"


    Examples:
      | nationality | reason                                 | result                                     |
      | Australia   | Tourism                                | You will not need a visa to come to the UK |
      | Colombia    | Join partner or family for a long stay | You may need a visa                        |

  @author_Annapoorna-Somayaji
  Scenario: Verify a chilean coming to UK for work for long duration requires visa
    When User clicks on start button
    And User selects "Chile", "Work,academic visit or business"
    And User selects intended stay for "longer than 6 months"
    And User selects "Health and care professional" for work type
    Then User can view visa requirement in "You need a visa to work in health and care"

  #PS:

  # I have merged Colombia scenario with Australia because the last few steps given in the requirements are not on the website



