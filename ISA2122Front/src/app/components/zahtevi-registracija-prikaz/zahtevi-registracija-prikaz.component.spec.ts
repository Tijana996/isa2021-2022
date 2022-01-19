import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahteviRegistracijaPrikazComponent } from './zahtevi-registracija-prikaz.component';

describe('ZahteviRegistracijaPrikazComponent', () => {
  let component: ZahteviRegistracijaPrikazComponent;
  let fixture: ComponentFixture<ZahteviRegistracijaPrikazComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZahteviRegistracijaPrikazComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZahteviRegistracijaPrikazComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
