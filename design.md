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


## Actors
### current
Customer

### future
* ShareAdmin
* Admin

## Use cases
* CRUD Account
* Place order Buy/Sell share based on quantity and price
* List available shares to buy from market with price
* List available shares in his account with price
* CRU money

## Entities

### Account

### CustomerAccont extends Account
	* balance
	* List<Orders>
	* List<Stocks>

### Stock
	* name
	* symbol

### StockInventory
	* stock
	* total-quantity
	* available-quantity
	* price

### Order
	* Type: buy, sell
	* Stock
	* quantity
	* price

### Market
	* StockInventory

## APIs
	customer-controller
		post /customers
		get /customers
		get /customers/{customerId}
		patch /customers/{customerId}
		delete /customers/{customerId}
		get /customers/{customerId}/inventory
	stock-inventory-controller
		get /stock/inventory
	db-init-controller
		post /db-init
	order-controller
		post /customers/{customerId}/orders
		get /customers/{customerId}/orders
		get /customers/{customerId}/orders/{orderid}

	APIs Excluded
	wallet-controller
		get	/wallet/customers/{customerId}
		put	/wallet/customers/{customerId}/add/{amount}
		put	/wallet/customers/{customerId}/withdraw/{amount}

	stock-controller
		<todo>
