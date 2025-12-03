package Module1.Generics.Task2;

//Milestone 2: Generic Inventory Management
//
//Objective: Implement a generic inventory system for managing items.
//
//Tasks:
//
//Design the Inventory<T extends Item> Class:
//
//Use HashMap<String, T> to store items, where id is the key.
//
//Add Core Methods to Inventory:
//
//addItem(T item): Add an item to the inventory.
//
//removeItem(String id): Remove an item by id.
//
//getItem(String id): Retrieve an item by id.
//
//getAllItems(): Return all items as a Collection<T>.


public class Task2 {
}

// Multibound generic example:
//Inventory< T extends Item & Interface1 & Interface2 >
// You can have multiple bounds for a generic type parameter by using the '&' symbol.
// You cannot use multiple class types in the bounds, only one class type is allowed, but you can have multiple interfaces.