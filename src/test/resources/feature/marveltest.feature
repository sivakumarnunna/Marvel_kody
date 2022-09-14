Feature: marvel characters rest api testing


     Scenario: verify every possible character record has all the JSON properties
     When I get the properties and values for all the characters with base path "v1/public/characters"
     Then each character should have all the properties listed below
    |id|name|description|modified|thumbnail|resourceURI|comics|series|stories|events|urls|
    
   
    Scenario: verify response code and descrption when giving wrong parameters
     When I give invalid path "v1/public/caracters"
     Then verify the response code and errormessage
     |Responsecode|errorcode|errormessage|
     |404|ResourceNotFound|does not exist|
     
     Scenario: verify response code and descrption when giving wrong credentials
     When I give wrong credentials "v1/public/characters"
     Then verify the response code and errormessage
     |Responsecode|errorcode|errormessage|
     |401|InvalidCredentials|The passed API key is invalid|
     
     Scenario: verify the number of comics that aaron_stack having with UI
     When I get the properties and values for the character with base path "v1/public/characters/1010699"
     Then get the number of comics
     When I login to page UI "https://www.marvel.com/comics/characters/1010699/aaron_stack"
     Then verify the number of comics in UI
     #
