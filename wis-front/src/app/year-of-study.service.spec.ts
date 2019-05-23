import { TestBed } from '@angular/core/testing';

import { YearOfStudyService } from './year-of-study.service';

describe('YearOfStudyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: YearOfStudyService = TestBed.get(YearOfStudyService);
    expect(service).toBeTruthy();
  });
});
