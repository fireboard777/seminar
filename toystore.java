import random

class Toy:
    def __init__(self, toy_id, name, quantity, weight):
        self.toy_id = toy_id
        self.name = name
        self.quantity = quantity
        self.weight = weight

    def __str__(self):
        return f"ID: {self.toy_id}, Название: {self.name}, Количество: {self.quantity}, Вес: {self.weight}%"

class ToyStore:
    def __init__(self):
        self.toys = []

    def add_toy(self, toy_id, name, quantity, weight):
        toy = Toy(toy_id, name, quantity, weight)
        self.toys.append(toy)

    def update_weight(self, toy_id, new_weight):
        for toy in self.toys:
            if toy.toy_id == toy_id:
                toy.weight = new_weight

    def choose_prize_toy(self):
        total_weight = sum(toy.weight for toy in self.toys)
        random_weight = random.randint(1, total_weight)
        
        for toy in self.toys:
            random_weight -= toy.weight
            if random_weight <= 0:
                if toy.quantity > 0:
                    toy.quantity -= 1
                    self.toys.remove(toy)
                    return toy
                else:
                    return None  # Если игрушки данного типа закончились

    def save_prize_toy_to_file(self, toy):
        with open("prize_toy.txt", "a") as file:
            file.write(f"{toy.name}\n")

    def display_toys(self):
        for toy in self.toys:
            print(toy)

if __name__ == "__main__":
    store = ToyStore()
    
    # Добавляем игрушки
    store.add_toy(1, "Мяч", 10, 20)
    store.add_toy(2, "Кукла", 8, 15)
    store.add_toy(3, "Машинка", 12, 10)
    
    store.display_toys()
    
    while True:
        input("Нажмите Enter для розыгрыша игрушки...")
        prize_toy = store.choose_prize_toy()
        if prize_toy:
            print(f"Поздравляем, вы выиграли: {prize_toy.name}")
            store.save_prize_toy_to_file(prize_toy)
        else:
            print("К сожалению, игрушки закончились.")
        
        print("Оставшиеся игрушки:")
        store.display_toys()
