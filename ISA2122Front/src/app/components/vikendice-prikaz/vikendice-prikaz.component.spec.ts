import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VikendicePrikazComponent } from './vikendice-prikaz.component';

describe('VikendicePrikazComponent', () => {
  let component: VikendicePrikazComponent;
  let fixture: ComponentFixture<VikendicePrikazComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VikendicePrikazComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VikendicePrikazComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
