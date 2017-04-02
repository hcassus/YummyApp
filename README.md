# YummyApp
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
