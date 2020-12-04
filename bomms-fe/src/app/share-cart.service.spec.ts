import { TestBed } from '@angular/core/testing';

import { ShareCartService } from './share-cart.service';

describe('ShareCartService', () => {
  let service: ShareCartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShareCartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
