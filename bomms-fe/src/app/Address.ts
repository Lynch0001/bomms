export class Address {
  private _id: number = null;
  private _street: string;
  private _city: string;
  private _state: string;
  private _zip: string;
  private _billing: boolean = false;
  private _shipping: boolean = false;


  constructor(id: number, street: string, city: string, state: string, zip: string, billing: boolean, shipping: boolean) {
    this._id = id;
    this._street = street;
    this._city = city;
    this._state = state;
    this._zip = zip;
    this._billing = billing;
    this._shipping = shipping;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get street(): string {
    return this._street;
  }

  set street(value: string) {
    this._street = value;
  }

  get city(): string {
    return this._city;
  }

  set city(value: string) {
    this._city = value;
  }

  get state(): string {
    return this._state;
  }

  set state(value: string) {
    this._state = value;
  }

  get zip(): string {
    return this._zip;
  }

  set zip(value: string) {
    this._zip = value;
  }

  get billing(): boolean {
    return this._billing;
  }

  set billing(value: boolean) {
    this._billing = value;
  }

  get shipping(): boolean {
    return this._shipping;
  }

  set shipping(value: boolean) {
    this._shipping = value;
  }
}
