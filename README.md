# Inventory-Manager

A Java-based inventory management system that allows tracking and managing various types of items including weapons, armor, consumables, and miscellaneous items.

## Features

- **Item Management**

  - Add individual or multiple items
  - Remove items by name
  - Track item details (name, value, weight)
  - Manage inventory space with maximum capacity limits

- **Item Categories**
  Depending on the category items have special methods.

  - Weapons: Track damage types (Bludgeoning, Slashing, Piercing, Elemental)
  - Armor: Classify by type (Light, Medium, Heavy)
  - Consumables: Manage uses/charges
  - Miscellaneous: Store additional notes

- **Item Interactions**

  - Armor & Weapons: Equip/Unequip usable items
  - Consumables: Consume and recharge consumable items
  - Miscellaneous: Update notes for miscellaneous items
  - Weapons: Alter item damage type

- **Inventory Features**
  - View total inventory value
  - Check remaining storage space
  - Filter and print items by category
  - Search and print items by name
  - Print all inventory details

## Usage

### Create a new inventory with specified size

This example creates an inventory with 8 available item slots.

```java
Inventory inventory = new Inventory(8);
```

### Add Items

Items can be added one by one or using an array.

```java
Weapon sword = new Weapon("Sword", 100.0, 3.0, false, DamageType.SLASHING);
Armor vest = new Weapon("Leather Armor", 200.0, 10.0, false);
inventory.addItem(sword);
inventory.addItem(vest);
```

Or

```java
Weapon sword = new Weapon("Sword", 100.0, 3.0, false, DamageType.SLASHING);
Armor vest = new Weapon("Leather Armor", 200.0, 10.0, false, ArmorType.LIGHT);
Items[] items = {sword, vest};

inventory.addMultiple(item);

```

### Inventory Methods

Methods that interact with the whole inventory are called like so. In this example inventory details would be printed.

```java
inventory.printInventoryDetails();
```

### Item Methods

Methods that interact with one item are called like so. In this example the armor status would be edited(Equip Item).

```java
vest.equip();
```

## Exception Handling

The project includes error handling for common scenarios:

- Full Inventory Exception 
    - Example: Would trigger if attempting to add more items than the inventory size initially set.
- Duplicate items Exception 
    - Example: Would trigger if attempting to add an item with the same name as another already existing.
- Item not found Exception 
    - Example: Would trigger if attempting to print item details for a nonexistent item.
- No uses remaining Exception 
    - Example: Would trigger if attempting consume a use of a Consumable that has no uses left.
- Invalid Item Exception 
    - Example: Would trigger if attempting to add an item with the wrong properties.


## Dependencies

- Java 23
- NetBeans IDE recommended for development

## Authors

- Abby
- Veevek
- Abhishek
