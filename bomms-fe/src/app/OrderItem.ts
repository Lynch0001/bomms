export class OrderItem {
  isbn: number;
  quantity: number;
  price: number;

  constructor() {
  }

  public get_isbn(): number{
    return this.isbn;
  }
  public set_isbn(isbn: number): void{
    this.isbn = isbn;
  }
  public get_quantity(): number{
    return this.quantity;
  }
  public set_quantity(quantity: number): void{
    this.quantity = quantity;
  }
  public get_price(): number{
    return this.price;
  }
  public set_price(price: number): void{
    this.price = price;
  }
}
