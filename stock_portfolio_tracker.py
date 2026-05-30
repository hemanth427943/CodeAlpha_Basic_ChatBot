# Stock Portfolio Tracker

# Hardcoded stock prices (dictionary)
stock_prices = {
    "AAPL": 180,
    "TSLA": 250,
    "GOOG": 2700,
    "AMZN": 3300,
    "MSFT": 300
}

portfolio = {}
total_investment = 0

print("📈 Welcome to Stock Portfolio Tracker")
print("Available stocks:", ", ".join(stock_prices.keys()))

# Taking user input
while True:
    stock = input("\nEnter stock name (or type 'done' to finish): ").upper()
    
    if stock == "DONE":
        break
    
    if stock not in stock_prices:
        print("❌ Stock not available. Try again.")
        continue
    
    quantity = int(input(f"Enter quantity of {stock}: "))
    
    # Store in portfolio
    portfolio[stock] = portfolio.get(stock, 0) + quantity

# Calculate total investment
print("\n📊 Portfolio Summary:")
for stock, qty in portfolio.items():
    price = stock_prices[stock]
    investment = price * qty
    total_investment += investment
    print(f"{stock} - Quantity: {qty}, Price: {price}, Value: {investment}")

print(f"\n💰 Total Investment Value: {total_investment}")

# Save to file (optional)
save = input("\nDo you want to save this to a file? (yes/no): ").lower()

if save == "yes":
    with open("portfolio.txt", "w") as file:
        file.write("Stock Portfolio Summary\n")
        for stock, qty in portfolio.items():
            price = stock_prices[stock]
            investment = price * qty
            file.write(f"{stock} - Qty: {qty}, Price: {price}, Value: {investment}\n")
        file.write(f"\nTotal Investment: {total_investment}")
    
    print("✅ Portfolio saved to portfolio.txt")