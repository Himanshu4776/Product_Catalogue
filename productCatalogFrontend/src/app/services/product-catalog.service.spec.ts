import { TestBed } from '@angular/core/testing';

import { ProductCatalogService } from './product-catalog.service';

describe('ProductCatalogService', () => {
  let service: ProductCatalogService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductCatalogService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
