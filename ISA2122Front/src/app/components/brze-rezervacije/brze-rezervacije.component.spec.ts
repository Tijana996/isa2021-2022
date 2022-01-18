import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrzeRezervacijeComponent } from './brze-rezervacije.component';

describe('BrzeRezervacijeComponent', () => {
  let component: BrzeRezervacijeComponent;
  let fixture: ComponentFixture<BrzeRezervacijeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrzeRezervacijeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrzeRezervacijeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
