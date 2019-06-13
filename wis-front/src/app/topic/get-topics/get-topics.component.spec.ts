import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTopicsComponent } from './get-topics.component';

describe('GetTopicsComponent', () => {
  let component: GetTopicsComponent;
  let fixture: ComponentFixture<GetTopicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetTopicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetTopicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
