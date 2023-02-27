import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingQuestionsComponent } from './pending-questions.component';

describe('PendingQuestionsComponent', () => {
  let component: PendingQuestionsComponent;
  let fixture: ComponentFixture<PendingQuestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PendingQuestionsComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PendingQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
