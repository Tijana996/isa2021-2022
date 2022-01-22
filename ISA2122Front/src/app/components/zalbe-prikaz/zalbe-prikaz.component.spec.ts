import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZalbePrikazComponent } from './zalbe-prikaz.component';

describe('ZalbePrikazComponent', () => {
  let component: ZalbePrikazComponent;
  let fixture: ComponentFixture<ZalbePrikazComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZalbePrikazComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZalbePrikazComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
