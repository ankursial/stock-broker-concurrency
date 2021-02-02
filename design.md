## Requiremnents
For reuqirements please refer to [this](README.md) document


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

## Entities and selected feilds

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
