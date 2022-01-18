import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VikendicaRezervacijaComponent } from './vikendica-rezervacija.component';

describe('VikendicaRezervacijaComponent', () => {
  let component: VikendicaRezervacijaComponent;
  let fixture: ComponentFixture<VikendicaRezervacijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VikendicaRezervacijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VikendicaRezervacijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
