# Stock broker project

A spring boot project to demonstrate concurrency issues

## Requiremnents
### Included:
* A customer will have account
* List different shares
* Buy/Sell shares at listed price and quantity
* See his list of shares he holds
* Orders will be placed at market price
* A customer should be above to deposit withdraw money

### Not included yet:
* Admin can block customers
* ShareAdmin and increase or decrease shares from the system
* To mock the share market system, the share prices will change randomly upto 1% once a sale purchase has been done
* Place limit, stop loss, stop limit orders
* Generate statements, tradebook
* System notifications

### Assumptions for this project
* System will start will constant number of shares. Share will be fixed in the market and its quantity should remain consistant.
* Prices will not fluctuate as of now (could be extendible)
* Auth is out of scope
* short trade is not allowed
* Payment auth will not be done. We would assume its authenticated.
* Order will either be fully fulfilled or not
* Order will be fulfulled in real time
* Customers will buy sell shares from central authority (could be extended)
* Check order status

For Design document refer to [this](design.md)

For swagger APIs (once the server is started) please refer to http://localhost:8000/swagger-ui.html

To start the application
* add MySQL DataSource details [here](src/main/resources/application.properties)
* run mvn spring-boot:run in the project directory

To check for concureency issue run curl command [here](/src/test/resources/concurrencyScript.txt)

Concurrency issues are handled and resolved by [Optimistic Locking](https://en.wikipedia.org/wiki/Optimistic_concurrency_control)
