import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IstruktorProfilComponent } from './istruktor-profil.component';

describe('IstruktorProfilComponent', () => {
  let component: IstruktorProfilComponent;
  let fixture: ComponentFixture<IstruktorProfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IstruktorProfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IstruktorProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
