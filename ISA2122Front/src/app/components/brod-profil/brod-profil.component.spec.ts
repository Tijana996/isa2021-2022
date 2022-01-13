import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrodProfilComponent } from './brod-profil.component';

describe('BrodProfilComponent', () => {
  let component: BrodProfilComponent;
  let fixture: ComponentFixture<BrodProfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrodProfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrodProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
