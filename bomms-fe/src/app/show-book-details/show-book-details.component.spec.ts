import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowBookDetailsComponent } from './show-book-details.component';

describe('ShowBookDetailsComponent', () => {
  let component: ShowBookDetailsComponent;
  let fixture: ComponentFixture<ShowBookDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowBookDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowBookDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
