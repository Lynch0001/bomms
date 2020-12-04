export class BookInCart{
  custid: string;
  title: string;
  authors: string;
  isbn: number;
  image: string;
  qty: number;
  price: number;

  constructor() {
  }

  public get_title(): string{
    return this.title;
  }
  public setTitle(title: string): void{
    this.title = title;
  }

  public get_authors(): string{
    return this.authors;
  }
  public set_authors(authors: string): void{
    this.authors = authors;
  }

  public get_image(): string{
    return this.image;
  }
  public set_image(image: string): void{
    this.image = image;
  }

  public get_custid(): string{
    return this.custid;
  }
  public set_custid(custid: string): void{
    this.custid = custid;
  }
  public get_isbn(): number{
    return this.isbn;
  }
  public set_isbn(isbn: number): void{
    this.isbn = isbn;
  }
  public get_qty(): number{
    return this.qty;
  }
  public set_qty(qty: number): void{
    this.qty = qty;
  }
  public get_price(): number{
    return this.price;
  }
  public set_price(price: number): void{
    this.price = price;
  }
}
