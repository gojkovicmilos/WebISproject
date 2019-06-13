import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetForumsComponent } from './get-forums.component';

describe('GetForumsComponent', () => {
  let component: GetForumsComponent;
  let fixture: ComponentFixture<GetForumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetForumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetForumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
