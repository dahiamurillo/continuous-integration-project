import { TestBed } from '@angular/core/testing';

import { UsersGuardService } from './users-guard.service';

describe('UsersGuardService', () => {
  let service: UsersGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
