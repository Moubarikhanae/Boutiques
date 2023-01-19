import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutBoutiqueComponent } from './ajout-boutique.component';

describe('AjoutBoutiqueComponent', () => {
  let component: AjoutBoutiqueComponent;
  let fixture: ComponentFixture<AjoutBoutiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjoutBoutiqueComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjoutBoutiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
