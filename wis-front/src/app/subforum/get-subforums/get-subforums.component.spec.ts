import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetSubforumsComponent } from './get-subforums.component';

describe('GetSubforumsComponent', () => {
  let component: GetSubforumsComponent;
  let fixture: ComponentFixture<GetSubforumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetSubforumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetSubforumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
