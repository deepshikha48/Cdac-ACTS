import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowFeedbackListComponent } from './show-feedback-list.component';

describe('ShowFeedbackListComponent', () => {
  let component: ShowFeedbackListComponent;
  let fixture: ComponentFixture<ShowFeedbackListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowFeedbackListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowFeedbackListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
