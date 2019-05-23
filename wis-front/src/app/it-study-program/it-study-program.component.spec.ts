import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItStudyProgramComponent } from './it-study-program.component';

describe('ItStudyProgramComponent', () => {
  let component: ItStudyProgramComponent;
  let fixture: ComponentFixture<ItStudyProgramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItStudyProgramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItStudyProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
