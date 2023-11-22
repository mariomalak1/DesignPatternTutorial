import java.util.ArrayList;

class Program{
	void Main(String[] args){
		Menu mainMenu = new Menu("Main Menu");
		Menu dinerMenu = new Menu("Diner Menu");
		Menu DisertMenu = new Menu("Disert Menu", new ArrayList<MenuComponent>());
		mainMenu.Add(dinerMenu);

		dinerMenu.Add(new Checken(150.00, "Babrica Wings"));
		dinerMenu.Add(DisertMenu);

		DisertMenu.Add(new Apitiser(15.5, "Present as Api-tiser ...."));
		DisertMenu.Add(new OmAli(10.1));

		mainMenu.display();
	}
}


interface MenuComponent{
	void display();
}


abstract class MenuItem implements MenuComponent{
	String ItemName;
	double price;

	@Override
	public void display(){
		throw new UnsupportedOperationException();
	}

	String getItemName(){
		return ItemName;
	}

	void setItemName(String name){
		ItemName = name;
	}

	double getPrice(){
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}


class Menu implements MenuComponent{
	String MenuName;
	ArrayList<MenuComponent> ComponentsList;

	Menu(String name){
		MenuName = name;
		ComponentsList = new ArrayList<MenuComponent>();
	}

	Menu(String name, ArrayList<MenuComponent>components){
		ComponentsList = components;
		MenuName = name;
	}

	void Add(MenuComponent MenuComponent){
		ComponentsList.add(MenuComponent);
	}

	void Remove(MenuComponent MenuComponent) {
		ComponentsList.remove(MenuComponent);
	}

	public String getMenuName() {
		return MenuName;
	}

	public void setMenuName(String menuName) {
		MenuName = menuName;
	}

	@Override
	public void display() {
		System.out.println(super.getMenuName() + " : ");

		for (MenuComponent component: super.ComponentsList) {
			System.out.print('\t');
			component.display();
		}
	}
}


// Disert Section

class OmAli extends MenuItem{
	@Override
	public void display() {
		System.out.println("Om Ali, With Price -> " + super.getPrice());
	}

	OmAli(double price){
		super.setPrice(price);
	}
}


class Apitiser extends MenuItem {
	String Recipe;
	@Override
	public void display() {
		System.out.println("Apitiser, With Price -> " + super.getPrice() + ", Recipe -> " + this.Recipe);
	}

	Apitiser(double price, String recipe){
		super.setPrice(price);
		Recipe = recipe;
	}
}


// diner menu

class Checken implements MenuItem{
	String wings;

	Checken(double price, String wings){
		this.wings = wings;
		super(price);
	}

	@Override
	public void display() {
		System.out.println("Cheken Wings, With Price -> " + super.getPrice() + ", Wings From Type -> " + Wings);
	}
}