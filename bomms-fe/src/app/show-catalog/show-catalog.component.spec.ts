import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCatalogComponent } from './show-catalog.component';

describe('ShowCatalogComponent', () => {
  let component: ShowCatalogComponent;
  let fixture: ComponentFixture<ShowCatalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowCatalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCatalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
