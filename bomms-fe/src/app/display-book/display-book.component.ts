import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookInCart} from '../BookInCart';
import {ShareCartService} from '../share-cart.service';


@Component({
  selector: 'app-display-book',
  templateUrl: './display-book.component.html',
  styleUrls: ['./display-book.component.css']
})
export class DisplayBookComponent implements OnInit {

  books: any[];
  currentYear: Date;
  @Input() book: any;

  constructor(private route: ActivatedRoute, private router: Router) {
    this.currentYear = new Date();
}

  ngOnInit(): void {

  }

  showBookDetail(book): void {
    console.log('Catalog - Review Cart method: ', book);
    this.router.navigate(['book'], {state: {data: book}});
  }


}
