class Item:
    def __init__(self,value,weight):
        self.value=value
        self.weight=weight

    def value_weight_ratio(self):
        return self.value/self.weight
    
def fractional_knapsack(items,capacity):
    items.sort(key= lambda item:item.value_weight_ratio(),reverse=True)
    total_value=0.0

    for item in items:
        if capacity>=item.weight:
            total_value+=item.value
            capacity-=item.weight
        else:
            total_value+= item.value_weight_ratio() * capacity

    return total_value

n=int(input("Enter Number of items: "))
items=[Item(*map(float,input("enter value and weight: ").split())) for _ in range(n)]
capacity= int(input("Enter capacity of kanpsack: "))

max_value=fractional_knapsack(items,capacity)
print(f"Maximum value in the knapsack = {max_value:.2f}")
