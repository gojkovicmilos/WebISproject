import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterNoviSadComponent } from './center-novi-sad.component';

describe('CenterNoviSadComponent', () => {
  let component: CenterNoviSadComponent;
  let fixture: ComponentFixture<CenterNoviSadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CenterNoviSadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CenterNoviSadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
