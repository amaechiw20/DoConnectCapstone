import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingAnswerComponent } from './pending-answer.component';

describe('PendingAnswerComponent', () => {
  let component: PendingAnswerComponent;
  let fixture: ComponentFixture<PendingAnswerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingAnswerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PendingAnswerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
