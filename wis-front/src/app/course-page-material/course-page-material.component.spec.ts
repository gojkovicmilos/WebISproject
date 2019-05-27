import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursePageMaterialComponent } from './course-page-material.component';

describe('CoursePageMaterialComponent', () => {
  let component: CoursePageMaterialComponent;
  let fixture: ComponentFixture<CoursePageMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursePageMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursePageMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
