import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrodPrikazComponent } from './brod-prikaz.component';

describe('BrodPrikazComponent', () => {
  let component: BrodPrikazComponent;
  let fixture: ComponentFixture<BrodPrikazComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrodPrikazComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrodPrikazComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
