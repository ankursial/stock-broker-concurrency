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

### Not included:
* Admin can block customers
* ShareAdmin and increase or decrease shares from the system
* To mock the share market system, the share prices will change randomly upto 1% once a sale purchase has been done
* Place limit, stop loss, stop limit orders
* Generate statements, tradebook
* System notifications

### Assumptions
* System will start will constant number of shares. Share will be fixed in the market and its quantity should remain consistant.
* Prices will not fluctuate as of now (could be extendible)
* Auth is out of scope
* short trade is not allowed
* Payment auth will not be done. We would assume its authenticated.
* Order will either be fully fulfilled or not
* Order will be fulfulled in real time
* Customers will buy sell shares from central authority (could be extended)
* Check order status
