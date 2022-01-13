import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VikendicaProfilComponent } from './vikendica-profil.component';

describe('VikendicaProfilComponent', () => {
  let component: VikendicaProfilComponent;
  let fixture: ComponentFixture<VikendicaProfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VikendicaProfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VikendicaProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
