import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahteviBrisanjeNalogaComponent } from './zahtevi-brisanje-naloga.component';

describe('ZahteviBrisanjeNalogaComponent', () => {
  let component: ZahteviBrisanjeNalogaComponent;
  let fixture: ComponentFixture<ZahteviBrisanjeNalogaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZahteviBrisanjeNalogaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZahteviBrisanjeNalogaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
