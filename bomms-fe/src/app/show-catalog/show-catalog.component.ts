import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BookInCart} from '../BookInCart';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ShareCartService} from '../share-cart.service';

@Component({
  selector: 'app-show-catalog',
  templateUrl: './show-catalog.component.html',
  styleUrls: ['./show-catalog.component.css']
})
export class ShowCatalogComponent implements OnInit {

  search: string;
  tags = new Map([['all', 'All'], ['angular', 'Angular'], ['ansible', 'Ansible'], ['apache', 'Apache'],['api', 'API'], ['audio', 'Audio'], ['aws', 'AWS'], ['azure', 'Microsoft Azure'], ['big-data', 'Big Data'], ['bootstrap', 'Bootstrap'], ['cassandra', 'Apache Cassandra'], ['cisco', 'Cisco'], ['cloud', 'Cloud'], ['c++', 'C++'], ['css', 'CSS'], ['cucumber', 'Cucumber'], ['database', 'Database'], ['design', 'Design'], ['docker', 'Docker'], ['dom', 'DOM'], ['ejb', 'EJB'], ['gis', 'GIS'], ['git', 'Git'], ['grails', 'Grails'], ['graph', 'Graph'], ['groovy', 'Groovy'], ['hadoop', 'Hadoop'], ['hibernate', 'Hibernate'], ['html', 'HTML'], ['hyper-v', 'Hyper-V'], ['iaas', 'IaaS'], ['java', 'Java'], ['javafx', 'JavaFX'], ['javascript', 'JavaScript'], ['kafka', 'Apache Kafka'], ['linux', 'Linux'], ['machine-learning', 'Machine Learning'],
    ['mapreduce', 'MapReduce'], ['mariadb', 'MariaDB'], ['media', 'Media'], ['mongodb', 'MongoDB'], ['mvc', 'MVC'], ['mysql', 'MySQL'], ['network', 'Network'], ['neural-networks', 'Neural Networks'], ['node', 'Node'],
    ['nosql', 'NoSQL'], ['oracle', 'Oracle'], ['paas', 'PaaS'], ['patterns', 'Patterns'], ['postgresql', 'PostgreSQL'], ['sap', 'SAP'], ['sass', 'Sass'], ['security', 'Security'], ['soap', 'SOAP'], ['spark', 'Apache Spark'], ['spring', 'Spring'], ['sql', 'SQL'], ['tensorflow', 'TensorFlow'], ['testing', 'Testing'], ['visualization', 'Visualization']]);
  books: any = [];
  booksFullList: any = [];
  booksByTag: any = [];
  booksBySearch: any = [];
  index: number = 0;

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.rest.getCatalog().subscribe((data: {} ) => {
      console.log('Parent - Catalog Data: ', data);
      this.books = data;
      this.booksFullList = data;
    });
  }

  getCatalog(): void {
    if (this.booksFullList.length > 0){
      this.books = this.booksFullList;
    } else {
    this.rest.getCatalog().subscribe((data: {}) => {
      console.log('Parent - Catalog Data: ', data);
      this.books = data;
    });
    }
  }


  getBooksByTag(tag: string): void{
    this.booksByTag = [];
    this.books = [];
    console.log('Starting getBooksByTag Method for Tag: ', tag);
    if (tag === 'all') {
      this.getCatalog();
    }
    else{
      for (const book of this.booksFullList){
        if (book.title.toLowerCase().includes(tag) || book.subtitle.toLowerCase().includes(tag)){
          this.booksByTag.push(book);
          console.log('book added to booksByTag List: ', this.booksByTag);
        }
      }
      this.books = this.booksByTag;
    }
  }

  getBooksBySearchInput(search: string): void{
    this.booksBySearch = [];
    this.books = [];
    console.log('Starting getBooksBySearch Method for Search: ', search);
    for (const book of this.booksFullList){
      if (book.title.toLowerCase().includes(search.toLowerCase()) || book.subtitle.toLowerCase().includes(search.toLowerCase())){
        this.booksBySearch.push(book);
        console.log('book added to booksByTag List: ', this.booksBySearch);
      }
    }
    this.books = this.booksBySearch;
    this.search = '';
  }

}
