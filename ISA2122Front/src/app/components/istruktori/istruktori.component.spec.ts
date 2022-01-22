import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IstruktoriComponent } from './istruktori.component';

describe('IstruktoriComponent', () => {
  let component: IstruktoriComponent;
  let fixture: ComponentFixture<IstruktoriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IstruktoriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IstruktoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
