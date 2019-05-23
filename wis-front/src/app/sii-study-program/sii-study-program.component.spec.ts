import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiiStudyProgramComponent } from './sii-study-program.component';

describe('SiiStudyProgramComponent', () => {
  let component: SiiStudyProgramComponent;
  let fixture: ComponentFixture<SiiStudyProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiiStudyProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiiStudyProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
