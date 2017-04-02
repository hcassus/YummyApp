# YummyApp
![Codeship Badge](https://codeship.com/projects/d6147760-f9f0-0134-3cb1-4e1e5050a870/status?branch=master)

## Documentation
The documentation for the Cucumber features are specified [here](http://www.relishapp.com/hcassus/YummyApp/docs/consume-country-api) using Relish.

## Requirements
* Java 8
* Maven 3.3.9
* VM Option `base.url` (currently supporting `.com` and `.co.uk` versions)

## Running the tests
Go to the project root and execute `mvn test -Dbase.url="http://{BASE_URL}.co.uk"`

## Ignored Tests
In order not to bloat the production environment with dummy users, the registration tests are being ignored, but are oprerational

## Observed issues
* Tab order in birth date fields for registration are locale independent (always month, day, year), which may cause minor confusion for UK users
* Right after login, one screen is shown, loaded, but right after redirected ("in your box" area). Since the load takes a while, that may also cause suboptimal user experience
* Ids for box/plan elements are not uniform between countries, which leads to hacky solutions to make the test compatible with both places
* The landing page is extremely heavy (11s to load, almost 5MB in assets and 171 requests) which causes both slower tests and slower experience to the user
* In order to have a proper test, the endpoint for post was mocked using mockable.io
* The name for the mocked endpoint as `post` was kept solely for consistency purposes. The ideal scenario would be a single `country` endpoint suporting retrival of the list, of the country data by code and the creation of it.
* Although cucumber is a very powerful tool for Gherkin scenarios, RestAssured also contains Gherkin hooks that could be used for the sake of readability diminishing the complexity of the stack and improving maintainability
